import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Billboard {
	
	private static int sx1, sx2, sy1, sy2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ax1 = Integer.parseInt(st.nextToken(" "));
		int ay1 = Integer.parseInt(st.nextToken(" "));
		int ax2 = Integer.parseInt(st.nextToken(" "));
		int ay2 = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		int gx1 = Integer.parseInt(st.nextToken(" "));
		int gy1 = Integer.parseInt(st.nextToken(" "));
		int gx2 = Integer.parseInt(st.nextToken(" "));
		int gy2 = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		 sx1 = Integer.parseInt(st.nextToken(" "));
		 sy1 = Integer.parseInt(st.nextToken(" "));
		 sx2 = Integer.parseInt(st.nextToken(" "));
		 sy2 = Integer.parseInt(st.nextToken(" "));
		
		int area = Math.abs(((ax2-ax1)*(ay2-ay1)) + ((gx2-gx1)*(gy2-gy1)));
		System.out.println(area);
	
		
		int a = checkIntersect(ax1, ay1, ax2, ay2);
		int b = checkIntersect(gx1, gy1, gx2, gy2);
		int answer = area - a - b;
		System.out.println(answer);
		pw.print(answer);
		pw.close();
		br.close();
		System.exit(0);
	}

	private static int checkIntersect(int x1, int y1, int x2, int y2) {
		int intersect;
		if(sx1 > x2 || sy1 > y2 || sx2 < x1 || sy2 < y1 ) return 0;
		int w1 = Math.max(x1, sx1);
		int w2 = Math.min(x2, sx2);
		int l1 = Math.max(y1, sy1);
		int l2 = Math.min(y2, sy2);
		intersect = Math.abs(w2-w1) * Math.abs(l2-l1);
		//System.out.println(intersect);
		return intersect;
		
	}
	

}
