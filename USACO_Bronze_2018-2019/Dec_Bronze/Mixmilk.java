import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: siddharthnath21
LANG: JAVA
TASK: Mixmilk
*/
public class Mixmilk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		// 3 buckets 
		int[] capacity = new int[3];
		int[] milk = new int[3];
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			capacity[i] = Integer.parseInt(st.nextToken());
			milk[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 1;
		int bucket1 = 0; 
		int bucket2 = 1;
		while(count <= 100) {
			if(milk[bucket1] + milk[bucket2] <= capacity[bucket2]) {
				milk[bucket2] += milk[bucket1];
				milk[bucket1] = 0;
			}
			else {
				int diff = capacity[bucket2]-milk[bucket2];
				milk[bucket2] += diff;
				milk[bucket1] -= diff;
			}
			count++;
			bucket1++;
			bucket2++;
			if(bucket1 > 2) bucket1 = 0;
			if(bucket2 > 2) bucket2 = 0;
		}
		
		for(int i=0; i<milk.length; i++) {
			pw.println(milk[i]);
		}
		
		br.close();
		pw.close();
		System.exit(0);

	}

}
