package programers.level2;

import java.util.HashMap;
import java.util.Map;

public class Solution_뉴클러스터링 {

	public static void main(String[] args) {
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";

		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < str1.length() - 1; i++) {
			if (str1.charAt(i) - 'A' < 0 || str1.charAt(i) - 'A' > 26)
				continue;
			if (str1.charAt(i + 1) - 'A' < 0 || str1.charAt(i + 1) - 'A' > 26)
				continue;
			String s = str1.substring(i, i + 2);
			if (map.containsKey(s)) {
				int cnt = map.get(s) + 1;
				map.put(s, cnt);
			} else
				map.put(s, 1);

		}

		double same = 0;
		double total = 0;
		for (int i = 0; i < str2.length() - 1; i++) {
			if (str2.charAt(i) - 'A' < 0 || str2.charAt(i) - 'A' > 26)
				continue;
			if (str2.charAt(i + 1) - 'A' < 0 || str2.charAt(i + 1) - 'A' > 26)
				continue;
			String s = str2.substring(i, i + 2);
			if (map.containsKey(s)) {
				same++;
				int cnt = map.get(s) - 1;
				if (cnt == 0)
					map.remove(s);
				else
					map.put(s, cnt);
			}
			total++;

		}

		total += map.size();
		answer = (int) (double)(same / total * 65536);

		if (answer == 0)
			answer = 65536;

		return answer;
	}
}
