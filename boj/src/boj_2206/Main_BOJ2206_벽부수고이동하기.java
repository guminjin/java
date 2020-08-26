package boj_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ2206_벽부수고이동하기 {
	public static int garo, sero;
	public static int[][] arr;
	public static boolean[][][] visit;
	
	public static int[] Y = {-1, 1, 0, 0};
	public static int[] X = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		
		arr = new int[sero][garo];
		visit = new boolean[2][sero][garo];
		
		for(int y = 0; y<sero; y++) {
			String s = in.readLine();
			for(int x = 0; x<garo; x++) {
				arr[y][x] = (s.charAt(x) - '0');
			}
		}
		
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<INFO> q = new LinkedList<INFO>();
		q.add(new INFO(0, 0, 1, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			INFO now = q.poll();
			
			if(now.y == sero - 1 && now.x == garo-1)
				return now.len;
			
			for(int i = 0; i<4; i++) {
				INFO next = new INFO();
				next.y = now.y + Y[i];
				next.x = now.x + X[i];
				next.len = now.len + 1;
				next.cnt = now.cnt;
				if(next.y <0 || next.x <0 || next.y >= sero || next.x >= garo)
					continue;
				if(arr[next.y][next.x] == 1)
					next.cnt++;
				if(next.cnt >1)
					continue;
				if(visit[next.cnt][next.y][next.x])
					continue;
				
				visit[next.cnt][next.y][next.x] = true;
				q.add(next);
			}
		}
		return -1;
	}
	
	static class INFO {
		int y, x;
		int len;
		int cnt;
		public INFO() {
		}
		public INFO(int y, int x, int len, int cnt) {
			this.y = y;
			this.x = x;
			this.len = len;
			this.cnt = cnt;
		}
		
	}
}
