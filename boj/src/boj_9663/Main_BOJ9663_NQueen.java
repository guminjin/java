package boj_9663;

import java.util.Scanner;

public class Main_BOJ9663_NQueen {
	public static int n;
	public static int[] num;
	public static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		num = new int[n];
		result = 0;
		
		dfs(0);
	
		System.out.println(result);
	}
	
	public static void dfs(int y) {
		if(y == n) {
			result++;
			return;
		}
		for(int i = 0; i<n ;i++) {
			num[y] = i;
			if(check(y))
				dfs(y + 1);
		}
	}

	private static boolean check(int y) {
		for(int i = 0; i < y; i++) {
			if(num[i] == num[y])
				return false;
			if((y-i) == Math.abs(num[i] - num[y]))
				return false;
		}
		return true;
	}

}
