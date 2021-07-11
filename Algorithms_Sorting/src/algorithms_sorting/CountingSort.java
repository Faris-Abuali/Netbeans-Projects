package algorithms_sorting;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class CountingSort {

    /*
     no comparisons between input elements occur anywhere in the code. 
    Counting sort uses the actual values of the elements to index into an array. 
     */
    public static int[] countingSort(int[] A, int k) {

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
            C[A[j]]++;
        }
        // every C[i] now contains the number of elements equal to i.

        for (int j = 1; j < C.length; j++) { // or from j=1 to (K+1)
            C[j] = C[j] + C[j - 1];
        }
        // every C[i] now contains the number of elements less than or equal to i.

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }
        /*
        An important property of counting sort is that it is stable: 
        numbers with the same value appear in the output array in the same order as they do in the input array.
        Normally, the property of stability is important only when satellite data are carried around with the element being sorted
         */

        //System.out.println("Output Array (B) : "+Arrays.toString(B));
        return B;

    }// end method

    public static void main(String[] args) {

        int[] smallRangeArray = GenerateRandomArray.generateArray(100, 50);// size,range

        int[] largeRangeArray = GenerateRandomArray.generateArray(100, 99000);//size,range

        long startTime, endTime;

        System.out.println("=========================================");
        startTime = System.nanoTime();

        CountingSort.countingSort(largeRangeArray, 99000); // the largest element in the array is 99K

        endTime = System.nanoTime();

        System.out.println("the large range array took : " + (endTime - startTime) + " nano Sec");

        //=======================================================================     
        startTime = System.nanoTime();

        CountingSort.countingSort(smallRangeArray, 50);// the largest element in the array is 50

        endTime = System.nanoTime();

        System.out.println("the small range array took : " + (endTime - startTime) + " nano Sec");

//        int[] A = GenerateRandomArray.generateArrayOnlyNonNegativeNumbers(33);
//
////        int[]A =new int[]{2,5,3,0,2,3,0,3};
//        
//
//        int[]A =new int[]{97,81,96,90,99,99,88,95,100,100,99,99,96,98,100,90,93,100,88,84,98};
//
//        
//        System.out.println("input Array:" + Arrays.toString(A));
//
//        int[] B = CountingSort.cointingSort(A, 100);
//
//        System.out.println("output Array:" + Arrays.toString(B));


        
    }// end main

}// end class
