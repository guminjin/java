package programers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		for(String s : solution(record)) {
			System.out.println(s);
		}
		
	}

	public static String[] solution(String[] record) {
		String[] answer;
		
		ArrayList<INFO> list = new ArrayList<INFO>();
		Map<String, String> user = new HashMap<String, String>();
		
		for(int i = 0; i<record.length; i++) {
			String[] str = record[i].split(" ");
			
			switch (str[0]) {
			case "Enter":
				list.add(new INFO(true, str[1]));
				user.put(str[1], str[2]);
				break;
			case "Leave":
				list.add(new INFO(false, str[1]));
				break;
			case "Change":
				user.put(str[1], str[2]);
				break;
			default:
				break;
			}
		}
		
		answer = new String[list.size()];
		for(int i = 0; i<list.size(); i++) {
			INFO now = list.get(i);
			StringBuilder name = new StringBuilder();

			if(now.status) {
				name.append(user.get(now.user)).append("님이 들어왔습니다.");
			} else {
				name.append(user.get(now.user)).append("님이 나갔습니다.");
			}
			answer[i] = name.toString();
		}
		return answer;
	}
	
	public static class INFO {
		boolean status;
		String user;
		public INFO() {
		}
		public INFO(boolean status, String user) {
			this.status = status;
			this.user = user;
		}
		
	}
	
}
