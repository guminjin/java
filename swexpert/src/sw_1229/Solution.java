package sw_1229;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();

			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}

			int cmd = sc.nextInt();
			for (int i = 0; i < cmd; i++) {
				String c = sc.next();
				int order = sc.nextInt();
				int count = sc.nextInt();
				switch(c) {
				case "I":
					for (int j = 0; j < count; j++) {
						int add = sc.nextInt();
						list.add(order + j, add);
					}
					break;
				case "D":
					for (int j = 0; j < count; j++) {
						list.remove(order);
					}
					break;
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i<10; i++) 
				System.out.print(list.poll() + " ");
			
			System.out.println();
		}
	}

}

