import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Algo3_구미_2반_구민진 {
	public static final int INF = 100000000; // 최대 위치
	public static final int MIN = -10000000; // 최소 위치

	public static int chCnt, homeCnt; // 치킨집의 수, 집의 수
	public static Set<Integer> set; // 방문한 위치 저장

	public static int[] X = { -1, 1 }; // 좌우 확인

	public static int result; // 결과 저장(치킨지수)

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(in.readLine()); // 입력을 위한 StringTokenizer

		chCnt = Integer.parseInt(st.nextToken()); // 치킨집의 수 입력
		homeCnt = Integer.parseInt(st.nextToken()); // 집의 수 입력

		set = new HashSet<Integer>(); // 방문한 위치 저장을 위한 set 초기화
		result = 0; // 결과값 초기화
		Queue<INFO> q = new LinkedList<INFO>(); // 치킨집과 가장 가까운 집위치를 선택하기 위한 큐 

		st = new StringTokenizer(in.readLine()); // 입력

		// 치킨집의 위치 입력
		for (int i = 0; i < chCnt; i++) {
			int chLo = Integer.parseInt(st.nextToken());
			set.add(chLo); // 중복체크를 위해 set에 삽입
			q.add(new INFO(chLo, 0)); // 치킨집 주위에 집을 짓기 위해 치킨위치와 거리를 큐에 저장
		}

		int cnt = 0; // 집 지은 개수
		// 집이 다 지어지면 while문 break
		while (cnt < homeCnt) {
			// 현재 위치
			INFO now = q.poll();

			// 현재 위치에서 집을 지을 수 있는지 좌우를 확인
			for (int i = 0; i < 2; i++) {
				INFO next = new INFO();
				next.x = now.x + X[i]; // 이동한 위치
				next.cnt = now.cnt + 1; // 이동했을 때 가장 가까운 치킨 집과의 거리

				if (next.x < MIN || next.x > INF) // 범위 확인
					continue;
				if (set.contains(next.x)) // 이미 집이 지어졌거나, 치킨집이 있는 위치인지 확인
					continue;

				// 해당 위치에 집이 지어지지 않았고, 치킨집도 없다면
				set.add(next.x); // 집을 짓는다.
				q.add(next); // 다음 집을 짓기 위해 해당 위치를 큐에 저장
				result += next.cnt; // 집과 가장 가까운 치킨집과의 거리를 저장

				if (++cnt == homeCnt) // 집이 다 지어졌는지 확인
					break;
			}
		}

		// 결과 출력
		System.out.println(result);
	}

	// queue활용을 위한 INFO 클래스
	static class INFO {
		int x; // 현재위치
		int cnt; // 가장 가까운 치킨집과의 거리

		// 생성자
		public INFO() {
		}

		public INFO(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

	}
}
