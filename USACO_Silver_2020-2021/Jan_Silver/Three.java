import java.io.*;
import java.util.*;
public class Three {

    private static int N;
    private static int[][] arr, sums;
    private static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("spacedout.in"));
        N = Integer.parseInt(br.readLine());

        arr = new int[1000][1000];
        sums = new int[1000][1000];

        for(int i=1; i<=N; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int j = 1;
           while(st.hasMoreTokens()){
               arr[i][j] = Integer.parseInt(st.nextToken());
               j++;
           }
        }       

        count = 0;
        calculate();

        System.out.println(count);
         
    }

    public static void calculate(){

        Pair p = new Pair(-1, -1);
        int x = 0;

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(arr[i][j] > x && sums[i][j] == 0){
                    if( (sums[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] < 2) &&
                        (sums[i - 1][j] + sums[i - 1][j + 1] + sums[i][j + 1] < 2) &&
                        (sums[i + 1][j] + sums[i + 1][j - 1] + sums[i][j - 1] < 2) &&
                        (sums[i + 1][j] + sums[i + 1][j + 1] + sums[i][j + 1] < 2)
                    )
                    {
                        x = arr[i][j];
                        p.x = i;
                        p.y = j;
                    }
                }
            }
        }

        if(p.x != -1){
            sums[p.x][p.y] = 1;
            count += arr[p.x][p.y];
            calculate();
        }

    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
