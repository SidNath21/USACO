import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Hps {

	private static int N;
	private static int[] moves;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

		N = Integer.parseInt(br.readLine());
		moves = new int[N];
		for(int i=0; i<N; i++) {
			char ch = br.readLine().charAt(0);
			int n = -1;
			if(ch == 'H') n = 0;
			if(ch == 'P') n = 1;
			if(ch == 'S') n = 2;
			moves[i] = n;
		}

		//System.out.println(getCount(2, 0, 4));
		
		int max = -1; 
		for(int i=0; i<3; i++) {
			for(int j = i + 1; j< 3; j++) {
				for(int k = 0; k <= N; k++) {
					int countA = getCount(i, j, k);
					int countB = getCount(j, i, k);
					max = Math.max(max, Math.max(countA, countB));
				}
			}
		}
		
		System.out.println(max);
		pw.println(max);
		br.close();
		pw.close();
		System.exit(0);
		
		


	}

	private static int getCount(int i, int j, int k) {
		int count = 0;
		int n = 0;
		for(int a = 0; a < k; a++) {
			if(i != moves[n]) {
				if(win(i, moves[n])) count++;
			}
			n++;
		}

		for(int b = k; b < N; b++) {
			if(b != moves[n]) {
				if(win(j, moves[n])) count++;
			}
			n++;
		}
		return count;
	}

	public static boolean win(int a, int b) {

		if(a == 0 && b == 2) return true;
		if(a == 1 && b == 0) return true;
		if(a == 2 && b == 1) return true;

		return false;
	}


}
