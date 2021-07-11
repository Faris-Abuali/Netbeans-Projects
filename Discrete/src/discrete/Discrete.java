/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discrete;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Discrete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer[] categories = new Integer[]{25, 10, 1};
        Integer[] numOfCoinsOfEachCategory = change(categories, 30);

        for (int i = 0; i < numOfCoinsOfEachCategory.length; i++) {
            System.out.println("# of coins of category " + categories[i] + " = " + numOfCoinsOfEachCategory[i]+" coin(s).");
        }
        
    }

    //Greedy Change-Making Algorithm
    public static Integer[] change(Integer[] categories, int money) {

        Integer[] d = new Integer[categories.length];

        for (int i = 0; i < categories.length; i++) {

            d[i] = 0;

            while (money >= categories[i]) {
                d[i]++;
                money = money - categories[i];
            }
        }

        return d;

    }

//    public static Integer[] change(int remainder) {
//
//        Integer[] arCategory = new Integer[4];
//
//        arCategory[0] = remainder / 25;
//
//        remainder = remainder % 25;
//
//        arCategory[1] = remainder / 10;
//
//        remainder = remainder % 10;
//        arCategory[2] = remainder / 5;
//
//        remainder = remainder % 5;
//
//        arCategory[3] = remainder;
//        
//        return arCategory;
//
//    }
}
