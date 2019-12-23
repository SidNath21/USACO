import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		
		int min = calculateMin();




	}

	private static int calculateMin() {
		int j = 0;
		int best = 0;
		for(int i=0; i<N; i++) {
			while(j < N-1 && cows[j+1]-cows[i] <= N-1) j++;
			best = Math.max(best, j-i+1);
		}
		
		
		return 0;
	}






	
}
