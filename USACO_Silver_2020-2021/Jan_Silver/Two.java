import java.io.*;
import java.util.*;
public class Two {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int[][] fnums = new int[26][N+1];
        int[][] lnums = new int[26][N+1];
       
        for(int i=0; i<N; i++){
            int num = (int) (str.charAt(i) - 65);
            fnums[num][i+1] = 1;
        }

       
        ArrayList<Integer> stops = new ArrayList<Integer>();

        for(int i=0; i<26; i++){
            int count = 0;
            for(int j=1; j<=N; j++){
                fnums[i][j] += fnums[i][j-1];
                if(fnums[i][j] > fnums[i][j-1]){
                    stops.add(j);
                }
                else if(stops.get(count) == j){
                    lnums[i][j] = 1;
                    count++;
                }
                lnums[i][j] += lnums[i][j-1];
            }
        }

        for(int i=0; i<26; i++){
            for(int j=0; j<=N; j++){
                System.out.print(lnums[i][j]);
            }
            System.out.println();
        }


        int[] ans = new int[Q];

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int count = 0;

            if(a != 1){
                for(int j=0; j<26; j++){
                    if(fnums[j][a] - fnums[j][0] > 0) count++;
                }
            }

            if(b != N){
                for(int j=0; j<26; j++){
                    if(fnums[j][N] - fnums[j][b] > 0) count++;
                }
            }
            ans[i] = count;
        }

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }

        
    }
}
