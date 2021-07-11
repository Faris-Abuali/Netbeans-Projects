package filesjune2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class ReadData {

    public static void main(String[] args) {
        File f = new File("scores.txt");

        try {
            Scanner sc = new Scanner(f);
            
            while(sc.hasNext()){
               // System.out.println(sc.nextLine());
               
               
               //or if you want to store each token in a specific variable
               
               String firstName=sc.next();
               String midName=sc.next(); 
               String lastName=sc.next();
               String score=sc.nextLine();
               
                System.out.println(firstName+" "+midName+" "+lastName+" "+score);
                
            }
            
            sc.close();
        } catch (FileNotFoundException e) {

        }

        
    }

}
