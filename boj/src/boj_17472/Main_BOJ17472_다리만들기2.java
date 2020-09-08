package boj_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ17472_다리만들기2 {
	public static int garo, sero;
	public static int[][] arr;
	public static int landCnt;
	public static ArrayList<BRIDGE> bridge = new ArrayList<BRIDGE>();
	public static int[] parent;
	public static int result;
	
	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());

		arr = new int[sero][garo];
		result = 0;
		
		for (int y = 0; y < sero; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < garo; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 0)
					continue;
				arr[y][x] = -1;
			}
		}

		// 섬나누기
		bfs();
		
		// 모든 다리길이 구하기
		allBridge();
		// 다리길이 정렬
		Collections.sort(bridge);
		
		// 다리 연결하기
		parent = new int[landCnt + 1];
		for(int i = 1; i<=landCnt; i++) 
			parent[i] = i;
		
		for(int i = 0; i<bridge.size(); i++) {
			BRIDGE now = bridge.get(i);
			
			if(find(now.land1) != find(now.land2)) {
				union(now.land1, now.land2);
				result += now.cost;
			}
		}
		
		for(int i = 1; i<landCnt; i++) {
			if(find(i) == find(i +1))
				continue;
			
			result = -1;
		}
		System.out.println(result);
		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a<b) {
			parent[b] = a;
		} else if (a > b) {
			parent[a] = b;
		} else 
			return;
	}

	private static int find(int a) {
		if(parent[a] == a)
			return a;
		
		return parent[a] = find(parent[a]);
	}

	private static void allBridge() {
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				if (arr[y][x] == 0)
					continue;

				for (int i = 0; i < 4; i++) {
					int nx = x;
					int ny = y;
					int cost = -1;
					
					while (true) {
						ny += Y[i];
						nx += X[i];
						cost += 1;

						if (ny < 0 || nx < 0 || ny >= sero || nx >= garo)
							break;
						if (arr[ny][nx] == arr[y][x])
							break;
						if (arr[ny][nx] == 0)
							continue;

						if(cost == 1)
							break;
						bridge.add(new BRIDGE(arr[y][x], arr[ny][nx], cost, i));
						break;
					}
				}
			}
		}
	}

	private static void print() {
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 섬 나누기
	private static void bfs() {
		landCnt = 0;

		boolean[][] visit = new boolean[sero][garo];

		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				if (arr[y][x] == 0 || visit[y][x])
					continue;

				landCnt++;
				Queue<XY> q = new LinkedList<XY>();
				q.add(new XY(y, x));
				visit[y][x] = true;
				arr[y][x] = landCnt;

				while (!q.isEmpty()) {
					XY now = q.poll();

					for (int i = 0; i < 4; i++) {
						XY next = new XY();
						next.y = now.y + Y[i];
						next.x = now.x + X[i];

						if (next.y < 0 || next.x < 0 || next.y >= sero || next.x >= garo)
							continue;
						if (arr[next.y][next.x] == 0 || visit[next.y][next.x])
							continue;

						visit[next.y][next.x] = true;
						arr[next.y][next.x] = landCnt;
						q.add(next);
					}
				}
			}
		}
	}

	static class BRIDGE implements Comparable<BRIDGE> {
		int land1, land2;
		int cost;
		int dir;

		public BRIDGE() {
		}

		public BRIDGE(int land1, int land2, int cost, int dir) {
			this.land1 = land1;
			this.land2 = land2;
			this.cost = cost;
			this.dir = dir;
		}

		@Override
		public int compareTo(BRIDGE o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static class XY {
		int y, x;

		public XY() {
		}

		public XY(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
