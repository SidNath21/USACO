import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Planting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a]++;
			arr[b]++;
		}
		
		int max = -1;
		for(int i=0; i<N; i++) {
			max = Math.max(arr[i], max);
		
	
		}
		System.out.println(max+1);
		pw.println(max+1);
		br.close();
		pw.close();
		System.exit(0);


	}
	
	

}
