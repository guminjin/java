package boj_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ1931_회의실배정 {
	static int n;
	static INFO[] time;
	static int result = 0;
	static Boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		time = new INFO[n];
		visit = new Boolean[n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			time[i] = new INFO();
			time[i].start = Integer.parseInt(st.nextToken());
			time[i].end = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		
		int result = 0;
		int end = -1;
		for(int i = 0; i<n; i++) {
			if(time[i].start < end)
				continue;
			
			end = time[i].end;
			result++;
		}
		
		System.out.println(result);
	}
	
	static class INFO implements Comparable<INFO> {
		int start, end;

		public INFO() {
		}

		public INFO(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(INFO o) {
			if(this.end ==  o.end)
				return this.start - o.start;
			else
				return this.end - o.end;
		}
		
	
	}
}
