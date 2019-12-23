import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Hoofball {

	private static int[] cows;
	private static int[] getBall;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		int N = Integer.parseInt(br.readLine());
		cows = new int[N];
		getBall = new int[1000];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cows[i] = Integer.parseInt(st.nextToken(" "));
		}
		Arrays.sort(cows);
		
		for(int i=0; i<N; i++) System.out.print(cows[i] + " ");
		System.out.println();
		
		for(int i=0; i<N; i++) {
			
			getBall[getNextPass(cows[i])]++;
		}
		
		int balls = 0;
		for(int i=0; i<cows.length; i++) {
			if(getBall[cows[i]]==0) balls++;
			int next = getNextPass(cows[i]);
			if(cows[i] < next && getBall[cows[i]] == 1 && getBall[next] == 1 && getNextPass(next)==cows[i]) balls++;
		}
		
		System.out.println(balls);
	
		
		pw.print(balls);
		pw.close();
		br.close();
		System.exit(0);
		


	}

	private static int getNextPass(int pos) {
		int leftDist = 1000;
		int rightDist = 1000;
		int leftPos = -1;
		int rightPos = -1;
		
		for(int j=0; j<cows.length; j++) {
			if(cows[j]<pos && pos-cows[j] < leftDist) {
				leftDist = pos-cows[j];
				leftPos = cows[j];
			}
			if(cows[j]>pos && cows[j]-pos<rightDist) {
				rightDist = cows[j]-pos;
				rightPos = cows[j];
			}
		}
		
		if(leftDist <= rightDist) {
			return leftPos;
		}
		
		return rightPos;
		
		
	}

}


