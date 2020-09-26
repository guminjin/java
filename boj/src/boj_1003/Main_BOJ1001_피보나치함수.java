package boj_1003;

import java.util.Scanner;

public class Main_BOJ1001_피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		int[] zero = new int[41];
		int[] one = new int[41];
		
		zero[0] = 1; zero[1] = 0;
		one[0] = 0; one[1] = 1;
		
		for(int t = 0; t<tc; t++) {
			int n = sc.nextInt();
			
			for(int i = 2; i<=n; i++) {
				zero[i] = zero[i-1] + zero[i-2];
				one[i] = one[i-1] + one[i-2];
			}
			
			System.out.println(zero[n] + " " + one[n]);
		}
	}

}
