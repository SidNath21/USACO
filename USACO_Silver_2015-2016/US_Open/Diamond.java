import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Diamond {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] diamonds = new int[N];
		boolean[] choosen = new boolean[N];

		for(int i=0; i<N; i++) {
			diamonds[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(diamonds);




		int ans = -1;
		int count = 0;
		for(int a = 0 ; a < N; a++) {
			for(int b = a+1 ; b < N; b++) {
				count = 0;
				
				
				int min = a;
				int max = N;
				
				
				for(int i=a; i< diamonds.length; i++) {
					if(!choosen[i]) {
						if(diamonds[i] - diamonds[a] <= K) {
							choosen[i] = true;
							count++;
						}
					}
					else break;

				}
				for(int i=b; i< diamonds.length; i++) {
					if(!choosen[i]) {
						if(diamonds[i]- diamonds[b] <= K) {
							choosen[i] = true;
							count++;
						}
					}
					else break;
					
					
					
					/*
					 * count = 0;
				
				int minA = a;
				int maxA = N;
				
				while(minA + 1 != maxA) {
					int mid = (minA + maxA) / 2;
					if(diamonds[mid]-diamonds[a] <= K) minA = mid;
					else if (diamonds[mid] - diamonds[a] > K) maxA = mid;
				}
				
				count += (minA- a + 1);
				
				int minB = b;
				int maxB = N;
				
				while(minB + 1 != maxB) {
					int mid = (minB + maxB) / 2;
					if(diamonds[mid]-diamonds[b] <= K) minB = mid;
					else if (diamonds[mid] - diamonds[b] > K) maxB = mid;
				}
				
				if(minB < minA) count -= (Math.abs(minA-minB));
				
				count += (minB - b + 1);
				
				System.out.println(count);

				ans = Math.max(ans, count);
				Arrays.fill(choosen, false);
					 */

				}
				
				
				ans = Math.max(ans, count);
				Arrays.fill(choosen, false);

			}
			
		}
		
		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);

	}

}
