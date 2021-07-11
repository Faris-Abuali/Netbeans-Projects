
package fullfinalproject2ndsemester2019safarini;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GuessTheNumber {

    public static void main(String[] args) {
System.out.println("Welcome to my Guess The Number gameplay:\n--------------------------------------");
        Scanner sc = new Scanner(System.in);
        // System.out.println("Name = Fares Hatem Abu Ali ");
        // -----------------------------------------------------------//

        ArrayList<String> a = new ArrayList<String>();
        Random r = new Random();
        int n = r.nextInt(1001);
        int input;
        int ctr = 0;
        while (true) {
            //JOptionPane.showMessageDialog(null, n);

            ctr++;
            String s = JOptionPane.showInputDialog(null, "Enter a number between 0 and 1000 :");
            a.add(s);
            input = Integer.parseInt(s);
            if (input == n) {
                break;
            }

            if (Math.abs(input - n) <= 10) {
                if (input > n) {
                    JOptionPane.showMessageDialog(null, "nearly large");
                } else {
                    JOptionPane.showMessageDialog(null, "nearly small");
                }
            } else if (input > n) {
                JOptionPane.showMessageDialog(null, "very  large");
            } else {
                JOptionPane.showMessageDialog(null, "very small");
            }

        }

        if (ctr <= 10) {
            JOptionPane.showMessageDialog(null, "Congrats ! the number is " + n + ". you guessed the number after " + ctr + " tries\n"
                    + "Your entered numbers were :" + a.toString());
        } else {
            JOptionPane.showMessageDialog(null, " You lost ! the number is " + n + ".  you guessed the number after " + ctr + " tries\n"
                    + "Your entered numbers were :" + a.toString());
        }

//JOptionPane.showMessageDialog(null, "Your entered numbers were :"+a.toString());
        //---EndOfmain---
    }

}
