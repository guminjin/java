package sw_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int len;
	static int start;
	static ArrayList<Integer>[] arr = new ArrayList[101];
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t<10; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			for(int i = 0; i<101; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			visit = new boolean [101];
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i<len / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a].add(b);
			}
			System.out.println("#" + t + " " + bfs());
		}
		
		
	}
	public static int bfs() {
		Queue<INFO> q = new LinkedList<INFO>();
		q.add(new INFO(start, 0));
		visit[start] = true;
		int mx = 0;
		int mxCnt = 0;
		while(!q.isEmpty()) {
			INFO now = q.poll();
			
			if(now.cnt > mxCnt) {
				mx =now.p;
				mxCnt = now.cnt;
			} else if (now.cnt == mxCnt) {
				if(mx < now.p)
					mx = now.p;
			}
			
			ArrayList<Integer> next = arr[now.p];
			for(int i = 0; i<next.size(); i++) {
				if(visit[next.get(i)]) 
					continue;
				
				visit[next.get(i)] = true;
				q.add(new INFO(next.get(i), now.cnt+1));
			}
		}
		return mx;
	}
	
	static class INFO {
		int p;
		int cnt;
		
		public INFO() {
		}

		public INFO(int p, int cnt) {
			this.p = p;
			this.cnt = cnt;
		}
		
	}

}
