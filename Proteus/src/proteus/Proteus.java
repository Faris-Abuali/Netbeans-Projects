package proteus;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Proteus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double w = 2 * 3.14;   // radian frequency in Kilo

        System.out.println("Enter t in ms:");
        double t = sc.nextDouble();  // time in ms

        System.out.println("U+UH = " + 7 * Math.sin(w * t));  // radian

        System.out.println("UH = " + 0.636 * Math.sin(w * t));  // radian

    }// end main

}// end class
