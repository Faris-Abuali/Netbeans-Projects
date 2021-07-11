package algorithms_sorting;

/**
 *
 * @author Fares Abu Ali
 */
public class Medians_and_Order_Statistics {

    static class Pair {

        static int min;
        static int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }// end class Pair

    public static Pair minMax(int[] A) {
        
        int numOfComparisons = 0;
        
        // this algorithm can give you the minimum(first order statistic) and the maximum (n-th order statistic)
        // by doing only  3* floor(n/2) comparisons, instead of 2(n-1) = 2n-2 comparisons 

        int n = A.length;
        /*
        --> If n is odd, we set both the minimum and maximum to the value of the first element,
       and then we process the rest of the elements in pairs. 
       
       
       --> If n is even, we perform 1 comparison on the first 2 elements to determine the initial values of the minimum and maximum.
         */

        if (n % 2 == 0) {

            if (A[0] < A[1]) {
                Pair.min = A[0];
                Pair.max = A[1];
            } else {
                Pair.min = A[1];
                Pair.max = A[0];
            }
        } 
        else {
            Pair.min = Pair.max = A[0];
        }
        
        numOfComparisons=1;

    /*
        we process elements in pairs:
        
        --> First, We compare pairs of elements from the input with each other.
        
        --> and then we compare the smaller with the current minimum 
        
        --> and the larger with the current maximum, 
        
        {at a cost of 3 comparisons for every 2 elements} 
    */
        
        int startFromI;

        if (n % 2 == 0) {
            startFromI = 2;
        } 
        else {
            startFromI = 1;
        }

        for (int i = startFromI; i < n; i += 2) {
            //3 comparisons

            int minOfTheCurrentPair, maxOfTheCurrentPair;

            if (A[i] < A[i + 1]) {
                minOfTheCurrentPair = A[i];
                maxOfTheCurrentPair = A[i + 1];
            } 
            else {
                minOfTheCurrentPair = A[i + 1];
                maxOfTheCurrentPair = A[i];
            }
            // finish comparison #1

            if (minOfTheCurrentPair < Pair.min) {
                Pair.min = minOfTheCurrentPair;
                // finish comparison #2
            }

            if (maxOfTheCurrentPair > Pair.max) {
                Pair.max = maxOfTheCurrentPair;
                // finish comparison #3
            }
            
            numOfComparisons+=3;

        }// end for

        
//        System.out.println("min = "+Pair.min);
//        System.out.println("Max = "+Pair.max);
//        
//        System.out.println("\nn = "+n);
//        System.out.println("number of comparisons = "+numOfComparisons);
        
        
        return new Pair(Pair.min, Pair.max);
    }// end method

    public static void main(String[] args) {
        
        int[] A={7,11,13,2,5,9,-4,6,70,-2,-10,16};
        
       
        minMax(A);
        
    }// end main

}// end class
