import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Leftout {

	private static int[][] cows;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
		N = Integer.parseInt(br.readLine());
		cows = new int[N][N];

		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				if(str.charAt(j) == 'L') {
					cows[i][j] = 0;
				}
				else cows[i][j] = 1;				
			}
		}


		for(int i=0; i<N; i++) {
			if(cows[0][i] == 1) flip(i, 'C');
			if(cows[i][0] == 1) flip(i, 'R');
		}
		
		int x = -1, y = -1;
		if(num(1, 1, N-1, N-1, 0) == 0) {
			x = 1;
			y = 1;
		}
		
		else if(num(1, 1, N-1, N-1, 1) == N-1) {
			for (int j=1; j<N; j++) if (num(1,j,N-1,j,1)==N-1) {
				x = 1;
				y = j +1;
			}
		    for (int i=1; i<N; i++) if (num(i,1,i,N-1,1)==N-1) {
		    	x = i+1;
		    	y = 1;
		    }
		}
		else if(num(1, 1, N-1, N-1, 1) != 1) {
			for(int i=1; i<N; i++) {
				for(int j=1; j<N; j++) {
					if(cows[i][j] == 1) {
						x = i + 1;
						y = j +1;
						break;
					}
				}
			}
		}
		
		System.out.println(x + " " + y);
		pw.print(x + " " + y);
		br.close();
		pw.close();
		System.exit(0);





	}
	
	private static int num(int x1, int y1, int x2, int y2, int n) {
		int ans = 0;
		for(; x1<=x2; x1++) {
			for(; y1<=y2; y1++) {
				if(cows[x1][y1] == n) ans ++;
			}
		}
		return ans;
	}

	private static void flip(int i, char ch) {

		if(ch == 'R') {
			for(int j=0; j<N; j++) {
				if(cows[i][j] == 1) cows[i][j] = 0;
				else cows[i][j] = 1;

			}
		}
		
		else {
			for(int j=0; j<N; j++) {
				if(cows[j][i] == 1) cows[j][i] = 0;
				else cows[j][i] = 1;
			}
		}


	}




}