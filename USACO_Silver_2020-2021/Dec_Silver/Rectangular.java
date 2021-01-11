/*
ID: siddharthnath21
LANG: JAVA
TASK: Rectangular Pasture
*/

import java.io.*;
import java.util.*;

public class Rectangular{

    private static ArrayList<Cow> cows;
    private static boolean sortX;
    private static int[][] sums;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("rectangle.in"));
        
        // int N = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(br.readLine());

        cows = new ArrayList<Cow>();
        sums = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer( br.readLine() /*scanner.nextLine()*/);
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            cows.add(new Cow(x, y));
        }

        sortX = true;
        Collections.sort(cows);
        for(int i=0; i<N; i++){
            cows.get(i).x = i+1;
        }

        sortX = false;
        Collections.sort(cows);
        for(int i=0; i<N; i++){
            cows.get(i).y = i+1;
        }

        for(int i=0; i<N; i++){
            sums[(int) cows.get(i).x][(int) cows.get(i).y] = 1;
        }

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         if(i > 0){
        //             sums[i][j] += sums[i-1][j];
        //         }
        //         if(j > 0){
        //             sums[i][j] += sums[i][j-1];
        //         }
        //         if(i > 0 && j > 0){
        //             sums[i][j] -= sums[i-1][j-1];
        //         }
        //     }
        // }

        for (int i=1; i<=N; i++){

            for (int j=1; j<=N; j++){

                sums[i][j] += sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
                System.out.print(sums[i][j] + " ");
            }
            System.out.println();
        }

        

        int ans = N + 1;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){

                int x1 = (int) Math.min(cows.get(i).x, cows.get(j).x) - 1;
                int x2 = (int) Math.max(cows.get(i).x, cows.get(j).x) - 1;
                int y1 = (int) Math.min(cows.get(i).y, cows.get(j).y) - 1; // i
                int y2 = (int) Math.max(cows.get(i).y, cows.get(j).y) - 1; // j
                
                ans += getSum(0,y1,x1,y2) * getSum(x2,y1,N-1,y2);
            
            }
        } 

        System.out.println(ans);
    }

    private static int getSum(int x1, int y1, int x2, int y2){
        return sums[x2+1][y2+1] - sums[x2+1][y1] - sums[x1][y2+1] + sums[x1][y1];
    }


    static class Cow implements Comparable<Cow> {

        long x, y;

        public Cow(long x, long y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Cow oCow){

            if(sortX){
                return (int) (x - oCow.x);
            }
            else{
                return (int) (y - oCow.y);
            }

        }

        public String toString(){
            return x + " " + y;
        }
    }


}



// import java.io.*;
// import java.util.*;

// public class Rectangular {

//     private static ArrayList<Cow> cows;

//     public static void main(String[] args) throws IOException {

//         Scanner scanner = new Scanner(System.in);
//         int N = Integer.parseInt(scanner.nextLine());

//         cows = new ArrayList<Cow>();

//         for(int i=0; i<N; i++){

//             StringTokenizer st = new StringTokenizer(scanner.nextLine());
//             long x = Integer.parseInt(st.nextToken());
//             long y = Integer.parseInt(st.nextToken());
//             cows.add(new Cow(x, y));

//         }

//         Collections.sort(cows);

       
//         int count = 0;

//         for(int i=0; i<N; i++){

//             ArrayList<Long> a = new ArrayList<Long>();
//             ArrayList<Long> b = new ArrayList<Long>();

//             int aCount = 0, bCount = 0;
//             long min = Integer.MAX_VALUE;
//             long max = Integer.MIN_VALUE;
//             long y1 = cows.get(i).y;

//             count++;

//             for(int j=i+1; j<N; j++){

//                 long y2 = cows.get(j).y;

//                 if(y2 < y1){
                    
//                     for(long n: b){
//                         if(n < y2) count++;
//                     }

//                     b.add(y2);
//                     if(y2 > max) bCount++; 
//                     max = Math.max(max, y2);

//                 }
                
//                 else{
                    
//                     for(long n: a){
//                         if(n > y2) count++;     
//                     }

//                     a.add(y2);
//                     if(y2 < min) aCount++;
//                     min = Math.min(min, y2);

//                 }

//                 count++;
//                 count += (aCount * bCount);
//             }

//         }

       
//         System.out.println(count + 1);
        
//     }

//     static class Cow implements Comparable<Cow> {
//         long x, y;
//         public Cow(long x, long y){
//             this.x = x;
//             this.y = y;
//         }
//         public int compareTo(Cow oCow){
//             return (int) (x - oCow.x);
//         }
//     }
    
// }
