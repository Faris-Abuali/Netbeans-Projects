package algorithms_sorting;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class QuickSortGeneric<E extends Comparable<E>> {

    public void quickSort(E[] A) {

        int p, r;
        p = 0;
        r = A.length - 1;

        quickSort(A, p, r);

    }// end method

    public void quickSort(E[] A, int p, int r) {

        if (p < r) {
            int q = partition(A, p, r);

            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);

        }
    }// end method

    public int partition(E[] A, int p, int r) {

        E x = A[r];  // x is the pivot. We chose the pivot to be the last element
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {

            if (A[j].compareTo(x) <= 0) {  // means: if A[j]<=x 
                i = i + 1;
                exchange(A, i, j);
            }
        }

        exchange(A, i + 1, r);

        return i + 1;
    }// end method

    public void exchange(E[] A, int i, int j) {
        E temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //===============================================================================
    public void randomized_quickSort(E[] A) {

        int p, r;
        p = 0;
        r = A.length - 1;

        randomized_quickSort(A, p, r);

    }// end method

    public void randomized_quickSort(E[] A, int p, int r) {

        if (p < r) {

            int q = randomized_partition(A, p, r);

            randomized_quickSort(A, p, q - 1);
            randomized_quickSort(A, q + 1, r);

        }
    }// end method

    public int randomized_partition(E[] A, int p, int r) {

        // the range of random index is from p-->r  and r is included. So range = (r-p)+1
        int i = (int) (Math.random() * (r - p + 1) + p);

        exchange(A, i, r);   //exchange A[r] with A[i] to make the A[i] as the new pivot

        return partition(A, p, r);
    }// end method

    public static void main(String[] args) {

        Integer[] A = new Integer[10_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        Integer[] B = new Integer[10_000];
        for (int i = 0; i < B.length; i++) {
            B[i] = i;
        }

        QuickSortGeneric<Integer> q = new QuickSortGeneric<>();

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        q.quickSort(A);
        endTime = System.currentTimeMillis();
        System.out.println("QucikSort Classic :"+(endTime - startTime) + " mSec");

        //=====================================
        startTime = System.currentTimeMillis();
        q.randomized_quickSort(B);;
        endTime = System.currentTimeMillis();
        System.out.println("Randomized QucikSort:"+(endTime - startTime) + " mSec");
        
        

//        startTime = System.currentTimeMillis();
//        q.randomized_quickSort(B);
//
//        endTime = System.currentTimeMillis();
//
//        System.out.println(endTime - startTime + " mSec randomized");
        //System.out.println(Arrays.toString(A));
    }

}// end class
