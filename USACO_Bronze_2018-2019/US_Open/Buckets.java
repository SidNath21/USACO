import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Buckets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
			
		int Br = 0, Bc = 0, Rr = 0, Rc = 0, Lr = 0, Lc = 0;
		char[][] map = new char[10][10];
		for(int i=0; i<10; i++) {
			String str = br.readLine();
			for(int j=0; j<10; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					Br = i;
					Bc = j;
				}
				else if(map[i][j] == 'R') {
					Rr = i;
					Rc = j;
				}
				else if(map[i][j] == 'L') {
					Lr = i;
					Lc = j;
				}
			}
		}
		
		int cows = Math.abs(Lr - Br) + (Math.abs(Lc - Bc)) - 1; 
		if((Rr == Br && Rr == Lr || Rc == Bc && Rc == Lc)){
			if((Rr > Br && Rr < Lr || Rr > Lr && Rr < Br) || (Rc > Bc && Rc < Lc || Rc > Lc && Rc < Bc)) cows += 2;
		}
		
		System.out.println(cows);
		pw.println(cows);
		br.close();
		pw.close();
		System.exit(0);
		
		
		

	}

}
