import java.io.*;
import java.util.*;

public class Paintbarn {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] sums = new int[1001][1001];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sums[x1][y1]++;
			sums[x1][y2]--;
			sums[x2][y1]--;
			sums[x2][y2]++;

		}

		int ans = 0;
		for(int i=0; i < sums.length; i++){
			for(int j=0; j<sums[i].length; j++){
				if(i > 0){
					sums[i][j] += sums[i-1][j];
				}
				if(j > 0){
					sums[i][j] += sums[i][j-1];
				}
				if(i >0 && j > 0 ){
					sums[i][j] -= sums[i-1][j-1];
				}

				if(sums[i][j] == K){
					ans++;
				}
			}
		}

		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);
		
		// int[][] fence = new int[1001][1001];

		
		// int xMin = 1000, xMax = 0, yMin = 1000, yMax = 0;
		// for(int i=0; i<N; i++) {
		// 	st = new StringTokenizer(br.readLine());
		// 	int X1 = Integer.parseInt(st.nextToken());
		// 	int Y1 = Integer.parseInt(st.nextToken());
		// 	int X2 = Integer.parseInt(st.nextToken());
		// 	int Y2 = Integer.parseInt(st.nextToken());
		// 	xMin = Math.min(X1, X2);
		// 	yMin = Math.min(Y1, Y2);
		// 	xMax = Math.max(X1, X2);
		// 	yMax = Math.max(Y1, Y2);
		// 	for(int x = X1; x<X2; x++) {
		// 		for(int y = Y1; y<Y2; y++) {
		// 			fence[x][y]++;
		// 		}
		// 	}
		// }
		
		// System.out.println(xMin + " " + xMax);
		// int ans = 0;
		// for(int i=0; i<=1000; i++) {
		// 	for(int j=0; j<=1000; j++) {
		// 	//	System.out.print(fence[i][j]);
		// 		if(fence[i][j] == K) ans++;
		// 	}
		// 	//System.out.println();
		// }
		// System.out.println(ans);
		
		// pw.println(ans);
		// br.close();
		// pw.close();
		// System.exit(0);
	}
	
	



}


