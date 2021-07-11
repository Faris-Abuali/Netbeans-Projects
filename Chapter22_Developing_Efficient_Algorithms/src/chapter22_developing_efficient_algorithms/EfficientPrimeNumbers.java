package chapter22_developing_efficient_algorithms;

import java.util.ArrayList;

/**
 *
 * @author Fares Abu Ali
 */
public class EfficientPrimeNumbers {
    
      /*
    This algorithm is another example of dynamic programming. The algorithm stores the results of the subproblems 
    in the array list and uses them later to check whether a new number is prime.
    */

    public static void allPrimesUpToN(int n) { //the complexity of this algorithm is O[ n * sqrt(n) / log(n) ]. which is better 
        // than the previous: O[n sqrt(n)]

        int number = 2;  // A number to be tested for primenes
        ArrayList<Integer> list = new ArrayList<>();  // create a list to store prime numbers that you will need
        // to test the divisibility of (number) on all of them

        int squareRoot = 1; // Check whether number <= squareRoot

        while (number <= n) {

            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // Test whether (number) is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {

                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop 
                }

            }// end for

            if (isPrime) {

                list.add(number); // Add a new prime to the list 
            }

            // Check whether the next number is prime 
            number++;

        }//end while

        System.out.println(list);
        System.out.println(list.size() + " less than or equal to " + n);

    }// end method
    

    
    //=======================================================================================================================
    
    
    
     public static boolean isPrime(int n) { // O(sqrt(n))

        boolean isPrime = true;

        int divisor = 2;

        while ((divisor*divisor) <= n) {

            if (n % divisor == 0) {
                isPrime = false;
                break;
            }

            divisor++;

        }// end while

        return isPrime;
    }// end method
  

    public static void main(String[] args) {
        allPrimesUpToN(1000);
    }

}// end class
