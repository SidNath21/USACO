import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backforth {


	private static boolean[] barnA;
	private static int answer = 0;

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

		ArrayList<Integer> bucketsA = new ArrayList<Integer>(10);
		ArrayList<Integer> bucketsB = new ArrayList<Integer>(10);

		barnA = new boolean[2000];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) {
			bucketsA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) {
			bucketsB.add(Integer.parseInt(st.nextToken()));
		}

		tuesday(bucketsA, bucketsB, 1000);
		
		System.out.println(answer);
		pw.println(answer);
		br.close();
		pw.close();
		System.exit(0);
	}

	private static void tuesday(ArrayList<Integer> bucketsA, ArrayList<Integer> bucketsB, int A) {
		for(int i=0; i<bucketsA.size(); i++) {
			int milk = bucketsA.remove(i);
			bucketsB.add(milk);		
			wednesday(bucketsA, bucketsB, A-milk);
			bucketsB.remove(bucketsB.size()-1);
			bucketsA.add(i, milk);

		}
	}


	private static void wednesday(ArrayList<Integer> bucketsA, ArrayList<Integer> bucketsB, int A) {
		for(int i=0; i<bucketsB.size(); i++) {
			int milk = bucketsB.remove(i);
			bucketsA.add(milk);
			thursday(bucketsA, bucketsB, A+milk);
			bucketsA.remove(bucketsA.size()-1);
			bucketsB.add(i,  milk);
		}
		
	}


	private static void thursday(ArrayList<Integer> bucketsA, ArrayList<Integer> bucketsB, int A) {
		for(int i=0; i<bucketsA.size(); i++) {
			int milk = bucketsA.remove(i);
			bucketsB.add(milk);		
			friday(bucketsA, bucketsB, A-milk);
			bucketsB.remove(bucketsB.size()-1);
			bucketsA.add(i, milk);

		}
		
	}


	private static void friday(ArrayList<Integer> bucketsA, ArrayList<Integer> bucketsB, int A) {
		for(int i=0; i<bucketsB.size(); i++) {
			if((barnA[A + bucketsB.get(i)]) == false) {
				barnA[A + bucketsB.get(i)] = true;
				answer++;
			}
		}
		
	}


	private static void print(ArrayList<Integer> bucket) {
		for(int i=0; i<bucket.size(); i++) {
			System.out.print(bucket.get(i) + " ");
		}
		System.out.println();

	}
}