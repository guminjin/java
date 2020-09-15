
public class Solution_3 {

	public static void main(String[] args) {
		String[] s = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] course = {	"java and backend and junior and pizza 100",
							"python and frontend and senior and chicken 200",
							"cpp and - and senior and pizza 250",
							"- and backend and senior and - 150",
							"- and - and - and chicken 100",
							"- and - and - and - 150"};
		int[] result = solution(s, course);
		for(Integer i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		// 지원자 정보 person에 저장
		INFO[] person = new INFO[info.length];
		for (int i = 0; i < info.length; i++) {
			String[] str = info[i].split(" ");
			
			int g = Integer.parseInt(str[4]);
			person[i] = new INFO(str[0], str[1], str[2], str[3], g);
		}
		
		for(int i = 0; i<query.length; i++) {
			String[] q = query[i].split(" and ");
			String[] q2 = q[3].split(" ");
			
			q[3] = q2[0];
			
			int g = 0;
			if(q2[1] != "-")
				g = Integer.parseInt(q2[1]);
		
			for(int j = 0; j<person.length; j++) {				
				if(!q[0].equals("-") && !q[0].equals(person[j].lan))
					continue;
				if(!q[1].equals("-") && !q[1].equals(person[j].job))
					continue;
				if(!q[2].equals("-") && !q[2].equals(person[j].year))
					continue;
				if(!q[3].equals("-") && !q[3].equals(person[j].food))
					continue;
				
				if(g != 0 && g > person[j].grade)
					continue;
				
				answer[i]++;
			}
		}
		return answer;

	}

	public static class INFO {
		String lan;
		String job;
		String year;
		String food;
		int grade;

		public INFO() {
			super();
		}

		public INFO(String lan, String job, String year, String food, int grade) {
			super();
			this.lan = lan;
			this.job = job;
			this.year = year;
			this.food = food;
			this.grade = grade;
		}

	}

}
