/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesjune2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        File f = new File("abc.txt"); // I mad an object of File for a file named "abc"

        // now I wnat to create this file and start writing on it
        // to solve the problem 
        if (!f.exists()) {

            try (PrintWriter output = new PrintWriter(f)) {
                // I made an object of class PrintWriter and passe the file to the constructor
                // of this class , so now the file is created on my machine and is ready to be written over it

//            output.print("Fares ");
//            output.print("CSE");
//            output.println("201810408");
//           output.print("this sentence will be written in  a new line");
                output.print("all the data in the file was lost because whenever I create an object of PrintWriter"
                        + "class , it overwrites the previous data ");

            } catch (FileNotFoundException e) {

            }
        }

    }
}
