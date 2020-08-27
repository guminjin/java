package boj_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ17406_배열돌리기4 {
	public final static int INF = Integer.MAX_VALUE;

	public static int garo, sero, k; // 가로, 세로, 연산의 개수
	public static int[][] arr; // 맵
	public static INFO[] oper; // 연산의 정보
	public static boolean[] visit;

	public static int[] Y = { 0, 1, 0, -1 }; // 우하좌상 Y
	public static int[] X = { 1, 0, -1, 0 }; // 우하좌상 X

	public static int result = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[sero][garo];
		oper = new INFO[k];
		visit = new boolean[k];

		// 맵 입력
		for (int y = 0; y < sero; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < garo; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산 입력
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			oper[i] = new INFO(r, c, s);
		}

		dfs(0);

		System.out.println(result);
	}

	// 출력
	public static void print() {
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 배열 최소값 찾기
	public static int calMin() {
		int min = INF;
		for (int y = 0; y < sero; y++) {
			int sum = 0;
			for (int x = 0; x < garo; x++) {
				sum += arr[y][x];
			}
			if (min > sum)
				min = sum;
		}
		return min;
	}

	// 배열 복사
	public static void copyArr(int[][] copy, int[][] origin) {
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				copy[y][x] = origin[y][x];
			}
		}
	}

	// 배열 돌리기
	public static void turnArr(INFO op) {
		int ny = op.r - op.s;		// 시작y
		int nx = op.c - op.s - 1;	// 시작x는 -1 : 우측으로 배열 값을 읽기 때문
		int len = (op.r + op.s) - (op.r - op.s) + 1;	// 길이

		while (len > 1) {			
			int now = 0;
			int before = arr[ny + 1][nx + 1];
			
			// 우, 하, 좌, 상
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < len; j++) {
					ny += Y[i];
					nx += X[i];
					
					now = arr[ny][nx];
					arr[ny][nx] = before;
					before = now;
				}
				// 하, 상 일때 배열에서 읽는 길이를 1줄이기
				if (i == 0 || i == 2)
					len--;
			}
		}

	}

	// 연산순서
	public static void dfs(int cnt) {
		if (cnt == k) {
			int min = calMin();
			if (result > min)
				result = min;
			return;
		}
		for (int i = 0; i < k; i++) {
			if (visit[i])
				continue;
			
			// 돌리기 전 배열 저장
			int[][] temp = new int[sero][garo];

			copyArr(temp, arr);
			
			visit[i] = true;
			turnArr(oper[i]);
			dfs(cnt + 1);

			visit[i] = false;
			copyArr(arr, temp);

		}
	}

	static class INFO {
		int r, c, s;

		public INFO() {
		}

		public INFO(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}
}
