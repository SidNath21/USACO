import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Blocks {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N);
		int[] blocksUsed = new int[26];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String up = st.nextToken(" ");
			String down = st.nextToken(" ");
			
			int[] blocksUp = getBlocks(up);
			int[] blocksDown = getBlocks(down);
			
			for(int j=0; j<26; j++){
				blocksUsed[j] += Math.max(blocksUp[j], blocksDown[j]);
			}
		}
		
		for(int i=0; i<26; i++){
			pw.println(blocksUsed[i]);
		}
		br.close();
		pw.close();
		System.exit(0);

		


	}

	private static int[] getBlocks(String str) {
		int[] blocksNeeded = new int[26];
		for(int j=0; j<str.length(); j++){
			int index = str.charAt(j)-'a';
			blocksNeeded[index]++;
		}
		return blocksNeeded;
	}


}
