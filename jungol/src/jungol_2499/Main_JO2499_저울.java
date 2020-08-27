package jungol_2499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_JO2499_저울 {
	static int n;
	static int[] arr;
	static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		if(arr[0] != 1)
			System.out.println(1);
		dfs(0, 0);
		
		int result = 0;
		for(int p : set) {
			if(result++ != p)
				break;
		}
		
		System.out.println(result);
	}

	public static void dfs(int now, int sum) {
		for (int i = now; i < n; i++) {

			set.add(sum);
			dfs(i + 1, sum + arr[i]);

		}
	}

}
