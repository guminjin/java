package boj_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ16933_벽부수고이동하기3 {
	public static int garo, sero, k;	// 가로, 세로, 부술 수 있는 벽의 개수
	public static int[][] arr;			// 맵
	public static boolean[][][][] visit;	// 벽을 부순 개수에 따른 방문처리, [낮/밤][벽][가로][세로]
	
	public static int[] Y = {-1, 1, 0, 0};	// 상하좌우 이동 y
	public static int[] X = {0, 0, -1, 1};	// 상하좌우 이동 x
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 가로, 세로, 부술 수 있는 벽의 개수 입력
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 배열 초기화
		arr = new int[sero][garo];
		visit = new boolean[2][k + 1][sero][garo];
		
		// 맵 입력
		for(int y = 0; y<sero; y++) {
			String s = in.readLine();
			for(int x = 0; x<garo; x++) {
				arr[y][x] = (s.charAt(x) - '0');
			}
		}
		
		// 결과 출력
		System.out.println(bfs());
	}
	
	// 탐색
	public static int bfs() {
		Queue<INFO> q = new LinkedList<INFO>();
		q.add(new INFO(0, 0, 1, 0, 1));
		
		// 시작위치 true
		visit[1][0][0][0] = true;
		visit[0][0][0][0] = true;

		while(!q.isEmpty()) {
			INFO now = q.poll();
			
			// 도착지면 거리 리턴
			if(now.y == sero-1&& now.x == garo-1)
				return now.len;
			
			// 상하좌우
			for(int i = 0; i<4; i++) {
				INFO next = new INFO();
				next.y = now.y + Y[i];
				next.x = now.x + X[i];
				next.len= now.len + 1;
				next.cnt = now.cnt;
				next.time = (now.time + 1) % 2;	// 낮밤 변경
				
				// 범위확인
				if(next.y <0 || next.x <0|| next.y >=sero || next.x >=garo)
					continue;
				// 이동위치가 벽이라면
				if(arr[next.y][next.x] == 1) {
					// 낮, 밤 확인
					if(now.time == 1) {
						next.cnt++;	// 낮이라면 벽을 부순다
					} else {
						// 밤이라면 이동을 할 수 없기때문에 이전 위치로 돌아간다.
						next.y -= Y[i];
						next.x -= X[i];
					}
				}
				// 벽을 부순개수 확인
				if(next.cnt > k)
					continue;
				// 방문확인
				if(visit[next.time][next.cnt][next.y][next.x])
					continue;
				
				visit[next.time][next.cnt][next.y][next.x] = true;
				q.add(next);
			}
		}
		
		
		return -1;
	}
	
	static class INFO {
		int y, x;		// 현재위치
		int len;		// 이동거리
		int cnt;		// 부순 벽의 개수
		int time;	// 낮 : 1, 밤 : 0
		
		public INFO() {
		}
		public INFO(int y, int x, int len, int cnt, int time) {
			this.y = y;
			this.x = x;
			this.len = len;
			this.cnt = cnt;
			this.time = time;
		}
		
	}
}
