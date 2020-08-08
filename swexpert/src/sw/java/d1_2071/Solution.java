package sw.java.d1_2071;

import java.util.Scanner;

public class Solution {
	static final int MAX = 10;
	static int t = 0;
	static int[] arr = new int[MAX];
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		for(int tc = 1; tc<=t; tc++) {
			result = 0;
			
			for(int i = 0; i<MAX; i++) {
				arr[i] = sc.nextInt();
				
				if(arr[i] %2 == 0) {
					continue;
				}
				result += arr[i];
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
