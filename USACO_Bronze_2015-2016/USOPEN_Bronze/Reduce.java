import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Reduce {

	private static int[] X;
	private static int[] Y;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		N = Integer.parseInt(br.readLine());
		
		X = new int[N];
		Y = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken(" "));
			Y[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(X[i] + " " + Y[i]);
		}
		
		int minArea = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			minArea = Math.min(calculate(i), minArea);
		}
		
		System.out.println(minArea);
		pw.print(minArea);
		pw.close();
		br.close();
		System.exit(0);
		
	}

	private static int calculate(int i) {
		int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = -1, y2 = -1;
		for(int j=0; j<N; j++) {
			if(j!=i) {
				x1 = Math.min(X[j], x1);
				x2 = Math.max(X[j], x2);
				y1 = Math.min(Y[j], y1);
				y2 = Math.max(Y[j], y2);
				
			}
		}
		return Math.abs((y2-y1) * (x2-x1));
	}
}
