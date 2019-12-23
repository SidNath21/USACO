
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Mootube {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		ArrayList<Pair>[] pairs = new ArrayList[N];
		for(int i=0; i<pairs.length; i++) {
			pairs[i] = new ArrayList<Pair>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken())-1;
			int q = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken());
			pairs[p].add(new Pair(q, r));
			pairs[q].add(new Pair(p, r));
			
		}
			
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken())-1;
			boolean[] visited = new boolean[N];
			LinkedList<Integer> q = new LinkedList<Integer>(); 
			q.add(V);
			int ans = 0;
			visited[V] = true;
			while(!q.isEmpty()) {
				int p = q.removeFirst();
				for(Pair pair: pairs[p]) {
					if(!visited[pair.a] && pair.b >= K) {
						visited[pair.a] = true;
						q.add(pair.a);
						ans++;
					}
				}
			}
			System.out.println(ans);
			pw.println(ans);
			
		}
		
		br.close();
		pw.close();
		System.exit(0);
		

	}



	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}


/*
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Mootube {
	
	
	private static ArrayList<Pair>[] network;
	private static int[] min;
	private static int count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		network = new ArrayList[N+1];
		min = new int[N+1];
		for(int i=0; i<network.length; i++) {
			network[i] = new ArrayList<Pair>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			network[p].add(new Pair(q, r));
			network[q].add(new Pair(p, r));	
		}
		
		for(int i=1; i<network.length; i++) {
			int miin = Integer.MAX_VALUE;
			for(int j=0; j<network[i].size(); j++) {
				miin = Math.min(miin, network[i].get(j).r);
			}
			min[i] = miin;
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			count = 0;
			search(K, V);
			System.out.println(count);
			pw.println(count);
			
		}
		
		br.close();
		pw.close();
		System.exit(0);
		
		
		
	
		
	}
	
	private static void search(int k, int v) {
		
		boolean[] visited = new boolean[network.length];
		for(int i=1; i<network.length; i++) {
		
			if(i != v) {
				boolean found = false;
				for(int j=0; j<network[i].size(); j++) {
				
					if(!visited[network[i].get(j).v] && network[i].get(j).v == v) {
						found = true;
						visited[network[i].get(j).v] = true;
						if(network[i].get(j).r >= k) count++;
					}
				}
				if(!found) {
					int m = Math.min(min[v], min[i]);
					if(m >= k) count++;
				}
			}
		}
		
	}

	static class Pair{
		int v, r;
		public Pair(int v, int r) {
			this.v = v;
			this.r = r;
		}
	}

}
*/
