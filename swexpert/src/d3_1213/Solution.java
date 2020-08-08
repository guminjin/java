package d3_1213;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String find = sc.next();
			String s = sc.next();

			String[] arr = s.split(find);
			int result = arr.length - 1;

			boolean flg = true;
			for (int i = s.length() - find.length(), j = 0; i < s.length(); i++, j++) {
				if (s.charAt(i) != find.charAt(j)) {
					flg = false;
					break;
				}
			}
			if (flg)
				result++;
			System.out.println("#" + t + " " + result);
		}
	}

}
