import java.io.*;
import java.util.*;

public class Convention2{

	private static ArrayList<Cow> cows;
	private static boolean[] done;
	private static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		N = Integer.parseInt(br.readLine());

		done = new boolean[N];

		cows = new ArrayList<Cow>();
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int priority = i;
			cows.add(new Cow(arrival, time, priority));
		}

		int maxTime = 0;
		int cowCount = 0;
		int currTime = 0;

		

		while(cowCount < N){

			boolean waiting = getWaiting(currTime);
			int next = getNext(currTime, waiting);

			if(waiting){
				maxTime = Math.max(maxTime, currTime - cows.get(next).arrival);
				currTime += cows.get(next).time;
			}
			else{
				currTime += cows.get(next).arrival - currTime + cows.get(next).time;	
			}


			done[next] = true;
			
			cowCount++;

		}

		System.out.println(maxTime);
		pw.println(maxTime);
		br.close();
		pw.close();
		System.exit(0);


		
		
	}

	private static boolean getWaiting(int currTime) {
		for(int i=0; i<cows.size(); i++){
			if(!done[i] && cows.get(i).arrival < currTime){
				return true;
			}
		}
		return false;
	}

	private static int getNext(int t, boolean waiting) {

		int next;

		if(!waiting){ // not waiting (check first arrival)
			int minTime = Integer.MAX_VALUE;
			next = -1;
			for(int i=0; i<cows.size(); i++){
				if(!done[i]){
					if(cows.get(i).arrival < minTime){
						minTime = cows.get(i).arrival;
						next = i;
					}
					else if(cows.get(i).arrival == minTime){
						if(cows.get(i).priority < next){
							next = i;
						}
					}
				}
			}

			return next;
			
		}
		else{ // waiting (check priority)

			next = -1;
			int minPriority = N;
			for(int i=0; i<cows.size(); i++){
				if(!done[i]){
					if(cows.get(i).arrival < t){
						next = i;
						break;
					}
				}
			}
			return next;

		}


	}

	

	

	static class Cow implements Comparable<Cow>{
		int arrival, time, priority;

		public Cow(int arrival, int time, int priority){
			this.arrival = arrival;
			this.time = time;
			this.priority = priority;
		}

	
		
		public int compareTo(Cow oCow) {

			if(arrival == oCow.arrival){
				return priority - oCow.priority;
			}

			return arrival - oCow.arrival;

		}



	}
}



























// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.StringTokenizer;

// public class Convention2 {

// 	private static int N;
// 	private static ArrayList<Cow> cows;
// 	private static boolean[] done;

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
// 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
// 		N = Integer.parseInt(br.readLine());
// 		cows = new ArrayList<Cow>(N);
// 		done = new boolean[N];

// 		for(int i=0; i<N; i++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
// 		}


// 		int t = 0;
// 		int maxTime = 0;
// 		int c = N;
// 		while(c!=0) {
// 			System.out.println(t);
// 			boolean inLine = inLine(t);
// 			int j = getNext(t, inLine);
// 			if(inLine) {
// 				maxTime = Math.max(maxTime, t - cows.get(j).arrive);
// 				t += cows.get(j).time;
// 			}
// 			else {
// 				t+= cows.get(j).arrive-t + cows.get(j).time;	
// 			}
// 			done[j] = true;
// 			c--;
// 		}

// 		System.out.println(maxTime);
// 		pw.print(maxTime);
// 		br.close();
// 		pw.close();
// 		System.exit(0);


// 	}

// 	private static boolean inLine(int t) {
// 		for(int i=0; i<cows.size(); i++) {
// 			if(!done[i] && cows.get(i).arrive < t) return true;
// 		}
// 		return false;
// 	}

// 	private static int getNext(int t, boolean inLine) {
// 		int next = N;
// 		int min = Integer.MAX_VALUE;

// 		if(inLine) {
// 			for(int i=0; i<cows.size(); i++) {
// 				if(!done[i] && cows.get(i).arrive < t && i < next) {
// 					next = i;
// 				}
// 			}
// 			return next;
// 		}

// 		else {
// 			for(int i=0; i<cows.size(); i++) {
// 				if(!done[i]) {
// 					if(cows.get(i).arrive < min) {
// 						min = cows.get(i).arrive;
// 						next = i;
// 					}
// 					if(cows.get(i).arrive == min) {
// 						next = Math.min(i, next);
// 					}
// 				}
// 			}
// 			return next;
// 		}
// 	}

// 	static class Cow{
// 		int arrive,  time,  p;
// 		public Cow(int arrive, int time, int p ) {
// 			this.arrive = arrive;
// 			this.time = time;
// 			this.p = p;
// 		}
// 	}

// 	static class Sort implements Comparator<Cow>{

// 		@Override
// 		public int compare(Cow o1, Cow o2) {

// 			return 0;
// 		}



// 	}

// }
