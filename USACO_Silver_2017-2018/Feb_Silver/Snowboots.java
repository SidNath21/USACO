import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Snowboots {


	private static int N, B;
	private static int[] snow, depth, steps;
	private static int best = Integer.MAX_VALUE;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][B];
		
		snow = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}
		
		depth = new int[B];
		steps = new int[B];
		for(int i=0; i<B; i++) {
			st = new StringTokenizer(br.readLine());
			depth[i] = Integer.parseInt(st.nextToken());
			steps[i] = Integer.parseInt(st.nextToken());
		}
		
		search(0, 0);
		System.out.println(best);
		pw.println(best);
		br.close();
		pw.close();
		System.exit(0);
	
	}

	private static void search(int i, int b) {
		
		if(visited[i][b]) return;
		visited[i][b] = true;
		
		if(i == N-1) {
			best = Math.min(best, b);
			return;
		}
		
		for(int j=i+1; j<N && j-i <= steps[b]; j++) {
			if(snow[j]<=depth[b]) search(j, b);
		}
		
		for(int newB = b+1; newB<B; newB++) {
			if(snow[i] <= depth[newB]) search(i, newB);
		}
		
	}

}
