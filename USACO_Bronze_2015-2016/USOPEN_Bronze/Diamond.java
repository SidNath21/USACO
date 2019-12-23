import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Diamond {

	private static int N, K;
	private static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		size = new int[N];
		for(int i=0; i<N; i++){
			size[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(size);


		
		int max = 0;
		for(int i=0; i<N; i++){
			int diamonds = 1;
			for(int j=i+1; j<N; j++){
				if(Math.abs(size[i]-size[j])<=K) diamonds++;
			
			}
			if(diamonds>max) max = diamonds;
		}
		
		
	





		System.out.println(max);
		pw.print(max);
		br.close();
		pw.close();
		System.exit(0);
	}

	
}
