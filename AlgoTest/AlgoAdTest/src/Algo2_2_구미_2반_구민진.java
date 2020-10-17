import java.util.Scanner;

public class Algo2_2_구미_2반_구민진 {

	public static int[] villige; // 마을
	public static int v, p, l; // 마을의 수, 경찰서의 수, 둘레
	public static int result; // 결과

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt(); // 테스트케이스 입력
		for (int t = 1; t <= tc; t++) {

			// 마을의 수과, 경찰서의 수, 둘레 입력
			v = sc.nextInt();
			p = sc.nextInt();
			l = sc.nextInt();

			// 결과값, 마을 초기화
			result = 987654321;
			villige = new int[v];
			for (int i = 0; i < v; i++) {
				villige[i] = sc.nextInt();
			}

			// v=p이면 모든 집에 경찰서가 있다.
			if (v != p) {
				// 조합 만들기
				int[] com = new int[p];
				combi(com, 1, 0);

			} else
				result = 0;

			// 결과 출력
			System.out.println("#" + t + " " + result);

		}
	}

	// 조합 만들기
	public static void combi(int[] com, int idx, int t) {
		// p개의 경찰서의 위치를 골랐을 경우 result 증가
		if (com.length == t) {
			int now = 0; // 현재 조합일 경우 집과 경찰서와의 거리

			// 모든 집에 대한 경찰서와의 거리를 측정
			for (int i = 0; i < v; i++) {
				int len = 987654321;
				for (int j = 0; j < p; j++) {
					int ch = Math.min(Math.abs(villige[i] - com[j]), Math.abs(l - villige[i] - com[j]));
					len = Math.min(len, ch);
				}

				// 경찰서와 거리가 제일 가까운 거리를 더함
				now += len;
			}

			// 현재 조합의 거리값과 비교
			result = Math.min(result, now);
			return;
		}

		// 마을의 수의 범위를 벗어나면 리턴
		if (idx == villige.length) {
			return;
		}

		// 경찰서의 위치 선택
		com[t] = villige[idx];

		// 해당 위치 선택
		combi(com, idx + 1, t + 1);

		// 해당 위치 선택 안햇을 경우
		combi(com, idx + 1, t);

	}

}
