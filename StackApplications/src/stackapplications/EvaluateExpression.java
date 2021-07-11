/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

import java.beans.Expression;
import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class EvaluateExpression {

    // this class evaluates expression(postfix or prefix)
    private static MyStack<String> operandsStack = new MyStack();

    
    private static boolean theExpressionMadeUpOfLetters(String expression){
        
        for(int i=0;i<expression.length();i++){
            
            char ch=expression.charAt(i);
            
            if(Character.isLetter(ch))
                return true;
        }
        
        return false;
    }
    
    
   private static String convertLetterExpressionToDigits(String expression){
        
       String[] tokens = expression.split(" ");
       
       
           for(int i=0;i<tokens.length;i++){

            if(Character.isLetter(tokens[i].charAt(0))){
                
                int num = new Integer(tokens[i].charAt(0));
                
               tokens[i]=num+"";
            }
        }
           
           
           expression="";
           
           for(int i=0;i<tokens.length;i++){
               expression+=tokens[i]+" ";
           }
           
           return expression;
    }
   
    public static int evaluateExpression(String expression) {

        if(theExpressionMadeUpOfLetters(expression)){
            expression=convertLetterExpressionToDigits(expression);
        }
        
            
        char ch = expression.charAt(0);
        int result = 0;

        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            result = evaluatePrefix(expression);
        } else {// then the expression is postfix
            result = evaluatePostExp(expression);
        }

        return result;

    }

    private static int evaluatePostExp(String postExp) {

        String[] tokens = postExp.split(" ");

        for (int i = 0; i < tokens.length; i++) {

            String ch = tokens[i];

            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {

                String operator = ch;

                int operand1 = new Integer(operandsStack.pop());
                int operand2 = new Integer(operandsStack.pop());

                switch (operator) {

                    case "+":
                        operandsStack.push((operand2 + operand1) + "");
                        break;

                    case "-":
                        operandsStack.push((operand2 - operand1) + "");
                        break;
                    case "*":
                        operandsStack.push((operand2 * operand1) + "");
                        break;
                    case "/":
                        operandsStack.push((operand2 / operand1) + "");
                        break;

                }

            } else { // then "ch" is an operand so push it to the operandStack

                operandsStack.push(ch);
            }

        }// end for

        return new Integer(operandsStack.getPeek());

    }// end method evaluatePostfix

    private static int evaluatePrefix(String postExp) {
        String[] tokens = postExp.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {

            String ch = tokens[i];

            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {

                String operator = ch;

                int operand1 = new Integer(operandsStack.pop());
                int operand2 = new Integer(operandsStack.pop());

                switch (operator) {

                    case "+":
                        operandsStack.push((operand1 + operand2) + "");
                        break;

                    case "-":
                        operandsStack.push((operand1 - operand2) + "");
                        break;
                    case "*":
                        operandsStack.push((operand1 * operand2) + "");
                        break;
                    case "/":
                        operandsStack.push((operand1 / operand2) + "");
                        break;

                }

            } else { // then "ch" is an operand so push it to the operandStack

                operandsStack.push(ch);
            }

        }
        return new Integer(operandsStack.getPeek());

    }

    public static void main(String[] args) {
       /// System.out.println(EvaluateExpression.evaluateExpression("31 4 + 12 6 / 13 * -"));

       // System.out.println(EvaluateExpression.evaluateExpression("- + 31 4 * / 12 6 13 "));
       
       
        System.out.println(EvaluateExpression.convertLetterExpressionToDigits("1 2 3 * +"));

    }
}// end class
