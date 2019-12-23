

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Billboard2 {

	private static int cx1, cy1, cx2, cy2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

		String lawn = br.readLine();
		String cowFeed = br.readLine();
		StringTokenizer st = new StringTokenizer(lawn);
		int lx1 = Integer.parseInt(st.nextToken(" "));
		int ly1 = Integer.parseInt(st.nextToken(" "));
		int lx2 = Integer.parseInt(st.nextToken(" "));
		int ly2 = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(cowFeed);
		cx1 = Integer.parseInt(st.nextToken(" "));
		cy1 = Integer.parseInt(st.nextToken(" "));
		cx2 = Integer.parseInt(st.nextToken(" "));
		cy2 = Integer.parseInt(st.nextToken(" "));

		int lawnArea = (Math.abs(lx2-lx1) * Math.abs(ly2-ly1));
		int corners = 0;
		int answer = 0;
		
		corners+=checkPoint(lx1, ly1);
		corners+=checkPoint(lx2, ly2);
		corners+=checkPoint(lx1, ly2);
		corners+=checkPoint(lx2, ly1);
		
		if(corners <=1 ) {
			System.out.println(lawnArea);
			pw.print(lawnArea);
		}
		else if(corners == 2){
				int x1 = Math.min(lx2, cx2);
				int x2 = Math.max(lx1, cx1);
				int y1 = Math.min(ly2, cy2);
				int y2 = Math.max(ly1, cy1);
				answer = lawnArea - (Math.abs(x2-x1))*(Math.abs(y2-y1));
				System.out.println(answer);
				pw.print(answer);
		}
		else {
			pw.print(0);
		}
		pw.close();
		br.close();
		System.exit(0);


	}

	private static int checkPoint(int x, int y) {
		int corners = 0;
		if(x>=cx1 && x<=cx2 && y>=cy1 && y <=cy2) corners++;
		return corners;
	}

}
