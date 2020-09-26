package boj_17069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ17069_파이프옮기기2 {

	public static int n;
	public static int[][] arr;
	public static long[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		dp = new long[n][n][3];

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = 1;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (x + 1 < n && arr[y][x + 1] == 0) {
					dp[y][x + 1][0] += dp[y][x][0];
					dp[y][x + 1][0] += dp[y][x][1];
				}
				if (x + 1 < n && y + 1 < n && arr[y + 1][x + 1] == 0 && arr[y + 1][x] == 0 && arr[y][x + 1] == 0) {
					dp[y + 1][x + 1][1] += dp[y][x][0];
					dp[y + 1][x + 1][1] += dp[y][x][1];
					dp[y + 1][x + 1][1] += dp[y][x][2];
				}
				if (y + 1 < n && arr[y + 1][x] == 0) {
					dp[y + 1][x][2] += dp[y][x][1];
					dp[y + 1][x][2] += dp[y][x][2];
				}
			}
		}

		long result = 0;
		for (int i = 0; i < 3; i++)
			result += dp[n - 1][n - 1][i];

		System.out.println(result);
	}

}
