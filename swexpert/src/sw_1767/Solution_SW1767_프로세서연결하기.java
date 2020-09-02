package sw_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW1767_프로세서연결하기 {
	public static final int INF = Integer.MAX_VALUE;

	public static int n;
	public static int[][] arr;
	public static ArrayList<CORE> core;

	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	public static int connect;
	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {

			n = Integer.parseInt(in.readLine());

			arr = new int[n][n];
			core = new ArrayList<CORE>();
			result = INF;
			connect = 0;

			for (int y = 0; y < n; y++) {
				st = new StringTokenizer(in.readLine());
				for (int x = 0; x < n; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
					if (arr[y][x] == 1)
						core.add(new CORE(y, x));
				}
			}

			dfs(0, 0, 0);
			System.out.println("#" + t + " " + result);

		}
	}

	public static void print() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void copyArr(int[][] copy, int[][] origin) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				copy[y][x] = origin[y][x];
			}
		}
	}

	public static void dfs(int idx, int len, int cnt) {
		if (idx == core.size()) {
			if(connect < cnt) {
				connect = cnt;
				result = len;
			}
			else if(connect == cnt)
				result = Math.min(result, len);
			return;
		}

		int[][] temp = new int[n][n];
		copyArr(temp, arr);

		CORE now = core.get(idx);
		if (now.x == 0 || now.y == 0 || now.x == n-1 || now.y == n-1)
			dfs(idx + 1, len, cnt + 1);
		else {
			dfs(idx + 1, len, cnt);
			for (int d = 0; d < 4; d++) {
				CORE next = new CORE(now.y, now.x);
				Queue<CORE> line = new LinkedList<CORE>();

				int l = 0;
				boolean flg = true;
				while (flg) {
					next.y += Y[d];
					next.x += X[d];

					if (next.y < 0 || next.x < 0 || next.y >= n || next.x >= n)
						break;
					if (arr[next.y][next.x] != 0) {
						flg = false;
						break;
					}

					l++;
					line.add(new CORE(next.y, next.x));
				}

				if (!flg)
					continue;
				else {
					while (!line.isEmpty()) {
						next = line.poll();
						arr[next.y][next.x] = 2;
					}
					dfs(idx + 1, len + l, cnt + 1);
					copyArr(arr, temp);
				}
			}
		}
	}

	static class CORE {
		int y, x;

		public CORE() {
		}

		public CORE(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
