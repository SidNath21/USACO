import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sleepy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> cows = new ArrayList<Integer>(N);
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			cows.add(Integer.parseInt(st.nextToken()));
		}

		int ans = 0;

		while(!isOrder(cows) && ans<N) {

			int cowFirst = cows.get(0);
			int back = cows.get(N-1) ;
			if(cowFirst > back) {
				cows.remove(0);
				cows.add(N-1, cowFirst);
			}
			else {
				int lastIndex = N-1;
				
				for(int i = N-1; i>0; i--) {
					int lastCow = cows.get(lastIndex);
					if(cows.get(i-1)>lastCow) {
						lastIndex--;
						break;
					}
					else {
						if(cowFirst > cows.get(i-1)) {
							lastIndex--;
							break;
						}
						lastIndex--;
					}

				
				}
				cows.remove(0);
				cows.add(lastIndex, cowFirst);		
			}

			for(int i=0; i<cows.size(); i++) {
				System.out.print(cows.get(i) + " ");
			}
			System.out.println();

			ans++;
		}

		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);


	}
	private static boolean isOrder(ArrayList<Integer> cows) {
		for(int i=0; i<cows.size(); i++) {
			if(cows.get(i)!=i+1) return false;
		}
		return true;
	}

}
