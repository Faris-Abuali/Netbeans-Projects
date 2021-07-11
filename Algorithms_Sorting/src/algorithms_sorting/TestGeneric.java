package algorithms_sorting;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class TestGeneric {

    public static void main(String[] args) {

//      Integer[] numbers = {4, 3, 16, 7, 2, 8, 1, 9, 14, 10};
////
//      HeapSortGeneric<Integer> obj0 = new HeapSortGeneric<>();
////
//       System.out.println("Original Array: " + Arrays.toString(numbers));
//       
//      obj0.buildMaxHeap(numbers);
////
//        obj0.heapSort(numbers);
//
//        HeapSortGeneric<Character> obj1 = new HeapSortGeneric<>();
//
//        Character[] letters = {'E', 'A', 'F', 'B', 'X', 'W', 'L', 'S', 'Q', 'C'};
//
//        System.out.println("Original Array: " + Arrays.toString(letters));
//        obj1.heapSort(letters);
        float x = 1000_000_000;
        int levels=0;

        while (x > 1) {
            x=0.9f*x;
           levels++;
        }
        
        System.out.println(levels);
        
        

    }
}// end class
