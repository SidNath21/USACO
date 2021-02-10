/*
ID: siddharthnath21
LANG: JAVA
TASK: Spaced Out
*/

import java.io.*;
import java.util.*;

public class SpacedOut {

    private static int N;
    private static int[][] arr, sums;
    private static int count;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());

        arr = new int[1000][1000];
        sums = new int[1000][1000];
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int j = 1;
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

      
    }
    
}

