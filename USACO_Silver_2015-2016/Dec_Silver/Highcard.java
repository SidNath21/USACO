import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Highcard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));

		int N = Integer.parseInt(br.readLine());

		int[] elsie = new int[N];
		int[] bessie = new int[N];
		boolean[] hasCard = new boolean[N*2+1];

		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			elsie[i] = n;
			hasCard[n] = true;
		}

		Arrays.sort(elsie);
		
		for(int i=0; i<N; i++) System.out.println(elsie[i]);

		int e = 0, b = 0;
		for(int i=1; i<=2*N; i++) {
			if(!hasCard[i]) {
				bessie[b++] = i;
			}
		}
		
		Arrays.sort(bessie);


		e = 0;
		b = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			System.out.println(elsie[i] + " " + bessie[i]);
			if(bessie[b] > elsie[e]) {
				count++;
				b++;
				e++;
			}
			else {
				b++;
			}
		}
		System.out.println(count);
		
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);
	}

}
