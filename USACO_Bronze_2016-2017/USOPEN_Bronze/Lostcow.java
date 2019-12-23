import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Lostcow {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int start = Integer.parseInt(st.nextToken(" "));
		int cow = Integer.parseInt(st.nextToken(" "));

		System.out.println(start + " " + cow);
		int dir = 1; // 1 = right, -1 = left
		boolean reachCow = false;
		
		
		int move = 1;
		int distance = 0;
		int pos1 = start;
		int pos2;
		while(reachCow != true) {
			pos2 = start + move*dir;
			distance += Math.abs(pos2 - pos1);
			if((cow > start && pos2 >= cow && dir > 0) || (cow < start && pos2 <= cow && dir < 0)) {
				distance-= Math.abs(pos2-cow);
				reachCow = true;
			}
			move *= 2;
			dir*= -1;
			pos1 = pos2;
		}
		System.out.println(distance);
		pw.print(distance);
		pw.close();
		br.close();
		System.exit(0);
		


	}




}
