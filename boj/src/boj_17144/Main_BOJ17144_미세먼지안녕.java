package boj_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ17144_미세먼지안녕 {
	public static int garo, sero, s; // 가로, 세로, 초
	public static int[][] arr; // 맵
	public static int[] cleaner; // 공기청정기 위치

	// 상하좌우
	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	// 결과
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 가로, 세초, 시간 일벽
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		// 배열, 공기청정기 위치, 결과값 초기화
		arr = new int[sero][garo];
		cleaner = new int[2];
		result = 0;

		int idx = 0; // 공기청정기 위치 저장을 위한 idx
		// 맵 입력
		for (int y = 0; y < sero; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < garo; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == -1) {
					cleaner[idx++] = y;
				}
			}
		}

		// s초동안 미세머지 확산과 공기청정기를 작동
		for (int i = 0; i < s; i++) {
			spread();
			airClean();
		}

		// 결과 출력
		result = restDust();
		System.out.println(result);
	}

	// 남은 미세먼지를 확인
	private static int restDust() {
		int sum = 0;
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				if (arr[y][x] == -1)
					continue;
				sum += arr[y][x];
			}
		}
		return sum;
	}

	// 공기 청정기 작동
	private static void airClean() {
		// 반시계 방향
		int yLen = cleaner[0];
		int xLen = garo - 1;

		int ny = cleaner[0];
		int nx = 0;

		int before = 0;
		int now = 0;

		// 우
		for (int x = 0; x < xLen; x++) {
			nx += X[3];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		// 상
		for (int y = 0; y < yLen; y++) {
			ny += Y[0];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		yLen--;
		// 좌
		for (int x = 0; x < xLen; x++) {
			nx += X[2];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		// 하
		for (int y = 0; y < yLen; y++) {
			ny += Y[1];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}

		// 시계 방향
		ny = cleaner[1];
		nx = 0;

		yLen = sero - cleaner[1] - 1;
		xLen = garo - 1;

		before = 0;
		now = 0;

		// 우
		for (int x = 0; x < xLen; x++) {
			nx += X[3];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		// 하
		for (int y = 0; y < yLen; y++) {
			ny += Y[1];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		yLen--;
		// 좌
		for (int x = 0; x < xLen; x++) {
			nx += X[2];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
		// 상
		for (int y = 0; y < yLen; y++) {
			ny += Y[0];

			now = arr[ny][nx];
			arr[ny][nx] = before;
			before = now;
		}
	}

	// 미세먼지 확산
	private static void spread() {
		// 미세먼지가 동시에 확산되므로 미세먼지를 저장할 다른 배열 필요
		int[][] temp = new int[sero][garo];

		// 공기청정기가 있는 위치는 -1
		temp[cleaner[0]][0] = -1;
		temp[cleaner[1]][0] = -1;

		// 모든 위치를 확인
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				// 미세먼지가 없거나, 공기청정기가 있는지 확인
				if (arr[y][x] == 0 || arr[y][x] == -1)
					continue;

				int div = arr[y][x] / 5;// 확산될 미세먼지

				int cnt = 0; // 몇칸에 확산되었는지 확인
				// 상하좌우 모두 확인
				for (int i = 0; i < 4; i++) {
					int ny = y + Y[i];
					int nx = x + X[i];

					// 범위확인
					if (ny < 0 || nx < 0 || ny >= sero || nx >= garo)
						continue;
					// 이동 위치에 공기청정기가 있는지 확인
					if (arr[ny][nx] == -1)
						continue;

					// 확산
					cnt++;
					temp[ny][nx] += div;
				}

				temp[y][x] += arr[y][x] - div * cnt;
			}
		}

		// 원래 배열에 copy
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				arr[y][x] = temp[y][x];
			}
		}
	}
}
