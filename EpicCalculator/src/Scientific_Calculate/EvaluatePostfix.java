/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scientific_Calculate;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class EvaluatePostfix {

    Stack<String> myStack = new Stack();// this stack is for operands only

    public double evaluatePostfix(ArrayList<String> al) {

        double secondOperand, firstOperand, result;

        for (int i = 0; i < al.size(); i++) {

            if (al.get(i).equals("+")) {
                // operators do not enter the stack
                // Now I have to pop the first two operands from the stack
                secondOperand = Double.parseDouble(myStack.peek());
                myStack.pop();
                firstOperand = Double.parseDouble(myStack.peek());
                myStack.pop();

                result = firstOperand + secondOperand;
                myStack.push(String.valueOf(result));

            } else if (al.get(i).equals("-")) {
                secondOperand = Double.parseDouble(myStack.peek());
                myStack.pop();
                firstOperand = Double.parseDouble(myStack.peek());
                myStack.pop();

                result = firstOperand - secondOperand;
                myStack.push(String.valueOf(result));

            } else if (al.get(i).equals("*")) {
                secondOperand = Double.parseDouble(myStack.peek());
                myStack.pop();
                firstOperand = Double.parseDouble(myStack.peek());
                myStack.pop();

                result = firstOperand * secondOperand;
                myStack.push(String.valueOf(result));

            } else if (al.get(i).equals("/")) {
                secondOperand = Double.parseDouble(myStack.peek());
                myStack.pop();
                firstOperand = Double.parseDouble(myStack.peek());
                myStack.pop();

                result = firstOperand / secondOperand;
                myStack.push(String.valueOf(result));

            } else {

                myStack.push(al.get(i));
            }

        }// end for loop

        result = Double.parseDouble(myStack.peek());
        return result;

    }

}
