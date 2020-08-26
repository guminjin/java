package boj_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ15686_치킨배달 {
	static final int INF = (1 << 31) - 1;
	static int n;
	static int m;
	static ArrayList<INFO> chicken = new ArrayList<INFO>();
	static ArrayList<INFO> home = new ArrayList<INFO>();
	static boolean[] visit;

	static int result = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(in.readLine());
			for (int x = 0; x < n; x++) {
				int now = Integer.parseInt(st.nextToken());

				if (now == 1) {
					home.add(new INFO(y, x));
				} else if (now == 2) {
					chicken.add(new INFO(y, x));
				}
			}
		}
		
		visit = new boolean[chicken.size()];
		dfs(0, 0);

		System.out.println(result);
	}

	public static int calLen(int idx) {
		INFO h = home.get(idx);
		
		int len = INF;

		for(int i = 0; i<chicken.size(); i++) {
			if(!visit[i])
				continue;
			int l = Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y);
			
			if(l<len)
				len  = l;
		}
		return len;
	}

	public static void dfs(int start, int cnt) {
		if (cnt == m) {
			int len = 0;
			for(int i = 0; i< home.size(); i++) {
				len += calLen(i);
			}
			
			if (len < result)
				result = len;

			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			if (visit[i])
				continue;
			
			visit[i] = true;
			dfs(i + 1, cnt + 1);
			visit[i] = false;
		}
	}

	static class INFO {
		int y, x;

		public INFO() {
		}

		public INFO(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
