import java.io.*;
import java.util.*;

public class Clocktree{

    private static ArrayList<Integer>[] adj;
    private static int[] dfst;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
        int N = Integer.parseInt(br.readLine());

        int[] clock = new int[N];
        dfst = new int[N];
        adj = new ArrayList[N];

        for(int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) clock[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }        

        int count = 0;
        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++) dfst[j] = clock[j];
               
            search(i, -1);
            System.out.println(dfst[i]);
            if(dfst[i] == 1 || dfst[i] == 12) count++;

        }

        System.out.println(count);
        pw.println(count);
        br.close();
        pw.close();
        System.exit(0);

    }

    private static int search(int curr, int parent) {
        
        for(int i : adj[curr]){
            if(i != parent){
                dfst[curr] += 12 - search(i, curr);
                dfst[curr] = (dfst[curr] - 1)%12 + 1;
            }
        }

        if(parent >= 0){
            dfst[parent]++;
        }
        return dfst[curr];

    }

   
}