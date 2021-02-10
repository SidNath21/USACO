import java.io.*;
import java.util.*;
public class One{

    private static ArrayList<Integer>[] visited;
    private static int[] cows;
    private static int N, K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("mooves.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Move> moves = new ArrayList<Move>(K);

        visited = new ArrayList[N];

        for(int i=0; i<visited.length; i++){
            visited[i] = new ArrayList<Integer>();
        }

        cows = new int[N];
        for(int i=0; i<N; i++){
            cows[i] = i;
            visited[i].add(i);
        }

        for(int i=0; i<K; i++){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            moves.add(new Move(a, b));

        }

        int count = 0;
        swap(moves.get(count).a, moves.get(count).b);
        count++;

        while(!works()){

            int a = moves.get(count % K).a;
            int b = moves.get(count % K).b;

            swap(a, b);
            count++;

        }

        for(int i=0; i<N; i++){
            System.out.println(visited[i] + " " + visited[i].size());
        }

    }

    private static boolean works(){
        for(int i=0; i<N; i++){
            if(cows[i] != i) return false;
        }
        return true;
    }

    private static void swap(int a, int b){

        if(!visited[cows[a]].contains(b)){
            visited[cows[a]].add(b);
        }

        if(!visited[cows[b]].contains(a)){
            visited[cows[b]].add(a);
        }

        int temp = cows[a];
        cows[a] = cows[b];
        cows[b] = temp;

    }

    static class Move{
        int a, b;
        public Move(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}