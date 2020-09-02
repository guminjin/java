import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MorningCoding2_구민진 {
	public static int n;
	public static int[] arr;
	public static boolean[] visit;
	
	public static int[] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		
		arr = new int[n];
		visit = new boolean[n];
		result = new int[n];

		st = new StringTokenizer(in.readLine());
		for(int i = 0 ;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 0);
	}
	public static void dfs(int start, int sum, int idx) {
		if(sum == 10) {
			for(int i = 0; i<idx; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
		for(int i = start; i<n; i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			result[idx] = arr[i];
			dfs(i + 1, sum + arr[i], idx+1);
			visit[i] = false;
		}
	}

}
