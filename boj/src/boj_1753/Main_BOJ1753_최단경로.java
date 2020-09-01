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
	
	public static int pointCnt;
	public static int lineCnt;
	public static int start;
	public static ArrayList<ArrayList<INFO>> list;
	
	public static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		pointCnt = Integer.parseInt(st.nextToken());
		lineCnt = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(in.readLine());
		
		list = new ArrayList<ArrayList<INFO>>(pointCnt + 1);
		for(int i = 0; i<=pointCnt; i++)
			list.add(new ArrayList<INFO>());
		
		result = new int[pointCnt + 1];
		for(int i= 1; i<=pointCnt; i++) 
			result[i] = INF;
		result[start] = 0;
		
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
		
		while(!q.isEmpty()) {
			INFO now  = q.poll();
			if(now.w >= result[now.p])
				continue;
			
			result[now.p] = now.w;

			ArrayList<INFO> l = list.get(now.p);
			for(int i = 0; i<l.size(); i++) {
				q.add(new INFO(l.get(i).p, l.get(i).w + now.w));
			}
		}
		
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
