import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int sero, garo;
	public static int[][] arr;
	public static int[] Y = {-1, 1, 0, 0};
	public static int[] X = {0, 0, -1, 1};
	
	public static int execute() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());

		arr = new int[sero][garo];

		for (int y = 0; y < sero; y++) {
			String temp = in.readLine();
			for (int x = 0; x < garo; x++) {
				char t = temp.charAt(x);
				if (t == 'L')
					arr[y][x] = 1;
			}
		}

		int result = 0;
		for(int y= 0; y<sero; y++) {
			for(int x = 0; x<garo; x++) {
				if(arr[y][x] == 0)
					continue;
				
				boolean[][] visit = new boolean[sero][garo];
				Queue<INFO> q= new LinkedList<INFO>();
				
				q.add(new INFO(y, x, 0));
				visit[y][x] = true;
				
				while(!q.isEmpty()) {
					INFO now = q.poll();
					
					for(int i = 0; i<4; i++) {
						INFO next = new INFO(now.y, now.x, now.len);
						next.y += Y[i];
						next.x += X[i];
						next.len ++;
						
						if(next.y <0 || next.x <0 || next.y >=sero || next.x >=garo)
							continue;
						if(visit[next.y][next.x] || arr[next.y][next.x] == 0)
							continue;
						
						q.add(next);
						visit[next.y][next.x] = true;
					}
					
					if(q.isEmpty())
						result = Math.max(result, now.len);
				}
			}
		}		
		// 구현하세요.

		return result; // 리턴값을 수정하세요
	} // end of execute
	
	public static class INFO {
		int y, x;
		int len;
		
		public INFO() {
		}

		public INFO(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
		
	}
	public static void print() {
		for (int y = 0; y < sero; y++) {
			for (int x = 0; x < garo; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}
} // end of class

/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
*/