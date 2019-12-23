import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Art {
	
	private static int[][] artBoard;
	private static int N;
	private static boolean[] colors;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("art.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));

		N = Integer.parseInt(br.readLine());
		artBoard = new int[N][N];
		colors = new boolean[10];
		int[] isUsed = new int[10];
		

		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<N; j++) {
				artBoard[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
				isUsed[artBoard[i][j]]++;
				System.out.print(artBoard[i][j]);
			}
			System.out.println();
		}
		
		
		for(int i=1; i<=9; i++) {
			if(isUsed[i]>0) colors[i] = true;
			for(int j=1; j<=9; j++) {
				if(i!=j && isUsed[j]>0  && isOverlap(i, j) == false) {
					colors[i] = true;
				}
				else {
					colors[j] = false;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<colors.length; i++) {
			if(colors[i] == true) answer++;
		}
		System.out.println(answer);
		pw.print(answer);
		pw.close();
		br.close();
		System.exit(0);



	}

	private static boolean isOverlap(int i, int j) {
		int left = N+1, right = -1, top = N+1, bottom = -1;
		for(int a = 0; a<artBoard.length; a++) {
			for(int b = 0; b<artBoard.length; b++) {
				if(artBoard[a][b] == i) {
					left = Math.min(b, left);
					right = Math.max(b, right);
					top = Math.min(a, top);
					bottom = Math.max(a, bottom);	
				}
			}
		
		}
		
	
		for(int a = top; a<=bottom; a++) {
			for(int b = left; b<=right; b++) {
				if(artBoard[a][b] == j) {
					return true;
				
				
				}
			}
		}
		
		
		return false;
	}

}
