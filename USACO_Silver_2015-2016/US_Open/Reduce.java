import java.io.*;
import java.util.*;

public class Reduce {

    private static boolean sortX = true;
    private static ArrayList<Point> minmaxPoints, points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        
        int N = Integer.parseInt(br.readLine());
        points = new ArrayList<Point>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        minmaxPoints = new ArrayList<Point>();
        for(int i=0; i<points.size() && i<4 ; i++){
            if(!minmaxPoints.contains(points.get(i))){
                minmaxPoints.add(points.get(i));
            }
        }
        for(int i=points.size()-1; i>=0 && i>points.size()-5 ; i--){
            if(!minmaxPoints.contains(points.get(i))){
                minmaxPoints.add(points.get(i));
            }
        }

        Collections.sort(points);

        for(int i=0; i<points.size() && i<4 ; i++){
            if(!minmaxPoints.contains(points.get(i))){
                minmaxPoints.add(points.get(i));
            }
        }
        for(int i=points.size()-1; i>=0 && i>points.size()-5 ; i--){
            if(!minmaxPoints.contains(points.get(i))){
                minmaxPoints.add(points.get(i));
            }
        }

        sortX = false;
        Collections.sort(minmaxPoints);

        int minArea = Integer.MAX_VALUE;
        for(int i=0; i<minmaxPoints.size(); i++){
            for(int j=i+1; j<minmaxPoints.size(); j++){
                for(int k=j+1; k<minmaxPoints.size(); k++){
                    int area = getArea(i, j, k);
                    minArea = Math.min(area, minArea);
                }
            }
        }

        System.out.println(minArea);


        
    }

    private static int getArea(int i, int j, int k) {
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int a = 0; a<minmaxPoints.size(); a++){

            if( a == i || a == j || a == k) continue;
            minX = Math.min(minX, minmaxPoints.get(a).x);
            minY = Math.min(minY, minmaxPoints.get(a).y);
            maxX = Math.max(maxX, minmaxPoints.get(a).x);
            maxY = Math.max(maxY, minmaxPoints.get(a).y);
        }

        int outCount = 0;
        for(int a = 0; a<points.size(); a++){
            if(points.get(a).x < minX || points.get(a).x > maxX || points.get(a).y < minY || points.get(a).y > maxY){
                outCount++;
            }
        }

        if(outCount <= 3) return (maxX - minX) * (maxY - minY);
        else{
            return Integer.MAX_VALUE;
        }
    }

    static class Point implements Comparable<Point> {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

       
        public int compareTo(Point oPoint) {
            if(sortX) return x - oPoint.x;
            else{
                return y - oPoint.y;
            }
        }


    }
    
}
