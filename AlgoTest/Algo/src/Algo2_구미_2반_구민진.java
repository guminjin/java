import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_구미_2반_구민진 {
	public static int m, n; // 반의 개수, 학생의 수
	public static int[][] student; // 각 반의 학생의 성적을 저장할 배열
	public static int[][] compare; // 각 반의 성적을 비교
	public static int result; // 결과

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(in.readLine()); // 입력을 위한 StringTokenizer

		m = Integer.parseInt(st.nextToken()); // 반의 개수 입력
		n = Integer.parseInt(st.nextToken()); // 학생의 수 입력

		student = new int[m][n]; // 배열 할당
		result = 0; // 결과 초기화

		// 각 반의 학생들의 점수를 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 반의 학생들끼리 점수를 비교하기위한 배열의 크기 찾기
		// n명의 학생이 서로 점수를 비교한다면
		// (n-1) + (n-2) + ... + 1개의 배열이 필요
		int size = 0;
		for (int i = 1; i < n; i++)
			size += i;

		// 비교한 성적을 저장하기 위한 배열 할당
		compare = new int[m][size];

		// 각 반의 학생들의 성적을 비교
		diff();

		// 모든 반들을 서로 비교하며 실력이 비슷한 반을 찾는다
		for (int i = 0; i < m - 1; i++) {
			for (int j = i + 1; j < m; j++) {
				boolean flg = true;

				// 두개의 반의 같은 위치에 있는 두명의 성적을 비교
				for (int k = 0; k < size; k++) {
					// 같으면 continue
					if (compare[i][k] == compare[j][k])
						continue;

					// 다르다면 두개의 반은 실력이 비슷하지 않다.
					// 반복문 종료
					flg = false;
					break;
				}

				// flg가 true일때 두반의 성적이 비슷하다.
				if (flg)
					result++;
			}
		}

		// 결과 출력
		System.out.println(result);
	}

	// 각 반의 학생들의 성적을 비교
	public static void diff() {
		// m개의 반 모두 비교
		for (int k = 0; k < m; k++) {
			int idx = 0;
			// 반의 모든 학생들과 성적을 비교
			// m반의 i번째 학생과 (i+1)~(n-1)번째의 학생들의 점수를 모두 비교
			for (int i = 0; i < n - 1; i++) {
				int first = student[k][i];	// m반의 i번째 학생
				for (int j = i + 1; j < n; j++) {
					int second = student[k][j];	// m반의 j번째 학생

					// first가 크면 1, 작으면 -1, 같으면 0을 저장
					// 저장 후 다음 비교 값을 저장하기 위해 idx++
					if (first > second)
						compare[k][idx++] = 1;
					else if (first == second)
						compare[k][idx++] = 0;
					else
						compare[k][idx++] = -1;
				}
			}
		}
	}
}
