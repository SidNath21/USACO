import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cowjump {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Line> lines = new ArrayList<Line>(N);

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			lines.add(i, new Line(x1, y1, x2, y2));
		}

		int ans = -1, max = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i!=j && intersect(lines, i, j)) {
					count++;
				}
			}
			if(count > max) {
				max = count;
				ans = i + 1;
			}
			count = 0;
		}

		System.out.println(ans);
		pw.println(ans);
		br.close();
		pw.close();
		System.exit(0);


	}
	static class Line{
		public int x1, y1, x2, y2;
		public Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	
	

	public static boolean intersect(ArrayList<Line> lines, int a, int b) {
		int ax1 = lines.get(a).x1; int ax2 = lines.get(a).x2; int ay1 = lines.get(a).y1; int ay2 = lines.get(a).y2;
		int bx1 = lines.get(b).x1; int bx2 = lines.get(b).x2; int by1 = lines.get(b).y1; int by2 = lines.get(b).y2;

		if(Math.min(ay1, ay2) <= Math.max(by1, by2) && Math.max(ay1, ay2) >= Math.min(by1, by2)
				&& Math.min(ax1, ax2) <= Math.max(bx1, bx2) && Math.max(ax1, ax2) >= Math.min(bx1, bx2)) return true;
		return false;
	}

}


