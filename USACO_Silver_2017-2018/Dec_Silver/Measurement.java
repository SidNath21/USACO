import java.io.*;
import java.util.*;

public class Measurement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		ArrayList<Log> logs = new ArrayList<Log>();
		boolean[] onTop = new boolean[100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int ID = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			char sign = str.charAt(0);
			int output = Integer.parseInt(str.substring(1));
			if(sign == '-') output *= -1;
			logs.add(new Log(day, ID, output));
			
		}
		
		Collections.sort(logs);
		
		
		for(int i=0; i<logs.size(); i++) {
			
		}
		
		
		
		

	
	}
	
	
	static class Log implements Comparable<Log>{
		int day, ID, output;
		public Log(int day, int ID, int output) {
			this.day= day;
			this.ID = ID;
			this.output = output;
		}

		public int compareTo(Log oLog){
			return day - oLog.day;
		}
	}
	

}
