/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Fares Abu Ali
 */
import java.util.Scanner;

public class JavaApplication2 
{
    
public static void main(String[] args)
{
     int length,width,area;
     Scanner input=new Scanner(System.in);
     
     System.out.println("Enter length\n");
     length=input.nextInt();
     System.out.println("Enter width\n");
     width=input.nextInt();
     
     area=length*width;
     
     System.out.printf("Area = %d",area);
    
}
}

