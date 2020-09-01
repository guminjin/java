package boj_2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ2933_미네랄 {
	public static int garo, sero, n;
	public static int[][] arr;
	public static int[] stick;

	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		arr = new int[sero + 1][garo + 1];

		for (int y = 1; y <= sero; y++) {
			String s = in.readLine();
			for (int x = 1; x <= garo; x++) {
				if (s.charAt(x) == 'x')
					arr[y][x] = 1;
				else
					arr[y][x] = 0;
			}
		}

		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			stick[i] = Integer.parseInt(st.nextToken());
		}

		boolean turn = true;
		for (int i = 0; i < n; i++) {
			int dir = 0;
			if (turn)
				dir = 3;
			else
				dir = 2;
			
			INFO lo = breakMineral(dir, stick[i]);
			if(lo.x != 0 && lo.y != 0) {
				
			}
			turn = !turn;
		}
	}

	public static void moveMineral(Boolean[][] visit, int num) {
		int maxY = sero + 1;
		int moveY = 0;
		
		for(int x=1; x<=garo; x++) {
			for(int y =1; y<=sero; y++) {
				if(!visit[y][x])
					continue;
				if(arr[y][x] == 1) {
					maxY = Math.max(maxY, y);
					break;
				}
				moveY = y;
				
			}
		}
	}
	public static void checkCluster(INFO lo) {
		for(int i = 0; i<4; i++) {
			boolean flg = false;
			boolean[][] visit = new boolean[sero][garo];
			
			Queue<INFO> q = new LinkedList<INFO>();
			q.add(new INFO(lo.y, lo.x));
			
			while(!q.isEmpty()) {
				INFO now = q.poll();
				
				if(now.y == 1)
					flg = true;
				for(int dir = 0; dir < 4; dir ++) {
					INFO next = new INFO();
					next.y = now.y + Y[dir];
					next.x = now.x + X[dir];
					
					if(next.y <= 0 || next.x <= 0 || next.y >sero || next.x >garo)
						continue;
					if(arr[next.y][next.x] == 0)
						continue;
					if(visit[next.y][next.x] )
						continue;
					
					visit[next.y][next.x] =true;
					q.add(next);
				}
			}
			
		}
	}
	public static INFO breakMineral(int dir, int y) {
		INFO lo = new INFO(0, 0);
		int x = 0;
		while (true) {
			x += X[dir];
			if (x <= 0 || x > garo)
				return lo;
			if (arr[y][x] == 1) {
				arr[y][x] = 0;
				lo.y = y;
				lo.x = x;
				break;
			}
		}

		return lo;
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
