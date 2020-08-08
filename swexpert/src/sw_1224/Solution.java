package sw_1224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			int len = Integer.parseInt(in.readLine());
			String s = in.readLine();
			
			// 후위식
			Stack<Character> oper =  new Stack<Character>();
			StringBuilder prefix = new StringBuilder();
			
			int cnt = 0;
			for(int i = 0; i<len; i++) {
				char now = s.charAt(i);
				if(now - '0' >= 0 && now -'0' <=9)
					prefix.append(now);
				else {
					switch(now) {
					case '+':
						if(oper.isEmpty())
							oper.add(now);
						else if(cnt != 0) {
							char ch = oper.peek();
							if(ch != '(')
								prefix.append(oper.pop());

							oper.add(now);
						} else {
							while(!oper.isEmpty()) {
								prefix.append(oper.pop());
							}
							oper.add(now);
						}
						break;
					case ')':
						cnt--;
						while(!oper.isEmpty()) {
							char ch = oper.pop();
							if(ch == '(')
								break;
							prefix.append(ch);
						}
						break;
					case '(':
						cnt++;
					default:
						oper.add(now);
						break;
					}
				}
			}
			while(!oper.isEmpty()) {
				prefix.append(oper.pop());
			}
			
			System.out.println(prefix.toString());
			// 계산
			Stack<Integer> number = new Stack<Integer>();
			for(int i = 0; i<prefix.length(); i++) {
				char now = prefix.charAt(i);
				if(now - '0' >= 0 && now -'0' <=9)
					number.add(now - '0');
				else {
					int num1 = number.pop();
					int num2 = number.pop();
					
					if(now == '*') 
						number.add(num1*num2);
					else
						number.add(num1+num2);
				}
			}
			System.out.println("#" + t+ " " + number.pop());
			
			
		}
	}

}
