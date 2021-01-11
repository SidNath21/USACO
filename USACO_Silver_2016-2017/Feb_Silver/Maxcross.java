import java.io.*;
import java.util.*;

public class Maxcross{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] broken = new int[N+1];

		for(int i=0; i<B; i++){
			int b = Integer.parseInt(br.readLine());
			broken[b]++;
		}

		int[] prefixSum = new int[N+1];
		int count = 0;
		for(int i=1; i<=N; i++){
			if(broken[i] > 0) count++;
			prefixSum[i] = count;
		}

		int min = Integer.MAX_VALUE;
		for(int i=K; i<=N; i++){
			int b = prefixSum[i] - prefixSum[i-K];
			min = Math.min(min, b);
		}

		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);

	}
}