import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class im대비_로봇이동 {

	public static int n;
	public static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			ArrayList<INFO> robot = new ArrayList<INFO>();

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					char temp = sc.next().charAt(0);
					if (temp == 'S')
						continue;
					else if (temp == 'W')
						map[y][x] = -1;
					else {
						map[y][x] = (temp - 'A') + 1;
						robot.add(new INFO(y, x));
					}
				}
			}

			int result = 0;
			for (int i = 0; i < robot.size(); i++) {
				INFO now = robot.get(i);
				int ro = map[robot.get(i).y][robot.get(i).x];

				INFO next = new INFO(now.y, now.x);
				switch (ro) {
				case 3:
					// 상
					while (true) {
						next.y -= 1;
						if (next.y < 0 || map[next.y][now.x] != 0)
							break;
						result++;
					}

					next.y = now.y;
					// 하
					while (true) {
						next.y += 1;
						if (next.y >= n || map[next.y][now.x] != 0)
							break;
						result++;
					}
				case 2:
					// 좌
					next.y = now.y;
					while (true) {
						next.x -= 1;
						if (next.x < 0 || map[now.y][next.x] != 0)
							break;
						result++;
					}
				case 1:
					// 우
					next.x = now.x;
					while (true) {
						next.x += 1;
						if (next.x >= n || map[now.y][next.x] != 0)
							break;
						result++;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	public static class INFO {
		int y, x;

		public INFO() {
		}

		public INFO(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
