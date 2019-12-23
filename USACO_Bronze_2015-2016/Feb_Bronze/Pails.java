import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Pails {
	
	private static int X, Y, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken(" "));
		Y = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		int maxX = Math.round(M/X);
		if(maxX*X > M) maxX--;
		int maxY = Math.round(M/Y);
		if(maxY*Y > M) maxY--;
		
		
		int max = 0;
		for(int i=0; i<=maxX; i++){
			for(int j=0; j<=maxY; j++){
				int num = calculate(i, j);
				if(num<=M && num>max) max = num;
			}
		}
		
		System.out.println(max);
		pw.print(max);
		br.close();
		pw.close();
		System.exit(0);
	}

	private static int calculate(int i, int j) {
		int number = 0;
		number = (X*i) + (Y*j);
		return number;
	}

}
