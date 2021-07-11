package deadlock_avoidance;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Banana {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x, y, a, b, c;

        x = sc.nextInt();
        y = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // I can eat only X YELLOW bananas & Y GREEN bananas.
        int[] a_yellow = new int[a];
        int[] b_green = new int[b];
        int[] c_noColor = new int[c];

        for (int i = 0; i < a; i++) {
            a_yellow[i] = sc.nextInt();
        }

        for (int i = 0; i < b; i++) {
            b_green[i] = sc.nextInt();
        }

        for (int i = 0; i < c; i++) {
            c_noColor[i] = sc.nextInt();
        }

        Arrays.sort(a_yellow);
        Arrays.sort(b_green);
        Arrays.sort(c_noColor);

        System.out.println(Arrays.toString(a_yellow));
        System.out.println(Arrays.toString(b_green));

        System.out.println(Arrays.toString(c_noColor));

        int sum = 0;

        int c_index=c-1;
        
        for (int i = a - 1; i >= 0 && x>0; i--) {
            
                if(a_yellow[i]>=c_noColor[c_index]){
                    x--;
                    sum+=a_yellow[i];
                }
                else if(c_index>=0){
                    sum+=c_noColor[c_index];
                    c_index--;
                    x--;
                    i++;
                }
        }
        
       // System.out.println("sum x = "+sum);
        
           for (int i = b - 1; i >= 0 && y>0; i--) {
            
                if(b_green[i]>=c_noColor[c_index]){
                    y--;
                    sum+=b_green[i];
                }
                else if(c_index>=0){
                    sum+=c_noColor[c_index];
                    c_index--;
                    y--;
                    i++;
                }
        }
        
         //===============================================================
           if(x>0 && c_index>=0){
               for(int i=c_index;i>=0;i--){
                   sum+=c_noColor[c_index];
                   c_index--;
                   x--;
               }
           }
           
            if(y>0 && c_index>=0){
               for(int i=c_index;i>=0;i--){
                   sum+=c_noColor[c_index];
                   c_index--;
                   y--;
               }
           }
           
           
           
           
        System.out.println(sum);
        

    }// end main

}//end class
