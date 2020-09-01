package boj_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ14889_스타트와링크 {
	public static final int INF = Integer.MAX_VALUE;

	public static int n;
	public static int[][] arr;
	public static boolean[] visit;

	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		visit = new boolean[n];
		result = INF;

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(result);
	}

	public static int calPower() {
		int s = 0;
		int l = 0;
		for (int y = 0; y < n; y++) {

			for (int x = y; x < n; x++) {
				if (y == x)
					continue;

				if (visit[y] && visit[x])
					s += (arr[y][x] + arr[x][y]);
				else if(!visit[y] && !visit[x])
					l += (arr[y][x] + arr[x][y]);
			}
		}
		return Math.abs(s - l);
	}

	public static void dfs(int start, int cnt) {
		if (cnt == n / 2) {
			result = Math.min(result, calPower());
			return;
		}

		for (int i = start; i < n; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			dfs(i + 1, cnt + 1);
			visit[i] = false;
		}
	}

}
