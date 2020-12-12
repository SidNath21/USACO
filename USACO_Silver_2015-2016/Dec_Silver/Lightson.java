import java.io.*;
import java.util.*;

public class Lightson{

	private static int N, M;
	private static boolean[][] visited;
	private static int[][] rooms;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static ArrayList<Point>[][] points;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rooms = new int[N][N];
		visited = new boolean[N][N];

		points = new ArrayList[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				points[i][j] = new ArrayList<Point>();
			}
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			points[x][y].add(new Point(a, b));
			points[a][b].add(new Point(x, y));
		}

		rooms[0][0] = 1;
		search(0, 0);
		
		int count = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(rooms[i][j]);
				if(rooms[i][j] == 1){
					count++;
				}
			}
			System.out.println();
		}

		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);

	}

	private static void search(int x, int y) {

		if(visited[x][y]) return;
		visited[x][y] = true;

		for(Point point: points[x][y]){

			int a = point.x;
			int b = point.y;

			if(rooms[a][b] == 0 && !visited[a][b]){
				rooms[a][b] = 1;
				if(hasVisitedNeighbor(a, b)){
					search(a, b);
				}
			}
		}

		for(int i=0; i<dx.length; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && !visited[newX][newY] && rooms[newX][newY] == 1){
				search(newX, newY);
			}
		}

		

	}

	private static boolean hasVisitedNeighbor(int x, int y) {
		
		for(int i=0; i<dx.length; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && visited[newX][newY]){
				return true;
			}
		}

		return false;
		
	}

	private static boolean inBounds(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static class Point {
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

