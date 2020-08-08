package sw_1228;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();

			LinkedList<String> list = new LinkedList<String>();
			for (int i = 0; i < n; i++) {
				String origin = sc.next();
				list.add(origin);
			}

			int cmd = sc.nextInt();
			for (int i = 0; i < cmd; i++) {
				char c = sc.next().charAt(0);
				int order = sc.nextInt();
				int count = sc.nextInt();
				for (int j = 0; j < count; j++) {
					String add = sc.next();
					list.add(order + j, add);
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i<10; i++) 
				System.out.println(list.poll() + " ");
			
			System.out.println();
		}
	}

}
