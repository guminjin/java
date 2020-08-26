import java.util.Scanner;
 
public class Permutation {
 
	private static int n, r;
	private static int[] arr;
	private static boolean[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		r = sc.nextInt();
		arr = new int[r];
		select = new boolean[n + 1];

		permutation(0);
	}

	private static void permutation(int cnt) {
		if (cnt == r) {
			for(int i = 0; i<r; i++) {
				System.out.println(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
			select[i] = true;

			permutation(cnt + 1);
			select[i] = false;
		}
	}
}
