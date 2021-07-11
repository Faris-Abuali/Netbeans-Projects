package stackapplications;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class CheckValidity {

    private static MyStack<String> s = new MyStack<>();

    private static boolean arePairs(String open, String close) {

        if (open.charAt(0) == '(' && close.charAt(0) == ')' || open.charAt(0) == '{' && close.charAt(0) == '}'
                || open.charAt(0) == '[' && close.charAt(0) == ']') {
            return true;
        }

        return false;

    }

    public static boolean isValid(String expression) {

        
        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if(i==0 && isOperator(ch) || i==expression.length()-1 && isOperator(ch))
                return false;
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch + "");
            } else if (ch == ')' || ch == '}' || ch == ']') {

                //System.out.println("yes it is close");
                if (s.isEmpty() || !arePairs(s.getPeek(), ch + "")) {
                    return false;

                }

                s.pop();
            }
            else if(!Character.isDigit(ch) && !Character.isLetter(ch) && !isOperator(ch)){
                return false;
            }
            else if(consecutiveOperators(expression)){
                return false;
            }
           

        }

        return s.isEmpty();
    }//end method

    
    private static boolean consecutiveOperators(String expression){
        
        for(int i=0;i<expression.length()-1;i++){
            
            char ch1= expression.charAt(i);
            char ch2=expression.charAt(i+1);
            
            if(isOperator(ch1) && isOperator(ch2))
                return true;
        }
        
        return false;
    }
    private static boolean isOperator(char ch){
        
        if(ch!='*'&& ch!='/' && ch!='+' && ch!='-')
            return false;
        
        return true;
        
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an expression: ");
        String expression = sc.next();

        System.out.println(CheckValidity.isValid(expression));

    }
}
