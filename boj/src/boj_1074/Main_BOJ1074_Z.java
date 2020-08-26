package boj_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ1074_Z {
	static int n;
	static int r;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

	}
	
	public static void div(INFO start, INFO end) {
		INFO mid = new INFO();
		mid.x = (start.x + end.x) / 2;
		mid.y = (start.y + end.y) / 2;
		
		if(start.x <= r && r < mid.x)
			div(start, mid);
		else
			div(mid, end);
	}
	
	static class INFO {
		int y, x;

		public INFO() {
		}

		public INFO(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	
}
