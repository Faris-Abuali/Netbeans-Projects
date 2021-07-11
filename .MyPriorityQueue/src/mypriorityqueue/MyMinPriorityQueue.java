package mypriorityqueue;

/**
 *
 * @author Fares Abu Ali
 */
public class MyMinPriorityQueue {

    //Attributes:
    private static final int INFITY = Integer.MAX_VALUE;
    private static final int INITIAL_CAPACITY = 20;

    private int capacity;
    private int heapSize = -1;
    private int currentSize = 0;

    private int[] A;

    public MyMinPriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    public MyMinPriorityQueue(int initial_Capacity) {
        A = new int[initial_Capacity];
        capacity = initial_Capacity;
    }

    //==================================================================================================
    // ----- REMEMBER: in a Min-priority-queue, we will never need to buildMinHeap
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

    public int HEAP_MINIMUM() { // just return
        return A[0];
    }

    public int HEAP_EXTRACT_MIN() { // remove and return

        //It is similar to the for loop body of the HEAPSORT procedure.
        //The running time of HEAP-EXTRACT-MAX is O(lgn)
        if (heapSize < 0) {
            throw new ArrayIndexOutOfBoundsException("HEAP UNDERFLOW");
        }

        int maxElement = A[0];

        A[0] = A[heapSize];  //A[0] <--> A[heap-size] 
        heapSize--;
        minHeapify(0, heapSize);

        return maxElement;
    }

    public void HEAP_DECREASE_KEY(int i, int newKey) {

        /*
        Notes:
        
        --> An index i into the array identifies the priority-queue element whose key we wish to decrease.
        
        -->  The procedure first updates the key of element A[i] to its new value
        
        --> Because increasing the key of A[i] might violate the max-heap property, the procedure then,
        in a manner similar to the insertion loop of INSERTION-SORT from, traverses a simple path from this node 
        toward the root to find a proper place for the newly increased key.
         */
        if (newKey > A[i]) {
            throw new RuntimeException("You invoked DECREASE_KEY() function BUT you're trying to INCREASE the key !!!");
        }

        A[i] = newKey;

        // this loop is similar to the INSERTION_SORT loop
        while (i > 0 && A[PARENT(i)] > A[i]) {
            swap(A, PARENT(i), i);
            i = PARENT(i);
        }

        /*The running time of HEAP-DECREASE-KEY on an n-element heap is O(lgn), 
        since the path traced from the node to the root has length O(lgn). */
    }// end method

    public void MIN_HEAP_INSERT(int key) {

        /*
        It takes as an input: the key of the new element to be inserted into max-heap A.
        The procedure first expands the max-heap by adding to the tree a new leaf whose key is -∞ (MINUS INFINITY)
        .Then it calls HEAP-INCREASE-KEY to set the key of this new node to its correct value and maintain the max-heap property.
         */
        heapSize++;
        A[heapSize] = INFITY;
        HEAP_DECREASE_KEY(heapSize, key);

        //The running time of MAX-HEAP-INSERT on an n-element heap is O.lgn/.
    }// end method

    public void HEAP_INREASE_KEY(int[] A, int i, int newKey) {

        // CAUTION: THIS METHOD IS FROM ME. NOT FROM THE BOOK
        if (newKey < A[i]) {
            throw new RuntimeException("You invoked INCREASE_KEY() function BUT you're trying to DECREASE the key !!!");
        }

        A[i] = newKey;

        // now you have to traverse down the bath in a way exact to the MAX_HEAPIFY procedure (Start from index i)
        minHeapify(i, heapSize);

    }// end method

    private int PARENT(int i) {
        // return the parent index of the index i

        return (i - 1) / 2;
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return (heapSize < 0);
    }

    public String toString() {

        StringBuilder builder = new StringBuilder("");

        builder.append("[");

        for (int i = 0; i <= heapSize; i++) {
            builder.append(A[i] + ", ");
        }

        if (builder.length() >= 2) {
            builder = builder.delete(builder.length() - 2, builder.length());
        }

        builder.append("]");

        return builder.toString();
    }

}// end class
