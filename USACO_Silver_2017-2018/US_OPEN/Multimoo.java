import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Multimoo {

	private static int N;
	private static int[][] board;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static int singleCount = 0, doubleCount = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		visited = new boolean[N][N];
		ArrayList<Integer>[] pairs = new ArrayList[1000000];
		for(int i=0; i<pairs.length; i++) {
			pairs[i] = new ArrayList<Integer>();
		}


		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}



		int singleMax = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					search(i, j, board[i][j]);
					singleMax = Math.max(singleMax, singleCount);

					singleCount = 0;
				}
			}
		}



		int doubleMax = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<4; k++) {
					int newX = i + dx[k];
					int newY = j + dy[k];
					if(inBounds(newX, newY) && !pairs[board[i][j]].contains(board[newX][newY]) && !pairs[board[newX][newY]].contains(board[i][j])) {

						for(boolean[] bool: visited) Arrays.fill(bool, false);

						search2(i, j, board[i][j], board[newX][newY]);

						pairs[board[i][j]].add(board[newX][newY]);
						pairs[board[newX][newY]].add(board[i][j]);

						doubleMax = Math.max(doubleMax, doubleCount);
						doubleCount = 0;

					}
				}
			}
		}

		System.out.println(singleMax + "\n" + doubleMax);
		pw.println(singleMax + "\n" + doubleMax);
		br.close();
		pw.close();
		System.exit(0);









	}

	private static void search2(int x, int y, int a, int b) {

		if(visited[x][y]) return;
		visited[x][y] = true;

		doubleCount++;

		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && (board[newX][newY] == a || board[newX][newY] == b) && !visited[newX][newY]) {
				search2(newX, newY, a, b);
			}
		}

	}

	private static void search(int x, int y, int num) {

		if(visited[x][y]) return;
		visited[x][y] = true;

		singleCount++;

		for(int i=0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && board[newX][newY] == num && !visited[newX][newY]) {
				search(newX, newY, num);
			}
		}

	}

	private static boolean inBounds(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}


}
