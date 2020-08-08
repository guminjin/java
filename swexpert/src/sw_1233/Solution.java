package sw_1233;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t<= 10; t++) {
			int n = sc.nextInt(); 
			sc.nextLine();

			boolean flg = true;
			for(int i = 1; i<=n; i++) {
				String s = sc.nextLine();
				String str[] = s.split(" ");
				
				String ch = str[1];
				if(i<=n/2) {
					if(ch.equalsIgnoreCase("+") ||ch.equalsIgnoreCase("-") || ch.equalsIgnoreCase("*") || ch.equalsIgnoreCase("/")) {
						continue;
					}
					else
						flg = false;
				} else {
					if(ch.equalsIgnoreCase("+") ||ch.equalsIgnoreCase("-") || ch.equalsIgnoreCase("*") || ch.equalsIgnoreCase("/")) {
						flg = false;
					}
				}
			}
			if(flg)
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
			
		}
	}

}
