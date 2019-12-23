import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Outofplace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

		int N = Integer.parseInt(br.readLine());
		System.out.println(N);
		int[] cowOrder = new int[N];
		int[] sorted = new int[N];

		for(int i=0; i<N; i++){
			cowOrder[i] = Integer.parseInt(br.readLine());
			sorted[i] = cowOrder[i];
			System.out.print(cowOrder[i] + " ");
		}
		Arrays.sort(sorted);
		int answer = -1;
		for(int i=0; i<N; i++){
			if(cowOrder[i]!=sorted[i]) answer++;
		}
		if(answer<=0) answer = 0;
		
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);



	}
}
