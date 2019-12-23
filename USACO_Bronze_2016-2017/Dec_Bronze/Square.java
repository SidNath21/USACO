import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Square {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("square.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		int bigX = 0;
		int bigY = 0;
		int smallX = 10;
		int smallY = 10;
		
		for(int i=0; i<2; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Xleft = Integer.parseInt(st.nextToken(" "));
			int Ybottom = Integer.parseInt(st.nextToken(" "));
			int Xright = Integer.parseInt(st.nextToken(" "));
			int Ytop = Integer.parseInt(st.nextToken(" "));
			
			if(Xleft<smallX) smallX = Xleft;
			if(Xright>bigX) bigX = Xright;
			if(Ybottom<smallY) smallY = Ybottom;
			if(Ytop > bigY) bigY = Ytop;
			
		}
		
		int sideLength = Math.max(bigX-smallX, bigY-smallY);
		int answer = sideLength * sideLength;
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);


	}
}


