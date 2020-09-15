import java.util.ArrayList;

public class Solution_1 {

	public static void main(String[] args) {
		String s = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(s));
	}

	public static String solution(String new_id) {

		// 1. 대문자 치환
		new_id = new_id.toLowerCase();

		ArrayList<Character> s = new ArrayList<Character>();
		for (int i = 0; i < new_id.length(); i++)
			s.add(new_id.charAt(i));

		ArrayList<Integer> re = new ArrayList<Integer>();

		// 2. 문자 확인
		for (int i = 0; i < s.size(); i++) {
			if(s.get(i) - '0' >= 0 && s.get(i) - '0' <= 9)
				continue;
			if (s.get(i) - 'a' >= 0 && s.get(i) - 'a' < 26)
				continue;
			if (s.get(i) == '.' || s.get(i) == '-' || s.get(i) == '_')
				continue;
			re.add(i);
		}
		for (int i = re.size() - 1; i >= 0; i--) {
			int idx = re.get(i);
			s.remove(idx);
		}
		re.clear();

		// 3. 연속된 '.' 확인
		for (int i = 0; i < s.size() - 1; i++) {
			if (s.get(i) != '.')
				continue;

			int t = i;
			for (int j = i + 1; j < s.size(); j++) {
				if (s.get(j) != '.')
					break;
				re.add(j);

				t = j;
			}
			i = t;
		}
		for (int i = re.size() - 1; i >= 0; i--) {
			int idx = re.get(i);
			s.remove(idx);
		}
		re.clear();

		// 4. 앞뒤 '.'확인
		int size = s.size();
		if (s.size() != 0)
			if (s.get(size - 1) == '.')
				s.remove(size - 1);
		if (s.size() != 0)
			if (s.get(0) == '.')
				s.remove(0);

		// 5. 빈문자열 확인
		if (s.size() == 0) {
			s.add('a');
		}

		// 6. 16자 이상인지 확인
		size = s.size();
		if (size > 15) {
			for (int i = size - 1; i >= 15; i--)
				s.remove(i);
			if (s.get(14) == '.')
				s.remove(14);
		}

		// 7. 2글자 이하인지 확인
		size = s.size();
		while (s.size() <= 2) {
			s.add(s.get(size - 1));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.size(); i++) {
			sb.append(s.get(i));
		}
		return sb.toString();
	}
}
