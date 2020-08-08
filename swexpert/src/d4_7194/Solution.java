package d4_7194;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class INFO implements Comparable<INFO>{
		int num;
		int cnt;

		public INFO(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(INFO in) {
			if(num < in.num)
				return 1;
			else
				return -1;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int start = sc.nextInt();
			int goal = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			PriorityQueue<INFO> pq = new PriorityQueue<INFO>();
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

			pq.add(new INFO(start + a, 1));
			pq.add(new INFO(start * b, 1));
			
			
			int result = -1;
			
			while (!pq.isEmpty()) {
				INFO now = pq.poll();
				
				//System.out.println(now.num + ", "+ now.cnt);
				if (now.num > goal)
					continue;
				if (now.num == goal) {
					result = now.cnt;
					break;
				}

				pq.add(new INFO(now.num + a, now.cnt + 1));
				pq.add(new INFO(now.num * b, now.cnt + 1));
			}
			
			System.out.println("#" + t + " "+ result);
		}
	}
}
