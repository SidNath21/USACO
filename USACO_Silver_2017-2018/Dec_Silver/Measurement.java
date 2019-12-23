import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

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
		
		Collections.sort(logs, new Sort());
		
		
		for(int i=0; i<logs.size(); i++) {
			int ID = logs.get(i).ID;
			int output = logs.get(i).output;
		}
		
		
		
		

	
	}
	
	
	static class Log{
		int day, ID, output;
		public Log(int day, int ID, int output) {
			this.day= day;
			this.ID = ID;
			this.output = output;
		}
	}
	
	static class Sort implements Comparator<Log>{
		
		public int compare(Log o1, Log o2) {
			return o1.day - o2.day;
		}
	}

}
