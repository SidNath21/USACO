import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bcs {

	private static int N, K;
	private static Character[][] original;
	private static Character[][] pieces;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcs.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));

		original = new Character[N][N];
		pieces = new Character[N*K][N];

		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<N; j++) {
				original[i][j] = row.charAt(j);
				System.out.print(original[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		for(int i=0; i<N*K; i++) {
			String row = br.readLine();
			for(int j=0; j<N; j++) {
				pieces[i][j] = row.charAt(j);
			}
		}

		System.out.println();

		check(1, 3);


	}

	private static void check(int i, int j) {
		Character[][] piece1 = new Character[N][N];
		Character[][] piece2 = new Character[N][N];
		
		
		int row1 = (i-1)*N;
		for(int k=0; k<N; k++) {
			for(int l=0; l<N; l++) {
				piece1[k][l] = pieces[row1][l];
				System.out.print(piece1[k][l]);
			}
			row1++;
			System.out.println();
		}
		
		System.out.println();
		
		int row2 = (j-1)*N;
		for(int k=0; k<N; k++) {
			for(int l=0; l<N; l++) {
				piece2[k][l] = pieces[row2][l];
				System.out.print(piece2[k][l]);
			}
			row2++;
			System.out.println();
		}
		
		
		}

	}


