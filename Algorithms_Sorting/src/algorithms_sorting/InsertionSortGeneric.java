package algorithms_sorting;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class InsertionSortGeneric< E extends Comparable<E>> {

    public void insertionSort(E[] A) {

        for (int j = 1; j < A.length; j++) {

            int i = j - 1;
            E key = A[j];

            while (i >= 0 && A[i].compareTo(key) > 0) {
                A[i + 1] = A[i];
                i--;
            }
            
            A[i+1]=key;
            
        }// end for

    }// end method
    
    
    
    
//    public static void main(String[] args) {
//        InsertionSortGeneric<Integer> i = new InsertionSortGeneric<>();
//        
//        Integer[] A = {33,22,54,51,77,99,11,13,45,665};
//        
//        i.insertionSort(A);
//        
//        System.out.println(Arrays.toString(A));
//    }

}// end class
