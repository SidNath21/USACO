import java.io.*;
import java.util.*;

public class Triangles {

	private static boolean sortX = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		int N = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		
		int[][] sum = new int[N][2];

		ArrayList<Point> points = new ArrayList<Point>();
		

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 100000;
			int y = Integer.parseInt(st.nextToken()) + 100000;
			points.add(new Point(x, y));
		}

		Collections.sort(points);

		for(int i=0; i<N; i++){
			int currX = points.get(i).x;
			int currY = points.get(i).y;
			int sY = 0;
			int sX = 0;
			for(int j=0; j<N; j++){
				
				if(points.get(j).x == currX){
					sY += Math.abs(points.get(j).y - currY);
				}

				if(points.get(j).y == currY){
					sX += Math.abs(points.get(j).x - currX);
				}
	
				
			}
			
			
			sum[i][1] = sY; 
			sum[i][0] = sX;
		}
		
		
		
		int s = 0;
		
		for(int i=0; i<points.size(); i++){
			// System.out.println(sum[i][0] * sum[i][1]);
			s += (sum[i][0] * sum[i][1]);
		}
		
		System.out.println(s % mod);
		pw.println(s % mod);
		br.close();
		pw.close();
		System.exit(0);
		
		

	}


	static class Point implements Comparable<Point>{
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		
		public int compareTo(Point oPoint) {
			if(sortX){
				return x - oPoint.x;
			}
			else{
				return y - oPoint.y;
			}
			
		}

		public String toString(){
			return x + " " + y;
		}
	}


}