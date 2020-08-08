import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int t = 1; t<=10; t++) {
            int n = sc.nextInt();
            int[] num = new int[8];
            
            int mn = 987654321;
            for(int i = 0 ;i<8; i++) {
                num[i] = sc.nextInt();
                if(mn > num[i])
                	mn = num[i];
            }
            
            Queue<Integer> q = new LinkedList<Integer>();
            int div = mn / 15;
            div = div * 15;
            for(int i = 0 ;i<8; i++) {
                num[i] = num[i] - div;
                q.add(num[i]);
            }
             
            boolean flg = true;
            while(flg) {
                for(int i = 1; i<=5; i++) {
                    int num2 = q.poll() - i;
                     
                    if(num2 <=0) {
                        q.add(0);
                        flg = false;
                        break;
                    }
                     
                    q.add(num2);
                }
            }
             
            System.out.print("#" + t + " ");
            while(!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
             
        }
    }
 
}