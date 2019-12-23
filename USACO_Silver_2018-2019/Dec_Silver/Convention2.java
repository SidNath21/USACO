import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Convention2 {

	private static int N;
	private static ArrayList<Cow> cows;
	private static boolean[] done;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		N = Integer.parseInt(br.readLine());
		cows = new ArrayList<Cow>(N);
		done = new boolean[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}


		int t = 0;
		int maxTime = 0;
		int c = N;
		while(c!=0) {
			System.out.println(t);
			boolean inLine = inLine(t);
			int j = getNext(t, inLine);
			if(inLine) {
				maxTime = Math.max(maxTime, t - cows.get(j).arrive);
				t += cows.get(j).time;
			}
			else {
				t+= cows.get(j).arrive-t + cows.get(j).time;	
			}
			done[j] = true;
			c--;
		}

		System.out.println(maxTime);
		pw.print(maxTime);
		br.close();
		pw.close();
		System.exit(0);


	}

	private static boolean inLine(int t) {
		for(int i=0; i<cows.size(); i++) {
			if(!done[i] && cows.get(i).arrive < t) return true;
		}
		return false;
	}

	private static int getNext(int t, boolean inLine) {
		int next = N;
		int min = Integer.MAX_VALUE;

		if(inLine) {
			for(int i=0; i<cows.size(); i++) {
				if(!done[i] && cows.get(i).arrive < t && i < next) {
					next = i;
				}
			}
			return next;
		}

		else {
			for(int i=0; i<cows.size(); i++) {
				if(!done[i]) {
					if(cows.get(i).arrive < min) {
						min = cows.get(i).arrive;
						next = i;
					}
					if(cows.get(i).arrive == min) {
						next = Math.min(i, next);
					}
				}
			}
			return next;
		}
	}

	static class Cow{
		int arrive,  time,  p;
		public Cow(int arrive, int time, int p ) {
			this.arrive = arrive;
			this.time = time;
			this.p = p;
		}
	}

	static class Sort implements Comparator<Cow>{

		@Override
		public int compare(Cow o1, Cow o2) {

			return 0;
		}



	}

}
