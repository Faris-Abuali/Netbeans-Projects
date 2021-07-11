/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medians_and_order_statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Flowers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");

        HashMap<Integer, String> tens = new HashMap<>();

        tens.put(2, "twenty");

        tens.put(3, "thirty");
        tens.put(4, "forty");
        tens.put(5, "fifty");
        tens.put(6, "sixty");
        tens.put(7, "seventy");
        tens.put(8, "eighty");
        tens.put(9, "ninety");

        if (Integer.parseInt(str) <= 20) {
            System.out.println(map.get(Integer.parseInt(str)));
        } 
        else {
            
            if(str.charAt(1)=='0'){
            System.out.print(tens.get(Integer.parseInt(str.charAt(0)+"")));
            }
            else{
            System.out.print(tens.get(Integer.parseInt(str.charAt(0)+"")));
            System.out.print("-");
            System.out.print(map.get(Integer.parseInt(str.charAt(1)+"")));
            }

        }

    }// end main
}
