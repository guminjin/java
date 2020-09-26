package boj_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int oper = Integer.parseInt(in.readLine());
		for (int i = 0; i < oper; i++) {
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int room = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				for(int j = 1; ; j++) {
					if(j*room > n)
						break;
					arr[j * room] = (arr[j * room] + 1) % 2;

				}
			} else {
				int now = room;
				int left = now;
				int right = now;

				while (true) {
					left--;
					right++;
					if (left > 0 && right <= n && arr[left] == arr[right])
						continue;

					for (int j = ++left; j < right; j++) {
						arr[j] = (arr[j] + 1) % 2;
					}
					break;
				}

			}
		}
		for(int i = 1; i<=n; i++) {
			System.out.print(arr[i]);
			if(i!=n)
				System.out.print(" ");
		}
		
	}

}
