package boj_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ1987_알파벳 {
	public static int garo, sero;
	public static int[][] arr;

	public static boolean[] alpha;
	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());

		arr = new int[sero][garo];

		alpha = new boolean[26];
		result = 0;
		for (int y = 0; y < sero; y++) {
			String s = in.readLine();
			for (int x = 0; x < garo; x++) {
				arr[y][x] = s.charAt(x) - 'A';
			}
		}

		alpha[arr[0][0]] = true;
		dfs(new INFO(0, 0), 1);

		System.out.println(result);
	}

	public static void dfs(INFO now, int cnt) {
		if(cnt >=26) {
			result = 26;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = now.y + Y[i];
			int nx = now.x + X[i];

			if (ny < 0 || nx < 0 || ny >= sero || nx >= garo || alpha[arr[ny][nx]]) {
				result = Math.max(result, cnt);
				continue;
			}
	
			alpha[arr[ny][nx]] = true;
			dfs(new INFO(ny, nx), cnt + 1);
			alpha[arr[ny][nx]] = false;
		}

	}

	static class INFO {
		int y, x;

		public INFO(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}
