package boj_15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ15961_회전초밥 {
	public static int n, d, k, c;	// 접시수, 초밥종류, 연속으로 먹을 수, 쿠폰
	public static int[] arr;		// 초밥의 종류
	public static int[] eat;		// 먹은 초밥

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[n + k - 1];
		eat = new int[d + 1];

		// 회전초밥 입력
		for (int x = 0; x < n; x++) {
			arr[x] = Integer.parseInt(in.readLine());
		}
		
		// 먹은 초밥의 종류 체크
		int result = 1;	
		eat[c]++;
		for (int x = 0; x < k; x++) {
			if(eat[arr[x]] == 0)
				result++;
			eat[arr[x]]++;
		}
	
		
		int sum = result;
		for (int i = k; i < n + k; i++) {
			if (--eat[arr[i - k]] == 0)
				sum--;
			
			if (eat[arr[i%n]]++ == 0)
				sum++;

			result = Math.max(result, sum);
		}

		System.out.println(result);
	}
}

