package stackapplications;

import static stackapplications.InfixToPrefixTwoStacks.allTwoStacksContent;

/**
 *
 * @author Fares Abu Ali
 */
public class InfixToPostfix {

    public static StringBuilder allTwoStacksContent = new StringBuilder("");

    String input;
    StringBuilder output;

    MyStack<String> operatorsStack;

    public InfixToPostfix(String input) {

        this.input = input;

        output = new StringBuilder("");

        operatorsStack = new MyStack<>();
    }

    public String converToPostfix() {

        input = deleteUnnecessaryBlanks();

               
        
        for (int i = 0; i < input.length(); i++) {

            String ch = input.charAt(i) + "";

            switch (ch) {

                case "+":
                case "-":
                    output.append(" ");
                    CheckThenAddToOperatorsStack(ch, 1);
                    break;

                case "*":
                case "/":
                    output.append(" ");
                    CheckThenAddToOperatorsStack(ch, 2);
                    break;

                case "(":
                    operatorsStack.push("(");
                    break;

                case ")":
                    CheckThenAddToOperatorsStack(ch, 0);
                    break;

                default: // then the ch is an operand so will not enter the operatorsStack
                    output.append(ch);
            }

            allTwoStacksContent.append("\nPass #" + i + "\n");
            allTwoStacksContent.append("Opertors Stack:\n" + operatorsStack + "\n");

        }// end for

        while (!operatorsStack.isEmpty()) {
            output.append(" ");

            output.append(operatorsStack.pop());

        }

        allTwoStacksContent.append("\nLast Pass\n");
        allTwoStacksContent.append("\n" + operatorsStack + "\n");

        
        //System.out.println("Now : "+allTwoStacksContent);
        return output.toString();
    }

    public void CheckThenAddToOperatorsStack(String ch, int precedence) {

        // this method checks and prepares the stack for the entrance of the new operator "ch"
        // Operators of the lower priority cannot enter the stack unless the operators of the higher priority pop out from it
        // Moreover, no two operators of the same priority can stay together in the stack
        if (precedence == 1) {

            while (!operatorsStack.isEmpty()
                    && (operatorsStack.getPeek().equals("*")
                    || operatorsStack.getPeek().equals("/")
                    || operatorsStack.getPeek().charAt(0) == '+'
                    || operatorsStack.getPeek().charAt(0) == '-')) {

                output.append(operatorsStack.pop());
                output.append(" ");

            }

            operatorsStack.push(ch);
        } else if (precedence == 2) {

            while (!operatorsStack.isEmpty()
                    && (operatorsStack.getPeek().equals("*") || operatorsStack.getPeek().equals("/"))) {
                output.append(operatorsStack.pop());
                output.append(" ");

            }

            operatorsStack.push(ch);

        } else if (precedence == 0) {

            while (!operatorsStack.getPeek().equals("(")) {
                output.append(" ");

                output.append(operatorsStack.pop());

            }

            operatorsStack.pop();  // pop the '(' 
        }
    }

    public String deleteUnnecessaryBlanks() {

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || Character.isDigit(ch) || Character.isLetter(ch)
                    || ch == '(' || ch == ')') {
                res.append(ch);
            }

        }
        return res.toString();
    }

}// end class
