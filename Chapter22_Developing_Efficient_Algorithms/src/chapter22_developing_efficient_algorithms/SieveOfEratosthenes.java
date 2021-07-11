package chapter22_developing_efficient_algorithms;

/**
 *
 * @author Fares Abu Ali
 */
public class SieveOfEratosthenes {
    
    // it has the same time complexity: O(n*sqrt(n) / logn) as the algoritm in EfficientPrimeNumbers
    
    //This upper bound O(n*sqrt(n) / logn) is very loose. The actual time complexity is much better than it.
    
    //Drawbaks:
    // SieveOfEratosthenes algorithm is good for a small n sucj that the array named (primes) can fit in the memory

    public static void allPrimesUpToN(int n) {

        boolean[] primes = new boolean[n + 1]; // Prime number sieve

        // Initialize primes[i] to true 
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k <= (n / k); k++) {

            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime 
                }
            }

        }

        int count = 0; // Count the number of prime numbers found so far 

        for (int i = 2; i < primes.length; i++) {

            if (primes[i]) {
                count++;
                if (count % 10 == 0) {
                    System.out.printf("%7d\n", i);
                } else {
                    System.out.printf("%7d", i);
                }
            }
        }
        
        
        System.out.println("\n" + count +" prime(s) less than or equal to " + n);
    }// end method

    
    
    
    
    public static void main(String[] args) {
        
        allPrimesUpToN(1000);
        
    }// end main

}// end class
