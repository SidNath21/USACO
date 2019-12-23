import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Homework {

	public static void main(String[] args) throws IOException { // Prefix Sums
		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N+1];
		int[] prefixSum = new int[N+1];
		int[] prefixMin = new int[N+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			sum += scores[i];
			prefixSum[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			min = Math.min(scores[N-i+1], min);
			prefixMin[i] = min;
		}
		
		double max = -1;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int k = 1; k<=N-2; k++) {
			double average = (prefixSum[N] - prefixSum[k] - prefixMin[N-k]) / (double) (N-k-1);
			if(average > max) {
				max = average;
				arr.clear();
				arr.add(k);
			}
			else if(average == max) arr.add(k);
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
			pw.println(arr.get(i));
		}
		
		br.close();
		pw.close();
		System.exit(0);
	}
}