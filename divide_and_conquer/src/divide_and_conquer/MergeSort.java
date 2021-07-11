package divide_and_conquer;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MergeSort {

    
    
    public static int[] merge(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];

        int leftPointer = 0;
        int rightPointer = 0;

        int i = 0;

        while (leftPointer < a.length && rightPointer < b.length) {

            if (a[leftPointer] < b[rightPointer]) {
                c[i] = a[leftPointer++];
            } else {
                c[i] = b[rightPointer++];
            }

            i++;
        }
        while (leftPointer < a.length) {

            c[i] = a[leftPointer++];
            i++;
        }
        while (rightPointer < b.length) {
            c[i] = b[rightPointer++];
            i++;
        }

        //System.out.println(Arrays.toString(c));
        return c;

    }// end method

    public static int[] mergeSort(int[] ar) {

        if (ar.length > 1) {

            //======= Divide the problem into a number of subproblems that are smaller instances of the same problem.==========
            int midIndex = ar.length / 2;

            int[] leftAr = Arrays.copyOfRange(ar, 0, midIndex);
            int[] rightAr = Arrays.copyOfRange(ar, midIndex, ar.length);
            
            //=====Conquer the subproblems by solving themrecursively. If the subproblem sizes are small enough ======
            int[] leftSortedAr = mergeSort(leftAr);
            int[] rightSortedAr = mergeSort(rightAr);

            
            //====Combine the solutions to the subproblems into the solution for the original problem.===========
            ar = merge(leftSortedAr, rightSortedAr);

        }

        return ar;
    }

    public static void main(String[] args) {

        /// int[] a = new int[]{4, 30, 42, 46, 79};
        ///int[] b = new int[]{3,21, 29, 74, 76,88,112,546};
        //int[] ar = {30, 46, 42, 4, 79, 3, 21, 29, 74, 76, 8, 13};

        //System.out.println(Arrays.toString(mergeSort(ar)));
        
        String x = "a";
        
        String y = new String("a");

        
        System.out.println(x==y);
    }

}// end class
