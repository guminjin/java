package boj_10816;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[] arr1 = new int[10000000+1];
		int[] arr2 = new int[10000000+1];

		for(int i = 0; i<n; i++) {
			int num = sc.nextInt();
			if(num < 0) {
				arr1[num * -1]++;
			} else
				arr2[num]++;
		}
		
		StringBuilder sb = new StringBuilder();
		m = sc.nextInt();
		for(int i = 0; i<m; i++) {
			int num = sc.nextInt();
			if(num <0) {
				num *= -1;
				sb.append(arr1[num] + " ");
			}
			else {
				sb.append(arr2[num] + " ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
