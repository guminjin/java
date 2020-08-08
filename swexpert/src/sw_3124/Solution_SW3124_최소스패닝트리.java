package sw_3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SW3124_최소스패닝트리 {
	static int v, e;
	static ArrayList<EDGE> list;
	static int[] parent = new int[100000 + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			list = new ArrayList<EDGE>();
			st = new StringTokenizer(in.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				list.add(new EDGE(v1, v2, c));
			}

			parentInit();
			Collections.sort(list);
			
			int cnt = 0;
			long result = 0;
			for (int i = 0; i < list.size(); i++) {
				EDGE now = list.get(i);
				if (findParent(now.v1) == findParent(now.v2))
					continue;

				union(now.v1, now.v2);
				result += now.cost;
				if(++cnt == v-1)
					break;
			}

			System.out.println("#" + t + " " + result);
		}
	}

	public static void parentInit() {
		for (int i = 0; i < 100000 + 1; i++)
			parent[i] = i;
	}

	public static int findParent(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = findParent(parent[x]);
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x < y)
			parent[y] = x;
		else if (x > y)
			parent[x] = y;
		else
			return;
	}

	static class EDGE implements Comparable<EDGE> {
		int v1, v2;
		long cost;

		public EDGE() {
		}

		public EDGE(int v1, int v2, long cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(EDGE o) {
			if (this.cost < o.cost)
				return -1;
			else if (this.cost == o.cost)
				return 0;
			else
				return 1;
		}

	}
}
