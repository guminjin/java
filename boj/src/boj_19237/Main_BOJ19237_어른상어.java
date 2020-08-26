package boj_19237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ19237_어른상어 {
	static int n;
	static int sharkCnt;
	static int k;
	static int[][] arr;
	static SMELL[][] smell;
	static int[][][] order;
	static SHARK[] shark;

	static int[] Y = { -1, 1, 0, 0 };
	static int[] X = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();

		int result = -1;
		for (int i = 1; i <= 1000; i++) {
			moveShark();
			removeSmell();
			//print();
			if (checkShark()) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

	public static void init() {
		// �迭 �ʱ�ȭ
		arr = new int[n][n];
		smell = new SMELL[n][n];
		shark = new SHARK[sharkCnt + 1];
		order = new int[sharkCnt + 1][4][4];
		for (int y = 0; y < n; y++)
			for (int x = 0; x < n; x++)
				smell[y][x] = new SMELL();
//		for(int i = 0; i<=sharkCnt; i++)
//			shark[i] = new SHARK();

	}

	public static void input() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// arr ũ��, ��� ��, k �Է�
		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		sharkCnt = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		init();

		// arr �Է�
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 0)
					continue;

				shark[arr[y][x]] = new SHARK(y, x, 0, true);
				smell[y][x].sec = k;
				smell[y][x].shark = arr[y][x];
			}
		}

		// shark �ʱ� ���� ����
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= sharkCnt; i++) {
			int dir = Integer.parseInt(st.nextToken());
			shark[i].dir = dir - 1;
		}

		// shark �켱����
		for (int i = 1; i <= sharkCnt; i++) {
			for (int y = 0; y < 4; y++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int x = 0; x < 4; x++) {
					int dir = Integer.parseInt(st.nextToken());
					order[i][y][x] = dir - 1;
				}
			}
		}
	}

	public static void moveShark() {
		for (int i = 1; i <= sharkCnt; i++) {
			if (!shark[i].live)
				continue;

			SHARK now = shark[i];
			boolean flg = false;
			int idx = -1;
			for (int d = 0; d < 4; d++) {
				SHARK next = new SHARK();
				int dir = order[i][now.dir][d];
				next.y = now.y + Y[dir];
				next.x = now.x + X[dir];
				next.dir = dir;
				next.live = true;

				if (next.y < 0 || next.x < 0 || next.y >= n || next.x >= n)
					continue;
				if (smell[next.y][next.x].sec != 0) {
					if (idx == -1 && smell[next.y][next.x].shark == i) {
						idx = d;
					}
					continue;
				}

				flg = true;
				shark[i] = next;
				break;
			}

			if (flg)
				continue;

			int dir = order[i][now.dir][idx];
			SHARK next = new SHARK(now.y + Y[dir], now.x + X[dir], dir, true);

			smell[next.y][next.x].shark = i;
			smell[next.y][next.x].sec = k + 1;

			shark[i] = next;

		}
		
		int[][] temp = new int[n][n];

		for(int i = 1; i<= sharkCnt; i++) {
			if(!shark[i].live)
				continue;
			
			if(temp[shark[i].y][shark[i].x] != 0) {
				shark[i].live = false;
			} else {
				temp[shark[i].y][shark[i].x] = i;
				smell[shark[i].y][shark[i].x].sec = k + 1;
				smell[shark[i].y][shark[i].x].shark = i;
			}
		}
		copyArr(arr, temp);
	}

	public static void copyArr(int[][] copy, int[][] origin) {
		for (int y = 0; y < n; y++)
			for (int x = 0; x < n; x++)
				copy[y][x] = origin[y][x];
	}

	public static void removeSmell() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (smell[y][x].sec == 0) {
					smell[y][x].shark = 0;
					continue;
				}
				smell[y][x].sec--;
			}
		}
	}

	public static boolean checkShark() {
		for (int i = 2; i <= sharkCnt; i++) {
			if (shark[i].live)
				return false;
		}
		return true;
	}

	public static void print() {
		System.out.println("arr");
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println("smell.sec");
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(smell[y][x].sec + " ");
			}
			System.out.println();
		}
		System.out.println("smell.shark");
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				System.out.print(smell[y][x].shark + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class SHARK {
		int y, x;
		int dir;
		boolean live;

		public SHARK() {
		}

		public SHARK(int y, int x, int dir, boolean live) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.live = live;
		}

	}

	static class SMELL {
		int sec;
		int shark;

		public SMELL() {
		}

		public SMELL(int sec, int shark) {
			this.sec = sec;
			this.shark = shark;
		}

	}

}
