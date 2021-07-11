/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

import java.util.Arrays;
import static stackapplications.InfixToPostfix.allTwoStacksContent;

/**
 *
 * @author Fares Abu Ali
 */
public class InfixToPrefixTwoStacks {

    public static StringBuilder allTwoStacksContent=new StringBuilder("");
    
    
    MyStack<String> operandsStack, operatorsStack;

    String input;
    String output;

    public InfixToPrefixTwoStacks(String input) {
        this.input = input;

        output = "";

        operandsStack = new MyStack<>();
        operatorsStack = new MyStack<>();
    }

    public String convertToPrefix() {

        input = insertBlanks();
        

        String[] tokens = input.split(" ");
    
       int i=0;
        
        for (String token : tokens) {

            switch (token) {

                case "+":
                case "-":
                    checkThenAddToOperatorsStack(token, 1);
                    break;

                case "*":
                case "/":
                    checkThenAddToOperatorsStack(token, 2);
                    break;

                case "(":
                    operatorsStack.push(token);
                    break;

                case ")":
                    checkThenAddToOperatorsStack(token, 0);
                    break;

                default: // then the token is an operand
                    operandsStack.push(token);

            }// end switch

           // System.out.println(operandsStack);
           
           allTwoStacksContent.append("\nPass #"+i+"\n");
           allTwoStacksContent.append("Operands Stack:\n"+operandsStack+"\n");
           allTwoStacksContent.append("Opertors Stack:\n"+operatorsStack+"\n");
           
           i++;
           
        }// end for each 

        //System.out.println(allTwoStacksContent);
        
        while (!operatorsStack.isEmpty()) {

            String operator = operatorsStack.pop();

            String operand1 = operandsStack.pop();
            String operand2 = operandsStack.pop();

            operandsStack.push(operator + " " + operand2 + " " + operand1);

        }
        
          allTwoStacksContent.append("Operands Stack:\n"+operandsStack+"\n");
          allTwoStacksContent.append("Opertors Stack:\n"+operatorsStack+"\n");
           

        // output is not initialized yet
        output = operandsStack.pop();

        return output;
    }

    public void checkThenAddToOperatorsStack(String token, int precedence) {

        if (precedence == 1) {

            while (!operatorsStack.isEmpty()
                    && (operatorsStack.getPeek().equals("+") || operatorsStack.getPeek().equals("-")
                    || operatorsStack.getPeek().equals("*") || operatorsStack.getPeek().equals("/"))) {

                String operator = operatorsStack.pop();

                String operand1 = operandsStack.pop();
                String operand2 = operandsStack.pop();

                operandsStack.push(operator + " " + operand2 + " " + operand1);
            }

            operatorsStack.push(token);

        } else if (precedence == 2) {

            while (!operatorsStack.isEmpty()
                    && (operatorsStack.getPeek().equals("*") || operatorsStack.getPeek().equals("/"))) {

                String operator = operatorsStack.pop();

                String operand1 = operandsStack.pop();
                String operand2 = operandsStack.pop();

                operandsStack.push(operator + " " + operand2 + " " + operand1);

            }
            operatorsStack.push(token);
        } else if (precedence == 0) {

            while (!operatorsStack.getPeek().equals("(")) {

                String operator = operatorsStack.pop();

                String operand1 = operandsStack.pop();
                String operand2 = operandsStack.pop();

                operandsStack.push(operator + " " + operand2 + " " + operand1);

            }

            operatorsStack.pop(); // pop the '('
        }

    }

    public String insertBlanks() {

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                res.append(" " + input.charAt(i) + " ");
            } else if (input.charAt(i) == '(') {
                res.append(input.charAt(i) + " ");

            } else if (input.charAt(i) == ')') {

                res.append(" " + input.charAt(i));

            } else if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))) {
                res.append(input.charAt(i));
            }
        }

        return res.toString();
    }

//    public static void main(String[] args) {
//
//        InfixToPrefixTwoStacks o = new InfixToPrefixTwoStacks("31+    4-12/6*13");
//
//        //String ready = o.insertBlanks();
//        // String[] tokens = ready.split(" ");
//        //System.out.println(Arrays.toString(tokens));
//        System.out.println(o.convertToPrefix());
//
//    }
}
