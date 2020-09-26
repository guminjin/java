package boj_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ1389_케빈베이컨의6단계법칙 {
	public static final int MAX = 987654321;
	
	public static int n, m;
	public static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new int[n][n];
		for(int i = 0; i<n; i++)
			Arrays.fill(dp[i], MAX);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			dp[a][b] = 1;
			dp[b][a] = 1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j || j == k )
						continue;
					
					if(dp[i][j] > dp[i][k] + dp[k][j])
						dp[i][j] = dp[i][k] + dp[k][j];
				}
			}
		}
		
		int result = 0;
		int min = MAX;
		for(int y = 0; y<n; y++) {
			int sum = 0;
			for(int x = 0; x<n; x++) {
				if(dp[y][x] == MAX)
					continue;
				
				sum += dp[y][x];
			}
			if(min > sum) {
				min = sum;
				result = y + 1;
			}
		}
		
		System.out.println(result);
	}
	public static void print() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(dp[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
