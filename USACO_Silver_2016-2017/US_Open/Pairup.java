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


public class Pairup {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		int N = Integer.parseInt(br.readLine());	
		int[][] cows = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());		
			int count = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			cows[i][0] = count;
			cows[i][1] = time;
		}
				
		java.util.Arrays.sort(cows, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[1], b[1]);
		    }
		});
		
		int i = 0, j = N-1;
		int time = 0;
		while(i < j) {
			int n = Math.min(cows[i][0], cows[j][0]);
			time = Math.max(time, cows[i][1] + cows[j][1]);
			
			cows[i][0] -= n;
			cows[j][0] -= n;
			
			if(cows[i][0] == 0) i++;
			if(cows[j][0] == 0) j--;
			
		}
		
		System.out.println(time);
		pw.print(time);
		br.close();
		pw.close();
		System.exit(0);

		
	}

	

}

