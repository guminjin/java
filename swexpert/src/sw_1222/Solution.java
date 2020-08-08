package sw_1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t<=10; t++) {
			int len = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), "+");
			
			int result = 0;
			for(int i = 0; i<len/2 + 1; i++) {
				result += Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
