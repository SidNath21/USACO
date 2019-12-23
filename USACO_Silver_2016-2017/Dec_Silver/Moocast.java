import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Moocast {
	
	private static boolean[] visited;
	private static int[] X, Y, power;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		N = Integer.parseInt(br.readLine());
		X = new int[N];
		Y = new int[N];
		power = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1;
		for(int i=0; i<N; i++) {
			search(i);
			max = Math.max(max, count());
			Arrays.fill(visited, false);
		}
		
		System.out.println(max);
		pw.println(max);
		br.close();
		pw.close();
		System.exit(0);
		
	}
	
	private static int count() {
		int count = 0;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) count++;
		}
		return count;
	}
	
	private static void search(int i) {
		
		if(visited[i]) return;
		visited[i] = true;
		
		int x1 = X[i];
		int y1 = Y[i];
		int radius = power[i];
		for(int j=0; j<N; j++) {
			if(!visited[j] && i != j) {
				int x2 = X[j];
				int y2 = Y[j];
				if(canReach(x1, y1, x2, y2, radius)) {
					search(j);
				}
			}
		}
	}

	public static boolean canReach(int x1, int y1, int x2, int y2, int r) {
		return (Math.pow(r, 2) >= (Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2)));
	}

}
