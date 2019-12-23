import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Balancing {
	
	private static int[] X, Y;
	private static int N;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		X = new int[N];
		Y = new int[N];
		
		int minX = 1000000;
		int maxX = 0;
		int minY = 1000000;
		int maxY = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			X[i] = x;
			Y[i] = y;
			minX = Math.min(X[i], minX);
			maxX = Math.max(X[i], maxX);
			minY = Math.min(Y[i], minY);
			maxY = Math.max(Y[i], maxY);
		}
		
		
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i<N; i++) {
			for(int j=0; j<N; j++) {
				min = Math.min(min, check(X[i] + 1, Y[j] + 1));
			}
		}
		
		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);
		
		
		
		
		
	}

	private static int check(int a, int b) {
		
		int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
		for(int i=0; i<N; i++) {
			int x = X[i];
			int y = Y[i];
			if(x > a && y > b) q1++;
			if(x < a && y > b) q2++;
			if(x < a && y < b) q3++;
			if(x > a && y < b) q4++;
		}
		
	
		
		return Math.max(q1, Math.max(q2, Math.max(q3, q4)));
	}
	


}
