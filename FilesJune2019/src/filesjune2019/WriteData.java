/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesjune2019;

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
public class WriteData {

    public static void main(String[] args) throws FileNotFoundException {

        //create a File object
        File f = new File("scores.txt");// here you type a name of a file that doesn't exist yet and you want 
        //  to create now

        // here you must know something: the class File cannot create a file on the machine, it just create a File object
        // so now if I invoked the method f.exists(); it will return false, because the file is not existent in the machine
        //Unlike the File class, the PrintWriter class has the ability to create a file on the machine
        if (f.exists()) { // file exist?
            System.out.println("File Already Exists");
            System.exit(1);// exit from the file because we don't want only to erite data on an empty file
        }

        //create a file
        PrintWriter output = new PrintWriter(f);
        //Invoking the constructor of PrintWriter will create a new file if the file does not exist. 
        // If the file already exists, the current content in the file will be discarded without verifying with the user. 

        //Invoking the constructor of PrintWriter may throw an I/O exception. Java forces you to write the code to
        //deal with this type of exception. For simplicity, we declare throws IOException in the main method header (line 2). 
        output.print("Fares H. AbuAli ");
        output.println(94 + "%");

        output.print("John T. Smith ");
        output.println(96 + "%");

        //close the file
        output.close();
        //The close() method must be used to close the file 
        //If this method is not invoked, the data may not be saved properly in the file. 

        
//Programmers often forget to close the file ,so:
//    try(PrintWriter output = new PrintWriter(f);) { // this is called a resource
//           output.print("John T Smith "); 
//           output.println(90);
//           output.print("Eric K Jones ");
//           output.println(85);    
//    }catch(FileNotFoundException e){
//        
//    }
      //After the block is finished, the resource’s close() method is automatically invoked to close the resource
      //. Using try-with-resources can not only avoid errors but also make the code simpler. 
      
 


        //EndOfmain
    }

}
