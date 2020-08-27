package boj_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ1074_Z {
	static int n;
	static int r;
	static int c;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int y = (int) Math.pow(2, n - 1);
		int x = (int) Math.pow(2, n - 1);

		for(int i = n - 1;i >= 0; i--) {
			int range = (int) Math.pow(2, i - 1);
			int sum = (int) Math.pow(4, i);
			
			if (r < y && c < x) {
				x -= range;
				y -= range;
			} else if (r < y && x <= c) {
				x += range;
				y -= range;
				result += sum;
			} else if (y <= r && c < x) {
				x -= range;
				y += range;
				result += sum * 2;
			} else {
				x += range;
				y += range;
				result += sum * 3;
			}
		}
		
		System.out.println(result);

	}

}
