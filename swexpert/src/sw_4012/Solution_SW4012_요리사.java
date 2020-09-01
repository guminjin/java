package sw_4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW4012_요리사 {
	public static final int INF = Integer.MAX_VALUE; 
	
	public static int n;		// 식재료 개수
	public static int[][] arr;	// 식재료의 시너지
	public static boolean[] visit;	// 식재료 방문
	
	public static int result;	// 결과
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());	// 테스트케이스입력
		for(int t = 1; t<=tc; t++) {
			n = Integer.parseInt(in.readLine());	// 식재료 개수 입력
			
			// 배열 초기화
			arr = new int [n][n];		
			visit = new boolean[n];
			
			// 식재료의 시너지 입력
			for(int y = 0; y<n ;y++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int x = 0; x<n; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = INF;
			dfs(0, 0);
			
			System.out.println("#" +  t + " " + result);
		}
	}
	
	// 각 음식의 맛 구하기
	public static int taste(boolean flg) {
		int t = 0;
		for(int i = 0 ;i<n; i++) {
			if(visit[i] != flg)
				continue;
			
			for(int j = i; j<n; j++) {
				if(i==j || visit[j] != flg)
					continue;
				t += (arr[i][j] + arr[j][i]);
			}
		}
		return t;
	}
	public static void dfs(int start, int cnt) {
		// 두 명의 식재료가 모두 선택
		if(cnt == n/2) {
			int dif = Math.abs(taste(true) - taste(false));
			result = Math.min(result, dif);
			return;
		}
		for(int i = start; i<n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			dfs(i + 1, cnt + 1);
			visit[i] = false;
		}
	}

}
