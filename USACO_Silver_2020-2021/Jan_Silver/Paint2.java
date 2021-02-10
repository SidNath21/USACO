import java.io.*;
import java.util.*;
public class Paint2 {
	
	public static int range[][]; 
	public static int fence[]; 
	public static Map<Integer,Integer> brushes = new HashMap();
	public static Map<String,Integer> paintedSegments = new HashMap();
	
	public static void removeBrush(int brush)
	{
		for (int i = brush+1; i <= 26; i++)
		{
			Integer br = i;
			if (brushes.containsKey(br))
			{
				brushes.remove(br);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		Scanner in = new Scanner(System.in);
		// read in the first line, store a and b
		StringTokenizer st = new StringTokenizer(in.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String pattern = in.nextLine();
		range = new int[k][2];
		for (int i=0; i < k; i++)
		{
			st = new StringTokenizer(in.nextLine());
			while (st.hasMoreTokens())
			{
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				range[i][0]=a;
				range[i][1]=b;
			}
		}

		fence = new int[n];
		for (int i=0; i < n; i++)
		{
			fence[i]=pattern.charAt(i)-64;
		}
		int totalSum=0;
		for(int i=0;i<k;i++)
		{
			brushes.clear();
			totalSum=0;
			String startKey = Integer.toString(range[i][0]);
			if(paintedSegments.containsKey(startKey))
			{
				totalSum+= paintedSegments.get(startKey);
			}
			else
			{
				int res = paintSegment(0,range[i][0]-1);
				paintedSegments.put(startKey, res);
				totalSum+=res;
			}
			brushes.clear();
			startKey = Integer.toString(range[i][1]);
			if(paintedSegments.containsKey(startKey))
			{
				totalSum+= paintedSegments.get(startKey);
			}
			else
			{
				int res = paintSegment(range[i][1],n);
				paintedSegments.put(startKey, res);
				totalSum+=res;
			}
			System.out.println(totalSum);
		}
		
		
		
	}

	private static int paintSegment(int start, int end) {
		int sum=0;
		
		
		for(int i=start; i<end; i++)
		{
			int current=fence[i];
			boolean check=false;
			removeBrush(current);
			if(!brushes.containsKey(current))
			{
				brushes.put(current, 0);
				sum++;
			}
			
			
		}
		return sum;
	}
	
	
}