import java.io.*;

public class MooBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        
        int N = Integer.parseInt(br.readLine());

        long min = 1;
        long max = Integer.MAX_VALUE;

        while(min != max){
            long mid = (min + max) / 2;
            long midCount = count(mid);

            if(midCount < N){
                min = mid + 1;
            }

            else if(midCount >= N){  
                max = mid;
            }

        }

        System.out.println(min);
        pw.println(min);
        br.close();
        pw.close();
        System.exit(0);
        
    }

    public static long count(long n){
        return n - (n/3) - (n/5) + (n/15);
    }
    
}
