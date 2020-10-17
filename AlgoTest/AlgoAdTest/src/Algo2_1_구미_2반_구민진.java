import java.util.Scanner;

public class Algo2_1_구미_2반_구민진 {

	public static int[] villige; // 마을
	public static int v, p; // 마을의 수, 경찰서의 수
	public static int result; // 결과

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt(); // 테스트케이스 입력
		for (int t = 1; t <= tc; t++) {

			// 마을의 수과, 경찰서의 수 입력
			v = sc.nextInt();
			p = sc.nextInt();

			// 결과값, 마을 초기화
			result = 0;
			villige = new int[v + 1];
			for (int i = 1; i <= v; i++)
				villige[i] = i;

			// 조합 만들기
			int[] com = new int[p];
			combi(com, 1, 0);

			// 결과 출력
			System.out.println("#" + t + " " + result);

		}
	}

	// 조합 만들기
	public static void combi(int[] com, int idx, int t) {
		// p개의 경찰서의 위치를 골랐을 경우 result 증가
		if (com.length == t) {
			result++;
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
