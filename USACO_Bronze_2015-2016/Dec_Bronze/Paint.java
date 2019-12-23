import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Paint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken(" "));
		int b = Integer.parseInt(st.nextToken(" "));
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken(" "));
		int d = Integer.parseInt(st.nextToken(" "));
		
		int max = Math.max(b, d);
		int min = Math.min(a, c);
		int answer = 0;
		
		int intersection = findIntersections(a, b, c, d);
		
		if(intersection > 0) answer = max-min;
		else answer = (d-c) + (b-a);
		
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);
	}

	private static int findIntersections(int a, int b, int c, int d) {
		if((c>=a && c<=b && d>=b) ||(d>=a && d<=b && c<=a) ) return 1;
		if((c>=a && c<=b && d>=a && d<=b) || (a>=c && a<=b && b>=c && b<=d)) return 2;
		
		return 0;
	}

}
