import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Crossroad {
	
	
	private static int[] cow, position;
	private static int[] lastSeen = new int[11];
	private static boolean[] check;
	
	private static int calculate(int i) {
		int count = 0;
		
		int lastPlace = position[i];
		for(int j = 0; j<cow.length; j++){
			if(cow[i]==cow[j] && position[j]!=lastPlace){
				lastPlace = position[j];
				count ++;
			}
			
		}
		if(count>0) {
			check[cow[i]] = true;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));

		int N = Integer.parseInt(br.readLine());
		cow = new int[N];
		position = new int[N];
		check = new boolean[11];
		
		
		System.out.println(N);
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			cow[i] =  Integer.parseInt(st.nextToken(" "));
			position[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		for(int i=0; i<11; i++){
			lastSeen[i]=0;
		}
		
		int answer = 0;
		for(int i=0; i<N; i++){	
			if(check[cow[i]]==false) answer += calculate(i);
		}
		System.out.println(answer);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);
	 
	}


}


