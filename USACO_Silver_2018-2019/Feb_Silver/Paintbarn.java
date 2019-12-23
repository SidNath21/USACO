import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Paintbarn {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] fence = new int[1001][1001];

		
		int xMin = 1000, xMax = 0, yMin = 1000, yMax = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			xMin = Math.min(X1, X2);
			yMin = Math.min(Y1, Y2);
			xMax = Math.max(X1, X2);
			yMax = Math.max(Y1, Y2);
			for(int x = X1; x<X2; x++) {
				for(int y = Y1; y<Y2; y++) {
					fence[x][y]++;
				}
			}
		}
		
		System.out.println(xMin + " " + xMax);
		int ans = 0;
		for(int i=0; i<=1000; i++) {
			for(int j=0; j<=1000; j++) {
			//	System.out.print(fence[i][j]);
				if(fence[i][j] == K) ans++;
			}
			//System.out.println();
		}
		System.out.println(ans);
		
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);
	}
	
	



}


