/*
ID: siddharthnath21
LANG: JAVA
TASK: Rectangular Pasture
*/

import java.io.*;
import java.util.*;

public class Rectangle {

    private static ArrayList<Cow> cows;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        cows = new ArrayList<Cow>();

        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            cows.add(new Cow(x, y));

        }

        Collections.sort(cows);

       
        int count = 0;

        for(int i=0; i<N; i++){

            ArrayList<Long> a = new ArrayList<Long>();
            ArrayList<Long> b = new ArrayList<Long>();

            int aCount = 0, bCount = 0;
            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;
            long y1 = cows.get(i).y;

            count++;

            for(int j=i+1; j<N; j++){

                long y2 = cows.get(j).y;

                if(y2 < y1){
                    
                    for(long n: b){
                        if(n < y2) count++;
                    }

                    b.add(y2);
                    if(y2 > max) bCount++; 
                    max = Math.max(max, y2);

                }
                
                else{
                    
                    for(long n: a){
                        if(n > y2) count++;     
                    }

                    a.add(y2);
                    if(y2 < min) aCount++;
                    min = Math.min(min, y2);

                }

                count++;
                count += (aCount * bCount);
            }

        }

        System.out.println(count + 1);
        
    }

    static class Cow implements Comparable<Cow> {
        long x, y;
        public Cow(long x, long y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Cow oCow){
            return (int) (x - oCow.x);
        }
    }
    
}
