package chapter6heapsort;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class HeapSortAlphabet {

    public static void buildMaxHeap(char[] a) {

        int lastParentIndex = (a.length - 1) / 2;

        for (int i = lastParentIndex; i >= 0; i--) { // start from the index of the last parent
            heapify(a, i, a.length - 1);
        }

        System.out.println("Max Heap: " + Arrays.toString(a));

    }// end method

    
    public static void heapify(char[] a, int parentIndex, int heapSize) {

        int maxIndex = parentIndex;

        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildeIndex = 2 * parentIndex + 2;

        if (leftChildIndex <= heapSize && a[leftChildIndex] > a[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildeIndex <= heapSize && a[rightChildeIndex] > a[maxIndex]) {
            maxIndex = rightChildeIndex;
        }

        if (maxIndex != parentIndex) {
            //System.out.println("swap the parent (" + a[parentIndex] + ") with " + a[maxIndex]);
            swap(a, maxIndex, parentIndex);
            heapify(a, maxIndex, heapSize);
        }

    }// end method

    public static void swap(char[] a, int i, int j) {

        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //======================================================== HeapSort ===================================================
    
      public static void heapSort(char[] a) {

        int heapSize = a.length-1;

        buildMaxHeap(a);
        
        //now the max heap has been built

        while (heapSize > 0) {
            swap(a, 0, heapSize);
            heapSize--;
            heapify(a, 0,heapSize);
        }
        
        
        System.out.println("HeapSorted: "+Arrays.toString(a));

    }// end method
    
    
    
    
    
    
    public static void main(String[] args) {

        
        char[] a = {'E','A','F','B','X','W','L','S','Q','C'};
        
       // buildMaxHeap(a);
       
        heapSort(a);
        
    }// end main
    
    
    
    
}// end class
