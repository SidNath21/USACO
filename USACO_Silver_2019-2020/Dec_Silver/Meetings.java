import java.util.*;
import java.io.*;

public class Meetings {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        ArrayList<Cow> cows = new ArrayList<Cow>(); 
        ArrayList<Integer> ltimes = new ArrayList<Integer>();
        ArrayList<Integer> rtimes = new ArrayList<Integer>();
        ArrayList<Pair> twPairs = new ArrayList<Pair>();
        ArrayList<Integer> leftPoint = new ArrayList<Integer>();
        

        int totWeight = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int d  = Integer.parseInt(st.nextToken());
            totWeight += w;
            if(d == -1){
                leftPoint.add(p);
            }
            cows.add(new Cow(p, w, d));
        }

        Collections.sort(cows);
        
        for(Cow c : cows){
            if(c.d == 1){
                rtimes.add(L-c.x);
            }
            else{
                ltimes.add(c.x);
            }
        }

        Collections.sort(rtimes);
        Collections.sort(ltimes);

        for(int i=0; i<ltimes.size(); i++){
            twPairs.add(new Pair(ltimes.get(i), cows.get(i).w));
        }

        for(int i=0; i<rtimes.size(); i++){
            twPairs.add(new Pair(rtimes.get(i), cows.get(N-i-1).w));
        }

        Collections.sort(twPairs);

        int weight = 0;
        int t = 0;
        while(2 * weight < totWeight){
            weight += twPairs.get(t).w;
            t++;
        }

        t = twPairs.get(t-1).t;

        Collections.sort(leftPoint);

        int ans = 0;
        for(int i=0; i<N; i++){
            if(cows.get(i).d == 1){
                ans += cowsToLeft(cows.get(i).x + 2 * t, leftPoint) - cowsToLeft(cows.get(i).x, leftPoint);
            }
        }

        System.out.println(ans);
        pw.println(ans);
        br.close();
        pw.close();
        System.exit(0);

    }

    private static int cowsToLeft(int x, ArrayList<Integer> leftPoint) {
        int count = 0;
        for(int i=0; i<leftPoint.size(); i++){
            if(x >= leftPoint.get(i)){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }

    static class Cow implements Comparable<Cow> {
        int x, w, d;
        public Cow(int x, int w, int d){
            this.x = x;
            this.w = w;
            this.d = d;
        }

        public int compareTo(Cow oCow){
            return x - oCow.x;
        }

        public String toString(){
            return x + " " + w + " " + d;
        }


    }

    static class Pair implements Comparable<Pair>{
        int t, w;
        public Pair(int t, int w){
            this.t = t;
            this.w = w;
        }

        public int compareTo(Pair oPair){
            return t - oPair.t;
        }
    }
    
}
