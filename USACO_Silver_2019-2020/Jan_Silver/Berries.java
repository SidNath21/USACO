import java.io.*;
import java.util.*;

public class Berries {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] berries = new int[N];
        int[] bucketCount = new int[1001];

        st = new StringTokenizer(br.readLine());
        int maxBerries = 0;
        for(int i=0; i<N; i++){
            berries[i] = Integer.parseInt(st.nextToken());
            maxBerries = Math.max(maxBerries, berries[i]);
        }

        int ans = 0;
        

        for(int bucketCap = 1; bucketCap<=maxBerries; bucketCap++){
            
            Arrays.fill(bucketCount, 0);

            for(int i=0; i<berries.length; i++){

                int fullBuckets = berries[i] / bucketCap;
                int remainder = berries[i] % bucketCap;
                bucketCount[bucketCap] += fullBuckets;
                bucketCount[remainder] += 1;

            }

            if( K/2 > bucketCount[bucketCap]) continue;

            bucketCount[bucketCap] -= K/2;

            int curr = bucketCap;
            int count = 0;
            int bessie = 0;
            while(curr > 0 && count < K/2){
                if(bucketCount[curr] > 0){
                    bucketCount[curr]--;
                    count++;
                    bessie += curr;
                }
                else{
                    curr--;
                }
            }

            if(count == K/2){
                
                ans = Math.max(ans, bessie);

            }

        }

        System.out.println(ans);
        pw.println(ans);
        br.close();
        pw.close();
        System.exit(0);



        
    }
    
}
