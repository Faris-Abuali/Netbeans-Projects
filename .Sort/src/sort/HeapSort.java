/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/*
 *
 * @author Fares Abu Ali
 */

public class HeapSort {

    public static void sortAscending(Integer[] ar) {

        Heap h = new Heap();
        h.buildMaxHeap(ar);


        while (h.getHeapSize() != 0) {

            swap(ar, 0, h.getHeapSize());// now because I gurantee the array is heap, I know that ar[0] is the maximum element
            h.setHeapSize(h.getHeapSize()-1);            
            h.heapifyMax(ar, 0);// we have to reheapify the array
        }

    }
    
       public static void sortDescending(Integer[] ar) {

        Heap h = new Heap();
        h.buildMinHeap(ar);

        while (h.getHeapSize() != 0) {

            swap(ar, 0, h.getHeapSize());// now because I gurantee the array is heap, I know that ar[0] is the maximum element
            h.setHeapSize(h.getHeapSize()-1);            
            h.heapifyMin(ar, 0);// we have to reheapify the array
        }

    }

    private static void swap(Integer[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
