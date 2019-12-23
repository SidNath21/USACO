import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CircleCross {

	private static Character[] cows;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		cows = new Character[52];

		String crossing = br.readLine();
		for(int i=0; i<cows.length; i++) {
			cows[i] = crossing.charAt(i);
			System.out.print(cows[i]);
		}
		System.out.println();
		int answer = 0;
		for(char a = 'A'; a<='Z'; a++) {
			for(char b = a; b<='Z'; b++) {
				if(a!=b && checkCross(a, b)) answer++;
			}
		}
		
		System.out.println(answer);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);



	}

	private static boolean checkCross(char a, char b) {
		int[] cowA = new int[2];
		int[] cowB = new int[2];

		int countA = 0;
		int countB = 0;
		for(int i=0; i<cows.length; i++) {
			if(cows[i] == a ) {
				cowA[countA] = i; 
				countA ++;
			}
			if(cows[i] == b) {
				cowB[countB] = i;
				countB++;
			}
		}

		int betweenA = 0;
		int betweenB = 0;
		for(int i=0; i<cowB.length; i++) {
			if(cowB[i] > cowA[0] && cowB[i] < cowA[1]) betweenA ++;
		}

		for(int i=0; i<cowA.length; i++) {
			if(cowA[i] > cowB[0] && cowA[i] < cowB[1]) betweenB ++;
		}

		if(betweenA == 1 && betweenB == 1) return true;
		return false;





	}

}
