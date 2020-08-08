package d4_1218;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int n;
	static String s;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t<=10; t++) {
			n = sc.nextInt();
			s = sc.next();
			
			Stack<Character> st = new Stack<Character>();
			boolean flg = true;
			for(int i = 0; i<n; i++) {
				char c = s.charAt(i);
				if(c == '(' || c == '{' || c == '<' || c == '[')
					st.push(c);
				else {
					char top = st.peek(); st.pop();
					
					switch(top) {
					case '(':
						if(c != ')')
							flg = false;
						break;
					case '{':
						if(c != '}')
							flg = false;
						break;
					case '<':
						if(c != '>')
							flg = false;
						break;
					case '[':
						if(c != ']')
							flg = false;
						break;
					}
					
					if(!flg)
						break;
				}
			}
			if(flg)
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
			
		}
	}

}
