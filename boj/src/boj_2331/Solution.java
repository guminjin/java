package boj_2331;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int p = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		arr.add(num);
		m.put(num, 0);
		int idx = 1;
		while(true) {
			String s = String.valueOf(arr.get(idx-1));
			int sum = 0;
			
			for(int i = 0; i<s.length(); i++) {
				int n = s.charAt(i) - '0';
				sum += (int)Math.pow(n, p);
			}
			
			if(m.containsKey(sum) == true) {
				idx = m.get(sum);
				break;
			}
			m.put(sum, idx);
			arr.add(sum);
			idx++;
		}
		System.out.println(idx);
	}

}
