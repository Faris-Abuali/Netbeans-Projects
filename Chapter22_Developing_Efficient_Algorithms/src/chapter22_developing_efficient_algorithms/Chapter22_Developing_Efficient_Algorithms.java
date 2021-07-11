package chapter22_developing_efficient_algorithms;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Chapter22_Developing_Efficient_Algorithms {

    /*
    Dynamic programming is the process of solving subproblems,
    then combining the solutions of the subproblems to obtain an overall solution. 
    This naturally leads to a recursive solution. However, it would be inefficient to use recursion, because the subproblems overlap.
    
    
     The key idea behind dynamic programming is to solve each subproblem only once and store the results
    for subproblems for later use to avoid redundant computing of the subproblems.


     */
 /*
    
    Obviously, the complexity of this new algorithm is O(n).
    This is a tremendous improvement over the recursive O(2^n) algorithm.
     */
    public static int fibo(int i) {

        int[] a = new int[i + 1];

        return fibo(i, a);
    }// end method

    public static int fibo(int i, int[] a) {// memoization

        if (i == 1 || i == 2) {
            a[i] = 1;
        } else if (a[i] == 0) {
            a[i] = fibo(i - 1, a) + fibo(i - 2, a);
        }

        return a[i];

    }// end method

    public static long improvedFib(long n) {

        long f0, f1, f2;

        f0 = 0;// For fib(0)
        f1 = 1;// For fib(1)
        f2 = 1;// For fib(2)

        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;

    }

    /*
    
    Brute force refers to an algorithmic approach that solves a problem in the simplest or most direct or obvious way.
    As a result, such an algorithm can end up doing far more work to solve a given problem than a cleverer
    or more sophisticated algorithm might do. On the other hand, a brute-force algorithm is often easier
    to implement than a more sophisticated one and, because of this simplicity, sometimes it can be more efficient.
     */
    public static int gcd(int a, int b) { //O(log n)

        // algorithm for finding the GCD was discovered by Euclid  around 300 b.c. 
        /*
        ■ If m % n is 0, gcd (m, n) is n. 
        ■ Otherwise, gcd(m, n) is gcd(n, m % n).
         */
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);

    }// end method

    public static void factorization(int n) {

        // We know that every integer number can be written as the product of prime numbers, so 
        // THIS METHOD GIVES THE PRIME FACTORS OF THE NUMBER n
        Set<Integer> set = new LinkedHashSet<>();
        int d = 2;

        while (n > 1) {

            if (n % d == 0) {
                //System.out.println(d);
                set.add(d);

                n /= d;

                if (isPrime(n)) { // this will imorove the efficiency of the method
                    //System.out.println(n);
                    set.add(n);
                    break;
                }
            } else {

                d++;
            }
        }// end while

        System.out.println(set);
    }// end function

    public static void allDivisors(int n) {  // O(n)

        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(n);

        for (int i = 2; i <= (n / 2); i++) {

            if (n % i == 0) {
                set.add(i);
            }
        }

        System.out.println(set);

    }// end method

    public static boolean isPrime(int n) { // O(sqrt(n))

        boolean isPrime = true;

        int sqrt = (int) Math.sqrt(n);

        int d = 2;

        while (d <= sqrt) {

            if (n % d == 0) {
                isPrime = false;
                break;
            }

            d++;
        }

        return isPrime;
    }// end method

    public static void main(String[] args) {

        //System.out.println(fibo(44));
        //System.out.println(improvedFib(10));
//        System.out.println(gcd(24, 36));
//        System.out.println(gcd(17, 9));
//                System.out.println(gcd(9,16));
        //System.out.println(gcd(80, 450));
        //System.out.println(gcd(191, 92));
        //System.out.println(gcd(2525, 125));
        
        
        //int n = 11111111 ;
        int n = 465;
        System.out.print("prime factors of: " + n + " are :");

        factorization(n);

        System.out.print("all divisors of: " + n + " are :");

        allDivisors(n);

    }

}
