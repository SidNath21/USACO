import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CityState {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> cityStates = new HashMap<String, Integer>();

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String city = st.nextToken().substring(0, 2);
			String state = st.nextToken();

			if(!city.equals(state)) {

				String str = city + state;

				if(!cityStates.containsKey(str)) {
					cityStates.put(str, 0);
				}
				
				cityStates.put(str, cityStates.get(str) + 1);

				
			}
		}

		int count = 0;

		for(String str : cityStates.keySet()) {
			System.out.println(str + " " + cityStates.get(str));
			String key = str.substring(2) + str.substring(0, 2);
			if(cityStates.containsKey(key)) {
				count += cityStates.get(str) * cityStates.get(key);
			}
			

		}

		System.out.println(count/2);
		pw.println(count/2);
		br.close();
		pw.close();
		System.exit(0);



		/*
		String[][] citystates = new String[N][2];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String state = st.nextToken().substring(0, 2);
			String code = st.nextToken();
			citystates[i][0] = state;
			citystates[i][1] = code;
		}

		int count = 0;
		for(int i=0; i<citystates.length; i++) {
			for(int j=i+1; j<citystates.length; j++) {
				if(citystates[i][0].equals(citystates[j][1]) && citystates[i][1].equals(citystates[j][0])) count++;

			}
		}



		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);

		 */




	}
}
/*
 		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Pair> pairs = new ArrayList<Pair>(N);
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String city = st.nextToken().substring(0, 2);
			String state = st.nextToken();
			System.out.println(city + state);
			pairs.add(new Pair(city, state));
		}


		int count = 0;
		for(int i=0; i<pairs.size(); i++) {
			for(int j=i+1; j<pairs.size(); j++) {
				String a = pairs.get(i).city + pairs.get(i).state;
				String b = pairs.get(j).state + pairs.get(j).city;
				if(a.equals(b)) count++;
			}
		}

		System.out.println(count);
		pw.println(count);
		br.close();
		pw.close();
		System.exit(0);

	}

	static class Pair {
		String city, state;
		public Pair(String city, String state) {
			this.city = city;
			this.state = state;
		}
	}


}
 */
