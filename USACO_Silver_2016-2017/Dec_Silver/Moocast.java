import java.io.*;
import java.util.*;

public class Moocast{

	private static ArrayList<Cow> cows;
	private static int N;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		N = Integer.parseInt(br.readLine());
		cows = new ArrayList<Cow>();
		StringTokenizer st;


		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			cows.add(new Cow(x, y, p));
		}
		visited = new boolean[N];

		int maxCount = 0;
		for(int i=0; i<N; i++){
			Arrays.fill(visited, false);
			search(i);
			maxCount = Math.max(maxCount, visitCount());
		}

		System.out.println(maxCount);
		pw.println(maxCount);
		br.close();
		pw.close();
		System.exit(0);
	}


	public static void search(int n){

		if(visited[n]) return;
		visited[n] = true;

		int radius = cows.get(n).p;
		int x = cows.get(n).x;
		int y = cows.get(n).y;

		for(int i=0; i<cows.size(); i++){
			int a = cows.get(i).x;
			int b = cows.get(i).y;
			if(!visited[i]){
				
				int distance = (int) (Math.pow(Math.abs(x - a), 2)) + (int) (Math.pow(Math.abs(y - b), 2));
				if(radius * radius >= distance){
					search(i);
				}
				 
			}
		}

	}

	private static int visitCount(){
		int count = 0;
		for(int i=0; i<visited.length; i++){
			if(visited[i]) count++;
		}
		return count;
	}

	static class Cow {
		int x, y, p;
		public Cow(int x, int y, int p){
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
}