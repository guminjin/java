package boj_15650;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static boolean visit[] = new boolean[9];
	static ArrayList<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		
		input();
		dfs(1, 0, "");
		
		for(int i = 0; i<result.size(); i++) {
			String out = result.get(i);
			for(int j = 0;j <out.length(); j++) {
				System.out.print(out.charAt(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
	}
	
	public static void dfs(int start, int cnt, String s) {
		if(cnt == m) {
			result.add(s);
			return;
		}
		for(int i = start; i<=n; i++) {
			if(visit[i])
				continue;
			
			String temp = s+ String.valueOf(i);
			visit[i] = true;
			dfs(i, cnt+1, temp);
			visit[i] = false;
		}
	}
}

