import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkOrder1 {
	
	private static int[] pos;
	private static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken(" ")); // # cows
		int M = Integer.parseInt(st.nextToken(" ")); // # social hierarchy
		int K = Integer.parseInt(st.nextToken(" ")); // # cows in specific position
		
		
		pos = new int[N+1];
		
		order = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			order[i] = Integer.parseInt(st.nextToken(" "));
			System.out.print(order[i]);
		}
		
		
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken(" "));
			int cowPos = Integer.parseInt(st.nextToken(" "));
			pos[cowPos] = cow;
		}
		System.out.println();
		
		for(int i=1; i<pos.length; i++) {
			if(pos[i]==0) check(i);
		}
		

		
	}

	private static void check(int i) {
		pos[i] = 1;
		
		
	}

}
