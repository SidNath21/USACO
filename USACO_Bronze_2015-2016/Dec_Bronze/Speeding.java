import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Speeding {

	private static int[] roadLength, roadSpeed, bessieLength, bessieSpeed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken(" "));
		int M = Integer.parseInt(st.nextToken(" "));
		System.out.println(N + " " + M);

		roadLength = new int[N];
		roadSpeed = new int[N];
		bessieLength = new int[M];
		bessieSpeed = new int[M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			roadLength[i] = Integer.parseInt(st.nextToken(" "));
			roadSpeed[i] = Integer.parseInt(st.nextToken(" "));
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			bessieLength[i] = Integer.parseInt(st.nextToken(" "));
			bessieSpeed[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		int answer = 0;
		for(int i=1; i<=100; i++) {
			int bSpeed = getBSpeed(i);
			int rSpeed = getRSpeed(i);
			System.out.println(i + " " + bSpeed + " " + rSpeed);
			answer = Math.max(bSpeed-rSpeed, answer);
		}
		System.out.println(answer);
		pw.println(answer);
		br.close();
		pw.close();
		System.exit(0);
	}

	private static int getRSpeed(int i) {
		int distance = 0;
		int pos = 0;
		for(int j=0; j<roadLength.length; j++) {
			distance += roadLength[j];
			if(i<=distance) {
				pos = j;
				break;
			}
		}
		return roadSpeed[pos];
	}

	private static int getBSpeed(int i) {
		int distance = 0;
		int pos = 0;
		for(int j=0; j<bessieLength.length; j++) {
			distance += bessieLength[j];
			if(i<=distance) {
				pos = j;
				break;
			}
		}
		return bessieSpeed[pos];
	}




}
