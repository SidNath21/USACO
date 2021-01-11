import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cowcode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();	
		long N = Integer.parseInt(st.nextToken()) - 1;
		
		char ans = search(N, str);
		
		
		System.out.println(ans);
		
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);
		
		
		
	}

	private static char search(long n, String str) {
		if(n < str.length()){
			return str.charAt((int) n);
		}

		long len = str.length();
		while( 2*len < n ){
			len *= 2;
		}

		if(len == n){
			return search(n-1, str);
		}

		else{
			return search(n - len - 1, str);
		}


	}


}
