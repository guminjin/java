package boj_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ11404_플로이드 {
	public static final int MAX = 987654321;

	public static int n, m;
	public static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(arr[i], MAX);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			arr[y][x] = Math.min(arr[y][x], c);

		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j || j == k)
						continue;

					if (arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}

		print();
	}

	public static void print() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (arr[y][x] == MAX)
					arr[y][x] = 0;
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
