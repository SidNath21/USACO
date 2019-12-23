import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Notlast {

	private static String[] cows, cowNames;
	private static int[] milkProduced, scores;
	private static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		N = Integer.parseInt(br.readLine());
		cowNames = new String[] {"Bessie", "Elsie" , "Daisy" , "Gertie", "Annabelle", "Maggie", "Henrietta" };
		scores = new int[7];
		cows = new String[N];
		milkProduced = new int[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows[i] = st.nextToken(" ");
			milkProduced[i] = Integer.parseInt(st.nextToken(" "));
			scores[findCowIndex(cows[i])] += milkProduced[i];
			System.out.println(cows[i] + " " + milkProduced[i]);
		}
		
		
		System.out.println();
		
	

		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int i=0; i<scores.length; i++) {
			min = Math.min(min, scores[i]);		
		}
		for(int i=0; i<scores.length; i++) {
			if(scores[i]>min) {
				secondMin = Math.min(secondMin, scores[i]);
			}
		}
		
		int countSecondLow = 0;
		int countMin = 0;
		for(int i=0; i<scores.length; i++) {
			if(scores[i] == secondMin) countSecondLow++;
			if(scores[i] == min) countMin++;
		}
		
		System.out.println(min + " " + secondMin);
		
		if(countSecondLow > 1 || countMin == 7) pw.println("Tie"); 
		else {
			String answer = " ";
			int index = -1;
			if(countSecondLow == 1) {
				for(int i=0; i<scores.length; i++) {
					if(scores[i] == secondMin) index = i;
				}
			}
			
			answer = cowNames[index];
			pw.println(answer);
		}
			
				br.close();
				pw.close();
				System.exit(0);

	}

	private static int findCowIndex(String string) {
		for(int i=0; i<cowNames.length; i++) {
			if(string.equals(cowNames[i])) return i;
		}
		return -1;
	}

}
