package maxsubarray;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MaxSubArray {

    /*
    Day     0    1    2     3    4     5     6     7     8     9     10     11   12    13   14   15   16 
    Price  100  113  110   85   105   102   86    63     81   101    94    106   101   79   94   90   97
    Change       13   -3   -25   20    -3   -16  -23    18    20    -7      12    -5   -22  15   -4    7
     */
    public static void printArray(int[] A) {

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " | ");
        }

        System.out.println("\n--------------------------------------------------------------------------------------------------\n");
    }

    /*
     the maximum subarray : nonempty, contiguous subarray of whose values have the largest sum
     */
    public static void fun(int[] A) {

        int[] change = new int[A.length];
        change[0] = 0;

        for (int j = 1; j < A.length; j++) {
            change[j] = A[j] - A[j - 1];
        }

        printArray(A);
        printArray(change);

        //========================= Now we will start to find the max subArray =================================
        int MAX_SUM_EVER = 0;
        int bestDayToSell = 0;
        int bestDayToBuy = 0;

        int maxProfit = 0;
        int sum = 0;
        int sellIndex = 0;
        int buyIndex;

        for (buyIndex = 0; buyIndex < change.length; buyIndex++) {

            sum = 0;
            maxProfit = 0;

            for (int i = buyIndex + 1; i < change.length; i++) {

                sum += change[i];

                if (sum > maxProfit) {
                    maxProfit = sum;
                    sellIndex = i;
                }
            }

            if (maxProfit > MAX_SUM_EVER) {
                MAX_SUM_EVER = maxProfit;
                bestDayToSell = sellIndex;
                bestDayToBuy = buyIndex;
            }

            //System.out.println("If buying day is : "+buyIndex+", then selling day will be "+sellIndex+". With maxProfit = "+maxProfit);
        }

        System.out.println("MAX SUM EVER : " + MAX_SUM_EVER);
        System.out.println(" bestDayToSell = " + bestDayToSell);
        System.out.println(" bestDayToBuy = " + bestDayToBuy);

        int[] maxSubAr = new int[bestDayToSell - bestDayToBuy];

        for (int i = bestDayToBuy + 1; i <= bestDayToSell; i++) {
            maxSubAr[i - bestDayToBuy - 1] = change[i];
        }

        System.out.println("MaxSubArray: " + Arrays.toString(maxSubAr));
        System.out.println("Sum = " + MAX_SUM_EVER);

    }// end method

    public static void maxSubArray(int[] A) {

        int sum, maxSum, startIndex, endIndex;

        sum = maxSum = startIndex = endIndex = 0;

        for (int j = 0; j < A.length; j++) {

            sum = 0;

            for (int i = j; i < A.length; i++) {

                sum += A[i];

                if (sum > maxSum) {
                    maxSum = sum;
                    startIndex = j;
                    endIndex = i;
                }
            }

        }

        
        int[] maxSubAr = new int[endIndex-startIndex+1];
        
        for(int i=startIndex;i<=endIndex;i++){
            maxSubAr[i-startIndex]=A[i];
        }
        
        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);
        System.out.println("maxSubArray = " + Arrays.toString(maxSubAr));
        System.out.println("maxSum = " + maxSum);

    }// end method

    public static void main(String[] args) {

        // int[] A = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        

        maxSubArray(A);

    }// end main

}// end class
