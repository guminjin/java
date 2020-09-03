package programers.level2;

public class Solution_문자열압축 {

	public static int Solution(String s) {
		int answer = 10000;
		if(s.length() == 1)
			answer = 1;
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			String compare = s.substring(0, i);

			int cnt = 1;
			for (int j = i; j < s.length(); j += i) {
				int end = j + i;
				if (end > s.length())
					end = s.length();
				String com = s.substring(j, end);

				if (compare.equals(com))
					cnt++;
				else {
					if (cnt > 1) {
						sb.append(Integer.toString(cnt)).append(compare);
					} else {
						sb.append(compare);
					}
					compare = new String(com);
					cnt = 1;
				}
			}

			if (cnt > 1) {
				sb.append(Integer.toString(cnt)).append(compare);
			} else {
				sb.append(compare);
			}

			System.out.println(sb);
			answer = Math.min(answer, sb.length());
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String s = "a";

		System.out.println(Solution(s));

	}

}
