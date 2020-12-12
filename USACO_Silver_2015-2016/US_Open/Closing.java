import java.util.*;
import java.io.*;

public class Closing{

	private static ArrayList<Integer>[] paths;
	private static boolean[] visited, closed;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		paths = new ArrayList[N];
		for(int i=0; i<N; i++){
			paths[i] = new ArrayList<Integer>();
		}

		int[] closings = new int[N];

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			paths[a].add(b);
			paths[b].add(a);
		}

		for(int i=0; i<N; i++){
			closings[i] = Integer.parseInt(br.readLine()) - 1;
		}

		visited = new boolean[N];
		closed = new boolean[N];

		int pos = closings[N-1];
		search(pos);
		if(works()){
			System.out.println("YES");
			pw.println("YES");
		}
		else{
			System.out.println("YES");
			pw.println("NO");
		}

		for(int i=0; i<closings.length-1; i++){
			Arrays.fill(visited, false);
			closed[closings[i]] = true;
			search(pos);
			if(works()){
				System.out.println("YES");
				pw.println("YES");
			}
			else{
				System.out.println("NO");
				pw.println("NO");
			}
		}

		br.close();
		pw.close();
		System.exit(0);

	}

	public static void search(int pos){

		if(visited[pos] || closed[pos]) return;
		visited[pos] = true;

		// System.out.println(pos);

		for(int i=0; i<paths[pos].size(); i++){

			if(!closed[paths[pos].get(i)]){
				if(!visited[paths[pos].get(i)]){
					search(paths[pos].get(i));
				}
			}
		
			
		}

	}

	public static boolean works(){
		for(int i=0; i<visited.length; i++){
			if(!closed[i]){
				if(!visited[i]) return false;
			}
			
		}

		return true;
	}
}
