package algorithms_sorting;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class HeapSortGeneric<E extends Comparable<E>> {

    public void buildMaxHeap(E[] a) {

        int lastParentIndex = (a.length - 1) / 2;

        for (int i = lastParentIndex; i >= 0; i--) { // start from the index of the last parent
            heapify(a, i, a.length - 1);
        }

        //System.out.println("Max Heap: " + Arrays.toString(a));
    }// end method

    public void heapify(E[] a, int parentIndex, int heapSize) {

        int maxIndex = parentIndex;

        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildeIndex = 2 * parentIndex + 2;

        if (leftChildIndex <= heapSize && a[leftChildIndex].compareTo(a[maxIndex]) > 0) {
            maxIndex = leftChildIndex;
        }

        if (rightChildeIndex <= heapSize && a[rightChildeIndex].compareTo(a[maxIndex]) > 0) {
            maxIndex = rightChildeIndex;
        }

        if (maxIndex != parentIndex) {
            //System.out.println("swap the parent (" + a[parentIndex] + ") with " + a[maxIndex]);
            swap(a, maxIndex, parentIndex);
            heapify(a, maxIndex, heapSize);
        }

    }// end method

    public void swap(E[] a, int i, int j) {

        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //======================================================== HeapSort ===================================================
    public void heapSort(E[] a) {

        int heapSize = a.length - 1;

        buildMaxHeap(a);

        //now the max heap has been built
        while (heapSize > 0) {
            swap(a, 0, heapSize);// Now I know that the largest element is in the root of the heap tree (in a[0])
            // so I will swap it with the last element.
            heapSize--;
            heapify(a, 0, heapSize);
        }

        //System.out.println("HeapSorted: "+Arrays.toString(a)+"\n");
    }// end method

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{7, 16, 10, 8, 2, 4, 3, 14, 9, 12};

        HeapSortGeneric<Integer> q = new HeapSortGeneric<>();

        q.buildMaxHeap(ar);

        System.out.println(Arrays.toString(ar));
    }

}// end class
