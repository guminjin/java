package sw_2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SW2806_NQueen {
	public static int n;
	public static int[] arr;
	
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t<=tc; t++) {
			n = Integer.parseInt(in.readLine());
			arr = new int[n];
			
			result = 0;
			
			dfs(0);
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static boolean check(int ny) {
		for(int y = 0; y<ny; y++) {
			if(arr[y] == arr[ny])
				return false;
			if((ny - y) == Math.abs(arr[y] - arr[ny]))
				return false;
		}
		return true;
	}
	public static void dfs(int y) {
		if(y == n) {
			result++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[y] = i;
			if(check(y))
				dfs(y + 1);
		}
	}

}
