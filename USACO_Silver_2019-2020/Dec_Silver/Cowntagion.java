/*
Siddharth Nath
Question 1: Cowntagion
20 December 2020
*/

import java.io.*;
import java.util.*;

public class Cowntagion{

    
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static int ans;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("cowntagion.in"));
        int N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<Integer>();
        }

        
        for(int i = 0; i<N-1; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);

        }

        search(0);

        System.out.println(ans);
        
    }

    private static void search(int pos) {

        if(visited[pos]) return;
        visited[pos] = true;

        int count = 0;

        for(int n: adj[pos]){
            if(!visited[n]){
                count++;
            }
        }

        ans += count;

        int log = (int) Math.ceil(Math.log(count + 1) / Math.log(2));
        ans += log;

        for(int n: adj[pos]){
            if(!visited[n]){
                search(n);
            }
        }      

    }

}


