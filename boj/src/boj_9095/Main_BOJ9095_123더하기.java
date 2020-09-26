package boj_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ9095_123더하기 {
	public static int n;
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4;i<12; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int tc = Integer.parseInt(in.readLine());
		for(int i = 0; i<tc; i++) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(dp[n]);
		}
	}

}
