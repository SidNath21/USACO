import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Angry {

	public static void main(String[] args) throws IOException { // BinarySearch
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] bales = new int[N];
		for(int i=0; i<N; i++) {
			bales[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bales);
		
		int min = 0, max = 100000000;
		while(min != max) {
			int mid = (min + max) / 2;
			int cows = 0;
			int leftCow = 0;
			while(leftCow < N) {
				cows++;
				int pos = leftCow + 1;
				while(pos < N && bales[pos] - bales[leftCow] <= 2*mid) {
					pos++;
				}
				leftCow = pos;
			}
			
			if(cows <= K) max = mid;
			else min = mid + 1;
			
			
			
		}
		
		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);
		

	}

}
