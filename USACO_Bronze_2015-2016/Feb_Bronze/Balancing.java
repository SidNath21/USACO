import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Balancing {
	
	private static int[] X;
	private static int[] Y;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		int B = Integer.parseInt(st.nextToken(" "));
		System.out.println(N + " " + B);
		
		X = new int[N];
		Y = new int[N];
		
		int xMin = B;
		int xMax = -1;
		int yMin = B;
		int yMax = -1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken(" "));
			Y[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(X[i] + " " + Y[i]);
			xMin = Math.min(xMin, X[i]);
			xMax = Math.max(xMax, X[i]);
			yMin = Math.min(yMin, Y[i]);
			yMax = Math.max(yMax, Y[i]);
		}
		
		int answer = Integer.MAX_VALUE;
		

		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a = X[i] + 1;
				int b = Y[j] + 1;
		
				answer = Math.min(checkCow(a, b), answer);
			}
		}
		
		
		System.out.println(answer);
		pw.println(answer);
		br.close();
		pw.close();
		System.exit(0);
		

	}

	private static int checkCow(int a, int b) {
		
		int region1 = 0;
		int region2 = 0;
		int region3 = 0;
		int region4 = 0;
		for(int i=0; i<N; i++) {
			if(X[i] > a && Y[i] > b) region1++;
			if(X[i] < a && Y[i] > b) region2++;
			if(X[i] < a && Y[i] < b) region3++;
			if(X[i] > a && Y[i] < b) region4++;
		}
		
		return Math.max(Math.max(Math.max(region1, region2), region3), region4);
		
	}

}
