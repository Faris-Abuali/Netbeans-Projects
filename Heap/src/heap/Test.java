package heap;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {
    
    public static void main(String[] args) {

//        Heap h = new Heap(new Integer[]{1,4,7,12,16,19});
//            Heap.setArray(new Integer[]{1,4,7,12,16,19});
//            Heap.buildHeap(Heap.getArray());
////            


        Heap h = new Heap();
        h.buildMaxHeap(new Integer[]{1,4,19,12,16,7});
        Integer[] ar = new Integer[]{1,4,19,12,16,7};

//       Heap h =new Heap();
//        h.buildMinHeap(ar);
//
//
//        HeapSort.sortDescending(ar);
//        
//        System.out.println(Arrays.toString(ar));

        // HeapSort.sortDescending(ar);
    }
    
}
