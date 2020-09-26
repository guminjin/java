package sw_3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int t = 1; t<=tc; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			int[] dp = new int[n];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			Arrays.fill(dp, 1);
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<i; j++) {
					if(arr[j] > arr[i])
						continue;
					if(dp[i] >= dp[j] + 1)
						continue;
					
					dp[i] = dp[j] + 1;
					result = Math.max(result, dp[i]);
				}
			} 
				
			
 			System.out.println("#" + t + " " + result);
		}
	}
}