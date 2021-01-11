import java.io.*;
import java.util.*;

public class Socdist {

    private static int[] left, right;
    private static ArrayList<Interval> intervals;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        intervals = new ArrayList<Interval>();

        left = new int[M];
        right = new int[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            intervals.add(new Interval(left, right));
        }

        Collections.sort(intervals);

        int min = 1;
        int max = 100000000;
        while(min < max){
            int mid = (min + max) / 2;

            if(works(mid)){
                min = mid + 1;
            }
            else{
                max = mid;
            }

        }

        System.out.println(min-1);

        pw.println(min-1);
        br.close();
        pw.close();
        System.exit(0);



    }

    private static boolean works(int d) {

        int curr = intervals.get(0).l;
        int interval = 0;
        int count = 1;

        while(count < N){

            curr += d;

            while(interval < M && intervals.get(interval).r < curr){
                interval++;
            }

            if(interval == M) return false;

            if(curr < intervals.get(interval).l){
                curr = intervals.get(interval).l;
            }

            count++;

        }

        return true;
    //    int curr = intervals.get(0).l;
    //    int intervalCount = 0;

    //    for(int i=1; i<N; i++){
    //        curr += d;
    //        while(intervalCount < M && curr > intervals.get(intervalCount).r){
    //            intervalCount++;
    //        }
    //        if(intervalCount == M){
    //            return false;
    //        }

    //        if(curr < intervals.get(intervalCount).l){
    //            curr = intervals.get(intervalCount).l;
    //        }
    //     }
    //     return true;

       
    }

    static class Interval implements Comparable<Interval>{
        int l, r;
        public Interval(int l, int r){
            this.l = l;
            this.r = r;
        }

        public int compareTo(Interval oInterval){
            return l - oInterval.l;
        }


    }

    
}
