import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Lifeguards {

	private static int[] startTime, endTime;
	private static int[] shift;
	private static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		N = Integer.parseInt(br.readLine());
		startTime = new int[N];
		endTime = new int[N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			startTime[i]= Integer.parseInt(st.nextToken(" "));
			endTime[i] = Integer.parseInt(st.nextToken(" "));
			System.out.println(startTime[i] + " " + endTime[i]);
		}

		shift = new int[1000]; 
		
		for(int i=0; i<N; i++) {
			for(int j=startTime[i]; j<endTime[i]; j++) {
				shift[j]++;
			}
		}

		for(int i=0; i<shift.length; i++) {
			System.out.print(shift[i] + " ");
		}
		System.out.println();
		

		int answer = -1;
		for(int i=0; i<N; i++) {
			int time = calculate(i);
			answer = Math.max(answer, time);
			for(int j=startTime[i]; j<endTime[i]; j++) {
				shift[j]++;
			}
		}
		
		System.out.println(answer);
		pw.print(answer);
		pw.close();
		br.close();
		System.exit(0);




	}



	private static int calculate(int i) {
		int start = startTime[i];
		int end = endTime[i];
		int time = 0;
		for(int j=start; j<end; j++) {
			shift[j]--;
		}
		
		for(int j=0; j<shift.length; j++) {
			System.out.print(shift[j] + " ");
			if(shift[j]>0) time++;
		}
		System.out.println();
		
		return time;

	}

}
