import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Maxcross {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] road = new int[N];
		int[] prefixSum = new int[N];
		
		for(int i=0; i<B; i++) {
			int pos = Integer.parseInt(br.readLine())-1;
			road[pos] = 1;
		}
		
		int sum = 0;
		for(int i=0; i<road.length; i++) {
			sum += road[i];
			prefixSum[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=K-1; i<road.length; i++) {
			int lights;
			if(! (i-K < 0))  lights = prefixSum[i]-prefixSum[i-K];
			else lights = prefixSum[i];
			
			System.out.println(i-K + " " + i + " " + lights);
			
			min = Math.min(min, lights);
			
			
		}
		
		System.out.println(min);
		pw.println(min);
		br.close();
		pw.close();
		System.exit(0);
		
		
		
		
	}
}
	