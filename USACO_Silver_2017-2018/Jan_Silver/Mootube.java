
import java.io.*;
import java.util.*;

public class Mootube {

	private static ArrayList<Pair>[] pairs;
	private static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		pairs = new ArrayList[N];
		for(int i=0; i<N; i++){
			pairs[i] = new ArrayList<Pair>();
		}


		for(int i=0; i<N-1; i++){
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int q = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken());
			pairs[p].add(new Pair(q, r));
			pairs[q].add(new Pair(p, r));
		}

		visited = new boolean[N];
		for(int i=0; i<Q; i++){
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken()) - 1;
			Arrays.fill(visited, false);
			search(v, k);
			int count = visitCount();
			
			System.out.println(count);
			pw.println(count);	
		}

		br.close();
		pw.close();
		System.exit(0);


	}

	private static void search(int v, int k) {

		if(visited[v]) return;
		visited[v] = true;

		for(Pair pair : pairs[v]){
			if(!visited[pair.x] && pair.r >= k){
				search(pair.x, k);
			}
		}

	}

	private static int visitCount(){
		int count = 0;
		for(int i=0; i<visited.length; i++){
			if(visited[i]) count++;
		}
		return count - 1;
	}

	static class Pair {
		int x, r;
		public Pair(int x, int r){
			this.x = x;
			this.r = r;
		}
	}
}
			
