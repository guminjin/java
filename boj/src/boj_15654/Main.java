package boj_15654;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static boolean visit[];
	static int[] arr;
	static int[] result = new int[8];
	
	public static void main(String[] args) {
		
		input();
		dfs(0, 0);
			
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		visit = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == m) {
			for(int i = 0; i<m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i<n; i++) {
			if(visit[i])
				continue;
			
			result[cnt] = arr[i];
			visit[i] = true;
			dfs(i, cnt+1);
			visit[i] = false;
		}
	}
}
