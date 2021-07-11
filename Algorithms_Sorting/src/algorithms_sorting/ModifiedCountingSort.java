package algorithms_sorting;

import algorithms_sorting.Medians_and_Order_Statistics.Pair;
import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class ModifiedCountingSort {

    public static int[] countingSort(int[] A) {

        // A is the input array
        Pair p = Medians_and_Order_Statistics.minMax(A); // O( 3*[n/2] )

        int minElement = p.min;
        int maxElement = p.max;

        int[] C_minus = new int[Math.abs(minElement) + 1]; // Since size of array cannot be negative 
        int[] C_plus = new int[maxElement + 1];

        // C_minus is the intermediate/auxiliary mapping array for negative numbers
        // C_plus is the intermediate/auxiliary mapping array for non-negative numbers
        // the default values of arrays are zeros initially
        //*************************************************************************************************
        for (int j = 0; j < A.length; j++) {
            if (A[j] >= 0) {
                C_plus[A[j]]++;
            } else {
                C_minus[-A[j]]++;
            }
        }

        // now C_plus[i] contains how many times the number (i) has appeared in the input array
        // and C_minus[i] contains how many times the number (-i) has appeared in the input array
//        System.out.println("C_plus: " + Arrays.toString(C_plus));
//        System.out.println("C_minus: " + Arrays.toString(C_minus));

        //*************************************************************************************************
        //Now first perform “running sum” on –ve mapping array (C_minus) from i=C_minus.length downto 0. 
        for (int j = C_minus.length - 2; j >= 0; j--) {
            C_minus[j] = C_minus[j] + C_minus[j + 1];
        }
        //now C_minus[i] contains the number of numbers that are <= (-i)

        //*************************************************************************************************
        //Then perform running sum on +ve mapping array from i=0 to C_plus.length.
        for (int j = 1; j < C_plus.length; j++) {
            C_plus[j] = C_plus[j] + C_plus[j - 1];
        }
        // now C_plus[i] contains the number of numbers that are <= (i)
        //*************************************************************************************************

//        System.out.println("After runnung sum:");
//        System.out.println("C_plus: " + Arrays.toString(C_plus));
//        System.out.println("C_minus: " + Arrays.toString(C_minus));

        /*
        
        Since we use two arrays one for mapping –ve and other for mapping +ve numbers so positive array 
        must have idea that how many –ve elements are there.
              
        
        NOW C_minus[0] CONTAINS HOW MANY NUMBERS ARE < ZERO      (now we know how many NEGATIVE number there are in the input array A[])
        
        $$$ NOW ADD C_minus[0] TO ALL ELEMENTS OF C_plus[] $$$
        This is done to make the running sum consistent since –ve integers are followed by positive integers in sorting
        (ascending order).
         */
        for (int j = 0; j < C_plus.length; j++) {
            C_plus[j] += C_minus[0];
        }

        //System.out.println("\nC_plus: " + Arrays.toString(C_plus));

        // now create the output array B:
        int[] B = new int[A.length];

        for (int j = A.length - 1; j >= 0; j--) {

            if (A[j] >= 0) {
                B[C_plus[A[j]] - 1] = A[j];
                C_plus[A[j]]--;
            } else {
                B[C_minus[-A[j]] - 1] = A[j];
                C_minus[-A[j]]--;
            }
        }

        return B;

    }// end method

    public static void main(String[] args) {
        // int[] A = {3, -1, -2, 0, 2};

        int[] A = {3, -7, 11, 8, -4, 0, 1, -3, -4, 9, 6, -8};

        System.out.println(Arrays.toString(countingSort(A)));
    }// end main

}//end class
