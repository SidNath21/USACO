/*
ID: siddharthnath21
LANG: JAVA
TASK: Dance Mooves
*/

import java.io.*;
import java.util.*;

public class Mooves {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Move> moves = new ArrayList<Move>();
        ArrayList<Integer>[] visited = new ArrayList[N];
        int[] cows = new int[N];

        for(int i=0; i<N; i++){
            cows[i] = i;
            visited[i] = new ArrayList<Integer>();
            visited[i].add(i);
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(scanner.nextLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            moves.add(new Move(a, b));
        }

        int count = 0;
        
        while(count < 10 * N * K){

            int a = moves.get(count % K).a;
            int b = moves.get(count % K).b;

            int temp = cows[a];
            cows[a] = cows[b];
            cows[b] = temp;

            if(!visited[cows[a]].contains(a)){
                visited[cows[a]].add(a);
            }

            if(!visited[cows[b]].contains(b)){
                visited[cows[b]].add(b);
            }

            count++;
        }

        for(int i=0; i<visited.length; i++){
            System.out.println(visited[i].size());
        }
        
    }

    static class Move{
        int a, b;
        public Move(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
}
