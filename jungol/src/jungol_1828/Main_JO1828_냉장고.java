package jungol_1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO1828_≥√¿Â∞Ì {
	static int n;
	static INFO[] item;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		item = new INFO[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			item[i] = new INFO(s, e);
		}

		Arrays.sort(item);
		int end = item[0].e;
		int result = 1;

		for (int i = 1; i < n; i++) {
			if (item[i].s <= end)
				continue;

			result++;
			end = item[i].e;
		}

		System.out.println(result);
	}

	static class INFO implements Comparable<INFO> {
		int s, e;

		public INFO() {
		}

		public INFO(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(INFO o) {
			return this.e - o.e;
			
		}
	}
}
