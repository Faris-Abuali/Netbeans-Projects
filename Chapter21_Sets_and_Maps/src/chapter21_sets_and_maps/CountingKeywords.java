package chapter21_sets_and_maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class CountingKeywords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = sc.nextLine();

        try {
            File file = new File(filename);

            if (file.exists()) {
                System.out.println("The number of keywords in " + " is " + countKeywords(file));
            } else {
                System.out.println("File " + filename + " does not exist");
            }
        } catch (Exception ex) {

        }

    }// end main

    public static int countKeywords(File file) throws Exception {
// Array of all Java keywords + true, false and null 

        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally", "float", "goto", "if",
            "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
            "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
            "try", "void", "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        
        
        int count = 0;
        
        
        Scanner sc = new Scanner(file);
        
        while(sc.hasNext()){
            
            String word = sc.next();
            
            if(keywordSet.contains(word)){
                count++;
            }
        }
        
        
        return count;

    }// end method
    
    
    
    
}// end class
