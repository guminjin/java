package boj_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ1753_최단경로 {
	public static final int INF = Integer.MAX_VALUE;
	
	public static int pointCnt, lineCnt; // 정점과 간선의 개수
	public static int start;	// 시작 지점
	public static ArrayList<ArrayList<INFO>> list;	// 연결된 점을 저장
	
	public static int[] result; // 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 입력
		pointCnt = Integer.parseInt(st.nextToken());
		lineCnt = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(in.readLine());
		
		// 2차원 arraylist생성
		list = new ArrayList<ArrayList<INFO>>(pointCnt + 1);
		for(int i = 0; i<=pointCnt; i++)
			list.add(new ArrayList<INFO>());
		
		// 결과 배열 할당 및 초기화
		result = new int[pointCnt + 1];
		for(int i= 1; i<=pointCnt; i++) 
			result[i] = INF;
		result[start] = 0;
		
		// 연결된 간선 입력, 시작지점은  q에 삽입
		// 가중치가 오름차순이 되도록 정렬
		PriorityQueue<INFO> q= new PriorityQueue<INFO>();
		for(int i = 0; i<lineCnt; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(x).add(new INFO(y,w));
			if(x == start)
				q.add(new INFO(y,w));
		}
		
		// 시작지점에서 갈 수 있는 모든 정점 방문 확인
		while(!q.isEmpty()) {
			INFO now  = q.poll();
			
			// 방문한 정점이 이미 최솟값을 가지고 있다면 더 이상 확인할 필요가 없다.
			if(now.w >= result[now.p])
				continue;
			
			// 해당 정점까지 도달하는 경로값을 저장
			result[now.p] = now.w;

			// now.p와 연결된 모든 정점을 확인
			ArrayList<INFO> l = list.get(now.p);
			for(int i = 0; i<l.size(); i++) {
				q.add(new INFO(l.get(i).p, l.get(i).w + now.w));
			}
		}
		
		// 결과 출력
		for(int i = 1; i<= pointCnt; i++) {
			if(result[i] == INF)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}
			
	}
	

	static class INFO implements Comparable<INFO> {
		int p;
		int w;
		
		public INFO() {
		}
		public INFO(int p, int w) {
			this.p = p;
			this.w = w;
		}
		@Override
		public int compareTo(INFO o) {
			return this.w - o.w;
		}
		
		
	}
 
}
