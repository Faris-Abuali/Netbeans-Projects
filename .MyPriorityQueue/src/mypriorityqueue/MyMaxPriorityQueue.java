package mypriorityqueue;

import java.util.*;

/**
 * @author Fares Abu Ali
 */


/*
In summary, a heap can support any priority-queue operation on a set of size n in O(lgn) time.

OPERATIONS ARE:

1- HEAP_MAX : return only
2- HEAP_EXTRACT_MAX : [remove and return]  IT IS SIMILAR TO THE PROCEDURE USED IN HEAP_SORT
                        (this method is the only method which invokes HEAPIFY_MAX method)

3- INCREASE_KEY : it uses a procedure similar to the INSERTION_SORT WHILE LOOP
4- HEAP_INSERT : it actually takes advantage of the method INCREAS_KEY

*/
public class MyMaxPriorityQueue {

    //Attributes:
    private static final int MINUS_INFITY = Integer.MIN_VALUE;
    private static final int INITIAL_CAPACITY = 20;

    private int capacity;
    private int heapSize = -1;
    private int currentSize = 0;

    private int[] A;

    public MyMaxPriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    public MyMaxPriorityQueue(int initial_Capacity) {
        A = new int[initial_Capacity];
        capacity = initial_Capacity;
    }

    //==================================================================================================
    
    // ----- REMEMBER: in a Max-priority-queue, we will never need to buildMaxHeap
//    public void buildMaxHeap(int[] a) {
//
//        int lastParentIndex = (a.length - 1) / 2;
//
//        for (int i = lastParentIndex; i >= 0; i--) { // start from the index of the last parent
//            maxHeapify(a, i, a.length - 1);
//        }
//
//        //System.out.println("Max Heap: " + Arrays.toString(a));
//    }// end method

    //-----------------------------------------------------------------------------
//    public void buildMinHeap(int[] a) {
//
//        int lastParentIndex = (a.length - 1) / 2;
//
//        for (int i = lastParentIndex; i >= 0; i--) { // start from the index of the last parent
//            minHeapify(a, i, a.length - 1);
//        }
//
//        //System.out.println("Max Heap: " + Arrays.toString(a));
//    }// end method

    private void maxHeapify(int parentIndex, int heapSize) {

        int maxIndex = parentIndex;

        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        if (leftIndex <= heapSize && A[leftIndex] > A[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex <= heapSize && A[rightIndex] > A[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != parentIndex) {
            swap(A, maxIndex, parentIndex);
            maxHeapify(maxIndex, heapSize);
        }

    }// end method

    private void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void minHeapify(int parentIndex, int heapSize) {

        int minIndex = parentIndex;

        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;

        if (leftIndex <= heapSize && A[leftIndex] < A[minIndex]) {
            minIndex = leftIndex;
        }
        if (rightIndex <= heapSize && A[rightIndex] < A[minIndex]) {
            minIndex = rightIndex;
        }

        if (minIndex != parentIndex) {
            swap(A, minIndex, parentIndex);
            minHeapify(minIndex, heapSize);
        }

    }// end method

    
    
    
    // ===================== NOW WE WILL START WITH THE [OPERATIONS]: extract,increaseKey,insert 
    
    
    //====================================== FROM THE BOOK ========================================================
    public int HEAP_MAXIMUM() { // just return
        return A[0];
    }

    public int HEAP_EXTRACT_MAX() { // remove and return

        //It is similar to the for loop body of the HEAPSORT procedure.
        //The running time of HEAP-EXTRACT-MAX is O(lgn)
        if (heapSize < 0) {
            throw new ArrayIndexOutOfBoundsException("HEAP UNDERFLOW");
        }

        int maxElement = A[0];

        A[0] = A[heapSize];  //A[0] <--> A[heap-size] 
        heapSize--;
        maxHeapify(0, heapSize);

        return maxElement;
    }

    public void HEAP_INCREASE_KEY(int i, int newKey) {

        /*
        Notes:
        
        --> An index i into the array identifies the priority-queue element whose key we wish to increase.
        
        -->  The procedure first updates the key of element A[i] to its new value
        
        --> Because increasing the key of A[i] might violate the max-heap property, the procedure then,
        in a manner similar to the insertion loop of INSERTION-SORT from, traverses a simple path from this node 
        toward the root to find a proper place for the newly increased key.
         */
        if (newKey < A[i]) {
            throw new RuntimeException("You invoked INCREASE_KEY() function BUT you're trying to DECREASE the key !!!");
        }

        A[i] = newKey;

        // this loop is similar to the INSERTION_SORT loop
        while (i > 0 && A[PARENT(i)] < A[i]) {
            swap(A, PARENT(i), i);
            i = PARENT(i);
        }

        /*The running time of HEAP-INCREASE-KEY on an n-element heap is O(lgn), 
        since the path traced from the node to the root has length O(lgn). */
    }// end method

    public void MAX_HEAP_INSERT(int key) {

    /*
        It takes as an input: the key of the new element to be inserted into max-heap A.
        The procedure first expands the max-heap by adding to the tree a new leaf whose key is -∞ (MINUS INFINITY)
        .Then it calls HEAP-INCREASE-KEY to set the key of this new node to its correct value and maintain the max-heap property.
    */
        heapSize++;
        A[heapSize] = MINUS_INFITY;
        HEAP_INCREASE_KEY(heapSize, key);
        
        //The running time of MAX-HEAP-INSERT on an n-element heap is O.lgn/.
        
    }// end method

    public void HEAP_DECREASE_KEY(int[] A, int i, int newKey) {

        // CAUTION: THIS METHOD IS FROM ME. NOT FROM THE BOOK
        if (newKey > A[i]) {
            throw new RuntimeException("You invoked DECREASE_KEY() function BUT you're trying to INCREASE the key !!!");
        }

        A[i] = newKey;

        // now you have to traverse down the bath in a way exact to the MAX_HEAPIFY procedure (Start from index i)
        maxHeapify(i, heapSize);

    }// end method

    private int PARENT(int i) {
        // return the parent index of the index i

        return (i - 1) / 2;
    }

    
    public int size(){
        return heapSize;
    }
    
    public boolean isEmpty(){
        return (heapSize<0);
    }
    
    
    public String toString(){
       
        StringBuilder builder = new StringBuilder("");
        
        builder.append("[");
        
        for(int i=0;i<=heapSize;i++){
            builder.append(A[i]+", ");
        }
        
        if(builder.length()>=2){
            builder = builder.delete(builder.length()-2, builder.length());
        }
        
        builder.append("]");
        
        return builder.toString();
    }
    
    
//    public static void main(String[] args) {
//
//        
//        MyMaxPriorityQueue q = new MyMaxPriorityQueue(13);
//        
//        
//        int[] ar = new int[]{7, 16, 10, 8, 2, 4, 3, 14, 9, 12};
//
//        
//    }//  end main
}// end class
