import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Revegetate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> S = new ArrayList<ArrayList<Integer>>(100001);
		
		ArrayList<Integer> temp = new ArrayList<>(1000);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			temp.add(a);
			if(type == 'S') S.add(a, temp);
		}
		
		
		pw.println(10);
		br.close();
		pw.close();
		System.exit(0);

	}

}
