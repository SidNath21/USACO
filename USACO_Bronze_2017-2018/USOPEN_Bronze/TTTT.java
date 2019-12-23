import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TTTT {

	private static int wins = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

		char[][] board = new char[3][3];

		for(int r=0; r<3; r++) {
			String row = br.readLine();
			for(int c=0; c<3; c++) {
				board[r][c] = row.charAt(c); 
			}
		}

		int ans1 = checkSingle(board);
		int ans2 = 0;
		for(char ch = 'A'; ch<='Z'; ch++) {
			for(char ch2 = (char) (ch + 1); ch2 <= 'Z'; ch2++) {
				
				if(ch != ch2) ans2 += checkDouble(ch, ch2, board);
			}
		}
		
		System.out.println(ans1);
		System.out.println(ans2);
		pw.println(ans1);
		pw.println(ans2);
		br.close();
		pw.close();
		System.exit(0);
	}

	
	

	private static int checkDouble(char ch, char ch2, char[][] board) {
		
		if(teamWins(ch, ch2, board, board[0][0], board[1][1], board[2][2])) return 1;
		if(teamWins(ch, ch2, board, board[0][2], board[1][1], board[2][0])) return 1;
		
		for(int i=0; i<3; i++) {
			if(teamWins(ch, ch2, board, board[0][i], board[1][i], board[2][i])) return 1;
			if(teamWins(ch, ch2, board, board[i][0], board[i][1], board[i][2])) return 1;
		}
		return 0;	
	}




	private static boolean teamWins(char ch, char ch2, char[][] board, char a, char b, char c) {
		if(ch != a && ch2 != a) return false;
		if(ch != b && ch2 != b) return false;
		if(ch != c && ch2 != c) return false;
		
		if (a != ch && b != ch && c != ch) return false;
		if (a != ch2 && b != ch2 && c != ch2) return false;
		return true;
	}




	private static int checkSingle(char[][] board) {
		int win = 0;
		for(int r=0; r<3; r++) {
			if(board[r][0] == board[r][1] && board[r][0] == board[r][2] && board[r][1] == board[r][2]) win++;
		}

		for(int c=0; c<3; c++) {
			if(board[0][c] == board[1][c] && board[0][c] == board[2][c] && board[1][c] == board[2][c]) win++;
		}	
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] == board[2][2]) win++;
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] == board[2][0]) win++;
		
		return win;
	}

	





}

