package d3_1208;

import java.util.Scanner;

public class Solution {

	final static int INF = 987654321;
	static int[] arr = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t<=10; t++) {
			int n = sc.nextInt();
			
			for(int i = 0; i<100;i++) {
				arr[i] = sc.nextInt();
			}

			while(n>0) {
				
				int[] temp = calMinMax();
				
				if(arr[temp[0]] == arr[temp[1]])
					break;
				
				arr[temp[0]]++;
				arr[temp[1]]--;
				n--;
			}
			
			int[] temp = calMinMax();
			int result = arr[temp[1]] - arr[temp[0]];
			System.out.println("#" + t+" " + result);
		}
	}
	
	static public int[] calMinMax () {
		int[] t = new int[2];
		
		int mx = 0;
		int mn = INF;
		t[1] = 0;
		t[0] = 0;
		
		for(int i = 0; i<100; i++) {
			if(mx <arr[i]) {
				mx=arr[i];
				t[1] = i;
			}
			if(mn > arr[i]) {
				mn=arr[i];
				t[0] = i;
			}
		}
		
		return t;
	}

}
