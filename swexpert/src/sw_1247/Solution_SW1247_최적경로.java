package sw_1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW1247_최적경로 {
	public static final int INF = Integer.MAX_VALUE;
	public static int n;
	public static LOCATION[] lo;
	public static boolean[] visit;
	public static LOCATION start;
	public static LOCATION end;

	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			result = INF;
			n = Integer.parseInt(in.readLine());
			lo = new LOCATION[n];
			visit = new boolean[n];

			st = new StringTokenizer(in.readLine());

			int x, y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			start = new LOCATION(y, x);

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			end = new LOCATION(y, x);

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				lo[i] = new LOCATION(y, x);
			}

			dfs(start, 0, 0);

			System.out.println("#" + t + " " + result);
		}
	}

	public static void dfs(LOCATION before, int len, int cnt) {
		if (len > result)
			return;
		if (cnt == n) {
			len += (Math.abs(before.x - end.x) + Math.abs(before.y - end.y));
			result = Math.min(len, result);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;

			int l = (Math.abs(before.x - lo[i].x) + Math.abs(before.y - lo[i].y));
			visit[i] = true;
			dfs(lo[i], len + l, cnt + 1);
			visit[i] = false;
		}
	}

	static class LOCATION {
		int y, x;

		public LOCATION() {
		}

		public LOCATION(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
