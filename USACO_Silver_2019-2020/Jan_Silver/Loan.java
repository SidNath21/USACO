import java.io.*;
import java.util.*;

public class Loan {

	private static long N, K, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("loan.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		

		long min = 0;
		long max = K;
		
		
		while(min != max) {
			
			long mid = (min + max)/2;
			
			if(works(mid)) {
				min = mid + 1;
			}
			else {
				max = mid;
			}
			
		}
		
		System.out.println(min-1);
		pw.print(min-1);
		br.close();
		pw.close();
		System.exit(0);
		
		
		

	}

	private static boolean works(long X) {
		int count = 0;
		long totalLoan = 0;

		while(count < K) {
			long Y = (N-totalLoan)/X;
			if(Y < M ) Y = M;
			count++;
			totalLoan += Y;
		}
		
		return (totalLoan >= N);

	}

}
