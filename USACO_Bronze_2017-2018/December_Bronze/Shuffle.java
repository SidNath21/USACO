import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Shuffle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

		int N = Integer.parseInt(br.readLine());
		System.out.println(N);
		int[] positions = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++){
			positions[i]=Integer.parseInt(st.nextToken(" "));
			System.out.print(positions[i] + " ");
		}
		System.out.println(" ");
		int[] id = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++){
			id[positions[i]] = Integer.parseInt(st.nextToken(" "));

		}
		System.out.println(" ");

		int[] original = new int[N+1];
		for(int i=1; i<=2; i++){
			for(int j=1; j<N+1; j++){
				int pos = positions[j];
				original[j]=positions[pos];
			}

			reset(original, positions);
			
		}

		for(int i=1; i<=N; i++){
			int ID = id[positions[i]];
			System.out.println(ID);
			pw.println(ID);
		}
		br.close();
		pw.close();
		System.exit(0);

	}

	private static void reset(int[] original, int[] positions) {
		for(int i=1; i<original.length; i++){
			positions[i] = original[i];
			original[i]=0;
		}
	}

}
