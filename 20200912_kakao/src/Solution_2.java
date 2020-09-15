import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_2 {

	public static void main(String[] args) {
		String[] s = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		
		String[] answer = solution(s, course);
		for(String ss : answer)
			System.out.println(ss);
	}

	public static String[] solution(String[] orders, int[] course) {
		// 알파벳 확인
		int[] alpha = new int[26];
		for(int i = 0; i<orders.length; i++) {
			String s = orders[i];
			for(int j = 0; j<s.length(); j++) {
				int idx = (s.charAt(j) - 'A');
				alpha[idx]++;
			}
		}
		// 필요없는 알파벳 삭제
		ArrayList<String> chOrder = new ArrayList<String>();
		for(int i = 0; i<orders.length; i++) {
			String s = orders[i];
			StringBuilder sb = new StringBuilder();

			for(int j = 0; j<s.length(); j++) {
				
				int idx = (s.charAt(j) - 'A');
				if(alpha[idx] < 2)
					continue;
				
				sb.append(s.charAt(j));
			}
			if(sb.length() <= 1)
				continue;
			
			chOrder.add(sb.toString());
		}
		
		// 알파벳 제거 후 주문길이 확인
		int[] c = new int[20 + 1];
		for(int i = 0; i<chOrder.size(); i++) {
			c[chOrder.get(i).length()]++;
		}
		
		// 코스 개수 확인
		for(int i = 0; i<course.length; i++) {
			if(c[course[i]] < 1)
				course[i] = -1;
		}
		ArrayList<Integer> chCourse = new ArrayList<Integer>();
		for(int i = 0; i<course.length; i++) {
			if(course[i] == -1)
				continue;
			chCourse.add(course[i]);
		}
		
		// 사용가능한 알파벳 저장
		int size = 0;
		for(int i = 0; i<26; i++) {
			if(alpha[i] < 2)
				continue;
			size++;
		}
		int idx = 0;
		char[] word = new char[size];
		for(int i = 0; i<26; i++) {
			if(alpha[i] < 2)
				continue;
			word[idx++] = (char) (i + 'A');
		}
		
		// 조합
		Set<String> set = new HashSet<String>();
		dfs(set, 0, 0, "", word, chCourse);
		
		// 결과
		ArrayList<INFO> result = new ArrayList<INFO>();
		Iterator<String> it = set.iterator(); 
		while (it.hasNext()) {
			String s = it.next();
			int cnt = 0;
			for(int i = 0; i<chOrder.size(); i++) {
				String or = chOrder.get(i);
				
				boolean flg = true;
				for(int j = 0; j<s.length(); j++) {
					String com = "";
					com += s.charAt(j);
					if(or.contains(com))
						continue;
					
					flg = false;
					break;
				}
				
				if(flg)
					cnt++;
				
				
			}
			if(cnt >=2)
				result.add(new INFO(s, cnt, s.length()));
			
		}
		
		ArrayList<String> re = new ArrayList<String>();
		Collections.sort(result);
		int maxCnt = 100;
		int maxLen = 100;
		for(int i = result.size() -1 ; i>=0; i--) {
			if(maxLen== result.get(i).len) {
				if(maxCnt == result.get(i).cnt) {
					re.add(result.get(i).word);
				}
			} else if(maxLen > result.get(i).len) {
				maxCnt = result.get(i).cnt;
				maxLen = result.get(i).len;
				re.add(result.get(i).word);
			}
		}

		Collections.sort(re);
		String[] answer = new String[re.size()];
		for(int i = 0; i<re.size();i++)
			answer[i] = re.get(i);
        return answer;
    }
	public static void dfs(Set<String> set, int start, int cnt, String s, char[] word, ArrayList<Integer> chCourse) {
		for(int i = 0; i<chCourse.size(); i++) {
			if(cnt == chCourse.get(i))
				set.add(s);
		}
		if(cnt == chCourse.get(chCourse.size() - 1))
			return;
		for(int i = start; i<word.length;i++) {
			String t = s;
			s+=word[i];
			dfs(set, i + 1, cnt + 1, s, word, chCourse);
			s= t;
		}
	}
	
	public static class INFO implements Comparable<INFO>{
		String word;
		int cnt;
		int len;
		public INFO() {
		}
		public INFO(String word, int cnt, int len) {
			this.word = word;
			this.cnt = cnt;
			this.len = len;
		}
		@Override
		public int compareTo(INFO o) {
			if(this.len == o.len)
				return Integer.compare(this.cnt, o.cnt);
			return Integer.compare(this.len, o.len);
			
		}
		
	}
}
