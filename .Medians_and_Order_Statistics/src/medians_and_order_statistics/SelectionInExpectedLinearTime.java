package medians_and_order_statistics;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class SelectionInExpectedLinearTime {

    public static int randomizedSelect(int[] A, int p, int r, int i) {

        // i : from 1 to A.length inclusive [1,A.length]
        // Input: Sequence of DISTINCT numbers
        // Output: the number who is the i-th smallest. (the i-th order statistic)
        //The following code for RANDOMIZED-SELECT returns the i-th smallest element of the array A[p..r].
        if (p == r) {
            return A[p];
        }

        int q = RANDOMIZED_PARTITION(A, p, r);
        int k = q - p + 1; //the number of elements in the low side of the partition, plus one for the pivot element. 

        if (i == k) { // then the pivot value is the answer (now my hand is pointing on the k-th smallest element)
            return A[q];
        } else if (i < k) {
            return randomizedSelect(A, p, q - 1, i);
        } else {
            return randomizedSelect(A, q + 1, r, i - k);
        }

    }// end method

//======================================== UTILITY METHODS =======================================
    public static int RANDOMIZED_PARTITION(int[] A, int p, int r) {

        // the range of random index is from p-->r  and r is included. So range = (r-p)+1
        int i = (int) (Math.random() * (r - p + 1) + p);

        swap(A, i, r);   //exchange A[r] with A[i] to make the A[i] as the new pivot

        return partition(A, p, r);
    }// end method

    public static int partition(int[] A, int p, int r) {

        int x = A[r];  // x is the pivot. We chose the pivot to be the last element
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {

            if (A[j] <= x) {
                i = i + 1;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, r);

        return i + 1;
    }// end method

    public static void swap(int[] A, int i, int j) {

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

    }// end method

    public static int randomizedSelect_ITERATIVE(int[] A, int p, int r, int i) {
        // returns the i-th smallest element

        int q=0;
        
        while (p != r) {

            q = RANDOMIZED_PARTITION(A, p, r);
            int k = q - p + 1; //the number of elements in the low side of the partition, plus one for the pivot element. 
            
            if(i==k){
                return A[q];
            }
            else if(i<k){
                r=q-1;
            }
            else{
                p=q+1;
                i = i-k;
            }
            
        }//end while
        
        return A[q];

    }// end method
//==============================================================================================

    public static void main(String[] args) {

        int[] A = {5, 13, 4, 22, 0, 7, -2, 8, 16, 37, -1, -17, 23, 3};  // length = 14

        int i = 4;  // the i-th smallest element (i-th order statistic)

        int x = randomizedSelect(A, 0, A.length - 1, i);
        
        int xx = randomizedSelect_ITERATIVE(A, 0, A.length-1, i);

        System.out.println("the " + i + "th order statistic = " + x);
        System.out.println("the " + i + "th order statistic = " + xx);

        Arrays.sort(A);

        System.out.println(Arrays.toString(A));

    }// end main
}// end class
