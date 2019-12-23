import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Measurement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		int N = Integer.parseInt(br.readLine());
		int[] days = new int[N];
		String[] cows = new String[N];
		int[] milk = new int[N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken(" "));
			cows[i] = st.nextToken(" ");
			milk[i] = Integer.parseInt(st.nextToken(" "));
		}

		int Bessie = 7, Elsie = 7, Mildred = 7;
		int answer = 0;
		boolean bessieOn = true, elsieOn = true, mildredOn = true;
		for(int currDay = 1; currDay<=100; currDay++){
			for(int i=0; i<N; i++){
				if(days[i]==currDay){
					String name = cows[i];
					int ammount = milk[i];
					if(name.equals("Bessie")) Bessie += ammount;
					if(name.equals("Elsie")) Elsie += ammount;
					if(name.equals("Mildred")) Mildred += ammount;

				}
				int max = Math.max(Bessie, Math.max(Elsie, Mildred));
				boolean bessieOnNext = Bessie == max;
				boolean elsieOnNext = Elsie == max;
				boolean mildredOnNext = Mildred == max;
				if(bessieOn != bessieOnNext || elsieOn != elsieOnNext || mildredOn != mildredOnNext) {
					answer++;
				}
				bessieOn = bessieOnNext;
				elsieOn = elsieOnNext;
				mildredOn = mildredOnNext;

			}
		}
		System.out.println(answer);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);
	}

}


