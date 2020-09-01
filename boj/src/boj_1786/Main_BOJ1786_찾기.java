package boj_1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ1786_찾기 {
	public static String str, pattern;
	public static ArrayList<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		str = in.readLine();
		pattern = in.readLine();
		result = new ArrayList<Integer>();

		kmp();

		System.out.println(result.size());
		for (Integer p : result)
			System.out.println(p + 1);
	}

	public static void kmp() {
		int[] pi = getPi();
		for(int i = 0 ; i < pi.length; i++){
			System.out.print(pi[i]);
		}		
		System.out.println();
		
		int n = str.length();
		int m = pattern.length();
		int j = 0;

		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();

		for (int i = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j])
				j = pi[j - 1];
			if (s[i] == p[j]) {
				if (j == m - 1) {
					result.add(i - m + 1);
					j = pi[j];
				} else
					j++;
			}
		}
	}

	private static int[] getPi() {
		int m = pattern.length();
		int j = 0;

		char[] p = new char[m];
		int[] pi = new int[m];

		p = pattern.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j])
				j = pi[j - 1];
			if (p[i] == p[j])
				pi[i] = ++j;
		}
		return pi;
	}

}
