import java.io.*;
import java.util.*;

public class Countcross{

	private static boolean [][] visited;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static ArrayList<Road>[][] roads;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		visited = new boolean[N][N];
		roads = new ArrayList[N][N];
		ArrayList<Cow> cows = new ArrayList<Cow>();

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				roads[i][j] = new ArrayList<Road>();
			}
		}

		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			roads[a][b].add(new Road(x, y));
			roads[x][y].add(new Road(a, b));
		}

		for(int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			cows.add(new Cow(x, y));
		}

		int count = 0;
		for(int i=0; i<K; i++){
			for(int j=i+1; j<K; j++){

				for(boolean[] arr: visited){
					Arrays.fill(arr, false);
				}
				
				int x = cows.get(i).x;
				int y = cows.get(i).y;

				int oX = cows.get(j).x;
				int oY = cows.get(j).y;

				search(x, y);

				if(!visited[oX][oY]) count++;
				
			}
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

		for(int i=0; i<4; i++){

			int newX = x + dx[i];
			int newY = y + dy[i];

			boolean blocked = false;
			for(Road road: roads[x][y]){
				if(road.x == newX && road.y == newY){
					blocked = true;
				}
			}

			if(!blocked && inBounds(newX, newY) && !visited[newX][newY]){
				search(newX, newY);
			}

		}
	}

	private static boolean inBounds(int x, int y){
		return x >= 0 && x < N && y>= 0 && y < N;
	}

	static class Road {
		int x, y;
		public Road(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static class Cow{
		int x, y;
		public Cow(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
