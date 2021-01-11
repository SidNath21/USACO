import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Angry {

	private static int[] bales;
	private static int N, K;

	public static void main(String[] args) throws IOException { // BinarySearch
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bales = new int[N];
		for(int i=0; i<N; i++) {
			bales[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bales);
		
		int min = 0, max = 100000000;
		while(min != max) {
			int mid = (min + max) / 2;

			if(works(mid)){
				max = mid;
			}
			else{
				min = mid + 1;
			}
			
		}

		
		
		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);
		

	}

	private static boolean works(int r){

		int curr = 0;
		int pos = bales[curr];
		for(int i=0; i<K; i++){

			while(curr < N && bales[curr] - pos <= 2*r){
				curr++;
			}

			if(curr == N) return true;

		
			pos = bales[curr];	

		}

		return false;


	}

}
