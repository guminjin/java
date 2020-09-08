import java.util.Arrays;
import java.util.Scanner;

public class MorningCoding3 {
	public static int n,k;
	public static char[] arr;
	public static boolean[] visit;
	public static char[] print;
	public static int result;
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new char[n];
		visit = new boolean[n];
		print = new char[k];
		
		result = 0;
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.next().charAt(0); 
		}
		
		dfs(0);
		System.out.println(result);
	}
	private static void dfs(int cnt) {
		if(cnt == k) {
			result++;
			System.out.println(Arrays.toString(print));
			return;
		}
		
		for(int i=0; i<n; ++i) {
			if(visit[i]) 
				continue;
			visit[cnt] = true;
			print[cnt] = arr[i];
			dfs(cnt+1);
			visit[cnt] = false;
		}
	}

}
