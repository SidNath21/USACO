
import java.io.*;
import java.util.*;

public class Gates{

	private static int N;
	private static int[][] farm;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		N = Integer.parseInt(br.readLine());
		String gateStr = br.readLine();
		int size = 98;
		farm = new int[size][size];
		visited = new boolean[size][size];

		int x = size/2, y = size/2;
		farm[x][y] = 1;
		visited[x][y] = true;
		int dirX = 0, dirY = 0;
		for(int i=0; i<N; i++){
			char ch = gateStr.charAt(i);
			if(ch == 'N') {
				dirX = 0;
				dirY = 1;
			}
			else if(ch == 'S') {
				dirX = 0;
				dirY = -1;
			}
			else if(ch == 'E') {
				dirX = 1;
				dirY = 0;
				
			}
			else {
				dirX = -1;
				dirY = 0;
			}
			for(int step = 0; step < 2; step++) {
				x += dirX;
				y += dirY;
				farm[x][y]++;
				visited[x][y] = true;
			}
		}

		int count = 0;
		
		for(int i=0; i<farm.length; i++) {
			for(int j=0; j<farm.length; j++) {
				// System.out.print(farm[i][j]);
				if(!visited[i][j] && farm[i][j] == 0) {
					search(i, j);
					count++;
				}
			}
			// System.out.println();
		}

		System.out.println(count-1);
		pw.println(count-1);
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
			if(inBounds(newX, newY) && !visited[newX][newY]){
				search(newX, newY);
			}
		}
	}

	private static boolean inBounds(int x, int y){
		return x >= 0 && x < farm.length && y >= 0 && y < farm.length;
	}

}



























// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.LinkedList;

// public class Gates { // BFS

// 	private static int[] dx = {-1, 1, 0, 0};
// 	private static int[] dy = {0, 0, -1, 1};
// 	private static int [][] farm;
// 	private static boolean [][] visited;
	
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
// 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
// 		int N = Integer.parseInt(br.readLine());
// 		farm = new int[2001][2001];
// 		visited = new boolean[2001][2001];
// 		String str = br.readLine();
// 		int x = 1000, y = 1000;
// 		farm[x][y]++;
// 		visited[x][y] = true;
// 		int dirX = 0;
// 		int dirY = 0;
// 		for(int i=0; i<N; i++) {
// 			char ch = str.charAt(i);
			
// 			if(ch == 'N') {
// 				dirX = 0;
// 				dirY = 1;
// 			}
// 			else if(ch == 'S') {
// 				dirX = 0;
// 				dirY = -1;
// 			}
// 			else if(ch == 'E') {
// 				dirX = 1;
// 				dirY = 0;
				
// 			}
// 			else {
// 				dirX = -1;
// 				dirY = 0;
				
// 			}
// 			for(int step = 0; step < 2; step++) {
// 				x += dirX;
// 				y += dirY;
// 				farm[x][y]++;
// 				visited[x][y] = true;
// 			}
// 		}
		

// 		int count = 0;
		
// 		for(int i=0; i<farm.length; i++) {
// 			for(int j=0; j<farm.length; j++) {
// 				if(!visited[i][j]) {
// 					search(i, j);
// 					count++;
// 				}
// 			}
// 		}
		
// 		System.out.println(count);
		
		
		

// 	}

// 	private static void search(int i, int j) {
		
// 		/*
// 		visited[i][j] = true;
// 		System.out.println(i + " " + j);
		
// 		for(int k=0; k<4; k++) {
// 			int newX = i + dx[k];
// 			int newY = j + dy[k];
// 			if(inBounds(newX, newY) && !visited[newX][newY] && farm[newX][newY] == 0) {
// 				search(newX, newY);
// 			}
// 		}
// 		*/
		
		
		
// 		LinkedList<Point> q = new LinkedList<Point>();
// 		q.add(new Point(i, j));
// 		visited[i][j] = true;
// 		while(!q.isEmpty()) {
// 			Point p = q.removeFirst();
			
// 			for(int k=0; k<4; k++) {
// 				int x = p.x + dx[k];
// 				int y = p.y + dy[k];
// 				if(inBounds(x, y) && !visited[x][y]) {
// 					visited[x][y] = true;
// 					q.add(new Point(x, y));
// 				}
				
// 			}
// 		}
		
// 	}
	
// 	private static boolean inBounds(int x, int y) {
// 		return (x >= 0 && y >= 0 && x < farm.length && y < farm.length);
// 	}
	
// 	static class Point{
// 		int x, y;
// 		public Point(int x, int y) {
// 			this.x = x;
// 			this.y = y;
// 		}
// 	}
// }



