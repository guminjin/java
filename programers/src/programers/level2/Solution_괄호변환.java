package programers.level2;

public class Solution_괄호변환 {

	public static void main(String[] args) {
		String s = "()))((()";
		System.out.println(solution(s));
	}
	
	public static String solution(String p) {
        String answer = "";
        
    	StringBuilder sb = new StringBuilder();

    	int left = 0;
    	int right = 0;
    	int check = 0;
    	boolean flg = true;

        for(int i = 0; i<p.length(); i++) {
        	
        	if(p.charAt(i) == '(') {
        		right++;
        		check++;
        	}
        	else {
        		left++;
        		check--;
        	}
        	
        	sb.append(p.charAt(i));
        	if(check <0)
        		flg = false;
        	if(right == left) {
        		String u = sb.toString();
        		String v = p.substring(i + 1, p.length());
        		
        		if(flg) 
        			return sb.append(solution(v)).toString();
        		else {
        			String u2 = u.substring(1, i);
        			StringBuilder sb3 = new StringBuilder();
        			for(int j = 0; j<u2.length(); j++) {
        				if(u2.charAt(j) == '(')
        					sb3.append(")");
        				else
        					sb3.append("(");
        			}
        			
            		StringBuilder sb2 = new StringBuilder();
        			return sb2.append("(").append(solution(v)).append(")").append(sb3.toString()).toString();
        		}
        			 
        			
        	}
        }
        return answer;
    }
	
}
