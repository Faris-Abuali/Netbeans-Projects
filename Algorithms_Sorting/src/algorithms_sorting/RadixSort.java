package algorithms_sorting;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class RadixSort {

    public static int[] countingSort(int[] A, int k, int digitOrder) {

        // HERE: digitOrder is the number of the digit (where digit 1is the lowest-order digit and digit d is the highest-order digit)
        int d = (int) (Math.pow(10, digitOrder));
        int dd = d/10;
        
        int[] B = new int[A.length]; // output array

        /*
        
        all elements must be integers in the range from 0-->K   (K is the largest integer in the array)
        
        A[1..n] : input Array
        B[1..n] : output Array, holds the sorted output
        C[0..k] : for temporary working storage ( we want every C[i] to store the number of elements less than or equal to i) 
         */
        int[] C = new int[k + 1]; //(K is the largest integer in the input array)
        // remember that C[0..k]  k is included so the size is (k+1).
        // Essentially, all elements are zeros in C.

        for (int j = 0; j < A.length; j++) {
            C[(A[j] % d)/dd]++;
        }
        // every C[i] now contains the number of elements equal to i.

        for (int j = 1; j < C.length; j++) { // or from j=1 to (K+1)
            C[j] = C[j] + C[j - 1];
        }
        // every C[i] now contains the number of elements less than or equal to i.

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[(A[j] % d)/dd] - 1] = A[j];
            C[(A[j] % d)/dd]--;
        }
        /*
        An important property of counting sort is that it is stable: 
        numbers with the same value appear in the output array in the same order as they do in the input array.
        Normally, the property of stability is important only when satellite data are carried around with the element being sorted
         */

        //System.out.println("Output Array (B) : "+Arrays.toString(B));
        return B;

    }// end method

    public static void radixSort(int[] A, int numOfDigits) {

        //number of digits. Digit (1) is the lowest order digit and digit (d) is the highest order digit
        
        for (int d = 1; d <= numOfDigits; d++) {
            A = countingSort(A, 9, d);
            System.out.println(Arrays.toString(A));
        }
        
    }// end method

    public static void main(String[] args) {

        int[] A = {329, 457, 657, 839, 436, 720, 355};

        radixSort(A, 3);

    }
}// end class
