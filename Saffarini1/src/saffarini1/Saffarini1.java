package saffarini1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Saffarini1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        BigInteger s1b = new BigInteger(s1);
        BigInteger s2b = new BigInteger(s2);
        
        
        System.out.println(s1b.add(s2b));
        
        System.out.println(s1b.multiply(s2b));

        
//        BigInteger fact = new BigInteger("1");
//
//        for (int i = 1; i <= n; i++) {
//            fact = fact.multiply(new BigInteger(i + ""));
//
//        }
//
//        System.out.println(fact);
//                System.out.println(fact.bitLength());
//
    }//end main

}// end class
