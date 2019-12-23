import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Angry {

	private static int[] bales;
	private static int N;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		N = Integer.parseInt(br.readLine());
		bales = new int[N];

		for(int i=0; i<N; i++) {
			bales[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bales);
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			int rightExplosion = getExplosionIndex(i, 1);
			int leftExplosion = getExplosionIndex(i, -1);
			
			answer = Math.max(rightExplosion - leftExplosion + 1, answer);
		}
		System.out.println(answer);
		
	}

	private static int getExplosionIndex(int pos, int dir) {
		int lastExplosion = pos;
		int radius = 1;
		
		while(pos>0 && pos < N-1) {
			
			int next = lastExplosion;
			while(next + dir >= 0 && next + dir < N-1 && Math.abs(bales[next+dir]-bales[lastExplosion])<=radius) {
				next += dir;
			}
			
			if(next == lastExplosion) {
				break;
			}
			
			lastExplosion = next;
			radius++;
			
		}
		
		return lastExplosion;
	} 

}