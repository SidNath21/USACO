import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Promote {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("promote.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		int[] before = new int[4];
		int[] after = new int[4];
		int[] promoted = new int[3];
		for(int i=0; i<4; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			before[i] = Integer.parseInt(st.nextToken(" "));
			after[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(before[i] + " " + after[i]);
		}
		
		int silver = after[1]-before[1];
		int gold = after[2]-before[2];
		int platinum = after[3]-before[3];
		
		promoted[2]=platinum;
		promoted[1]=gold+platinum;
		promoted[0]=silver+gold+platinum;
		
		for(int i=0; i<3; i++){
			System.out.println(promoted[i]);
			pw.println(promoted[i]);
		}
		br.close();
		pw.close();
		System.exit(0);
		
		
		
	}

}
