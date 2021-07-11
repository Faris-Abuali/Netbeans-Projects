/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionjune2019;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Permutation {

    public static void permutations(String str) {
        System.out.println("The permutations are:");
        permu(str, 0, str.length() - 1);
    }

    private static void permu(String str, int low, int high) {

        if (low == high) {
            System.out.println(str);
        } else {
            for (int i = low; i <= high; i++) {
                str=swap(str, low, i);
                permu(str, low + 1, high);
                str=swap(str, low, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] a = str.toCharArray();
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return String.valueOf(a);
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str=sc.next();
        System.out.println();
        
        permutations(str);
    }

    //--EndOfClass
}
