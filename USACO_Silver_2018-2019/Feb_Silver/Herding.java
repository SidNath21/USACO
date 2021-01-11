import java.io.*;
import java.util.*;

public class Herding {

	private static int N;
	private static int[] cows;

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		for(int i=0; i<N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(cows);

		int max = cows[N-1] - cows[0] - N + 2 - Math.min(cows[N-1] - cows[N-2], cows[1] - cows[0]);
		System.out.println(max);
		
		




	}

	
}
