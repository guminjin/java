package boj_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> idx = new Stack<Integer>();
		StringBuilder sb  = new StringBuilder();
		sb.append("");
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stringToken = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(stringToken.nextToken());
			while (true) {
				if (st.empty()) {
					sb.append("0 ");
					st.add(num);
					idx.add(i + 1);
					break;
				} else {
					int top = st.peek(); 
					if(num>=top) {
						st.pop();
						idx.pop();
						continue;
					} else {
						sb.append(idx.peek() + " ");

						st.add(num);
						idx.add(i + 1);
						break;
					}	
				}
			}
		}
		System.out.println(sb.toString());
	}

}
