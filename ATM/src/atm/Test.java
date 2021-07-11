/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        File f = new File("frs.txt");

//        try (PrintWriter output = new PrintWriter(f);
//                Scanner sc = new Scanner(System.in);) {
//
//            do {
//                System.out.print("Enter name:- ");
//                output.print(sc.next() + " ");
//                System.out.print("Enter account number:- ");
//                output.print(sc.nextInt() + " ");
//                System.out.print("Enter PIN:- ");
//                output.print(sc.nextInt());
//                output.println();
//
//                System.out.println("Enter 0 to exit ");
//
//            } while (sc.nextInt() != 0);
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try ( //try-with-resources
                //create input and output files
                Scanner sc = new Scanner(f);) {

            String str = "";     

            while (sc.hasNext()) {

                String line = "";

                String name = sc.next();
                String accountNum=sc.next();
                

                if (Integer.parseInt(accountNum) == 9998) {
                    line = name +" "+ accountNum+" " + "30";
                } else {
                    line = name+" " + accountNum+" "+sc.next() ;
                }
                str = str + "\n" + line;
            sc.nextLine();
            }
            
            System.out.println(str);
                    

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
    }

}
