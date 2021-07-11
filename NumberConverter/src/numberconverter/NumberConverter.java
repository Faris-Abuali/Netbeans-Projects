package numberconverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Fares Abu Ali
 */
public class NumberConverter {

    public static void add(int[] a, int[] b) {

      
       //LinkedList<Integer> c = new LinkedList<>();

       int[] c = new int[a.length+1];
       
        int car = 0;

        for (int i = b.length - 1; i >= 0; i--) {

            int F = a[i] + b[i] + car;

           
            //c.addFirst(F%2);
            c[i+1]=F%2;

            if (F > 1) {
                car = 1;
            } else {
                car = 0;
            }
            
            
        }

        
        //c.addFirst(car);
        c[0]=car;
        
        
        System.out.println(Arrays.toString(c));
    }

    public static void main(String[] args) {

        
        add(new int[]{1,0,1,1,1,0,1},new int[]{0,1,1,0,1,1,1});
    }

}
