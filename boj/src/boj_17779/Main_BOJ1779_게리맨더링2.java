package boj_17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ1779_게리맨더링2 {
	public static final int MAX = Integer.MAX_VALUE;
	
	public static int n;
	public static int[][] arr;
	
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		for(int y =0; y<n; y++) {
			st = new StringTokenizer(in.readLine());
			for(int x = 0; x<n ;x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
