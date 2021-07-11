
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class Rahaf {  
        public static void main(String[] args) {
       
            
            Scanner sc = new Scanner(System.in);
            
            int n = (int)(Math.random()*100+1);
            
            System.out.println("I have a number between 1 and 100. Can you guess it?");
            
            int t = sc.nextInt();
            
            while(t!=n){
                
                if(t<n){
                    System.out.println("Too low");
                }
                else if(t>n){
                    System.out.println("Too high");
                }
                
                System.out.println("Try again...");
                t = sc.nextInt();
            }
            
            System.out.println("Correct, the number is "+n);
           
    }// end main
}
