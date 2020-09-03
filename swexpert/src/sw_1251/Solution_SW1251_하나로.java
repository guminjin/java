package sw_1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SW1251_하나로 {
	public static int n;
	public static double e;
	public static LAND[] land;
	public static ArrayList<INFO> len;
	public static int[] parent;

	public static double result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			// 섬의 개수 입력
			n = Integer.parseInt(in.readLine());

			land = new LAND[n];
			result = 0;
			len = new ArrayList<INFO>();
			parent = new int[n];
			for (int i = 0; i < n; i++)
				parent[i] = i;

			// x좌표 입력
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				double lo = Double.parseDouble(st.nextToken());
				land[x] = new LAND(0, lo);
			}
			// y좌표 입력
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				land[x].y = Double.parseDouble(st.nextToken());
			}

			// 환경 부담 세율 입력
			e = Double.parseDouble(in.readLine());

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					len.add(new INFO(i, j, dist(land[i], land[j])));
				}
			}
			Collections.sort(len);

			for (int i = 0; i < len.size(); i++) {
				INFO now = len.get(i);

				if (find(now.p1) == find(now.p2))
					continue;

				union(now.p1, now.p2);
				result += now.dist;
			}

			result = Math.round(result * e);
			System.out.println("#" + t + " " + result);
		}
	}

	public static int find(int p1) {
		if (parent[p1] == p1)
			return p1;

		return parent[p1] = find(parent[p1]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else if (a > b)
			parent[b] = b;
	}

	public static double dist(LAND a, LAND b) {
		return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
	}

	static class LAND {
		double y, x;

		public LAND() {
		}

		public LAND(double y, double x) {
			this.y = y;
			this.x = x;
		}

	}

	static class INFO implements Comparable<INFO> {
		int p1, p2;
		double dist;

		public INFO() {
		}

		public INFO(int p1, int p2, double cost) {
			this.p1 = p1;
			this.p2 = p2;
			this.dist = cost;
		}

		@Override
		public int compareTo(INFO o) {
			return Double.compare(this.dist, o.dist);
		}

	}

}
