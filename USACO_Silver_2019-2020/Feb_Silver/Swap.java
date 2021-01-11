import java.io.*;
import java.util.*;

public class Swap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] cows = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) cows[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            for(int j=0; j < (b-a+1)/2; j++){
                int temp = cows[a+j];
                cows[a + j] = cows[b - j];
                cows[b - j] = temp;
            }

        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                ArrayList<Integer> cycle = new ArrayList<Integer>();
                int curr = cows[i];
                cycle.add(i);
                while(curr != i){
                    visited[curr] = true;
                    cycle.add(curr);
                    curr = cows[curr];
                }

                int mod = K % cycle.size();
                for(int j=0; j<cycle.size(); j++){
                    cows[cycle.get(j)] = cycle.get( (j + mod) % cycle.size());
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.print(cows[i] + 1 + " ");
            pw.println(cows[i] + 1);
        }

        br.close();
        pw.close();
        System.exit(0);


        // int[] swapTo = new int[N];

        // for(int i=0; i<N; i++){
        //     swapTo[i] = cows[i];
        // }

        // for(int i=0; i<K-1; i++){
        //     int[] arr = new int[N];
        //     for(int j=0; j<N; j++){
        //         arr[j] = cows[swapTo[j]];
        //     }

        //     cows = arr;
        // }

        // for(int i=0; i<cows.length; i++){
        //     System.out.print(cows[i] + 1 + " ");
        //     pw.println(cows[i] + 1);
        // }

        // br.close();
        // pw.close();
        // System.exit(0);


	}

	

}
