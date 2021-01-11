import java.io.*;
import java.util.*;

public class Helpcross{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] chickens = new int[C];	
		ArrayList<Cow> cows = new ArrayList<Cow>();

		for(int i=0; i<C; i++){
			 chickens[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			cows.add(new Cow(s, e));
		}

		Arrays.sort(chickens);
		Collections.sort(cows);
		boolean[] used = new boolean[N];
		int count = 0;
		for(int i=0; i<chickens.length; i++) {
			for(int j=0; j<cows.size(); j++) {
				if(!used[j]) {
					if(chickens[i] >= cows.get(j).start && chickens[i] <= cows.get(j).end) {
						count++;
						used[j] = true;
						break;
					}
				}
			}

		}


		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);

	}

	static class Cow implements Comparable<Cow>{
		int start, end;
		public Cow(int start, int end){
			this.start = start;
			this.end = end;
		}

		public int compareTo(Cow oCow){
			if(end == oCow.end){
				return start - oCow.start;
			}

			return end - oCow.end;
		}
	}

}

