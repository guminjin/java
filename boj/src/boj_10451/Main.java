package boj_10451;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t<tc; t++) {
			int n = sc.nextInt();
			arr = new int[n + 1];
			visit = new boolean[n + 1];
			for(int i = 1; i<=n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int result = 0;
			for(int i = 1; i<=n; i++) {
				if(visit[i])
					continue;
				dfs(i);
				result++;
			}
			
			System.out.println(result);
		}
	}
	public static void dfs(int start) {
		int next = arr[start];
		if(visit[next])
			return;
		visit[next] = true;
		dfs(next);
	}

}
