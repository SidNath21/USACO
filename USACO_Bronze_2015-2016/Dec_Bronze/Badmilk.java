import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Badmilk {
	
	private static int[] person, milk, time;
	private static int[] personSick, timeSick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken(" "));
		int M = Integer.parseInt(st.nextToken(" "));
		int D = Integer.parseInt(st.nextToken(" "));
		int S = Integer.parseInt(st.nextToken(" "));
		
		person = new int[D];
		milk = new int[D];
		time = new int[D];
		
		for(int i=0; i<D; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = Integer.parseInt(st.nextToken(" "));
			milk[i] = Integer.parseInt(st.nextToken(" "));
			time[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(person[i] + " " + milk[i] + " " + time[i]);
		}
		
		personSick = new int[S];
		timeSick = new int[S];
		
		for(int i=0; i<S; i++) {
			st = new StringTokenizer(br.readLine());
			personSick[i] = Integer.parseInt(st.nextToken(" "));
			timeSick[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(personSick[i] + " " + timeSick[i]);
		}
		
		
		for(int i=1; i<=M; i++) {
			if(milkBad(i)) {
				
			}
		}
		
		
	}

	private static boolean milkBad(int i) {
		boolean milkBad = false;
		int count = 0;
		for(int j=0; j<personSick.length; i++) {
			for(int k=0; k<person.length; k++) {
				if(personSick[j] == person[k] && milk[k]==i && time[k]<timeSick[j]) count++;
			}
		}
		if(count==personSick.length-1) return true;
		return false;
	}

}
