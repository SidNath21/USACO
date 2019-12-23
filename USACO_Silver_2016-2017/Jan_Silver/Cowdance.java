import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Cowdance {
	
	private static int[] cows;
	private static int N, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		cows = new int[N];
		
		for(int i=0; i<N; i++) {
			cows[i]  = Integer.parseInt(br.readLine());
		}
		
		
		System.out.println(works(6));
		
		int min = 1;
		int max = N;
		while(min != max) {
			int mid = (min + max) / 2;
			
			if(works(mid)) max = mid;
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);
		
		
		
	

	}

	private static boolean works(int mid) {
		
		int time = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<cows.length; i++) {
			Collections.sort(arr);
			if(arr.size() == mid) {
				time = arr.remove(0);
				
			}
			if(time + cows[i] > T) return false;
			arr.add(time + cows[i]);
			
		}
		return true;
	}

	

}
