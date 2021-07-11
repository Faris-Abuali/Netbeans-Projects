package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Heap {

    private Integer[] ar;
    private int heapSize;

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public Integer[] getArray() {
        return ar;
    }

//    public Heap(Integer[] intArray) {
//
//        ar = intArray;
//
//        heapSize = ar.length - 1;
//
//    }
//    public static void setArray(Integer[] intArray) {
//
//        ar = intArray;
//
//        heapSize = ar.length - 1;
//
//    }
//    public static Integer[] getArray() {
//        return ar;
//    }
    public void buildMaxHeap(Integer[] ar) {

        this.ar = ar;
        this.heapSize = ar.length - 1;

        for (int i = (heapSize - 1) / 2; i >= 0; i--) {// i statrts from the index of the last parent in the tree
            System.out.println("i = "+i);
            heapifyMax(ar, i);
            System.out.println("------------------------------------");
        }

    }

    public void buildMinHeap(Integer[] ar) {

        this.ar = ar;
        this.heapSize = ar.length - 1;

        for (int i = (heapSize - 1) / 2; i >= 0; i--) {// i statrts from the index of the last parent in the tree
            //System.out.println("i = "+i);
            heapifyMin(ar, i);
            //System.out.println("------------------------------------");
        }

    }

    public void heapifyMax(Integer[] ar, int parentIndex) {

        System.out.println(Arrays.toString(ar));
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int maxIndex = parentIndex; // initial value

        if (leftChildIndex <= heapSize && ar[leftChildIndex] > ar[maxIndex]) {

            maxIndex = leftChildIndex;
        }
        if (rightChildIndex <= heapSize && ar[rightChildIndex] > ar[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != parentIndex) {// this means that one of there's a child larger than the parent, so the parent will be changed
            swap(ar, parentIndex, maxIndex);
            heapifyMax(ar, maxIndex);// again invoke the function for the new parent
        }
    }

    public void heapifyMin(Integer[] ar, int parentIndex) {

        //System.out.println(Arrays.toString(ar));
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        int minIndex = parentIndex; // initial value

        if (leftChildIndex <= heapSize && ar[leftChildIndex] < ar[minIndex]) {

            minIndex = leftChildIndex;
        }
        if (rightChildIndex <= heapSize && ar[rightChildIndex] < ar[minIndex]) {
            minIndex = rightChildIndex;
        }

        if (minIndex != parentIndex) {// this means that one of there's a child larger than the parent, so the parent will be changed
            swap(ar, parentIndex, minIndex);
            heapifyMin(ar, minIndex);// again invoke the function for the new parent
        }
    }

    public boolean checkIfMaxHeap(Integer[] ar) {

        boolean flag = true;

        int lastParentIndex = (ar.length - 1 - 1) / 2;

        for (int i = lastParentIndex; i >= 0; i--) {
            
            if (checkIfMaxHeap(ar, i) == false) {
                flag = false;
                break;
            }

        }
        
        return flag;

    }

    private boolean checkIfMaxHeap(Integer[] ar, int parentIndex) {

        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildeIndex = 2 * parentIndex + 2;
        int maxIndex = parentIndex; // initial value

        if (leftChildIndex < ar.length && ar[leftChildIndex] > ar[maxIndex]) {
            return false;
        }
        if (rightChildeIndex < ar.length && ar[rightChildeIndex] > ar[maxIndex]) {
            return false;
        }
        
        return true;

    }

    private void swap(Integer[] ar, int maxIndex, int parentIndex) {
        int temp = ar[parentIndex];
        ar[parentIndex] = ar[maxIndex];
        ar[maxIndex] = temp;
    }

    
   
}
