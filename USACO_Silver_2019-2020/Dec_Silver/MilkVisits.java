import java.io.*;
import java.util.*;

public class MilkVisits {

    private static ArrayList<Pair>[] pairs;
    private static int[] visited;
    private static char[] types;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        pairs = new ArrayList[N];
		for(int i=0; i<N; i++){
			pairs[i] = new ArrayList<Pair>();
		}

        String list = br.readLine();
        types = list.toCharArray();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            pairs[x].add(new Pair(y, types[y]));
            pairs[y].add(new Pair(x, types[x]));
        }

        visited = new int[N];
        Arrays.fill(visited, -1);

        int group = 0;
        for(int i=0; i<N; i++){

            if(visited[i] == -1){
                search(i, group);
                group++;
            }

        }



        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            char c = (st.nextToken().charAt(0));

            if(types[a] != types[b]){
                System.out.print(1);
                pw.print(1);
            }
            else{
                if(types[a] == c){
                    System.out.print(1);
                    pw.print(1);
                }
                else{
                    if(visited[a] != visited[b]){
                        System.out.print(1);
                        pw.print(1);
                    }
                    else{
                        System.out.print(0);
                        pw.print(0);
                    }
                }
            }

        }

        br.close();
        pw.close();
        System.exit(0);

    }

    private static void search(int x, int group) {

        if(visited[x] != -1) return;
        visited[x] = group;

        for(Pair pair : pairs[x]) {
            if(visited[pair.x] == -1 && pair.c == types[x]){
                search(pair.x, group);
            }
        }
       

    }

    static class Pair {
        int x;
        char c;
        public Pair(int x, char c){
            this.x = x;
            this.c = c;
        }
    }
    
}
