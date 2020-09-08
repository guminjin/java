package boj_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ16236_아기상어 {
	public static final int INF = Integer.MAX_VALUE;

	public static int n;
	public static int[][] arr;
	public static INFO shark;
	public static ArrayList<INFO> fish = new ArrayList<INFO>();
	public static int fishCnt;
	public static int result;

	public static int[] Y = { -1, 0, 0, 1 };
	public static int[] X = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());

		arr = new int[n][n];
		result = 0;

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());

				if (arr[y][x] == 0)
					continue;
				else if (arr[y][x] == 9) {
					shark = new INFO(y, x, 2);
					arr[y][x] = 0;
				} else {
					fish.add(new INFO(y, x, arr[y][x]));
					arr[y][x] = fish.size();
				}
			}
		}

		int cnt = 0;
		int eatIdx, d;
		while (!fish.isEmpty()) {
			int[] re = findEatFish();
			
			eatIdx =re[0];
			d = re[1];
			
			if (eatIdx == -1)
				break;

			result += d;

			if (++cnt == shark.size) {
				shark.size++;
				cnt = 0;
			}

			shark.y = fish.get(eatIdx).y;
			shark.x = fish.get(eatIdx).x;
			
			System.out.println(result);
			print();
		}

		System.out.println(result);

	}

	// 먹을 물고기 찾기
	public static int[] findEatFish() {
		boolean[][] visit = new boolean[n][n];
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(shark.y, shark.x, 0));
		visit[shark.y][shark.x] = true;

		int eatIdx = -1;
		int d = -1;
		loop: while (!q.isEmpty()) {
			XY now = q.poll();
			if (arr[now.y][now.x] != 0) {
				if (fish.get(arr[now.y][now.x] - 1).size > shark.size)
					continue;
				else if (fish.get(arr[now.y][now.x] - 1).size < shark.size) {
					eatIdx = arr[now.y][now.x] - 1;
					arr[now.y][now.x] = 0;
					d = now.dist;
					break loop;
				}
			}

			for (int i = 0; i < 4; i++) {
				XY next = new XY();
				next.y = now.y + Y[i];
				next.x = now.x + X[i];
				next.dist = now.dist + 1;

				if (next.y < 0 || next.x < 0 || next.y >= n || next.x >= n)
					continue;
				if (visit[next.y][next.x])
					continue;

				visit[next.y][next.x] = true;
				q.add(next);
			}
		}
		
		int[] re = {eatIdx, d};
		
		return re;
	}

	public static void print() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++)
				System.out.print(arr[y][x] + " ");
			System.out.println();
		}
		System.out.println();
	}

	static class XY implements Comparable<XY> {
		int y, x;
		int dist;

		public XY() {
		}

		public XY(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(XY o) {
			if(this.dist == o.dist) {
				if(this.y == o.y) {
					return Integer.compare(this.x, o.x);
				}
			}
			return 0;
		}
	}

	static class INFO {
		int y, x;
		int size;

		public INFO() {
		}

		public INFO(int y, int x, int size) {
			this.y = y;
			this.x = x;
			this.size = size;
		}

		

	}
}
