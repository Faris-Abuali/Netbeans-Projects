/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

/**
 *
 * @author Fares Abu Ali
 */
public class MyColor {

    public static void print() {
        System.out.println("A");
    }
}

class YourColor extends MyColor {

    public static void print() {
        System.out.println("B");
    }

}

class Hiding {

    public static void main(String[] args) {
        MyColor mpColor = new YourColor();
        YourColor mpYourColor = new YourColor();

        MyColor.print();
        mpColor.print();

        YourColor.print();
        mpYourColor.print();

        ((MyColor) mpYourColor).print();

        mpColor = mpYourColor;

        mpColor.print();

        ((YourColor) mpColor).print();

    }

}
