import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Convention {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] cows = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cows);

		int low = 0, high = cows[N-1];
		int last = -1;

		while(low < high) {
			int mid = (low+high)/2;
			if(last == mid) break;
			if(work(cows, mid, M, K)) high = mid;
			else low = mid;		
			last = mid;
		}

		int ans = 0;
		if(work(cows, high, M, K)) {
			ans = high;
		}
		else ans = low;

		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);
	}

	public static boolean work(int[] cows , int time, int m, int c ) {

		int count = 0;
		int currTime = cows[0];

		for(int i = 0; i<cows.length; i++) {
			if(cows[i] - currTime > time || count >= c) {
				currTime = cows[i];
				m--;
				count = 0;
			}
			count++;
		}
		m--;

		if(m < 0) return false;


		return true;

	}

}
