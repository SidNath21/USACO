import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Lightson {

	private static int[][] rooms;
	private static boolean[][] visited;
	private static ArrayList<Switch> switches;
	private static int [] dr = {1, -1, 0, 0};
	private static int [] dc = {0, 0, -1, 1};
	private static int N, M;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rooms = new int[N][N];
		visited = new boolean[N][N];
		switches = new ArrayList<Switch>();

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			switches.add(new Switch(x, y, a, b));
		}

		Collections.sort(switches, new Sort());



		rooms[0][0] = 1;
		search(0, 0);

		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(rooms[i][j] == 1) {

					count++;
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

		System.out.println(r + " " + c);

		if(visited[r][c]) return;
		visited[r][c] = true;
		


		for(int i=0; i<switches.size(); i++) {
			int x = switches.get(i).x;
			int y = switches.get(i).y;
			int a = switches.get(i).a;
			int b = switches.get(i).b;
			if(x == r && y == c) {
				if(rooms[a][b] == 0) {
					rooms[a][b] = 1;
					if(hasNeighbor(a, b)) search(a, b);
				}
			}
		}

		for(int i=0; i<4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			if(inBounds(newR, newC) && rooms[newR][newC] == 1) {
				search(newR, newC);
			}
		}


	}

	private static boolean hasNeighbor(int a, int b) {

		for(int i=0; i<4; i++) {
			if((inBounds(a+dr[i],b + dc[i]) && rooms[a+dr[i]][b + dc[i]] == 1 && visited[a+dr[i]][b + dc[i]])) return true;
		}
		return false;
	}

	private static boolean inBounds(int r, int c) {
		return(r >= 0 && r < N && c >= 0 && c < N);
	}

	static class Switch {

		int x, y, a, b;
		public Switch(int x, int y, int a, int b) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
		}

	}

	static class Sort implements Comparator<Switch>{


		public int compare(Switch o1, Switch o2) {

			if(o1.x != o2.x) return o1.x - o2.x;
			else if(o1.y != o2.y) return o1.y - o2.y;
			else if(o1.a != o2.a) return o1.a - o2.a;
			else return o1.b - o2.b;
			
			


		}

	}
}


