/*
ID: siddharthnath21
LANG: JAVA
TASK: Stuck in a Rut
*/

import java.io.*;
import java.util.*;

public class Stuck {

    private static boolean sortNorthCows;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[] cows = new int[N];
        boolean[] done = new boolean[N];

        ArrayList<Cow> northCows = new ArrayList<Cow>();
        ArrayList<Cow> eastCows = new ArrayList<Cow>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(scanner.nextLine());

            char c = st.nextToken().charAt(0);
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            if(c == 'N'){
                northCows.add(new Cow(x, y, i));
            }
            else{
                eastCows.add(new Cow(x, y, i));
            }

        }

        sortNorthCows = true;
        Collections.sort(northCows);
        sortNorthCows = false;
        Collections.sort(eastCows);

        for(int i=0; i<eastCows.size(); i++){

            long ex = eastCows.get(i).x;
            long ey = eastCows.get(i).y;
            int ei = eastCows.get(i).i;

            for(int j=0; j<northCows.size(); j++){

                long nx = northCows.get(j).x;
                long ny = northCows.get(j).y;
                int ni = northCows.get(j).i;

                long x = nx - ex;
                long y = ey - ny;

                if(x == y) continue;

                if(nx > ex && ny < ey){

                    if(x > y){

                        if(!done[ni] && !done[ei]){
                            done[ei] = true;
                            cows[ni] += (cows[ei] + 1);
                        }

                    }
                    if (x < y){

                        if(!done[ni] && !done[ei]){
                            done[ni] = true;
                            cows[ei] += (cows[ni] + 1);
                        }

                    }
                }

                
            }

        }

        for(int i=0; i<cows.length; i++){
            System.out.println(cows[i]);
        }
        
    }

    
    static class Cow implements Comparable<Cow>{
        long x, y;
        int i;
        public Cow(long x, long y, int i){
            this.x = x;
            this.y = y;
            this.i = i;
        }

        public int compareTo(Cow oCow){
            
            if(sortNorthCows){
                return (int) (x - oCow.x);
            }
            else{
                return (int) (y - oCow.y);
            }
        }

    }

    
    
}
