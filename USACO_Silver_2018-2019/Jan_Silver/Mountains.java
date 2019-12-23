import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Mountains {

	private static ArrayList<Peak> peaks;
	private static int N;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		N = Integer.parseInt(br.readLine());
		peaks = new ArrayList<Peak>(N);

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			peaks.add(new Peak(x, y));
		}

		int count = 0;
		for(int i=0; i<peaks.size(); i++) {
			if(isVisible(i)) count++;
		}

		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);


	}

	
	
	private static boolean isVisible(int i) {
	
		int x1 = peaks.get(i).x - peaks.get(i).y;
		int x2 = peaks.get(i).x + peaks.get(i).y;
		
		for(int j=0; j<peaks.size(); j++) {
			if(j!=i) {
				
				int x3 = peaks.get(j).x - peaks.get(j).y;
				int x4 = peaks.get(j).x + peaks.get(j).y;
				
				if(x3 <= x1 && x4 >= x2) return false;
			}
		}
		
		return true;
	}



	static class Peak{
		private int x, y;
		public Peak(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}