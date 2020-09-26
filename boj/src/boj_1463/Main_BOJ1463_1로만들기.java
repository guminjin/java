package boj_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ1463_1로만들기 {
	public static final int MAX = 1000000 + 1;
	
	public static int n;
	public static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[MAX];
		n= Integer.parseInt(in.readLine());
		
		dp[1] = 0;
		dp[2] = 1;
		for(int i = 3; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i%2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		System.out.println(dp[n]);
	}

}
