package jungol_1733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO1733_오목 {
	public static int n = 19;
	public static int[][] arr = new int[n + 1][n + 1];
	public static boolean[][][] visit = new boolean[4][n + 1][n + 1];

	public static int[] Y = { 0, 1, 1, 1 };
	public static int[] X = { 1, 1, 0, -1 };

	public static int rx, ry;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int y = 1; y <= n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 1; x <= n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flg = false;
		loop: for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= n; x++) {
				if (arr[y][x] == 0)
					continue;

				if (bfs(y, x, arr[y][x])) {
					flg = true;
					System.out.println(arr[y][x]);
					System.out.println(ry + " " + rx);
					break loop;
				}

			}
		}
		if (!flg)
			System.out.println("0");
	}

	public static boolean bfs(int startY, int startX, int color) {
		boolean ch = false;

		Queue<INFO> q = new LinkedList<INFO>();
		q.add(new INFO(startY, startX, 1));
		for (int i = 0; i < 4; i++) {
			visit[i][startY][startX] = true;
		}

		loop: while (!q.isEmpty()) {
			INFO now = q.poll();

			for (int i = 0; i < 4; i++) {
				INFO next = new INFO(now.y, now.x, now.cnt);
				while (true) {
					next.y += Y[i];
					next.x += X[i];

					if (next.y <= 0 || next.x <= 0 || next.y > n || next.x > n)
						break;
					if (arr[next.y][next.x] != color)
						break;
					if (visit[i][next.y][next.x])
						break;

					visit[i][next.y][next.x] = true;
					next.cnt++;
				}

				if (next.cnt == 5) {
					if (i == 3) {
						rx = next.x - X[i];
						ry = next.y - Y[i];
					} else {
						rx = now.x;
						ry = now.y;
					}
					ch = true;
					break loop;
				}
			}
		}
		return ch;
	}

	static class INFO {
		int y, x;
		int cnt;

		public INFO() {
		}

		public INFO(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}
}
