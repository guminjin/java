package sw_4366;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_SW4366_정식이의은행업무 {
	public static char[] num1, num2;
	public static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			String s1 = in.readLine();
			String s2 = in.readLine();

			num1 = new char[s1.length()];
			num2 = new char[s2.length()];
			result = 0;

			num1 = s1.toCharArray();
			num2 = s2.toCharArray();

			Set<Long> set = new HashSet<Long>();

			for (int i = 0; i < s1.length(); i++) {
				num1[i] = num1[i] == '0' ? '1' : '0';
				set.add(toTen(num1, 2));
				num1[i] = num1[i] == '0' ? '1' : '0';
			}

			loop: for (int i = 0; i < s2.length(); i++) {
				for (int j = 0; j < 3; j++) {
					if (num2[i] - '0' == j)
						continue;

					char temp = num2[i];

					num2[i] = (char) (j + '0');

					long sum = toTen(num2, 3);
					if (set.contains(sum)) {
						result = sum;
						break loop;
					}
					num2[i] = temp;

				}
			}

			System.out.println("#" + t + " " + result);
		}

	}

	private static Long toTen(char[] num, int k) {
		long sum = 0;
		for (int i = 0, j = num.length - 1; i < num.length; i++, j--)
			sum += (num[i] - '0') * Math.pow(k, j);
		return sum;
	}

}
