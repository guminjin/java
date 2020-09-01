package sw_3234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW3234_준환이의양팔저울 {
	static int n;			// 추의 개수
	static int[] weight;	// 추의 무게 저장 배열
	static boolean[] visit;	// 추의 방문 처리	
	
	static int result;		// 결과

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// testcase 입력
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(in.readLine());	// 추의 개수 입력
			
			// 초기화
			weight = new int[n];					
			visit = new boolean[n];
			result = 0;

			int sum = 0;	// 모든 추의 합
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}
			
			dfs(0, 0, sum, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	// 탐색
	public static void dfs(int left, int right, int remain, int cnt) {
		// 남은 추의 무게를 어느쪽에 더해도 left를 넘지 않을 경우
		if (left >= right + remain) {
			int sum = 1;
			
			for (int i = 0; i < n - cnt; i++)
				sum *= 2;
			for (int i = 1; i <= n - cnt; i++)
				sum *= i;
			result += sum;
			
			return;
		}
		// 모든 추를 올렸을 경우
		if (cnt == n) {
			result++;
			
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;

			visit[i] = true;

			// left
			dfs(left + weight[i], right, remain - weight[i], cnt + 1);

			// right의 무게가 left보다 작을 겨웅
			if (left >= right + weight[i])
				dfs(left, right + weight[i], remain - weight[i], cnt + 1);

			visit[i] = false;

		}
	}

}