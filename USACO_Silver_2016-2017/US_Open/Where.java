import java.io.*;
import java.util.*;

public class Where{

    private static int N;
    private static int[][] arr;
    private static ArrayList<PLC> plcs;
    private static int[] colorCount;
    private static boolean[][] visited;
    private static int count;
    private static ArrayList<Integer> colors;

    private static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j) - 64;
            }
        }

        plcs = new ArrayList<PLC>();


        colorCount = new int[100];
        colors = new ArrayList<Integer>();

        for(int x1 = 0; x1 < N; x1 ++){
            for(int y1 = 0; y1 < N; y1 ++){
                for(int x2 = x1; x2 < N; x2++){
                    for(int y2 = y1; y2 < N; y2++){


                        PLC plc = new PLC(x1, y1, x2, y2);
                        int c = getColorCount(plc);

                        if(c == 2){

                            int first = colors.remove(0);
                            int second = colors.remove(0);

                            int firstComponents = 0;
                            int secondComponents = 0;

                            for(int i=x1; i<=x2; i++){
                                for(int j=y1; j<=y2; j++){
                                    if(!visited[i][j] && arr[i][j] == first){
                                        search(i, j, first, plc);
                                        firstComponents++;
                                    }
                                    if(!visited[i][j] && arr[i][j] == second){
                                        search(i, j, second, plc);
                                        secondComponents++;
                                    }
                                }
                            }

                            if( (firstComponents == 1 && secondComponents >= 2) || (firstComponents >= 2 && secondComponents == 1)){
                                plcs.add(plc);
                            }

                        }

                        for(boolean[] b: visited){
                            Arrays.fill(b, false);
                        }

                        Arrays.fill(colorCount, 0);
                        colors.clear();
            
                    }
                }
            }
        } 

        int count = 0;
        for(int i=0; i<plcs.size(); i++){
            if(isContained(i)){
                plcs.remove(i);
                i--;
            }
        }

        System.out.println(plcs.size());
        pw.println(plcs.size());
        br.close();
        pw.close();
        System.exit(0);

    }

    private static boolean isContained(int n) {

        int x1 = plcs.get(n).x1;
        int y1 = plcs.get(n).y1;
        int x2 = plcs.get(n).x2;
        int y2 = plcs.get(n).y2;

        for(int i=0; i<plcs.size(); i++){
            if(i != n){
                if( x1 >= plcs.get(i).x1 && x2 <= plcs.get(i).x2 && 
                    y1 >= plcs.get(i).y1 && y2 <= plcs.get(i).y2){
                        return true;
                    }
            }
        }

        return false;

       
    }

    private static void search(int x, int y, int c, PLC plc) {

        if(visited[x][y]) return;
        visited[x][y] = true;


        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(inBounds(newX, newY, plc) && !visited[newX][newY] && arr[newX][newY] == c){
                search(newX, newY, c, plc);
            }
        }

    }

    private static boolean inBounds(int x, int y, PLC plc){
        return x >= plc.x1 && x <= plc.x2 && y >= plc.y1 && y <= plc.y2;
    }

    private static int getColorCount(PLC plc){

        int count = 0;
        for(int i=plc.x1; i<=plc.x2; i++){
            for(int j=plc.y1; j<= plc.y2; j++){
                if(colorCount[arr[i][j]] == 0){
                    colors.add(arr[i][j]);
                    count++;
                }
                colorCount[arr[i][j]]++;
            }
        }
        return count;
    }

    static class PLC{
        int x1, y1, x2, y2;

        public PLC(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public String toString(){
            String str = "";
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    str += arr[i][j];
                }
                str += "\n";
            }
            return str;
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


