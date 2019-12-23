import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Rental {

	private static int N, M, R;
	private static ArrayList<Store> stores;
	private static int[] cows;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		cows = new int[N];
		stores = new ArrayList<Store>();
		int[] prices = new int[R];
		int[] prefixPrice = new int[R];

		for(int i=0; i<N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cows);

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gallons = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			stores.add(new Store(gallons, price));
		}

		Collections.sort(stores, new Sort());

		for(int i=0; i<R; i++) {
			prices[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(prices);
		int total = 0;
		for(int i=0; i<R; i++) {
			total += prices[R-i-1];
			prefixPrice[i] = total;
		}

		long max = -1;
		for(int i=0; i < N; i++) {
			if(i < M ) {
				int rent = prefixPrice[i];
				int store = getStores(i);
				max = Math.max(max, rent + store);

			}
		}
		
		if(N-1 < R) max = Math.max(max, prefixPrice[N-1]);
		if(N-1 < M) max = Math.max(max, getStores(-1));

		System.out.println(max);
		pw.println(max);
		br.close();
		pw.close();
		System.exit(0);
		
	
	}

	private static int getStores(int n) {


		int[] newCows = Arrays.copyOf(cows, cows.length);
		ArrayList<Store> newStores = new ArrayList<Store>(M);
		for(int i=0; i<M; i++) {
			newStores.add(new Store(stores.get(i).gallons, stores.get(i).price));
		}

		int store = 0;
		int total = 0;

		int i = N-1;
		while(i > n && store < newStores.size()) {
			
			int price = newStores.get(store).price;
			int gallons = newStores.get(store).gallons;
			
			int use = Math.min(gallons, newCows[i]);
			total += use * price;
			newStores.get(store).gallons -= use;
			newCows[i] -= use;
			if(newCows[i] == 0) i--;
			if(gallons - use == 0) store++;
		
		}
		return total;
	}

	static class Store{
		int gallons, price;
		public Store(int gallons, int price) {
			this.gallons = gallons;
			this.price = price;
		}
	}

	static class Sort implements Comparator<Store>{


		public int compare(Store o1, Store o2) {

			return o2.price - o1.price;
		}

	}

}
