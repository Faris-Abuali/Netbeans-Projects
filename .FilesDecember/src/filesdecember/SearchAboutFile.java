/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesdecember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class SearchAboutFile {
    
     public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    static int filesOccurences = 0;
    static int foldersOccurences = 0;

    public static void findKey(File curFile, String key) {

        find(curFile, key);

        System.out.println("");
        System.out.println(filesOccurences + " files matching ");
        System.out.println(foldersOccurences + " directories matching ");

    }

    public static void find(File curFile, String key) {

        if (curFile.isDirectory()) {

            File[] filesArray = curFile.listFiles();
            //System.out.println(Arrays.toString(filesArray));

            for (int i = 0; filesArray != null && i < filesArray.length; i++) {

                // first, check whether the directory itself has the same name as the key
                if (filesArray[i].getName().equals(key)) {
                    System.out.println(ANSI_GREEN+"The Directory(" + key + ")"+ANSI_RESET+" was found in " + curFile.getAbsolutePath());
                    foldersOccurences++;
                }
                
                find(filesArray[i], key); // recursion
            }
        } else {// then f is just a file, not a directory

            if (curFile.getName().equals(key + ".txt")) {
                System.out.println(ANSI_CYAN+"The File(" + key + ")"+ANSI_RESET+" was found in " + curFile.getAbsolutePath());
                filesOccurences++;
            }
        }

    }

    public static void main(String[] args) {


        findKey(new File("C:\\Users\\Fares Abu Ali\\Documents"), "Ali");
        
        
        
        
        
        //        File f = new File("C:\\Users\\Fares Abu Ali\\Documents");
//
//        String[] ar = f.list();
//
//        System.out.println(Arrays.toString(ar));
//
//        String key = "marks";

        //System.out.println(f.getName());
//        try (/*FileInputStream fo = new FileInputStream(new File("marks.txt"));*/)
//     
//                
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found...!");
//        } catch (NoSuchElementException e) {
//            System.out.println("No such element...!");
//        }
    }

}
