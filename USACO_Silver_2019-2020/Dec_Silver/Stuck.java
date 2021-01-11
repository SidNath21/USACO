/*
Siddharth Nath
Question 3: Stuck in a Rut
20 December 2020
*/
import java.io.*;
import java.util.*;

public class Stuck {

    private static ArrayList<Cow> northCows;
    private static ArrayList<Cow> eastCows;

    private static ArrayList<Integer>[] cows;
    private static boolean sortX = true;


    public static void main(String[] args) throws IOException {

        // Scanner scanner = new Scanner(System.in);
        // int N = Integer.parseInt(scanner.nextLine());

        BufferedReader br = new BufferedReader(new FileReader("stuck.in"));
        int N = Integer.parseInt(br.readLine());

        northCows = new ArrayList<Cow>();
        eastCows = new ArrayList<Cow>();
        cows = new ArrayList[N];
        for(int i=0; i<N; i++){
            cows[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(/*scanner.nextLine()*/ br.readLine());
            char dir = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(dir == 'N'){
                northCows.add(new Cow(x, y, i));
            }
            else{
                eastCows.add(new Cow(x, y, i));
            }

        }

        Collections.sort(northCows);
        sortX = false;
        Collections.sort(eastCows);

        for(Cow eCow: eastCows){

            int ex = eCow.x;
            int ey = eCow.y;
            int eIndex = eCow.index;

            for(int i=0; i<northCows.size(); i++){

                int nx = northCows.get(i).x;
                int ny = northCows.get(i).y;
                int nIndex = northCows.get(i).index;

                int y = ny + nx - ex;;
                
                if(ny > ey || nx < ex || y == ey){
                    continue;
                }
            
                if(y > ey){
                    cows[nIndex].add(eIndex);
                    break;
                }

                else{

                    cows[eIndex].add(nIndex);
                    northCows.remove(i);
                    i--;

                }
              


            }
        }

        for(int i=0; i<N; i++){
            System.out.println(getSum(i));
        }
        
        
    }

    private static int getSum(int pos){
        int total = 0;
        for(int n: cows[pos]){
            if(cows[n].size() == 0) total++;
            else total += 1 + getSum(n);
        }
        return total;
    }


    static class Cow implements Comparable<Cow>{

        int x, y, index;

        public Cow(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public int compareTo(Cow oCow){

            if(sortX) return x - oCow.x;        
            else return y - oCow.y;    
            
        }
        
    }
    
}

