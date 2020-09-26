package sw_4613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW4613_러시아국기같은깃발 {

	public static int garo, sero;
	public static int[][] map;
	public static int[][] check;
	public static int[] select;
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int t = 1; t<=tc; t++) {
			st = new StringTokenizer(in.readLine());
			sero = Integer.parseInt(st.nextToken());
			garo = Integer.parseInt(st.nextToken());
			
			map = new int[sero][garo];
			check = new int[sero][3];
			select = new int[3];
			result = Integer.MAX_VALUE;
			
			for(int y = 0; y<sero; y++) {
				String s = in.readLine();
				for(int x= 0; x<garo; x++) {
					if('W'==s.charAt(x))
						map[y][x] = 0;
					else if('B'==s.charAt(x))
						map[y][x] = 1;
					else
						map[y][x] = 2;
				}
				for(int x = 0; x<garo; x++) {
					int now = map[y][x];
					check[y][now]++;
				}
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " "+ result);
		}
		
	}
	public static void dfs(int start, int cnt) {
		if(cnt == 3) {
			cal();
			return;
		}
		for(int i = start; i<sero; i++) {
			select[cnt] = i;
			dfs(i + 1, cnt + 1);
		}
	}
	public static void cal() {
		int cnt = 0;
		int start = 0; 
		int end = 0;
		for(int i = 0; i<3; i++) {
			start = end;
			if(i == 2)
				end = sero;
			else 
				end = select[i + 1];
			
			for(int j = start; j<end; j++) {
				cnt += (garo - check[j][i]);
			}
		}
		result = Math.min(result,  cnt);
	}

}
