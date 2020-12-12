
import java.io.*;
import java.util.*;

public class Perimeter{

	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1} ;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int N;
	private static int area, perimeter;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		N = Integer.parseInt(br.readLine());

		arr = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<N; j++){
				int num;
				if(str.charAt(j) == '#'){
					num = 1;
				}
				else{
					num = 0;
				}
				arr[i+1][j+1] = num;
			}
		}

		int maxArea = -1;
		int minPerimeter = Integer.MAX_VALUE;
		for(int i=0; i<N+2; i++){
			for(int j=0; j<N+2; j++){
				if(!visited[i][j] && arr[i][j] == 1){
					area = 0;
					perimeter = 0;
					search(i, j);
					if(area > maxArea){
						maxArea = area;
						minPerimeter = perimeter;
					}

					else if(area == maxArea){
						minPerimeter = Math.min(minPerimeter, perimeter);
					}
					
				}
			}
		}

		System.out.println(maxArea + " " + minPerimeter);
		pw.println(maxArea + " " + minPerimeter);
		br.close();
		pw.close();
		System.exit(0);


		// for(int i=0; i<N+2; i++){
		// 	for(int j=0; j<N+2; j++){
		// 		System.out.print(arr[i][j]);
		// 	}
		// 	System.out.println();
		// }
		
	}

	private static void search(int x, int y) {

		if(visited[x][y]) return;
		visited[x][y] = true;
		area++;

		int p = 0;
		for(int i=0; i<dx.length; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && arr[newX][newY] == 0){
				p++;
			}
		}

		perimeter += p;

		for(int i=0; i<dx.length; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(inBounds(newX, newY) && arr[newX][newY] == 1 && !visited[newX][newY]){
				search(newX, newY);
			}

		}

	}

	private static boolean inBounds(int x, int y) {
		return x >= 0 && y >=0 && x < N+2 && y < N+2;
	}
}



// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.Arrays;

// public class Perimeter {

// 	private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
// 	private static int N;
// 	private static int[][] arr;
// 	private static boolean[][] visited;
// 	private static int area = 0, perimeter = 0;

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
// 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
// 		 N = Integer.parseInt(br.readLine());
// 		arr = new int[N+2][N+2];
// 		visited = new boolean[N+2][N+2];
		
		
// 		for(int i=0; i<N; i++) {
// 			String str = br.readLine();
// 			for(int j=0; j<str.length(); j++) {
// 				char ch = str.charAt(j);
// 				int k = 0;
// 				if(ch == '#') k = 1;
// 				arr[i+1][j+1] = k;
// 			}
// 		}
		
// 		int maxArea = 0;
// 		int maxPerimeter = Integer.MAX_VALUE;
// 		for(int i=0; i<N+2; i++) {
// 			for(int j = 0; j<N+2; j++) {
// 				if(!visited[i][j] && arr[i][j] == 1) {
// 					area = 0;
// 					perimeter = 0;
// 					search(i, j);
// 					if(area > maxArea) {
// 						maxArea = area;
// 						maxPerimeter = perimeter;
// 					}
// 					if(area == maxArea) {
// 						maxPerimeter = Math.min(maxPerimeter, perimeter);
// 					}
					
// 				}
// 			}
// 		}
		
// 		System.out.println(maxArea + " " + maxPerimeter);
// 		pw.println(maxArea + " " + maxPerimeter);
// 		br.close();
// 		pw.close();
// 		System.exit(0);
		
		
		
		
// 	}

// 	private static void search(int x, int y) {
// 		if(visited[x][y]) return;
// 		visited[x][y] = true;
// 		area++;
// 		perimeter += nextTo(x, y);
		
// 		for(int i=0; i<4; i++) {
// 			int newX = x + dx[i];
// 			int newY = y + dy[i];
// 			if(inBounds(newX, newY) && arr[newX][newY] == 1 && !visited[newX][newY]) {
// 				search(newX, newY);
// 			}
// 		}
		
// 	}
	
// 	private static boolean inBounds(int x, int y) {
// 		return (x >= 0 && x < N + 2 && y >= 0 && y < N+2);
// 	}
	
// 	private static int nextTo(int x, int y) {
// 		int count = 0;
// 		for(int i=0; i<4; i++) {
// 			if(inBounds(x + dx[i], y + dy[i]) && arr[x+dx[i]][y+dy[i]] == 0) count++;
// 		}
// 		return count;
// 	}

// }
