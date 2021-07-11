package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class InsertionRecursive {

    public static void insertionSortRec(int[] a, int n) {

        // sort the first n-1 elements of the array
        // then take the nth element of the array and insert it into the sorted n-1 elements at the appropriate position
        if (n < 1) {
            return;
        }

        insertionSortRec(a, n - 1);

        int key = a[n];
        int i = n - 1;

        while (i >= 0 && a[i] > key) {
            a[i + 1] = a[i];
            i--;
        }

        a[i + 1] = key;

    }// end method

    public static void main(String[] args) {

        int[] a = new int[]{5, 2, 9, 7, 14, 8};

        insertionSortRec(a, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

}// end class
