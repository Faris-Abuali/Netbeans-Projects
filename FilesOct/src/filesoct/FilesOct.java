package filesoct;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class FilesOct {

    public static void main(String[] args) {

        File sourceFile = new File("source.txt");
        File targetFile = new File("target.txt");

        if (!sourceFile.exists()) {
            System.out.println("the source file doesn't exist..");
        } else if (targetFile.exists()) {
            System.out.println("the target file already exists..");
        } else {

            try (Scanner input = new Scanner(sourceFile);
                    PrintWriter output = new PrintWriter(targetFile);) {

                while (input.hasNext()) {

                    String s1 = input.nextLine();

                    String s2 = s1.replaceAll("Fares", "Haneen");

                    output.print(s2);

                }

            } catch (FileNotFoundException ex) {

                System.out.println(ex);

            }

        }

//        int ctr = 0;
//        try (Scanner sc = new Scanner(f);) {
//
//            int n = sc.nextInt();
//
//            String s=sc.nextLine();
//            
//            System.out.println(n);
//            
//            System.out.println(s);
//        } catch (FileNotFoundException ex) {
//
//            System.out.println(ex);
//
//        }
//        try {
//            Scanner sc = new Scanner(f);
//
//            while (sc.hasNextLine()) {
//
//                System.out.println(sc.next());
//            }
//            
//            sc.close();
//        } catch (FileNotFoundException ex) {
//
//            System.out.println(ex);
//        }
//        if (f.exists()) {
//            System.out.println("File already exists");
//        } else {
////
////            try {
////                PrintWriter output = new PrintWriter(f);
////
////                output.println("Fares H. Abu Ali");
////                output.print("%98");
////
////                output.close();
////            } catch (FileNotFoundException ex) {
////                System.out.println(ex);
////            }
//
////
////            try (PrintWriter output = new PrintWriter(f);) {
////
////                output.println("Fares H. Abu Ali");
////                output.print("%100");
////            } catch (FileNotFoundException ex) {
////                System.out.println(ex);
////            }
//
//
//    
//
//        }// end else
    }//end main

}// end class

