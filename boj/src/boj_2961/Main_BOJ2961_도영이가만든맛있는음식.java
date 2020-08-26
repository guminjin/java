package boj_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ2961_도영이가만든맛있는음식 {
	static int n;
	static INFO[] taste;
	static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		taste = new INFO[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			taste[i] = new INFO();
			taste[i].ss = Integer.parseInt(st.nextToken());
			taste[i].bb = Integer.parseInt(st.nextToken());
		}
		result = (1 << 31) - 1;
		dfs(0, 1, 0, 0);
		
		System.out.println(result);
	}
	
	
	
	public static void dfs(int now, long mul, long sum, int cnt) {
		if(cnt > 0) {
			long abs = Math.abs(sum - mul);
			if(abs <result)
				result = abs;
		}
		for(int i = now; i<n; i++) {
			dfs(i+1, mul * taste[i].ss, sum + taste[i].bb, cnt + 1);
			
		}
		
		
	}
	static class INFO {
		long ss, bb;

		public INFO() {
		}

		public INFO(long ss, long bb) {
			this.ss = ss;
			this.bb = bb;
		}
		
	}
}
