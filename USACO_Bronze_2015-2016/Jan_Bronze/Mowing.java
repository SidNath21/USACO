import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Mowing {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
		int N = Integer.parseInt(br.readLine());
		int[][] field = new int[2000][2000];
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				field[i][j] = -1;
			}
		}
		int x = 1000; 
		int y = 1000;
		field[x][y] = 0;
		int time = 0;
		
		int answer = 1001;
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String direction = st.nextToken(" ");
			int dirX = 0, dirY = 0;
			if(direction.equals("N")) dirY = 1;
			if(direction.equals("S")) dirY = -1;
			if(direction.equals("E")) dirX = 1;
			if(direction.equals("W")) dirX = -1;
			int move = Integer.parseInt(st.nextToken(" "));
			for(int j=1; j<=move; j++){
				x+=dirX;
				y+=dirY;
				time++;
				if(field[x][y]>=0 && time-field[x][y]<answer){
					answer = time-field[x][y];
				}
				field[x][y] = time; 
			}
		}
		
		if(answer == 1001) answer = -1;
		
		pw.print(answer);
		br.close();
		pw.close();
		System.exit(0);

	}

}
