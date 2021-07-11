/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class EvaluateInfixExpression {

    public static void main(String[] args) {

//        String expression = insertBlanks("(1+3*3-2)*(12/6*5)");
//        String[] tokens = expression.split(" ");
//
//        System.out.println(Arrays.toString(tokens));
//
//        System.out.println("java's split");
//        tokens = mySplit(expression);
//
//        System.out.println("mySplit:");
//        System.out.println(Arrays.toString(tokens));
//        
        if (args.length != 1) {
            System.out.println("Usage: java EvaluateExpression \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    public static String[] mySplit(String s) {

// notice that the size of the array will be equal to the number of blanks found, so first count the number of blanks
        int arSize = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                arSize++;
            }

        }

        String[] ar = new String[arSize];

        int ctr = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                ctr++;
            } else {

                if (ar[ctr] == null) {
                    ar[ctr] = s.charAt(i) + "";
                } else {
                    ar[ctr] = ar[ctr] + s.charAt(i) + "";
                }
            }

        }

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == null) {
                ar[i] = "";
            }

        }

        return ar;

    }

    public static int evaluateExpression(String expression) {

        MyStack<Integer> operandStack = new MyStack<>();

        MyStack<Character> operatorStack = new MyStack<>();

        expression = insertBlanks(expression);

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            if (token.length() == 0)// blank space
            {
                continue;// Back to the while loop to extract the next token
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

                while (!operatorStack.isEmpty()
                        && (operatorStack.getPeek() == '+' || operatorStack.getPeek() == '-' || operatorStack.getPeek() == '*'
                        || operatorStack.getPeek() == '/')) {

                    processAnOperator(operandStack, operatorStack);
                } // end while

                // Push the + or - operator into the operator stack 
                operatorStack.push(token.charAt(0));

            } // end else if
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {

                while (!operatorStack.isEmpty()
                        && (operatorStack.getPeek() == '*' || operatorStack.getPeek() == '/')) {

                    processAnOperator(operandStack, operatorStack);
                }// end while

                // Push the * or / operator into the operator stack 60        
                operatorStack.push(token.charAt(0));

            }// end else if
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push(token.charAt(0));

            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '(' 
                while (operatorStack.getPeek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack 
            } else { // the token is operand
                operandStack.push(new Integer(token));
            }
        } // end for each

        // Phase 2: Process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);

        }

        // return the result
        return operandStack.pop();

    }// end evaluateExpression method

    public static void processAnOperator(MyStack<Integer> operandStack, MyStack<Character> operatorStack) {

        char operator = operatorStack.pop();

        int operand1 = operandStack.pop();
        int operand2 = operandStack.pop();

        if (operator == '+') {
            operandStack.push(operand2 + operand1);
        } else if (operator == '-') {
            operandStack.push(operand2 - operand1);
        } else if (operator == '*') {
            operandStack.push(operand2 * operand1);
        } else if (operator == '/') {
            operandStack.push(operand2 / operand1);
        }

    }

    public static String insertBlanks(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')'
                    || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                res += " " + s.charAt(i) + " ";
            } else {
                res += s.charAt(i);
            }
        }

       // System.out.println(res);
        return res;

    }
}
