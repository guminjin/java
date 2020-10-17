package programers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_두개뽑아더하기 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		int[] result = solution(numbers);
	}
	
	public static int[] solution(int[] numbers) {
		int[] result;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<numbers.length; i++) {
			for(int j = i; j<numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		
		int idx = 0;
		result = new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			result[idx ++] = iter.next();
		}
		Arrays.sort(result);
		return result;
	}

}
