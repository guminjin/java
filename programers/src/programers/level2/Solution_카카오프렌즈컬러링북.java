package programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int sero = 6;
		int garo = 4;
		int[][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		int[] result = solution(sero, garo, arr);
		System.out.println(result[0] + ", " + result[1]);
	}

	public static int[] solution(int sero, int garo, int[][] arr) {
		int[] X = { 0, 0, -1, 1 };
		int[] Y = { -1, 1, 0, 0 };

		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		boolean[][] visit = new boolean[sero][garo];

		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				if (visit[y][x] || arr[y][x] == 0)
					continue;
				
				numberOfArea++;
				int cnt = 1;
				Queue<POINT> q = new LinkedList<POINT>();
				q.add(new POINT(y, x));
				visit[y][x] = true;
				int color = arr[y][x];

				while (!q.isEmpty()) {
					POINT now = q.poll();

					for (int i = 0; i < 4; i++) {
						POINT next = new POINT();
						next.x = now.x + X[i];
						next.y = now.y + Y[i];

						if (next.x < 0 || next.y < 0 || next.x >= garo || next.y >= sero)
							continue;
						if (visit[next.y][next.x] || color != arr[next.y][next.x])
							continue;

						visit[next.y][next.x] = true;
						q.add(next);
						cnt++;
					}
				}
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static class POINT {
		int y, x;

		public POINT() {
		}

		public POINT(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
