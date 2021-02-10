/*
ID: siddharthnath21
LANG: JAVA
TASK: No Time To Paint
*/

import java.io.*;
import java.util.*;

public class Paint {

    private static int[][] arr;
    private static int[] sums1, sums2;
    private static String str;
    private static int N, Q;
    private static Map<Integer, Integer> mp1;
    private static Map<String, Integer> mp2;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        str = scanner.nextLine();

        mp1 = new HashMap();
        mp2 = new HashMap();

        arr = new int[Q][2];

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(scanner.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        sums1 = new int[N];
        sums2 = new int[N];

        mp1.clear();
        getCountOne(0, N);
        mp1.clear();
        getCountTwo(0, N);

        for(int i=0; i<Q; i++){
            long count = 0;
            int a = arr[i][0] - 1;
            int b = arr[i][1];
            
            if(a != 0) count += sums1[a - 1];
            if(b != N) count += sums2[N-b-1];

            System.out.println(count);
            
        }

    }

    private static void getCountOne(int a, int b){

        int count = 0;
        for(int i=a; i<b; i++){

            int n = (int) (str.charAt(i) - 64);

            for(int j=n+1; j<=26; j++){
                if(mp1.containsKey((Integer) j)){
                    mp1.remove((Integer) j);
                }
            }

            if(!mp1.containsKey(n)){
                mp1.put(n, 0);
                count++;
            }
            sums1[i] = count;
        }

    }

    private static void getCountTwo(int a, int b){

        int count = 0;
        for(int i=b-1; i>=a; i--){

            int n = (int) (str.charAt(i) - 64);

            for(int j=n+1; j<=26; j++){
                if(mp1.containsKey((Integer) j)){
                    mp1.remove((Integer) j);
                }
            }

            if(!mp1.containsKey(n)){
                mp1.put(n, 0);
                count++;
            }
            sums2[str.length()-i-1] = count;
        }
    }
    
}
