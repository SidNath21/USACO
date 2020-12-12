import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Moop {

    private static ArrayList<Particle> particles;
    private static boolean[] visited;
    private static int[] groups;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("moop.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        
        int N = Integer.parseInt(br.readLine());
        particles = new ArrayList<Particle>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            particles.add(new Particle(x, y));
        }

        visited = new boolean[N];

        groups = new int[N];
        Arrays.fill(groups, -1);
        int group = 0;  
        for(int i=0; i<N; i++){
            if(groups[i] == -1){
                search(i, group);
                group++;
            }
        }

        int ans = group++;
        System.out.println(ans);
        pw.println(ans);
        br.close();
        pw.close();
        System.exit(0);
        
            

    }

    public static void search(int n, int group) {

        if(groups[n] != -1) return;
        groups[n] = group;

        int currX = particles.get(n).x;
        int currY = particles.get(n).y;

        for(int i=0; i<particles.size(); i++){

            int x = particles.get(i).x;
            int y = particles.get(i).y;

            if(groups[i] == -1 && canColide(currX, currY, x, y)){
                search(i, group);
            }
        
        }

    }

    public static boolean canColide(int x1, int y1, int x2, int y2){    
        return (x1 <= x2 && y1 <= y2) || (x2 <= x1 && y2<=y1);
    }


    static class Particle implements Comparable<Particle>{
        int x, y;
        public Particle(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Particle oParticle){
            if(x == oParticle.x){
                return y - oParticle.y;
            }
            return x - oParticle.x;
        }
    }
    
}
