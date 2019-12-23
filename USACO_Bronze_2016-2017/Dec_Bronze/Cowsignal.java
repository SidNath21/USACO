import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Cowsignal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken(" "));
		int N = Integer.parseInt(st.nextToken(" "));
		int K = Integer.parseInt(st.nextToken(" "));
		System.out.println(M + " " + N + " " + K);


		for(int line=0; line<M; line++){
			String str = br.readLine();
			for(int i=0; i<K; i++){
				for(int index=0; index<N; index++){
					for(int multiplier=0; multiplier<K; multiplier++){
						pw.print(str.charAt(index));	
					}
				}
				pw.println();
			}
		}
	
		
		br.close();
		pw.close();
		System.exit(0);
	}

}
