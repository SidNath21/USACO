import java.io.*;
import java.util.*;

public class Mooyomooyo{

	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static int N;
	private static int[][] board;
	private static boolean[][] visited;
	private static int count;
	private static ArrayList<Point> points;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[N][10];
		visited = new boolean[N][10];
		points = new ArrayList<Point>();

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<10; j++){
				int num = Integer.parseInt(Character.toString(str.charAt(j)));
				board[i][j] = num;
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		
		boolean gameOver = false;
		while(!gameOver){

			gameOver = true;
			for(int i=0; i<N; i++){
				for(int j=0; j<10; j++){

					if(!visited[i][j] && board[i][j] > 0){	
						
						for(boolean[] arr: visited) Arrays.fill(arr, false);			
						points.clear();

						count = 0;
						search(i, j, board[i][j]);

						if(count >= K){
							gameOver = false;
							for(Point p: points){
								board[p.x][p.y] = 0;
							}
						}


					}

				}
			}

			gravity();

		
		}

		System.out.println();
		for(int i=0; i<N; i++){
			for(int j=0; j<10; j++){
				System.out.print(board[i][j]);
				pw.print(board[i][j]);
			}
			System.out.println();
			pw.println();
		}

		br.close();
		pw.close();
		System.exit(0);

	}

	private static void search(int x, int y, int c) {

		if(visited[x][y]) return;
		visited[x][y] = true;
		points.add(new Point(x, y));
		count++;

		for(int i=0; i<4; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];

			if(inBounds(newX, newY) && !visited[newX][newY] && board[newX][newY] == c){
				search(newX, newY, c);
			}

		}

	}

	private static void gravity() {
		for(int i=0; i<10; i++){
			int emptyCount = 0;
			for(int j=N-1; j>=0; j--){
				if(board[j][i] == 0) emptyCount++;
				else{
					if(emptyCount > 0){
						board[j+emptyCount][i] = board[j][i];
						board[j][i] = 0;
					}
				}
			}
				
		}

	}


	private static boolean inBounds(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < 10;
	}

	static class Point{
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
