package Scientific_Calculate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class InfixToPostfix {

    Stack<Character> myStack = new Stack();// this stack is dedicated for operators not operands

    public ArrayList<String> infixToPostfix(String exp) {

        ArrayList<String> a = new ArrayList<>(20);

        char ch, stackPeek;
        StringBuilder postExp = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {

            ch = exp.charAt(i);

            if (ch == '(') {

                if (postExp.length() > 0) {
                    a.add(String.valueOf(postExp));
                    postExp = new StringBuilder();
                }

                myStack.push(ch);
            } else if (ch == ')') {

                 if (postExp.length() > 0) {
                    a.add(String.valueOf(postExp));
                    postExp = new StringBuilder();
                }

                stackPeek = myStack.peek();

                while (stackPeek != '(') {

                    //postExp.append(myStack.peek());
                    a.add(String.valueOf(stackPeek));
                    myStack.pop();

                    stackPeek = myStack.peek();

                }
                myStack.pop(); // pop the '('

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                if (postExp.length() > 0) {
                    a.add(String.valueOf(postExp));
                    postExp = new StringBuilder();
                }
                
                if (myStack.empty()) {
                    myStack.push(ch);
                } else {
                    // Operator of lower priority cannot enter the stack unless all the operators of higher priority pop out.
                    // Moreover, no two operators of the same priority can stay together in the stack

                    stackPeek = myStack.peek();

                    while (((ch == '+' || ch == '-') && stackPeek != '(')
                            || ((ch == '*' || ch == '/') && (stackPeek == '*' || stackPeek == '/'))) {

                        //postExp.append(stackPeek);
                        a.add(String.valueOf(stackPeek));

                        myStack.pop();

                        if (myStack.empty()) {
                            break;
                        }

                        stackPeek = myStack.peek();

                    }

                    myStack.push(ch);
                }

            } else { // if ch is nither '(' nor ')' nor an operator '+ - * /', then ch is an operand(digit) and operands
                //are not allowed to enter the stack. The stack is only for operators
                postExp.append(ch);
            }
        }// end for loop

        // now after we've traversed all the string expression, we have only to check wheter there're stil operators in the stack
        // if so, pop them all out
        
        
         if(postExp.length()>0)
            a.add(String.valueOf(postExp));
         
        while (!myStack.empty()) {

            a.add(String.valueOf(myStack.peek()));
            
            myStack.pop();
        }

        return a;
    }

}
