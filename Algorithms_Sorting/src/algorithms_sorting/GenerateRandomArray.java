/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms_sorting;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class GenerateRandomArray {

    public static Integer[] generateArray(int size) {

        Integer[] A = new Integer[size];

        int range = size * 3;  // to minimize repeatetion 

        for (int i = 0; i < A.length; i++) {

            A[i] = (int) (Math.random() * range);

            //=============== to generate negative numbers =========
            int negative = (int) (Math.random() * 2);

            if (negative == 1) {
                A[i] *= -1;
            }
            //======================================================

        }

        return A;
    }// end method

    public static int[] generateArray(int size, int range) {

        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {

            A[i] = (int) (Math.random() * range);
        }

        return A;
    }// end method

    public static int[] generateArrayOnlyNonNegativeNumbers(int size) {

        int[] A = new int[size];

        int range = size + 1; // we want the last number to be included

        for (int i = 0; i < A.length; i++) {

            A[i] = (int) (Math.random() * range);
        }

        return A;
    }// end method

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArrayOnlyNonNegativeNumbers(5)));
    }//end main

}// end class
