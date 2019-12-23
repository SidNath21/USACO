

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthScrollBarUI;


public class Milkorder {

	private static int[] cows, cowOrder;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken(" "));
		int M = Integer.parseInt(st.nextToken(" "));
		int K = Integer.parseInt(st.nextToken(" "));	
		System.out.println(N + " " + M + " " + K);

		cows = new int[N];
		cowOrder = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			cowOrder[i] = Integer.parseInt(st.nextToken(" "));
			System.out.print(cowOrder[i] + " ");
		}
		System.out.println();

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken(" "));
			int pos = Integer.parseInt(st.nextToken(" "));
			System.out.println(cow + " " + pos);
			if(cow == 1) pw.print(pos);
			cows[pos-1] = cow;	
		}

		for(int i=0; i<cowOrder.length; i++) {
			if(cowOrder[i]==1) checkOrder(i);
		}

		int answer = N;
		for(int i=0; i<cows.length; i++) {
			if(cows[i]==0) {
				if(check(i)==true) {
					answer = i+1;
					break;
				}
			}
		}
		
		System.out.println(answer);
		

	}

	private static boolean check(int i) {
		cows[i]=1;
		int count = 0;
		for(int j=0; j<cows.length; j++) {
			if(cows[j]==0) {
				cows[j]=cowOrder[count];
				count++;
			}
			System.out.print(cows[j] + " ");
			
		}
		
		
		return false;
	}

	private static void checkOrder(int i) {
		int count = 0;
		System.out.println(i);
		for(int j=0; j<cows.length; j++) {
			if(cows.length==0) cows[j]=cowOrder[count];
			System.out.println(cows[i]);
		}	
	}





}
