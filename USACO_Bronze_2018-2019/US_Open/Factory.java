import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Factory {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		int N = Integer.parseInt(br.readLine());
		int[] factories = new int[N+1];
		int[] value = new int[N+1];
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			factories[a] = b;
			value[b]++;
			
		}
		
		int ans = -1;
		for(int i=1; i< factories.length; i++) {
			if(factories[i] == 0) ans = i;
		}
		
		
		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);
		
	}
	
	

}
