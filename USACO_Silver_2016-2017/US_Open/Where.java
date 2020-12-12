import java.io.*;
import java.util.*;

public class Where{

    private static int[][] arr;
    private static int[] colors;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0 , -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        colors = new int[26];
        ArrayList<PLC> plcs = new ArrayList<PLC>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                arr[i][j] = c - 64;
                // System.out.print(arr[i][j]);
            }
            // System.out.println();
        }

        visited = new boolean[N][N];
        for(int x1=0; x1 < N; x1++){
            for(int y1 = 0; y1 < N; y1++){
                for(int x2 = x1; x2 < N; x2++){
                    for(int y2 = y1; y2 < N; y2++){

                        PLC plc = new PLC(x1, y1, x2, y2);

                        Arrays.fill(colors, 0);
                        int colorCount = getColors(plc);
                        System.out.println(colorCount);

                        if(colorCount == 2){

                            int c = arr[x1][y1];
                            int x = x1;
                            int y = y1;
                            
                            search(x, y, c, plc);
                            

                        }

                        for(boolean[] arr: visited){
                            Arrays.fill(arr, false);
                        }
                        

                    }
                }
            }
        }


        // System.out.println(getColors(0, 1, 1, 2));
    }

    private static void search(int x, int y, int c, PLC plc) {

        if(visited[x][y]) return;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
        }

    }

    private static int getColors(PLC plc) {

        int count = 0;
        for(int i=plc.x1; i<=plc.x2; i++){
            for(int j=plc.y1; j<=plc.y2; j++){
                // System.out.print(arr[i][j]);
                if(colors[arr[i][j]] == 0){
                    count++;
                }
                colors[arr[i][j]]++;
            }
            // System.out.println();
        }

        return count;
    }

    static class PLC{
        int x1, y1, x2, y2;
        public PLC(int x1, int y1, int x2, int y2){
            x1 = this.x1;
            x2 = this.x2;
            y1 = this.y1;
            y2 = this.y2;
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
// import java.util.Arrays;

// public class Where {


// 	private static ArrayList<PCL> pcls;
// 	private static int[][] field;
// 	private static int[] colors;
// 	private static boolean[][] visited;
// 	private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
// 	private static int count = 1;

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new FileReader("where.in"));
// 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));

// 		int N = Integer.parseInt(br.readLine());
// 		field = new int[N][N];
// 		colors = new int[27];
// 		pcls = new ArrayList<PCL>();
// 		visited = new boolean[N][N];

// 		for(int i=0; i<N; i++) {
// 			String str = br.readLine();
// 			for(int j = 0; j<N; j++) {
// 				field[i][j] = str.charAt(j) - 64;
// 				System.out.print(field[i][j] + " ");
// 			}
// 			System.out.println();
// 		}

// 		for(int x1 = 0; x1<N; x1++) {
// 			for(int y1 = 0; y1<N; y1++) {
// 				for(int x2 = x1; x2<N; x2++) {
// 					for(int y2 = y1; y2<N; y2++) {
						
// 							PCL pcl = new PCL(x1, y1, x2, y2);

// 							Arrays.fill(colors, 0);
// 							for(boolean[] arr: visited) Arrays.fill(arr, false);

// 							int regions = findRegions(pcl);

// 							if(regions == 2) {

// 								int a = field[x1][y1];
// 								search(x1, y1, x2, y2, x1, y1, a);
// 								int numA = count;
// 								count = 1;

// 								int b = 0;
// 								int bx = -1, by = -1;
// 								for(int i=x1; i<=x2; i++) {
// 									for(int j=y1; j<=y2; j++) {
// 										if(field[i][j] != a) {
// 											b = field[i][j];
// 											bx = i;
// 											by = j;
// 											break;
// 										}
// 									}
// 								}

// 								search(x1, y1, x2, y2, bx, by, b);
// 								int numB = count;
// 								count = 1;

// 								if((numA == colors[a] && numB != colors[b]) || (numB == colors[b] && numA != colors[a])) {
// 									pcls.add(pcl);
// 								}
	

// 						}

// 					}
// 				}
// 			}
// 		}

// 		int ans = 0;
// 		for(int i=0; i<pcls.size(); i++) {
// 			int x1 = pcls.get(i).x1;
// 			int y1 = pcls.get(i).y1;
// 			int x2 = pcls.get(i).x2;
// 			int y2 = pcls.get(i).y2;
// 			if(!contained(x1, y1, x2, y2, i)) ans++;
// 		}

// 		System.out.println(ans);
// 		pw.println(ans);
// 		br.close();
// 		pw.close();

// 	}


// 	private static void search(int x1, int y1, int x2, int y2, int x, int y, int a) {


// 		if(visited[x][y] || field[x][y] != a) return;


// 		visited[x][y] = true;

// 		for(int i=0; i<4; i++) {
// 			int newX = x + dr[i];
// 			int newY = y + dc[i];
// 			if(inBounds(newX, newY, x1, y1, x2, y2) && field[newX][newY] == a && !visited[newX][newY]) {
// 				count++;
// 				search(x1, y1, x2, y2, newX, newY, a);
// 			}
// 		}

// 	}

// 	private static boolean inBounds(int x, int y, int x1, int y1, int x2, int y2) {
// 		return (x >= x1 && x<= x2 && y>= y1 && y <= y2);
// 	}

// 	private static int findRegions(PCL pcl) {

// 		int count = 0;
// 		for(int i=pcl.x1; i<=pcl.x2; i++) {
// 			for(int j=pcl.y1; j<=pcl.y2; j++) {
// 				int pos = field[i][j];
// 				if(colors[pos] == 0) count++;
// 				colors[pos]++;
// 			}
// 		}
// 		return count;
// 	}

// 	private static boolean contained(int x1, int y1, int x2, int y2, int j) {

// 		int xL = Math.min(x1, x2);
// 		int xR = Math.max(x1, x2);
// 		int yT = Math.max(y1, y2);
// 		int yB = Math.min(y1, y2);

// 		for(int i=0; i<pcls.size(); i++) {

// 			if(j!=i) {

// 				int x3 = pcls.get(i).x1;
// 				int y3 = pcls.get(i).y1;
// 				int x4 = pcls.get(i).x2;
// 				int y4 = pcls.get(i).y2;

// 				int leftX = Math.min(x3, x4);  
// 				int rightX = Math.max(x3, x4);
// 				int botY = Math.min(y3, y4);
// 				int topY = Math.max(y3, y4);

// 				if (xL >= leftX && xR <= rightX && yT <= topY && yB >= botY) return true;

// 			}
// 		}

// 		return false;
// 	}

// 	static class PCL{
// 		int x1, y1, x2, y2;
// 		public PCL(int x1, int y1, int x2, int y2) {
// 			this.x1 = x1;
// 			this.y1 = y1;
// 			this.x2 = x2;
// 			this.y2 = y2;
// 		}
// 	}

// }


