package stackapplications;

import java.util.Arrays;
import static stackapplications.InfixToPostfix.allTwoStacksContent;

/**
 *
 * @author Fares Abu Ali
 */
public class InfixToPrefix {

    public static StringBuilder allTwoStacksContent = new StringBuilder("");

// this class uses one stack only. The operators stack
    //Procedure:-
    //1. receive the infix expression (input) and reverse it. Notice that '(' converts to ')' and vice versa
    //2. Now work on the same algorithm used in the (infixToPostfix) class, just make one change:
    // the change is that: operatoes of the same priority can stay together in the stack
    //3. now just take the output and reverse it, the result is the prefix expression
    String input;
    StringBuilder output;
    MyStack<String> operatorsStack;

    public InfixToPrefix(String input) {
        this.input = input;

        output = new StringBuilder("");

        operatorsStack = new MyStack<>();
    }

    public String convertToPrefix() {

        input = insertBlanks();

        String[] tokens = input.split(" ");

        input = reverseInput(tokens); // first, reverse the original expression, with '(' becomes ')' and vice versa

        for (int i = 0; i < input.length(); i++) {

            String ch = input.charAt(i) + "";

            switch (ch) {

                case "+":
                case "-":
                    output.append(" ");
                    checkAndPrepareOperatorsStack(ch, 1);
                    break;

                case "*":
                case "/":
                    output.append(" ");
                    checkAndPrepareOperatorsStack(ch, 2);
                    break;

                case "(":
                    operatorsStack.push("(");
                    break;

                case ")":
                    checkAndPrepareOperatorsStack(ch, 0);
                    break;

                default: // then "ch" is an operand
                    output.append(ch);

            }

            allTwoStacksContent.append("\nPass #" + i + "\n");
            allTwoStacksContent.append("Opertors Stack:\n" + operatorsStack + "\n");

        }

        while (!operatorsStack.isEmpty()) {

            output.append(" ");

            output.append(operatorsStack.pop());
        }
        allTwoStacksContent.append("Opertors Stack:\n" + operatorsStack + "\n");

        String[] finalResult = output.toString().split(" ");

        String str = reverseOutput(finalResult);

        output = new StringBuilder(str);

        return output.toString();
    }// end method convert

    public void checkAndPrepareOperatorsStack(String ch, int precedence) {

        if (precedence == 1) {

            while (!operatorsStack.isEmpty()
                    && (operatorsStack.getPeek().equals("*") || operatorsStack.getPeek().equals("/"))) {

                output.append(operatorsStack.pop());
                output.append(" ");
            }
            operatorsStack.push(ch);
        } else if (precedence == 2) {

            operatorsStack.push(ch);

        } else if (precedence == 0) {

            while (!operatorsStack.getPeek().equals("(")) {

                output.append(" ");
                output.append(operatorsStack.pop());

            }

            operatorsStack.pop(); // pop the "("
        }

    }

    public String insertBlanks() {

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == '(' || ch == ')' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                res.append(" " + ch + " ");
            } else if (Character.isDigit(ch) || Character.isLetter(ch)) {
                res.append(ch);
            }

        }

        if (res.charAt(0) == ' ') {
            res = res.deleteCharAt(0);
        }

        return res.toString();
    }

    public String reverseInput(String[] tokens) {

        // the input is in infix form, so we must pay attention to '(' and ')' 
        String[] temp = new String[tokens.length];

        for (int i = temp.length - 1; i >= 0; i--) {

            if (tokens[i].equals("(")) {
                temp[temp.length - i - 1] = ")";
            } else if (tokens[i].equals(")")) {
                temp[temp.length - i - 1] = "(";
            } else {
                temp[temp.length - i - 1] = tokens[i];
            }
        }

        String res = "";
        for (int i = 0; i < temp.length; i++) {
            res += temp[i];
        }

        return res;

    }

    public String reverseOutput(String[] tokens) {
        // the input is in infix form, so we must pay attention to '(' and ')' 
        String[] temp = new String[tokens.length];

        for (int i = temp.length - 1; i >= 0; i--) {

            if (tokens[i].equals("(")) {
                temp[temp.length - i - 1] = ")";
            } else if (tokens[i].equals(")")) {
                temp[temp.length - i - 1] = "(";
            } else {
                temp[temp.length - i - 1] = tokens[i];
            }
        }

        String res = "";
        for (int i = 0; i < temp.length; i++) {
            res += temp[i] + " ";
        }

        return res;
    }
}
