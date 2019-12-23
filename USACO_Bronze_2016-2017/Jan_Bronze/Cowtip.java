import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Cowtip {
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		N = Integer.parseInt(br.readLine());
		int[][] cows = new int[N][N];
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<N; j++) {
				cows[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
				System.out.print(cows[i][j]);	
			}
			System.out.println();
		}
		
		int answer = 0;
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(cows[i][j] == 1) {
					answer++;
					for(int r = 0; r<=i; r++) {
						for(int c=0; c<=j; c++) {
							if(cows[r][c] == 0) cows[r][c] = 1;
							else if(cows[r][c] == 1) cows[r][c] = 0;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);

	}
}


