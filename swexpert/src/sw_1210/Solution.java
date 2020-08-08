package sw_1210;

import java.util.Scanner;

public class Solution {
	final static int MAX = 100;
	static int[][] arr = new int[MAX][MAX];
	static int desX = 0;
	static int desY = 0;
	static int startX = 0;
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) {
		for (int t = 1; t <= 10; t++) {
			input();
			sol();

			System.out.println("#" + t + " " + startX);
		}

	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int y = 0; y < MAX; y++) {
			for (int x = 0; x < MAX; x++) {
				arr[y][x] = sc.nextInt();
			}
		}
		for(int x = 0;x<MAX; x++) {
			if (arr[99][x] == 2) {
				desY = 0;
				desX = x;
			}
		}
	}

	public static void sol() {
		while (true) {
			if (desY == 0) {
				startX = desX;
				break;
			}
			arr[desY][desX] = 0;
			for (int i = 0; i < 3; i++) {
				int ny = desY + dir[i][0];
				int nx = desX + dir[i][1];

				if (ny < 0 || nx < 0 || ny >= MAX || nx >= MAX)
					continue;
				if (arr[ny][nx] == 1) {
					desY = ny;
					desX = nx;
					break;
				}
			}

		}
	}
}
