package boj_10815;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<n; i++) 
			set.add(sc.nextInt());
		
		m = sc.nextInt();
		for(int i = 0; i<m; i++) {
			int num = sc.nextInt();
			if(set.contains(num))
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		
	}

}
