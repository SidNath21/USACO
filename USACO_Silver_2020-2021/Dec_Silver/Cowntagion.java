/*
ID: siddharthnath21
LANG: JAVA
TASK: Cowntagion
*/

import java.io.*;
import java.util.*;

public class Cowntagion {

    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static int ans;

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        adj = new ArrayList[N];
        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        search(0);
        System.out.println(ans);
        
    }

    private static void search(int n) {
        if(visited[n]) return;
        visited[n] = true;

        int count = 0;
        for(int pos: adj[n]){
            if(!visited[pos]){
                count++;
            }
        }

        ans += count;

        int log = (int) Math.ceil(Math.log(count + 1) / Math.log(2));
        ans += log;
        
        for(int pos: adj[n]){
            if(!visited[pos]){
                search(pos);
            }
        }



    }

    
    
}
