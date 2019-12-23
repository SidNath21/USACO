import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Hps {
	
	private static int N;
	private static int[] cow1, cow2;
//	private static int[][] scores;
	private static int calculate(int a, int b, int c) {
		int wins = 0;
		for(int i=0; i<N; i++){
		if(cow1[i]==a && cow2[i]==b) wins++;
		if(cow1[i]==b && cow2[i]==c) wins++;
		if(cow1[i]==c && cow2[i]==a) wins++;
		
		}
		return wins;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		N = Integer.parseInt(br.readLine());
		System.out.println(N);
		cow1 = new int[N];
		cow2 = new int[N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			cow1[i]=Integer.parseInt(st.nextToken(" "));
			cow2[i]=Integer.parseInt(st.nextToken(" "));
			System.out.println(cow1[i] + " " + cow2[i]);
		}
		
		int a = Math.max(calculate(1, 2, 3), (calculate(2, 3, 1)));
		
		int answer = Math.max(a, calculate(3, 2, 1));
		System.out.println(answer);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);
		
		
		

	}

}
