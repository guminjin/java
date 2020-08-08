package d3_5251;

import java.util.Scanner;

public class Solution {
	final static int MAX = 20;

	static int[] grade = new int[MAX];
	static int[] cal = new int[MAX];
	static int n;
	static int l;
	static boolean[] visit = new boolean[MAX];

	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			l = sc.nextInt();
			result = 0;

			// ют╥б
			for (int i = 0; i < n; i++) {
				grade[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			for(int i = 0; i<n; i++)
				DFS(i, 0, 0);
			System.out.println("#" + t + " " + result);

		}
	}

	static void DFS(int start, int g, int c) {
		if(c>l)
			return;
		if (result < g)
			result = g;

		for (int i = start; i < n; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			int g2 = g + grade[i];
			int c2 = c + cal[i];

			DFS(i, g2, c2);
			visit[i] = false;

		}
	}

}
