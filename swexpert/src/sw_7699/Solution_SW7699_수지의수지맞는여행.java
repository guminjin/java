package sw_7699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW7699_수지의수지맞는여행 {
	public static int garo, sero;
	public static char[][] arr;
	public static boolean[] alpha;
	public static int result;
	
	public static int[] Y = { -1, 1, 0, 0 };
	public static int[] X = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t<=tc; t++) {
			st = new StringTokenizer(in.readLine());
			sero = Integer.parseInt(st.nextToken());
			garo = Integer.parseInt(st.nextToken());
			
			arr = new char[sero][garo];
			alpha = new boolean[26];
			
					for(int y = 0; y<sero; y++) {
				String s = in.readLine();
				for(int x = 0; x<garo; x++) {
					arr[y][x] = s.charAt(x);
				}
			}

			result = 0;
			
			alpha[(arr[0][0] - 'A')] = true;
			dfs(new INFO(0, 0), 1);

			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void dfs(INFO now, int cnt) {
		if(cnt >=26) {
			result = 26;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = now.y + Y[i];
			int nx = now.x + X[i];

			if (ny < 0 || nx < 0 || ny >= sero || nx >= garo || alpha[(arr[ny][nx] - 'A')] ){
				result = Math.max(result, cnt);
				continue;
			}
	
			alpha[(arr[ny][nx] - 'A')] = true;
			dfs(new INFO(ny, nx), cnt + 1);
			alpha[(arr[ny][nx] - 'A')] = false;
		}
	}
	static class INFO {
		int y, x;

		public INFO(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
