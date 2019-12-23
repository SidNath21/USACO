import java.io.*;
public class Div7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		
		int N = Integer.parseInt(br.readLine());
		long[] prefixSum = new long[N];
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += Integer.parseInt(br.readLine());
			prefixSum[i] = sum%7;
			System.out.println(prefixSum[i]);
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				if((prefixSum[j] - prefixSum[i]) % 7 == 0) {
					max = Math.max(max, j-i);
				}
			}
		}
		
		System.out.println(max);
		pw.println(max);
		br.close();
		pw.close();
		System.exit(0);
	}
		

}
