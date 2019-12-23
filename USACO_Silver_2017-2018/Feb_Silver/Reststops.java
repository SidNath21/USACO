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

public class Reststops {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ArrayList<Stop> stops = new ArrayList<Stop>(N);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			stops.add(new Stop(d, c));
		}
		
		for(int i=0; i<stops.size(); i++) {
			System.out.println(stops.get(i).d + " " + stops.get(i).c);
		}
		
		int[] prefixMax = new int[N];
		int max = -1;
		for(int i=N-1; i>= 0; i--) {
			max = Math.max(max, stops.get(i).c);
			prefixMax[i] = max;
		}
		
		long tF = 0, tB = 0;
		long t = 0;
		long lastD = 0;
		for(int i=0; i<stops.size(); i++) {
			
			long d = stops.get(i).d;
			long c = stops.get(i).c;
			
			if(c == prefixMax[i]) {
				tF += F * (d - lastD);
				tB += B * (d - lastD);
				t += c * (tF-tB);
				tB = tF;
				lastD = d;
			}
		}
		System.out.println(t);
		pw.println(t);
		br.close();
		pw.close();
		System.exit(0);
		
		
	}
	
	static class Stop implements Comparable<Stop>{
		int d, c;
		public Stop(int d, int c) {
			this.d = d;
			this.c = c;
		}
		@Override
		public int compareTo(Stop o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}

}
