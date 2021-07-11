package chapter22_developing_efficient_algorithms;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class PrimeNumbers {

    public static void allPrimesUpToN(int n) {

        //the time complexity for this algorithm is O(n*sqrt(n))
        // the method isPrime() takes  // O(sqrt(n))
        ArrayList<Integer> list = new ArrayList<>();

        int number = 2;  // A number to be tested for primenes

        while (number <= n) {

            if (isPrime(number)) {
                list.add(number);
            }

            number++;
        }// end while

        System.out.println(list);
        System.out.println(list.size() + " less than or equal to " + n);
    }// end  method

    public static boolean isPrime(int n) { // O(sqrt(n))

        boolean isPrime = true;

        //int sqrt = (int) Math.sqrt(n);

        /*
        In fact, there is no need to actually compute Math.sqrt(number) for every number. 
        You need look only for the perfect squares such as 4, 9, 16, 25, 36, 49, and so on. 
        Note that for all the numbers between 36 and 48, inclusively, their (int)(Math.sqrt(number)) is 6.
        With this insight, you can replace the code:
        
        int sqrt = (int) Math.sqrt(n);

        
        with the following:
        

         */
 /* We know that if there are divisors(factors) for n, then those divisors will be less than or equall to sqrt(n)
        
        d <= sqrt(n)  then  d^2 <= n
        
        so all what I need is to everytime check if (d*d) <= n 
         */
        

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
    
    /*
    This algorithm can be further improved. In fact,
    you need to check only whether the (prime) numbers from 2 to sqrt(i) are possible divisors for i.
    
    (see class EfficientPrimeNumbers)
    
    I mean: for example when you want to ckeck whether 53 is prime or not, if 53 is prime then we will
    find a factor for it <= sqrt(53) which is a factor <= 7
    
    then you don't have to check whether  53 is divisible by  2,3,4,5,6,7
    we just have to check if 53 is divisible by the prime numbers from 2 to 7 : I mean 2,3,5,7
    
    
    
    
    
    We can prove that if i is not prime, there must exist a prime number p such that i = pq and p<= q.
    Here is the proof. Assume that i is not prime; let p be the smallest factor of i. p must be prime, 
    otherwise, p has a factor k with 2<=k<p. k is also a factor of i, which contradicts that p be the smallest factor of i.
    Therefore, if i is not prime, you can find a prime number from 2 to 2i that is divisible by i. 
    This leads to a more efficient algorithm for finding all prime numbers up to n,
    
    */

    public static void main(String[] args) {

        allPrimesUpToN(10000);

    }// end main

}// end class
