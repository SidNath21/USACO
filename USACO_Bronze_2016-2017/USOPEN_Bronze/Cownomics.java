import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Cownomics {


	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken(" ")); // 3
		int M = Integer.parseInt(st.nextToken(" ")); // 8
		System.out.println(N + " " + M);

		String[] spotty = new String[N];
		String[] plain = new String[N];
		for(int i=0; i<N; i++){
			spotty[i]=br.readLine();
			System.out.println(spotty[i]);
		}
		for(int i = 0; i<N; i++){
			plain[i]=br.readLine();
			System.out.println(plain[i]);
		}
		int answer = 0;
		for(int i = 0; i<M; i++){
			if(checkTrait(spotty, plain, i)) answer++;
		}
		
		
		pw.print(answer);
		pw.close();
		br.close();
		System.exit(0);
	}


	private static boolean checkTrait(String[] spotty, String[] plain, int i) {
		boolean[][] traits = new boolean[4][2];
		for(int j=0; j<4; j++){
			for(int k=0; k<2; k++){
				traits[j][k] = false;
			}
		}
		
		for(int j=0; j<spotty.length; j++){
			if(spotty[j].charAt(i)=='A') traits[0][0] = true;
			if(spotty[j].charAt(i)=='T') traits[1][0] = true;
			if(spotty[j].charAt(i)=='C') traits[2][0] = true;
			if(spotty[j].charAt(i)=='G') traits[3][0] = true;
		}
		for(int j=0; j<plain.length; j++){
			if(plain[j].charAt(i)=='A') traits[0][1] = true;
			if(plain[j].charAt(i)=='T') traits[1][1] = true;
			if(plain[j].charAt(i)=='C') traits[2][1] = true;
			if(plain[j].charAt(i)=='G') traits[3][1] = true;
		}
		
		
		for(int j=0; j<4; j++){
			if(traits[j][0]==true && traits[j][1]==true) return false;
		}
		return true;
	}

}
