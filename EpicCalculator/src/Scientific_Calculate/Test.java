/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scientific_Calculate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {
    
    /*
    examples:
    21+8*((8+2*3)/2)+1
    10*(2+1+5)/2-1
    
    
    */
        public static void main(String[] args) {

        
            InfixToPostfix obj=new InfixToPostfix();
            EvaluatePostfix ev=new EvaluatePostfix();
            
        Scanner sc=new Scanner(System.in);
        
        
//        
//          ArrayList<String> ar = new ArrayList<>();
//          
//          ar.add("ddd");
//          ar.add("ss");
//          
//          
//            System.out.println(ar);

            
        String infix;
        System.out.println("Enter your infix expression: ");
        infix=sc.next();
        
        
       ArrayList<String> al= obj.infixToPostfix(infix);
       
        System.out.println("The postfix expression is: "+ al);
        
        
        double result=ev.evaluatePostfix(al);
        
            System.out.println("The postfix expression after evaluation: "+result);
        
    }
}
