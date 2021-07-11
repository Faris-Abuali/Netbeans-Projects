/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class XO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int CTR = 0;

        while (T > 0) {

            String str = sc.next();
            CTR = 0;
            StringBuilder builder = new StringBuilder("");

            int[] ar = {12, 6, 4, 3, 2, 1};

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'X') {
                    CTR++;
                    // System.out.println("1X12");
                    builder.append("1x12 ");

                    break;
                }
            }
            //==========================================

            //==========================================
            int ctr26 = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'X' && str.charAt((i + 6) % 12) == 'X') {
                    ctr26++;
                }

            }
            if (ctr26 >= 2) {
                CTR++;
                builder.append("2x6 ");

                //System.out.println("2X6");
            }

            //==========================================
            int ctr34 = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'X' && str.charAt((i + 4) % 12) == 'X') {
                    ctr34++;
                }

            }
            if (ctr34 >= 3) {
                CTR++;
                builder.append("3x4 ");

                //System.out.println("3X4");
            }

            //==========================================
            
               int ctr43 = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'X' && str.charAt((i + 3) % 12) == 'X') {
                    ctr43++;
                }

            }
            if (ctr43 >= 4) {
                CTR++;
                builder.append("4x3 ");

                //System.out.println("4X3");
            }
            //==============================================
            int ctr62 = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'X' && str.charAt((i + 2) % 12) == 'X') {
                    ctr62++;
                }

            }
            if (ctr62 >= 6) {
                CTR++;
                builder.append("6x2 ");

                //System.out.println("6X2");
            }

            //==========================================
            //==========================================
         
//==========================================
            boolean allX = true;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) != 'X') {
                    allX = false;
                }

            }

            if (allX) {
                CTR++;
                builder.append("12x1");
                // System.out.println("12X1");

            }

            //==========================================
            System.out.print(CTR+" ");
            System.out.println(builder);
            
            
            T--;
        }
    }// end main

}
