import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Haybales {
	
	private static int[] farm, position;
	private static int N, Q;

	public static void main(String[] args) throws IOException { // Binary Search
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		position = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			position[i] = pos;
		}
		
		Arrays.sort(position);
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int aCount = findBales(a-1);
			int bCount = findBales(b);
			
			System.out.println(bCount - aCount);
			pw.println(bCount - aCount);
					
			
		}
	
		
		br.close();
		pw.close();
		System.exit(0);
		

	}

	private static int findBales(int n) {
		
		
		
		if(n < position[0]) return 0;
		if(n >= position[N-1]) return N;
		
		int min = 0;
		int max = N;
		
		
		while(min < max) {

			int mid = (min + max) / 2;
			
			if(n >= position[mid]){
				min = mid + 1;
			} 
			else{
				max = mid;
			}
					
		}
		
		return max;
		
	}

}
