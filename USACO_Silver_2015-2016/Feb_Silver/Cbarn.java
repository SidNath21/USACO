import java.io.*;

public class Cbarn {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		for(int i=0; i<N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	}

}
