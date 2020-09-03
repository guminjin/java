package jungol_1681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_JO1681_해밀턴순환회로 {
	public static int n;
	public static int[][] arr;
	public static boolean[] visit;
	
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n];
		result = Integer.MAX_VALUE;
				
		for(int y = 0; y<n; y++) {
			st = new StringTokenizer(in.readLine());
			for(int x = 0; x<n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit[0] = true;
		for(int i = 1; i<n; i++) {
			if(arr[0][i] == 0)
				continue;
			
			visit[i] = true;
			dfs(i, arr[0][i], 1);
			visit[i] = false;
		}
		
		System.out.println(result);
	}
	
	public static void dfs (int before, int len, int cnt) {
		if(result < len)
			return;
		if(cnt == n- 1) {
			if(arr[before][0] != 0)
				result = Math.min(len + arr[before][0], result);
			return;
		}
		for(int i = 1; i<n ;i++) {
			if(visit[i] || arr[before][i] == 0)
				continue;
			
			visit[i] = true;
			dfs(i, len + arr[before][i], cnt + 1);
			visit[i] = false;
		}
	}
	
	static class INFO implements Comparable<INFO>{
		int p1, p2;
		int cost;
		public INFO() {
		}
		public INFO(int p1, int p2, int cost) {
			this.p1 = p1;
			this.p2 = p2;
			this.cost = cost;
		}
		@Override
		public int compareTo(INFO o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}

}

/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
 */
