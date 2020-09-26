package boj_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ11403_경로찾기 {
	public static int n;
	public static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j == k || arr[i][j] == 1)
						continue;

					if (arr[i][k] == 1 && arr[k][j] == 1)
						arr[i][j] = 1;
				}
			}
		}

		print();
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
}
