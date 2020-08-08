package boj_9466;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] visit;
	static int[] point;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(in.readLine());
			arr = new int[n + 1];
			visit = new int[n + 1];
			point = new int[n + 1];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (visit[i] != 0)
					continue;
				result += dfs(i, i, 1);

			}
			sb.append((n - result) + "\n");
		}
		System.out.println(sb.toString());

	}

	public static int dfs(int start, int now, int cnt) {
		if(visit[now] != 0) {
			if(start != point[now])
				return 0;
			return cnt - visit[now];
		}
		
		visit[now] = cnt;
		point[now] = start;

		return dfs(start, arr[now], cnt + 1);

	}
}

/*
 2 
 7 
 3 1 3 7 3 4 6 
 8 
 1 2 3 4 5 6 7 8
 */
