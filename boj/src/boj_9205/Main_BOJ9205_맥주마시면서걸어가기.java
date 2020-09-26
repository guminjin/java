package boj_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ9205_맥주마시면서걸어가기 {
	public static int MAX;
	public static int storeCnt;
	public static ArrayList<LOCATION> lo;
	public static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			storeCnt = Integer.parseInt(in.readLine());

			MAX = storeCnt + 2;
			lo = new ArrayList<LOCATION>();
			dp = new int[storeCnt + 2][storeCnt + 2];
			for (int y = 0; y < storeCnt + 2; y++) {
				for(int x = 0; x<storeCnt + 2; x++) {
					if(x== y)
						continue;
					
					dp[y][x] = MAX;
				}
				
			}

			for (int i = 0; i < storeCnt + 2; i++) {
				st = new StringTokenizer(in.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				lo.add(new LOCATION(y, x));
			}

			for (int y = 0; y < storeCnt + 2; y++) {
				LOCATION now = lo.get(y);
				for (int x = y + 1; x < storeCnt + 2; x++) {
					LOCATION next = lo.get(x);
					if (distance(now, next) <= 1000) {
						dp[y][x] = 1;
						dp[x][y] = 1;
					}
				}
			}			
			
			floyd();
			
			if (dp[0][storeCnt + 1] > 0 && dp[0][storeCnt + 1] < MAX)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	public static void print() {
		for (int y = 0; y < storeCnt + 2; y++) {
			for (int x = 0; x < storeCnt + 2; x++) {
				System.out.print(dp[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void floyd() {
		for (int k = 0; k < storeCnt + 2; k++) {
			for (int i = 0; i < storeCnt + 2; i++) {
				for (int j = 0; j < storeCnt + 2; j++) {
					if (i == j || j == k)
						continue;

					if (dp[i][j] > dp[i][k] + dp[k][j])
						dp[i][j] = dp[i][k] + dp[k][j];
				}
			}
		}
	}

	public static int distance(LOCATION a, LOCATION b) {
		return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
	}

	static class LOCATION {
		int y, x;

		public LOCATION() {
		}

		public LOCATION(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
