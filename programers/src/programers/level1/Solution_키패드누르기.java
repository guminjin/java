package programers.level1;

public class Solution_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		String hand = "right";

		String result = solution(numbers, hand);
		System.out.println(result);
	}

	public static String solution(int[] numbers, String hand) {
		int left = 10;
		int right = 12;

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				numbers[i] = 11;
			
			if (numbers[i] % 3 == 1) {
				left = numbers[i];
				result.append("L");
			} else if (numbers[i] % 3 == 0) {
				right = numbers[i];
				result.append("R");
			} else {
				int nRow = numbers[i] / 3;
				int nCol = numbers[i] % 3;

				int lRow = left / 3;
				int lCol = left % 3;
				int rRow = right / 3;
				int rCol = right % 3;

				if (nCol == 0) {
					nRow--;
					nCol = 3;
				}
				if (lCol == 0) {
					lRow--;
					lCol = 3;
				}
				if (rCol == 0) {
					rRow--;
					rCol = 3;
				}

				int lLen = Math.abs(lRow - nRow) + Math.abs(lCol - nCol);
				int rLen = Math.abs(rRow - nRow) + Math.abs(rCol - nCol);

				if (lLen == rLen) {
					if (hand.equals("right")) {
						right = numbers[i];
						result.append("R");
					} else {
						left = numbers[i];
						result.append("L");
					}
				} else if (lLen > rLen) {
					right = numbers[i];
					result.append("R");
				} else {
					left = numbers[i];
					result.append("L");
				}
			}
		}

		return result.toString();
	}
}
