

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Taming {

	// create an array of length N containing the log entries. Entries are either -1 or a positive integer
	// if value is a positive integer, it indicates the last time a breakout occurred
	// For MAX breakouts: Set each (-1) to 0 which indicates that all missing entries were breakouts; 
	// For MIN breakouts: for each (-1), let it continue the log. 
	// NOTE: the first log entry is a breakout so set it to 0;

/*	private int[] log;


	public Taming(int[] log){
		this.log = log;
	}

	public boolean check(){
		if(log[0] > 1) return false; 	
		return true;
	}

	public int findMin(){
		int min = 0;
		for(int i=log.length-1; i>0; i--){
			if(log[i]>0){ 
				int a = log[i];
				log[i-1] = a-1;

			}			
		}
		for(int j=0; j<log.length; j++){
			if(log[j]==0) min++;
		}

		return min;
	}

	public int findMax(){
		int max = 0;
		for(int i=log.length-1; i>0; i--){
			if(log[i]>0){ 
				int a = log[i];
				log[i-1] = a-1;
			}			
		}
		for(int j=0; j<log.length; j++){
			System.out.print(log[j] + " ");
			if(log[j]<=0) max++;
		}
		return max;
	}
	*/






	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int N = Integer.parseInt(br.readLine());
		int[] log = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			log[i] = Integer.parseInt(st.nextToken( ""));
		}
		
		int min = getMin(log);
		int max = getMax(log);


	}

	private static int getMax(int[] log) {
		int max = 0;
		for(int i=log.length-1; i>0; i--) {
			if(log[i]>0) {
				int breakout = log[i];
				log[i--] = breakout-1;
			}
		}
		return 0;
	}

	private static int getMin(int[] log) {
		int min = 0;
		for(int i=log.length-1; i>0; i--) {
			if(log[i]>0) {
				int breakout = log[i];
				log[i--] = breakout-1;
			}
		}
		
		for(int i=0; i<log.length; i++) {
			if(log[i]==0) min++;
		}
		return min;
		
	}

}
