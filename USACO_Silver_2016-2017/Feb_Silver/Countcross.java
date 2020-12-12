import java.io.*;
import java.util.*;

public class Countcross{

	private static ArrayList<Road>[][] roads;
	private static boolean[][] visited;
	private static int N;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		roads = new ArrayList[N][N];
		visited = new boolean[N][N];
		
		ArrayList<Cow> cows = new ArrayList<Cow>();

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				roads[i][j] = new ArrayList<Road>();
			}
		}

		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			roads[x][y].add(new Road(a, b));
			roads[a][b].add(new Road(x, y));
		}
		
		for(int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			cows.add(new Cow(x, y));
		}

		int count = 0;
		for(int i=0; i<K; i++) {
			for(int j=i+1; j<K; j++) {	
					search(cows.get(i).x, cows.get(i).y);
					if(!visited[cows.get(j).x][cows.get(j).y]) count++;
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

	private static void search(int x, int y){
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

			if(!blocked){
				if(inBounds(newX, newY) && !visited[newX][newY]){
					search(newX, newY);
				}
			}
			
			
		}

		
	}


	private static boolean inBounds(int x, int y){
		return x >= 0 && x < N && y >=0 && y < N;
	}



	static class Road{
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










// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class Countcross {

// 	private static int[][] cows;
// 	private static boolean[][] visited;
// 	private static int N;
// 	private static int[] dr = {-1, 1, 0, 0};
// 	private static int[] dc = {0, 0, -1, 1};
// 	private static ArrayList<Fence>[][] fences;


// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
// 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		N = Integer.parseInt(st.nextToken());
// 		int K = Integer.parseInt(st.nextToken());
// 		int R = Integer.parseInt(st.nextToken());

// 		fences = new ArrayList[N][N];

// 		for(int i=0; i<fences.length; i++) {
// 			for(int j=0; j<fences.length; j++) {
// 				fences[i][j] = new ArrayList<Fence>();
// 			}
// 		}
		
// 		visited = new boolean[N][N];
// 		cows = new int[K][2];
// 		for(int i=0; i<R; i++) {
// 			st = new StringTokenizer(br.readLine());
// 			int r1 = Integer.parseInt(st.nextToken())-1;
// 			int c1 = Integer.parseInt(st.nextToken())-1;
// 			int r2 = Integer.parseInt(st.nextToken())-1;
// 			int c2 = Integer.parseInt(st.nextToken())-1;
// 			fences[r1][c1].add(new Fence(r2, c2));
// 			fences[r2][c2].add(new Fence(r1, c1));
// 		}

// 		for(int i=0; i<K; i++) {
// 			st = new StringTokenizer(br.readLine());
// 			int r = Integer.parseInt(st.nextToken())-1;
// 			int c = Integer.parseInt(st.nextToken())-1;
			
// 			cows[i][0] = r;
// 			cows[i][1] = c;
// 		}

// 		int count = 0;
// 		for(int i=0; i<K; i++) {
// 			for(int j=i+1; j<K; j++) {	
// 					search(cows[i][0], cows[i][1]);
// 					if(!visited[cows[j][0]][cows[j][1]]) count++;
// 					for(boolean[] arr: visited) {
// 						Arrays.fill(arr, false);
// 					}
// 				}
			
// 		}

// 		System.out.println(count);
// 		pw.println(count);
// 		br.close();
// 		pw.close();
// 		System.exit(0);



// 	}

// 	private static void search(int r, int c) {

		
// 		if(visited[r][c]) return;
// 		visited[r][c] = true;

// 		for(int k=0; k<4; k++) {
// 			int newR = r + dr[k];
// 			int newC = c + dc[k];
// 			boolean blocked = false;
// 			for(int a = 0; a<fences[r][c].size(); a++) {
// 				if(newR == fences[r][c].get(a).r && newC == fences[r][c].get(a).c) {
// 					blocked = true;
// 				}
// 			}

// 			if(!blocked) {
// 				if(inBounds(newR, newC) && !visited[newR][newC]) {
// 					search(newR, newC);
// 				}
// 			}
// 		}

// 	}

// 	private static boolean inBounds(int r, int c) {
// 		return (r >= 0 && r < N && c >= 0 && c < N);
// 	}

// 	static class Fence{
// 		int r, c;
// 		public Fence(int r, int c) {
// 			this.r = r;
// 			this.c = c;
// 		}
// 	}

// }
