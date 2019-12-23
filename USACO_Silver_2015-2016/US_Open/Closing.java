import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Closing {

	private static ArrayList<Integer>[] pairs;

	private static boolean[] visited, closed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		closed = new boolean[N];
		pairs = new ArrayList[N];
		int[] closing = new int[N];
		visited = new boolean[N];
		for(int i=0; i<pairs.length; i++) {
			pairs[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			pairs[a].add(b);
			pairs[b].add(a);
		}

		for(int i=0; i<N; i++) {
			closing[i] = Integer.parseInt(br.readLine())-1;
		}

		
		int pos = closing[N-1];
		search(pos);
		
		if(works()) {
			System.out.println("YES");
			pw.println("YES");
		}
		else {
			System.out.println("NO");
			pw.println("NO");
		}

		for(int i=0; i<closing.length-1; i++) {
			closed[closing[i]] = true;
			Arrays.fill(visited, false);
			
			search(pos);
			
			
			if(works()) {
				System.out.println("YES");
				pw.println("YES");
			}
			else {
				System.out.println("NO");
				pw.println("NO");
			}


		}
		
		br.close();
		pw.close();
		System.exit(0);
		





	}

	private static boolean works() {

		for(int i=0; i<visited.length; i++) {
			if(!closed[i]) {
				if(!visited[i]) return false;
			}
		}

		return true;


	}

	private static void search(int n) {

		if(visited[n] || closed[n]) return;
		visited[n] = true;

		for(int i = 0; i<pairs[n].size(); i++) {
			if(!closed[pairs[n].get(i)] ) {
				if(!visited[pairs[n].get(i)]) {
					search(pairs[n].get(i));
				}
			}
		}



	}




}

