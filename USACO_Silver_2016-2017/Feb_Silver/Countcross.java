import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Countcross {

	private static int[][] cows;
	private static boolean[][] visited;
	private static int N;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static ArrayList<Fence>[][] fences;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		fences = new ArrayList[N][N];

		for(int i=0; i<fences.length; i++) {
			for(int j=0; j<fences.length; j++) {
				fences[i][j] = new ArrayList<Fence>();
			}
		}
		
		visited = new boolean[N][N];
		cows = new int[K][2];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			fences[r1][c1].add(new Fence(r2, c2));
			fences[r2][c2].add(new Fence(r1, c1));
		}

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			cows[i][0] = r;
			cows[i][1] = c;
		}

		int count = 0;
		for(int i=0; i<K; i++) {
			for(int j=i+1; j<K; j++) {	
					search(cows[i][0], cows[i][1]);
					if(!visited[cows[j][0]][cows[j][1]]) count++;
					for(boolean[] arr: visited) {
						Arrays.fill(arr, false);
					}
				}
			
		}

		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);



	}

	private static void search(int r, int c) {

		
		if(visited[r][c]) return;
		visited[r][c] = true;

		for(int k=0; k<4; k++) {
			int newR = r + dr[k];
			int newC = c + dc[k];
			boolean blocked = false;
			for(int a = 0; a<fences[r][c].size(); a++) {
				if(newR == fences[r][c].get(a).r && newC == fences[r][c].get(a).c) {
					blocked = true;
				}
			}

			if(!blocked) {
				if(inBounds(newR, newC) && !visited[newR][newC]) {
					search(newR, newC);
				}
			}
		}

	}

	private static boolean inBounds(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}

	static class Fence{
		int r, c;
		public Fence(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
