import java.util.Scanner;

public class MorningCoding {
	public static int n;			// 단어의 개수
	public static int k;			// 선택할 수 있는 단어의 개수
	public static String[] word;	// 단어 저장
	public static boolean[] visit;	// 단어 방문 처리
	public static String[] result;	// 선택된 단어 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		n = sc.nextInt();
		k = sc.nextInt();
		// 배열 초기화
		word = new String[n];
		result = new String[k];
		visit = new boolean[n];
		
		// 단어 입력
		for(int i = 0; i<n; i++) 
			word[i] = sc.next();
		//탐색
		dfs(0, 0);
	}
	
	public static void dfs(int start, int cnt) {
		// k개의 단어를 골랐으면 출력
		if(cnt == k) {
			for(int i = 0 ;i<k; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<n; i++) {
			// 방문확인
			if(visit[i])
				continue;
			
			visit[i] = true;		// 방문처리
			result[cnt] = word[i];	// cnt번째 뽑은 단어를 저장
			
			dfs(i + 1, cnt + 1);
			
			visit[i] = false;		//// 방문 취소
		}
	}
}
