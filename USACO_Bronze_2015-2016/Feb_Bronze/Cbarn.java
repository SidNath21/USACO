import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Cbarn {
	
	private static int N;
	private static int[] rooms;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		N = Integer.parseInt(br.readLine());
		rooms = new int[N+1];
		for(int i=0; i<N; i++){
			rooms[i] = Integer.parseInt(br.readLine());
			System.out.print(rooms[i] + " ");
		}
		System.out.println(" ");
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++){
			int distance = calculate(i);
			if(distance<min) min = distance;
		}
		System.out.println(min);
		pw.print(min);
		br.close();
		pw.close();
		System.exit(0);
		
	
	}

	private static int calculate(int i) {
		int[] doors = new int[N];
		int door = 0;
		for(int j=i; j<N; j++){
			doors[j] = door++;
		}
		
		for(int j=0; j<i; j++){
			doors[j] = door++;
		}
		
		int distance = 0;
		for(int j=0; j<N; j++){
			distance += rooms[j]*doors[j];
		}
		
		return distance;
		
	}

}
