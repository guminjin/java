package sw_7393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SW7393_대구의팬덤활동 {
	public static int n;
	public static int[][][] dp;
	public static int MOD = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t<= tc; t++) {
			n = Integer.parseInt(in.readLine());
			dp = new int[10][n + 1][1 << 10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < n + 1; j++)
					Arrays.fill(dp[i][j], -1);
			}

			int result = 0;
			for (int i = 1; i <= 9; i++) {
				result += solve(i, 1, 1 << i);
				result %= MOD;
			}

			System.out.println("#" + t + " " + result);
		}

	}

	public static int solve(int start, int len, int num) {
		if (len == n)
			return num == (1 << 10) - 1 ? 1 : 0;

		if (dp[start][len][num] != -1)
			return dp[start][len][num];

		int res = 0;
		if (start - 1 >= 0)
			res += solve(start - 1, len + 1, num | 1 << (start - 1));
		if (start + 1 <= 9)
			res += solve(start + 1, len + 1, num | 1 << (start + 1));

		dp[start][len][num] = res % MOD;
		return dp[start][len][num];
	}
}
