
package sort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Fares Abu Ali
 */
public class RandomArrayGenerator {
    
    public static int[] generateArray(int size){
        
        int[] ar = new int[size];
        int n=0;
        
        
        for(int i=0;i<ar.length;i++){
          n  = (int)(Math.random()*100);
          ar[i]=n;
        }
        
        System.out.println(Arrays.toString(ar));
      return ar;
        
    }// end method
    
}// end class
