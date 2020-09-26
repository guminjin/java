package sw_7236;

import java.util.Scanner;

public class Solution_SW7236_저수지의물의총깊이구하기 {

	public static int n;
	public static int[][] map;
	public static int[] Y = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static int[] X = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					char temp = sc.next().charAt(0);
					if (temp == 'G')
						map[y][x] = -1;
					else
						map[y][x] = 1;
				}
			}

			int result = 1;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (map[y][x] == -1)
						continue;

					int cnt = 0;
					for (int i = 0; i < 8; i++) {
						int ny = y + Y[i];
						int nx = x + X[i];

						if (ny < 0 || nx < 0 || ny >= n || nx >= n)
							continue;
						if (map[ny][nx] == -1)
							continue;

						cnt++;
					}
					result = Math.max(result, cnt);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
