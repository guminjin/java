package sw_7733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW7733_치즈도둑 {
	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[] check;
	
	static int[] Y = {-1, 1, 0, 0};
	static int[] X = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t<= tc; t++) {
			n = Integer.parseInt(in.readLine());
			arr = new int[n][n];
			check = new boolean[100 + 1];
			
			int mx = 0;
			for(int y = 0; y<n ;y++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int x = 0; x<n; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
					check[arr[y][x]] = true;
					
					if(mx < arr[y][x])
						mx = arr[y][x];
				}
			}
			
			int result = 0;
			for(int i = 1; i<=mx; i++) {
				if(!check[i])
					continue;
				
				int cnt = 0;
				visit = new boolean[n][n];

				for(int y = 0; y<n ;y++) {
					for(int x = 0; x<n; x++) {
						if(arr[y][x] <= i || visit[y][x])
							continue;
						bfs(y, x, i);
						cnt++;
					}
				}
				
				if(cnt > result)
					result = cnt;		
			}
			
			if(result == 0)
				result = 1;
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void bfs(int y, int x, int days) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		visit[y][x] = true;
		
		while(!q.isEmpty()) {
			XY now = q.poll();
			
			for(int i = 0; i<4; i++) {
				XY next = new XY(now.y, now.x);
				next.y += Y[i];
				next.x += X[i];
				
				if(next.y <0 || next.x <0 || next.y >=n || next.x>=n)
					continue;
				if(arr[next.y][next.x]<= days || visit[next.y][next.x] == true)
					continue;
				
				visit[next.y][next.x] = true; 
				q.add(next);
			}
			
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
