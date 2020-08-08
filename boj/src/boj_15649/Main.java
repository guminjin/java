package boj_15649;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static boolean visit[];
	static ArrayList<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n+1];		
		
		for(int i = 1; i<=n; i++) {
			String s = String.valueOf(i);
			visit[i] = true;
			dfs(1, s);
			visit[i] = false;
		}
		
		for(int i = 0; i<result.size(); i++) {
			String out = result.get(i);
			for(int j = 0; j<out.length();j++) {
				System.out.print(out.charAt(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int cnt, String s) {
		if(cnt == m) {
			result.add(s);
			return;
		}
		
		for(int i = 1; i<=n; i++) {
			if(visit[i])
				continue;
			String temp = s + String.valueOf(i);
			visit[i] = true;
			dfs(cnt + 1, temp);
			visit[i] = false;
		}
		
	}
}


