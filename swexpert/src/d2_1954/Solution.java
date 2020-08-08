package d2_1954;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();

			int[][] arr = new int[n][n];
			int num = 1;
			int cnt = n;
			int nx = -1;
			int ny = 0;

			while (num<=n*n) {
				for (int i = 0; i < cnt; i++) {
					if (num > n * n)
						break;

					nx += dir[0][1];
					ny += dir[0][0];

					arr[ny][nx] = num++;
				}
				cnt--;

				for (int i = 0; i < cnt; i++) {
					if (num > n * n)
						break;

					nx += dir[1][1];
					ny += dir[1][0];

					arr[ny][nx] = num++;
				}

				for (int i = 0; i < cnt; i++) {
					if (num > n * n)
						break;

					nx += dir[2][1];
					ny += dir[2][0];

					arr[ny][nx] = num++;
				}
				cnt--;
				for (int i = 0; i < cnt; i++) {
					if (num > n * n)
						break;

					nx += dir[3][1];
					ny += dir[3][0];

					arr[ny][nx] = num++;
				}
			}
			
			System.out.println("#" + t);
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					System.out.print(arr[y][x] + " ");
				}
				System.out.println();
			}

		}
	}

}
