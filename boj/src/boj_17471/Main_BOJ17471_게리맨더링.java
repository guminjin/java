package boj_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ17471_게리맨더링 {
	public static final int INF = Integer.MAX_VALUE;
	
	public static int n;	// 지역의 개수
	public static int[] city;	// 지역의 인구수
	public static boolean[][] arr;	// 연결된 지역
	public static boolean[] visit;	// 방문체크
		
	public static int result;	// 결과
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 크기 입력
		n= Integer.parseInt(in.readLine());
		
		// 초기화
		city = new int[n+1];
		arr = new boolean[n+1][n+1];
		visit = new boolean[n+1];
		result = INF;
		
		// 각 구역의 인구 입력
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=n; i++) 
			city[i] = Integer.parseInt(st.nextToken());
		
		// 연결된 지역 입력
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j= 0; j<cnt; j++) {
				int c = Integer.parseInt(st.nextToken());
				arr[i][c] = true;
			}
		}
		
		dfs(1, 0);
		
		// 두개의 선거구로 나눌 수 없다.
		if(result == INF)
			result = -1;
		System.out.println(result);
	}
	
	// 두개의 선거구로 나눈 지역들의 인구수의 차이를 계산
	public static int peapleDiff() {
		int t = 0;
		int f = 0;
		for(int i = 1; i<=n; i++) {
			if(visit[i])
				t += city[i];
			else
				f+= city[i];
		}
		
		return Math.abs(t-f);
	}
	
	// 나누어진 지역들이 서로 연결되어 있는지 확인
	public static boolean checkConnection(ArrayList<Integer> a, boolean flg) {
		boolean[] ch = new boolean[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a.get(0));
		ch[a.get(0)]= true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i<=n; i++) {
				if(!arr[now][i] || visit[i] != flg || ch[i])
					continue;
				
				ch[i] = true;
				q.add(i);
				cnt++;
			}
		}
		
		// 나누어진 지역과 연결된 지역의 수가 같다면 해당 지역구는 연결되어있다.
		if(a.size() == cnt)
			return true;
		else
			return false;
	}
	
	// 선택한 도시들이 두개로 나누어 질 수 있는지 확인
	public static boolean checkDivision() {
		ArrayList<Integer> a = new ArrayList<Integer>();	// true 지역
		ArrayList<Integer> b = new ArrayList<Integer>();	// false 지역
		
		// 각각의 지역들을 나눈다.
		for(int i = 1; i<=n; i++) {
			if(visit[i])
				a.add(i);
			else
				b.add(i);
		}
		
		// 어느 구역이라도 연결되어있지않으면 두개의 구역으로 나눌 수 없다.
		if(checkConnection(a, true) && checkConnection(b, false))
			return true;
		else 
			return false;
	}
	
	// 모든 지역을 선택하면서 탐색
	public static void dfs(int idx, int cnt) {
		if(cnt > 0) {
			if(checkDivision()) {
				result = Math.min(peapleDiff(), result);
			}
		}
		for(int i = idx ;i<n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			dfs(i + 1, cnt + 1);
			visit[i] = false;
		}
	}
}
