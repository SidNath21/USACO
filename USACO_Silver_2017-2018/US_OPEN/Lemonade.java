import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lemonade {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cows = new int[N];
		for(int i=0; i<N; i++) cows[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(cows);
		
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			if(count <= cows[i]) {
				count++;
			}
		}

		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);
	}

}
