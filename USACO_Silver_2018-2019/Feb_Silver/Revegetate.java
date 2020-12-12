import java.io.*;
import java.util.*;

public class Revegetate {

	private static ArrayList<Pair>[] pairs;
	private static int[] groups;
	private static boolean impossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		pairs = new ArrayList[N];
		for(int i=0; i<N; i++){
			pairs[i] = new ArrayList<Pair>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			int c;
			if(type == 'S'){
				c = 0;
			}
			else{
				c = 1;
			}
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			pairs[a].add(new Pair(b, c));
			pairs[b].add(new Pair(a, c));
			
		}

		groups = new int[N];
		int ans = 0; // num of components
		for(int i=0; i<N; i++){
			if(groups[i] == 0){
				search(i, 1);
				ans++;
			}
		}

		pw.print("1");
		for(int i=0; i<ans; i++){
			pw.print("0");
		}

		br.close();
		pw.close();
		System.exit(0);

	}

	public static void search(int n, int v){

		if(groups[n] != 0) return;
		groups[n] = v;

		for(Pair pair: pairs[n]){
			if(pair.type == 0){ // same
				search(pair.pos, v);
			}
			else{
				search(pair.pos, 3-v);
			}
		}
			
	}


	static class Pair{
		int pos, type;
		public Pair(int pos, int type){
			this.pos = pos;
			this.type = type;
		}
	}

}
