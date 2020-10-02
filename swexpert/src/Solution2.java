import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static final int MOD = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long fac[] = new long[n + 1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++)
				fac[i] = (fac[i - 1] * i) % MOD;

			long bottom = (fac[r] * fac[n - r]) % MOD;
			long reBottom = fermat(bottom, MOD - 2);

			long result = (fac[n] * reBottom) % MOD;
			System.out.println("#" + t + " " + result);

		}
	}

	public static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		
		long temp = fermat(n, x / 2);
		long result = (temp * temp) % MOD;
		if (x % 2 == 0)
			return result;
		else
			return (result * n) % MOD;
	}

}
