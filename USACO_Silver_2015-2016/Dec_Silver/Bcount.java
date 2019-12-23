import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bcount {

	public static void main(String[] args) throws IOException { // Prefix Sums
		
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int A = 0;
		int B = 0;
		int C = 0;
		
		
		
		for(int i=0; i<N; i++) {
			int cow = Integer.parseInt(br.readLine());
			if(cow == 1) {
				A++;
			}
			if(cow == 2) {
				B++;
			}
			if(cow == 3) {
				C++;
			}

			
			a[i] = A;
			b[i] = B;
			c[i] = C;
			
		}
		
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			
			System.out.println(start + " " + end);
			int h,g,j;
			if(start-1 == -1) {
				h = a[end];
				g = b[end];
				j = c[end];
			}
			else {
			 h = a[end]-a[start-1];
			 g = b[end]-b[start-1];
			 j = c[end]-c[start-1];
			}
			System.out.println(h + " " + g + " " + j);
			pw.println(h + " " + g + " " + j);
			System.out.println();
		}
		
		
		
		
		br.close();
		pw.close();
		System.exit(0);
		
		

	}

}
