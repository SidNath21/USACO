import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Cowqueue {



	//	private static int calculate(int time){		
	//		int timeToEnter = Integer.MAX_VALUE;
	//		int nextToEnter = 0;
	//
	//		for(int i=0; i<N; i++){
	//			if(processed[i]==false){
	//				if(arrival[i]-time<=timeToEnter){
	//					timeToEnter = arrival[i]-time;
	//					nextToEnter = i;
	//				}
	//			}
	//		}
	//		System.out.println(arrival[nextToEnter] + " " + duration[nextToEnter]);
	//		System.out.println(time);
	//		if(arrival[nextToEnter]<=time) time+=duration[nextToEnter];
	//		else time+=duration[nextToEnter]+(arrival[nextToEnter]-time);
	//		processed[nextToEnter]=true;
	//		System.out.println(time);
	//		System.out.println(" ");
	//		return time;
	//		
	//	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

		int	N = Integer.parseInt(br.readLine());
		System.out.println(N);
		int[] arrival = new int[N];
		int[] duration = new int[N];
		boolean[] processed = new boolean[N];
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrival[i] = Integer.parseInt(st.nextToken(" "));
			duration[i] = Integer.parseInt(st.nextToken(" "));
		}

		int currTime = 0;
		for(int i=0; i<N; i++) {
			int nextToEnter = -1;
			for(int j=0; j<N; j++) {
				if(!processed[j] && (nextToEnter == -1 || arrival[j] < arrival[nextToEnter])) {
					nextToEnter = j;
				}
			}
			
			processed[nextToEnter] = true;
			if(arrival[nextToEnter] > currTime ) {
				currTime = arrival[nextToEnter] + duration[nextToEnter];
			}
			else {
				currTime += duration[nextToEnter];
			}
		}

		System.out.println(currTime);








	}

}
