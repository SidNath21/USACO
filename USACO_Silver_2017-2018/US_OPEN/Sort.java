import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Sort {



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));

		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		for(int i=0; i<N; i++) cows[i] = Integer.parseInt(br.readLine());

		
		int count = 0;
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i=0; i<=N-2; i++) {
				if(cows[i+1] < cows[i]) {
					int temp = cows[i];
					cows[i] = cows[i+1];
					cows[i+1] = temp;
					sorted = false;
				}
			}
			count++;
		}
		
		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);


	}

	
}
