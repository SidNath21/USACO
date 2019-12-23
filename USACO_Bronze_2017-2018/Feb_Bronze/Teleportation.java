
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teleportation {
	
	public int calculate(int a, int b, int c, int d){
		int answer;
		answer = Math.abs(a-b);
		answer = Math.min(answer, Math.abs(a-c) + Math.abs(b-d));
		answer = Math.min(answer, Math.abs(a-d) + Math.abs(b-c));

		return answer;
	}
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken(" "));
		int b = Integer.parseInt(st.nextToken(" "));
		int c = Integer.parseInt(st.nextToken(" "));
		int d = Integer.parseInt(st.nextToken(" "));
		int answer;
		Teleportation teleportation = new Teleportation();
		answer = teleportation.calculate(a, b, c, d);
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);    
		
		
		
	}
	
	
	}

	
	

		
		
	


