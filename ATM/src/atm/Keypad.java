/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Keypad {

    private Scanner sc;

    public Keypad() {
        sc = new Scanner(System.in);
    }

    public int getInput() { //Because the ATM’s keypad,unlike a computer keyboard,
        //contains only the numbers 0–9,we specify that this operation returns an integer value
        return sc.nextInt();
    }
    // [Note: Method nextInt can throw an InputMismatchException if the user enters non-integer input. 
    // Because the real ATM’s keypad permits only integer input, we assume that no exception will occur 
    //anddonot attemptto fix this problem.
}
