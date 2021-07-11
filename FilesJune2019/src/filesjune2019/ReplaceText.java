package filesjune2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class ReplaceText {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        //check if sourceFile exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        //check if target file exists
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Source file " + args[1] + " already exists");
            System.exit(3);
        }

        try (                     //try-with-resources
                //create input and output files
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);) {

            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.print(s2);
            }

        }

        //endOfmain   
    }

}
