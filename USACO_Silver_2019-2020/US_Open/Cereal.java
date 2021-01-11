import java.io.*;
import java.util.*;

public class Cereal {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cows = new int[N][2];
        int[] cereal = new int[M+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cows[i][0] = a;
            cows[i][1] = b;
        }

        int[] ans = new int[N];
        int count = 0;
        for(int i=N-1; i>=0; i--){
            int j = i;
            int pos = cows[i][0]; // first cereal of cow i
            while(true){
                if(cereal[pos] == 0){ // not taken yet (nothing changes for previous cows)
                    cereal[pos] = j;
                    count++;
                    break;
                }
                else if(cereal[pos] < j){
                    break;
                }
                else{
                    int k = cereal[pos];
                    cereal[pos] = j;
                    if(pos == cows[k][1]){
                        break;
                    }
                    j = k;
                    pos = cows[k][1];
                    
                }
            }
            ans[i] = count;
        }

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
            pw.println(ans[i]);
        }
        br.close();
        pw.close();
        System.exit(0);
    }
}
