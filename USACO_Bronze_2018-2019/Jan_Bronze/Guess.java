/*
ID: siddharthnath21
LANG: JAVA
TASK: guess
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Guess {

	public static String[][] adj;
	public static int[] sizes;
	public static int N;

	public static ArrayList<String> questions;
	public static String[] animals;
	public static ArrayList<String> adjectives;
	public static boolean[] possible;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

		N = Integer.parseInt(br.readLine());
		animals = new String[N];
		adj = new String[N][100];
		sizes = new int[N];
		questions = new ArrayList<String>(N);
		adjectives = new ArrayList<String>(N);
		possible = new boolean[N];

		for(int i=0; i<N; i++) {
			possible[i] = true;
		}

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			animals[i] = st.nextToken();
			int adjs = Integer.parseInt(st.nextToken());
			sizes[i] = adjs;
			for(int j=0; j<adjs; j++) {
				adj[i][j] = st.nextToken();
				if(canAdd(adj[i][j])) {
					adjectives.add(adj[i][j]);
				}
				
			}
		
		}

		int yes = 0;

		while(num(animals)!=1) {

			System.out.println("Possible Animals: ");
			for(int i=0; i<animals.length; i++) {
				if(animals[i] !=null) System.out.print(animals[i] + " ");
			}
			System.out.println();
			System.out.println("--------------------------");
			
			
			String nextQ = "";
			int max = 0;
			for(int i=0; i<adjectives.size(); i++){
				int freq = frequency(adjectives.get(i));
				if(freq >= max) {
					max = freq;
					nextQ = adjectives.get(i);
				}
			}
			
			System.out.println("Does the animal " + nextQ + "?");
			System.out.println("Yes");
			
			for(int i=0; i<animals.length; i++) {
				if(possible[i] && canRemove(i, nextQ) ) { 
					animals[i] = null;
					possible[i] = false;
				}
			}
		
			adjectives.remove(getIndex(adjectives, nextQ));
			yes++;
			
			System.out.println();

		}
		
		for(int i=0; i<animals.length; i++) {
			if(animals[i]!=null) System.out.println("The animal is a " + animals[i]);
		} 
		
		System.out.println(yes);
		pw.println(yes);
		br.close();
		pw.close();
		System.exit(0);

	}


	private static int num(String[] animals) {
		int count = 0;
		for(int i=0; i<animals.length; i++) {
			if(animals[i]!=null) count++;
		}
		return count;
	}


	private static boolean canRemove(int i, String nextQ) {
		
		for(int j=0; j<sizes[i]; j++) {
			if(adj[i][j].equals(nextQ) && adj[i][j]!= null) {
				return false;
			}
		}

		return true;
	}

	private static int getIndex(ArrayList<String> list, String str) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(str)) return i;
		}
		return -1;
	}

	private static boolean canAdd(String str) {
		for(int i=0; i<adjectives.size(); i++) {
			if(adjectives.get(i).equals(str)) return false;
		}
		return true;
	}
	
	private static int frequency(String str) {
		int count = 0;
		for(int i=0; i<N; i++) {
			if(possible[i]) {
				for(int j=0; j<sizes[i]; j++) {
					if(adj[i][j].equals(str)) count++;
				}
			}
		}
		return count;
	}

}

