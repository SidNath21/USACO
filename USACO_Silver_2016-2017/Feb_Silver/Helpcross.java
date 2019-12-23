import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Helpcross {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] chickens = new int[C];
		ArrayList<Time> times = new ArrayList<Time>();

		for(int i=0; i<C; i++) {
			chickens[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			times.add(new Time(a, b));
		}

		Arrays.sort(chickens);
		Collections.sort(times, new Sort());
		boolean[] used = new boolean[N];
		int count = 0;
		for(int i=0; i<chickens.length; i++) {
			for(int j=0; j<times.size(); j++) {
				if(!used[j]) {
					if(chickens[i] >= times.get(j).start && chickens[i] <= times.get(j).end) {
						count++;
						used[j] = true;
						break;
					}
				}
			}

		}


		System.out.println(count);
		pw.print(count);
		br.close();
		pw.close();
		System.exit(0);


	}

	static class Time{
		int start, end;
		public Time(int a, int b) {
			start = a;
			end = b;
		}
	}


	static class Sort implements Comparator<Time>{

		@Override
		public int compare(Time o1, Time o2) {
			if(o1.start == o2.start && o1.end == o2.end) return 0;
			if(o1.end < o2.end) return -1;
			if(o1.end == o2.end && o1.start < o2.start) return -1;

			else return 1;
		}

	}


}
