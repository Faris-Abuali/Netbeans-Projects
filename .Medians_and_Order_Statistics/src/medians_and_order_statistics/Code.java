package medians_and_order_statistics;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Code {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        int caseCtr=1;
        
        while(t>0){
            
            int n =sc.nextInt();
            String str = sc.next();
            
            int dots=0;
            
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='.'){
                    dots++;
                }
            }
            
           // System.out.println("dots "+dots);
           
            System.out.println("Case "+caseCtr+":"+" "+(int)(Math.ceil(dots/3.0)));
            
            caseCtr++;
            
            
            t--;
        }// end while
        

    }// end main
}// end class
