package sw_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW1767_프로세서연결하기 {
	public static final int INF = Integer.MAX_VALUE;

	public static int n;	// 맵의 크기
	public static int[][] arr;	// 맵
	public static ArrayList<CORE> core; // 코어의 위치를 저장

	// 상하좌우
	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	public static int connect;// 연결된 코어의 수
	public static int result;// 전선의 길이

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스 개수 입력
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {

			// 맵의 크기 입력
			n = Integer.parseInt(in.readLine());

			// 초기화
			arr = new int[n][n];
			core = new ArrayList<CORE>();
			result = INF;
			connect = 0;

			// 맵 입력
			for (int y = 0; y < n; y++) {
				st = new StringTokenizer(in.readLine());
				for (int x = 0; x < n; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
					
					if (arr[y][x] == 1)
						core.add(new CORE(y, x));
				}
			}

			// 탐색
			dfs(0, 0, 0);
			// 결과출력
			System.out.println("#" + t + " " + result);

		}
	}

	// 배열 복사
	public static void copyArr(int[][] copy, int[][] origin) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				copy[y][x] = origin[y][x];
			}
		}
	}

	// 탐색, idx : 코어번호, len : 연결된 코어의 전선 길이, cnt : 연결된 코어의 개수
	public static void dfs(int idx, int len, int cnt) {
		// 모든 코어를 확인했다면
		if (idx == core.size()) {
			// 연결된 코어의 개수가 이전보다 많다면 값 갱신
			if(connect < cnt) {
				connect = cnt;
				result = len;
			}
			// 연결된 코어의 개수가 같다면 길이가 더 작은 값을 갱신
			else if(connect == cnt)
				result = Math.min(result, len);
			return;
		}

		// 현재 상태 복사
		int[][] temp = new int[n][n];
		copyArr(temp, arr);

		// 현재 코어
		CORE now = core.get(idx);
		// 현재 코어가 벽에 붙어있다면 이미 전원이 연결됨
		if (now.x == 0 || now.y == 0 || now.x == n-1 || now.y == n-1)
			dfs(idx + 1, len, cnt + 1);
		else {
			// 코어를 연결하지 않았을 경우
			dfs(idx + 1, len, cnt);
			
			// 코어를 연결한 경우
			for (int d = 0; d < 4; d++) {
				CORE next = new CORE(now.y, now.x);
				
				// 전선의 위치를 저장
				Queue<CORE> line = new LinkedList<CORE>();

				int l = 0;// 전선의 길이
				boolean flg = true;// 해당 전선이 연결 가능한지 확인
				while (flg) {
					next.y += Y[d];
					next.x += X[d];

					// 벽을 만날때 까지 진행
					if (next.y < 0 || next.x < 0 || next.y >= n || next.x >= n)
						break;
					// 이동 위치에 코어가 있거나, 이미 전선이 설치되어있다면
					// 해당 방향으로 전선을 설치할 수 없다.
					if (arr[next.y][next.x] != 0) {
						flg = false;
						break;
					}

					l++;
					line.add(new CORE(next.y, next.x));
				}
				
				// 해당 방향으로 전선을 연결할 수 없으므로 다른 방향 확인
				if (!flg)
					continue;
				// 해당 방향으로 전선을 연결 가능
				else {
					// 맵에 전선 표시
					while (!line.isEmpty()) {
						next = line.poll();
						arr[next.y][next.x] = 2;
					}
					dfs(idx + 1, len + l, cnt + 1);
					
					// 맵을 전선이 연결되기 전의 상태로 복구
					copyArr(arr, temp);
				}
			}
		}
	}

	static class CORE {
		int y, x;

		public CORE() {
		}

		public CORE(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
