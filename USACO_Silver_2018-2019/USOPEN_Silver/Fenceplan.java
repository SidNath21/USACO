import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Fenceplan {

	
	private static ArrayList<Integer>[] pairs;
	private static boolean[] visited;
	private static int[] X, Y;
	private static int x1, y1, x2, y2;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = new int[N];
		Y = new int[N];
		
		
		pairs = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			pairs[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			X[i] = x;
			Y[i] = y;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			pairs[a].add(b);
			pairs[b].add(a);
		}
		
		
		int minPerimeter = Integer.MAX_VALUE;
		for(int i=0; i<pairs.length; i++) {
			if(!visited[i]) {
				x1 = Integer.MAX_VALUE;
				y1 = Integer.MAX_VALUE;
				x2 = Integer.MIN_VALUE;
				y2 = Integer.MIN_VALUE;
				visit(i);
				minPerimeter = Math.min(minPerimeter, (2 * ((x2-x1) + (y2-y1))));
			}
		}
		
		System.out.println(minPerimeter);
		pw.println(minPerimeter);
		br.close();
		pw.close();
		System.exit(0);
		

	}


	private static void visit(int i) {
		if(visited[i]) return;
		visited[i] = true;
		
		x1 = Math.min(x1, X[i]);
		y1 = Math.min(y1, Y[i]);
		x2 = Math.max(x2, X[i]);
		y2 = Math.max(y2, Y[i]);
		
		for(int j = 0; j<pairs[i].size(); j++) {
			if(!visited[pairs[i].get(j)]) {
				visit(pairs[i].get(j));
			}
		}
		
		
	}




}
