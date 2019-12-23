import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mooyomooyo {

	private static int N, K;
	private static int[][] board;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static boolean works = false, done = false;
	

	

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][10];
		visited = new boolean[N][10];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<10; j++) {
				board[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
			}
		}
		
	
		
		while(!done) {
			
			int count = 0;
			done = false;
			works = false;
			
			for(boolean[] bool: visited) Arrays.fill(bool, false);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<10; j++) {
					
					if(board[i][j] != 0 && !visited[i][j]) {
						ArrayList<Point> points = new ArrayList<Point>();
						search(i, j, board[i][j], points);
						if(points.size() >= K) {
							count++;
							for(Point p: points) {
								board[p.x][p.y] = 0;
							}
						}
					}
				}
			}

			
			if(count == 0) {
				done = true;
				
			}
			
			
			while(!works) {
				gravity();
			}
		
			
		}
		
		print();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<10; j++) {
				pw.print(board[i][j]);
			}
			pw.println();
		}
		
		br.close();
		pw.close();
		System.exit(0);
		
		
		
		
		
		
		//print();
		//gravity();
		//print();
		
		
		

	}


	private static void search(int x, int y, int k, ArrayList<Point> points ) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		points.add(new Point(x, y));
		
		for(int i = 0; i<4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && !visited[newX][newY] && board[newX][newY] == k) {
				search(newX, newY, k, points);
			}
		}
		
	}
	
	private static void gravity() {
		int count = 0;
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<10; j++) {
				if(board[i][j] == 0 && board[i-1][j] > 0) {
					count++;
					board[i][j] = board[i-1][j];
					board[i-1][j] = 0;
					
				}
				
			}
		}
		
		if(count == 0) works = true;
		else works = false;
		
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(board[i][j] + "");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static boolean inBounds(int x, int y) {
		return (x >= 0 && x< N && y >= 0 && y < 10);
	}
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
