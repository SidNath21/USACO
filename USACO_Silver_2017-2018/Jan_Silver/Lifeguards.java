import java.io.*;
import java.sql.Time;
import java.util.*;

public class Lifeguards {

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Time> times = new ArrayList<Time>();

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			times.add(new Time(s, i));
			times.add(new Time(e, i));
		}

		Collections.sort(times);

		ArrayList<Integer> cows = new ArrayList<Integer>();
		int currTime = times.get(0).time;
		int[] alone = new int[N];
		int covered = 0;

		for(int i=0; i<times.size(); i++){

			if(cows.size() == 1){
				alone[cows.get(0)] += times.get(i).time - currTime;
			}
			if(!cows.isEmpty()){
				covered += times.get(i).time - currTime;
			}
			if(cows.contains(times.get(i).index)){
				cows.remove(times.get(i).index);
			}
			else{
				cows.add(times.get(i).index);
			}
			
		}

		int ans = 0;
		for(int i=0; i<alone.length; i++){
			ans = Math.max(ans, covered - alone[i]);
		}

		System.out.println(ans);
		
		
		
		
	
	}

	static class Time implements Comparable<Time>{
		int time, index;
		public Time(int time, int index){
			this.time = time;
			this.index = index;
		}

		public int compareTo(Time oTime){
			return time - oTime.time;
		}



	}
	
	
}
	

