import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class im대비_꽃나라반 {
	public static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			check = new int[10];

			String num = in.readLine();
			for (int i = 0; i < num.length(); i++) {
				int n = num.charAt(i) - '0';
				if (n == 6 || n == 9) {
					if (check[6] <= check[9])
						check[6]++;
					else
						check[9]++;
				} else {
					check[n]++;
				}
			}

			int result = 0;
			for (int i = 0; i < 10; i++) {
				result = Math.max(result, check[i]);
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
