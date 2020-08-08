package sw_9229;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int mx;
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t<=tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			mx = -1;
			
			// ют╥б
			arr = new int [n];
			for(int i = 0; i<n; i++) 
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + mx);
		}
	}
	public static void dfs(int now, int cnt, int w) {
		if(cnt == 2) {
			if(mx<w)
				mx = w;
			return;
		}
		for(int i = now; i<n; i++) {
			int t = w + arr[i];
			
			if(t>m)
				return;
			
			dfs(i + 1, cnt + 1, t);
		}
	}

}
