package d3_7193;


import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
       int tc = sc.nextInt();
       for(int t = 1; t<= tc; t++) {
    	   int n = sc.nextInt();
    	   String x = sc.next();
    	   
    	   int p = 0;
    	   int sum = 0;
    	   for(int i = x.length() - 1; i>=0; i--) {
    		   int num = x.charAt(i) - '0';
    		   sum += (int)Math.pow(n, p++) * num;
    	   }
    	   
    	   int result = sum % (n-1);
    	   
    	   System.out.println("#" + t + " " + result);
       }
    }
 
}
