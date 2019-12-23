import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Blist {
	
	private static int [] start, end, buckets;
	private static int[] oStart, oEnd;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		N = Integer.parseInt(br.readLine());
		start = new int[N];
		end = new int[N];
		buckets = new int[N];
		oStart = new int[N];
		oEnd = new int[N];
		
		int time = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			start[i] = a;
			end[i] = b;
			oStart[i] = a;
			oEnd[i] = b;
			buckets[i] = c;
			time = Math.min(a, time);
			System.out.println(a + " " + b + " " + c);		
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		
		System.out.println();
		int answer = 0;
		int bkts = 0;
		int s = 0, e = 0;
		
		while(s < N || e < N) {
			if(s!=N && start[s] < end[e]) { // encounter a start time
				int bucketsRequired = getBuckets(start[s]);
				//if(bucketsRequired > bkts ) bkts = bucketsRequired;
				bkts += bucketsRequired;
				System.out.println(start[s] + " " + bkts);
				s++;
			}
			else if(e!=N){ // end time
				int bucketsRequired = getBuckets(end[e]);
				bkts -= bucketsRequired;
				System.out.println(end[e] + " " + bkts);
				e++;
			}
			
			answer = Math.max(bkts, answer);
		}
		System.out.println();
		System.out.println(answer);
		
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);

	}

	private static int getBuckets(int i) {
		for(int j = 0; j<N; j++) {
			if(oStart[j] == i || oEnd[j] == i) {
				return buckets[j];
			}
		}
		return 0;
	}

}
