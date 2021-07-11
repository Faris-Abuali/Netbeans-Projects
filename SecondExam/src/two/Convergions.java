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
public class Convergions {

    public static void decToHex(int num) {
        if (num == 0) {
            return;
        }

        decToHex(num / 16);
        if (num % 16 > 10) {
            System.out.print((char) (num % 16 + 'A' - 10));
        } else {
            System.out.print(num % 16);
        }

    }

    public static void hexToDec(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) >= 'A' && s.charAt(i)<='F')
                sum += (s.charAt(i) - 55) * Math.pow(16, s.length() - 1 - i);
            
            else
                sum += (s.charAt(i)-'0') * Math.pow(16, s.length() -i-1);
        }
        
        System.out.println(sum);
    }

    public static void main(String[] args) {
        //decToHex(123);

        hexToDec("41");
    }
}
