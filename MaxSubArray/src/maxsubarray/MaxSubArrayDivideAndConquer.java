package maxsubarray;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MaxSubArrayDivideAndConquer {

    public static int[] FIND_MAXIMUM_CROSSING_SUBARRAY(int[] A, int low, int mid, int high) { // O(n)

        // --- the left half, A[low..mid] 
        int leftSum = Integer.MIN_VALUE;   //holds the greatest sum found so far
        int sum = 0;  // holding the sum of the entries in A[low..mid]

        int maxLeft = 0;  // as an index

        for (int i = mid; i >= low; i--) {
            sum += A[i];

            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        // -------- work analogously for the right half, A[mid+1..high]
        int rightSum = Integer.MIN_VALUE;

        int maxRight = 0;

        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += A[i];

            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        //return (max-left,max-right,left_sum + right-sum)
        int tuple[] = new int[]{maxLeft, maxRight, (leftSum + rightSum)};

        // return the indices max_left and max_right that demarcate a maximum subarray crossing the midpoint,
        //along with the sum left_sum + right_sum of the values in the subarray A[max_left..max-right]. 
        return tuple;

    }// end method

    /*
    With a linear-time FIND-MAX-CROSSING-SUBARRAY procedure in hand, 
    we can write pseudocode for a divide-and-conquer algorithm to solve the maximum_subarray problem:

     */
    public static int[] FIND_MAXIMUM_SUBARRAY(int[] A, int low, int high) {

        if (high == low) {
            int[] triplet = new int[]{low, high, A[low]};  // tuple: (low,high,maxSum)
            return triplet;
        }

        int mid = (low + high) / 2;

        int[] leftTriplet = new int[3];  // tuple: (left_low, left_high, left_sum)
        int[] rightTriplet = new int[3]; // tuple: (right_low, right_high, right_sum)
        int[] crossTriplet = new int[3]; // tuple: (cross_low, cross_high, cross_sum)

        leftTriplet = FIND_MAXIMUM_SUBARRAY(A, low, mid);
        rightTriplet = FIND_MAXIMUM_SUBARRAY(A, mid + 1, high);
        crossTriplet = FIND_MAXIMUM_CROSSING_SUBARRAY(A, low, mid, high);

        if (leftTriplet[2] >= rightTriplet[2] && leftTriplet[2] >= crossTriplet[2]) { //means: if left_sum >= right_sum and left_sum >= cross_sum
            return leftTriplet;
        } else if (rightTriplet[2] >= leftTriplet[2] && rightTriplet[2] >= crossTriplet[2]) {// means: if right_sum >= left_sum and right_sum >= cross_sum
            return rightTriplet;
        } else { // means: if cross_sum >= left_sum and cross_sum >= right_sum
            return crossTriplet;
        }

    }//end method

    public static int[] printAndGiveMaxSubArray(int[] A, int[] triplet) {
        // a method just to print the maxSubarry
        
        
        // remember that the triplet contains : (low,high,maxSum)
        int start = triplet[0];
        int end = triplet[1];

        System.out.println("startIndex (low) = " + start);
        System.out.println("endIndex (high) = " + end);

        int[] maxSubAr = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            maxSubAr[i - start] = A[i];
        }

        System.out.println("Max Subarray : " + Arrays.toString(maxSubAr));
        System.out.println("Max Sum: " + triplet[2]);

        return maxSubAr;
    }// end method

    public static void main(String[] args) {

        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        int[] triplet = FIND_MAXIMUM_SUBARRAY(A, 0, A.length - 1);   // will return (low,high,maxSum)

        printAndGiveMaxSubArray(A, triplet);

    }// end main
}// end class
