import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_2반_구민진 {
	public static final int MAX = 10000; // 최대 거리
	public static int j1, j2; // 김싸피가 뛰는 거리 j1, 박싸피가 뛰는 거리 j2
	public static int h1, h2; // 김싸피의 집 위치 h1, 박싸피의 집의 위치 h2
	public static boolean[] lo; // 방문체크

	public static int result; // 결과값

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(in.readLine()); // 입력을 위한 StringTokenizer

		j1 = Integer.parseInt(st.nextToken()); // 김싸피의 뛰는 거리 입력
		j2 = Integer.parseInt(st.nextToken()); // 박싸피의 뛰는 거리 입력
		h1 = Integer.parseInt(st.nextToken()); // 김싸피의 집의 위치 입력
		h2 = Integer.parseInt(st.nextToken()); // 박싸피의 집의 위치 입력

		lo = new boolean[MAX + 1]; // 최대 거리 할당
		result = -1; // 결과값 초기화

		// 1. 김싸피가 이동할 수 있는 위치는 모두 true값으로 바꾼다.
		while (h1 <= MAX) {
			lo[h1] = true; // 뛴 위치 true 변경
			h1 += j1; // 다음 위치로 이동
		}

		// 2. 박싸피가 뛰면서 김싸피가 이동했는 곳을 만나는 지 확인
		while (h2 <= MAX) {
			// 해당 위치가 true면 김싸피가 이동했던 곳
			if (lo[h2]) {
				result = h2; // 해당 위치를 저장
				break; // 반복문 종료
			}

			h2 += j2; // 다음 위치로 이동
		}

		// 결과 출력
		System.out.println(result);

	}

}
