import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Shuffle {



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int N = Integer.parseInt(br.readLine());
		int[] shuffle = new int[N+1];
		int[] position = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			shuffle[i] = Integer.parseInt(st.nextToken());
			position[shuffle[i]]++;
		}

		int ans = N;

		int count = 0;
		ArrayList<Integer> cows = new ArrayList<Integer>(N);
		for(int i=1; i<=N; i++) {
			if(position[i] == 0) {
				cows.add(i);
				ans--;
			}
		}


		while(!cows.isEmpty()) {
			int pos = cows.remove(cows.size()-1);
			if(position[shuffle[pos]]-1 == 0) {
				cows.add(shuffle[pos]);
				ans--;
			}

		}

		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);






	}

}
