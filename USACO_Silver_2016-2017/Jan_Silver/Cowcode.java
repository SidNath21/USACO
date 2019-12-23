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
		long N = Integer.parseInt(st.nextToken());
		
		while(str.length() < N) {
			String translated = Character.toString(str.charAt(str.length()-1)) + str.substring(0, str.length()-1);
			str += translated;
		}
		
		
		System.out.println(str);
		System.out.println(str.charAt((int) (N-1)));
		pw.println(str.charAt((int) (N-1)));
		br.close();
		pw.close();
		System.exit(0);
		
		
		
	}


}
