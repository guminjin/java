package WS0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_WS0827 {
	public static int garo, sero;
	public static char[][] arr;

	public static int[] Y = { -1, 0, 1 };

	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		arr = new char[sero][garo];
		result = 0;

		for (int y = 0; y < sero; y++) {
			String s = in.readLine();
			for (int x = 0; x < garo; x++) {
				arr[y][x] = s.charAt(x);
			}
		}

		for (int i = 0; i < sero; i++)
			dfs(i, 0);

		System.out.println(result);

	}

	public static boolean dfs(int y, int x) {
		for (int i = 0; i < 3; i++) {
			int ny = y + Y[i];
			int nx = x + 1;

			if (ny < 0 || nx < 0 || ny >= sero || nx >= garo)
				continue;
			if (arr[ny][nx] == 'x' || arr[ny][nx] == 'p')
				continue;

			arr[ny][nx] = 'p';

			if (nx == garo - 1) {
				result++;
				return true;
			}

			if (dfs(ny, nx))
				return true;
		}
		return false;
	}

}
