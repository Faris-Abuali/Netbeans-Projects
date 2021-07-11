package combinations;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class CombinationsModified<E> {

    ArrayList<List<E>> arList = new ArrayList<>();

    public CombinationsModified() {
    }

    void combinationUtil(E arr[], E data[], int start, int end, int index, int r) {
        // Current combination is ready to be printed, print it 
        if (index == r) {

            arList.add(Arrays.asList(Arrays.copyOfRange(data, 0, r)));
//            for (int j = 0; j < r; j++) {
//                System.out.print(data[j] + " ");
//            }
//            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }

    }// end method

    void printCombination(E arr[], int n, int r) {
        // A temporary array to store all combination one by one 
        E data[] = (E[]) new Object[r];

        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    /*Driver function to check for above function*/
    
    
//    public static void main(String[] args) {
//        Integer arr[] = {1, 2, 3, 4, 5};
//        int r = 3;
//        int n = arr.length;
//        printCombination(arr, n, 4);
//    }
}// end class
