package programers.level2;


public class Solution_멀쩡한사각형 {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static int gcd(int w, int h) {
		if(w%h == 0)
			return h;
		return gcd(h, w%h);
	}
	public static long solution(int w, int h) {
		int g = gcd(w, h);
		long total = (long)w *(long)h;
		return total - (g * ((w/g) + (h/g) - 1));
	}
}
