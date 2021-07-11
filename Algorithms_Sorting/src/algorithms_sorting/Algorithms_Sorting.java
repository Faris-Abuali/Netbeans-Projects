package algorithms_sorting;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Algorithms_Sorting {

    public static void main(String[] args) {

        Integer[] A = GenerateRandomArray.generateArray(2_000_000_0);

        Integer[] ACopy = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            ACopy[i] = A[i];
        }
        
        
       // System.out.println(Arrays.toString(A));
        //System.out.println(Arrays.toString(ACopy));

        //System.out.println("Original Array: " + Arrays.toString(A));
        //System.out.println(Arrays.toString(GenerateRandomArray.generateArray(11)));
        QuickSortGeneric<Integer> q = new QuickSortGeneric<>();
        HeapSortGeneric<Integer> h = new HeapSortGeneric<>();

        long startTime, endTime;
        startTime = endTime = 0;

        
      
        
        
        startTime = System.currentTimeMillis();

        h.heapSort(A);

        endTime = System.currentTimeMillis();

        System.out.println("HeapSort : " + (endTime - startTime) + " msec");

        

        startTime = System.currentTimeMillis();

        q.quickSort(ACopy);

        endTime = System.currentTimeMillis();

        System.out.println("QuickSort : " + (endTime - startTime) + " msec");

        //------------------------------------------------
        //System.out.println("Sorted: " + Arrays.toString(A));
        // h.heapSort(A);
    }// end main

}// end class
