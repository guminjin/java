package jungol_1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];

		if (m == 0)
			System.out.println(n);
		else {
			init();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (i == parent[i])
					result++;
			}
			System.out.println(result);
		}
	}

	public static void init() {
		for (int i = 1; i <= n; i++)
			parent[i] = i;
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

}
