 package pratice;

public class WS_20200922_1 {
	public static int[] fibo;
	public static void main(String[] args) {
		fibo = new int[9];
		fibo[1] = 2;
		fibo[2] = 3;
		for(int i = 3; i<9; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[8]);
	}
}
