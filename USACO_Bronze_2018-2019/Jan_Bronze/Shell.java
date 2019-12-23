import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Shell {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shell.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		int N = Integer.parseInt(br.readLine());
		
		int[] shells = new int[4];
		for(int i=1; i<4; i++) {
			shells[i] = i;
		}
		
		int[] ans = new int[4];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			int t1 = shells[a];
			int t2 = shells[b];
			
			shells[b] = t1;
			shells[a] = t2;
			
			if(shells[g] == 1) ans[1]++;
			if(shells[g] == 2) ans[2]++;
			if(shells[g] == 3) ans[3]++;
			
		}
		
		int answer = 0;
		for(int i=1; i<4; i++) {
			answer = Math.max(answer, ans[i]);
		}
		System.out.println(answer);
		pw.println(answer);
		br.close();
		pw.close();
		System.exit(0);

	}

}
