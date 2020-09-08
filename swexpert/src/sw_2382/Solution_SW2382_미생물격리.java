package sw_2382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SW2382_미생물격리 {
	public static int n, m, k;
	public static int[][] map;
	public static ArrayList<INFO> bug;

	public static int[] Y = {-1, 1, 0, 0};
	public static int[] X = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스입력
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());

			// 맵의 크기, 시간, 미생물의 수
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			// 미생물 저장 배열 초기화
			bug = new ArrayList<INFO>();

			// 미생물 입력
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());

				int y, x, dir;
				long size;
				
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				size = Long.parseLong(st.nextToken());
				dir = Integer.parseInt(st.nextToken());

				// 0상, 1하, 2좌, 3우
				bug.add(new INFO(y, x, size, dir - 1, true));
			}

			// m시간 동안 이동
			for (int i = 0; i < m; i++) {
				// 미생물 이동
				moveBug();
				
				Collections.sort(bug);

				// 미생물 이동 위치 확인
				checkLocation();
				
				//print();
			}
			
			long result = 0;
			for(int i = 0; i<k; i++) {
				if(!bug.get(i).live)
					continue;
				
				result += bug.get(i).size;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void print() {
		for(int y = 0; y<n; y++) {
			for(int x = 0; x<n; x++)
				System.out.print(map[y][x] + " ");
			System.out.println();
		}
		System.out.println();
	}

	// 미생물이 현재 위치에 위치할 수 있는지 확인
	private static void checkLocation() {
		// 미생물 위치 저장
		map = new int[n][n];
		
		for(int i = 0; i<k; i++) {
			INFO now = bug.get(i);
			// 살아있을 때만 확인
			if(!bug.get(i).live)
				continue;
			
			// 해당 위치에 미생물의 존재유무
			if(map[now.y][now.x] == 0) {
				map[now.y][now.x]= i + 1; 
			} else {
				// 현재위치에 미생물이 존재한다면
				
				// 몇번째 미생물인지 확인
				int idx = map[now.y][now.x] - 1;
				
				// 미생물의 수를 비교 
				if(bug.get(idx).size > bug.get(i).size) {
					bug.get(i).live = false;
					bug.get(idx).size += bug.get(i).size;
				} else {
					bug.get(idx).live = false;
					bug.get(i).size += bug.get(idx).size;
					
					map[now.y][now.x] = i + 1;
				}
			}
		}
	}

	// 미생물 이동
	private static void moveBug() {
		for (int i = 0; i < k; i++) {
			INFO now = bug.get(i);
			
			// 살아있을 때만 이동
			if (!now.live)
				continue;

			// 이동
			now.y += Y[now.dir];
			now.x += X[now.dir];
			
			// 이동한 위치가 제일 가장 자리라면 이동방향 변경 후 미생물 수/2
			if (check(now)) {
				switch (now.dir) {
				case 0:
					now.dir = 1;
					break;
				case 1:
					now.dir = 0;
					break;
				case 2:
					now.dir = 3;
					break;
				case 3:
					now.dir = 2;
					break;
				}

				now.size /= 2;
			}

		}
	}

	// 현재 위치가 가장자리인지 확인
	private static boolean check(INFO next) {
		if (next.y == 0 || next.x == 0 || next.y == n - 1 || next.x == n - 1)
			return true;
		return false;
	}

	// 미생물 정보
	public static class INFO implements Comparable<INFO>{
		int y, x;
		long size;
		int dir;
		boolean live;

		public INFO() {
		}

		public INFO(int y, int x, long size, int dir, boolean live) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.dir = dir;
			this.live = live;
		}

		@Override
		public int compareTo(INFO o) {
			return (int) (o.size - this.size);
		}

	}

}
