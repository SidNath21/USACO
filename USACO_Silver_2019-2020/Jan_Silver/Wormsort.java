import java.io.*;
import java.util.*;

public class Wormsort {

    private static ArrayList<Pair>[] pairs;
    private static boolean[] visited;
    private static int[] cowOrder;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) ;
        int M = Integer.parseInt(st.nextToken());

        cowOrder = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cowOrder[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        pairs = new ArrayList[N];
		for(int i=0; i<N; i++){
			pairs[i] = new ArrayList<Pair>();
        }

        int[] weights = new int[M];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            weights[i] = w;

            pairs[a].add(new Pair(b, w));
            pairs[b].add(new Pair(a, w));
        }

        Arrays.sort(weights);

        visited = new boolean[N];
        

        if(works()){
            System.out.println("-1");
            pw.println("-1");
            br.close();
            pw.close();
            System.exit(0);
        }

        int ans = 0;

        int min = 0;
        int max = 1000000001;
        while(min != max){
            int mid = (min + max + 1) / 2;
            boolean work = false;

            for(int i=0; i<N; i++){
                Arrays.fill(visited, false);
                search(i, mid);
                if(works()){
                    work = true;
                    break;
                } 
            }

            if(work){
                min = mid;
            }
            else{
                max = mid - 1;
            }
        }

        ans = min;
       
        System.out.println(ans);
        pw.println(ans);
        br.close();
        pw.close();
        System.exit(0);

    }

    private static boolean works() {

        for(int i=0; i<cowOrder.length; i++){
            if(cowOrder[i] != i){
                if(!visited[i]){
                    return false;
                }
                else{
                    if(!visited[cowOrder[i]]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void search(int n, int weight) {

        if(visited[n]) return;
        visited[n] = true;

        for(Pair pair: pairs[n]){

            if(!visited[pair.x] && pair.w >= weight){
                search(pair.x, weight);
            }

        }

    }

    static class Pair{
        int x, w;
        public Pair(int x, int w){
            this.x = x;
            this.w = w;
        }
    }

    

    
}
