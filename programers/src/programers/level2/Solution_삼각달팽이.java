package programers.level2;

import java.util.ArrayList;

public class Solution_삼각달팽이 {

	public static void main(String[] args) {
		int[] result = solution(3);

	}

	public static int[] solution(int n) {
		int[] Y = { 1, 0, -1 };
		int[] X = { 0, 1, -1 };

		int[][] arr = new int[n][n];

		int dir = 0;
		int num = 1;
		int y = -1, x = 0;
		int size = n;
		while (size > 0) {
			for (int i = size; i > 0; i--) {
				y += Y[dir];
				x += X[dir];

				arr[y][x] = num;
				num++;
			}

			dir = (dir + 1) % 3;
			size--;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (y = 0; y < n; y++) {
			for (x = 0; x < n; x++) {
				if (arr[y][x] == 0)
					break;
				list.add(arr[y][x]);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		return result;
	}

	public static void print(int[][] arr, int n) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(arr[y][x] + " ");

			}
			System.out.println();
		}
		System.out.println();
	}
}
