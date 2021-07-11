/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midexam;

import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class QuestionThree {

    private static boolean checkCorrespondence(Stack<Character> st, char close) {

        if (st.isEmpty()) {
            return false;
        }

        char open = st.peek();
        
        if (close == ')' && open == '(') {
            st.pop();
            return true;

        } else if (close == ']' && open == '[') {
            st.pop();
            return true;
        } else if (close == '}' && open == '{') {
            st.pop();
            return true;
        }

        return false;

    }

    public static boolean isBalancedParenthesis(String expression) {

        boolean flag = false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char currentChar = expression.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                st.push(currentChar);
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                flag = checkCorrespondence(st, currentChar);

                if (flag == false) {
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }// end for

        if (flag == true && !st.isEmpty()) {
            flag = false;
        }

        return flag;

    }// end method

    public static void main(String[] args) {

        String str1 = "({[]})}";//true
        String str2 = "(({[]})";//false
        String str3 = "{}[()]";//true
        String str4 = "({[(]))}";//false

        System.out.println(isBalancedParenthesis(str1));

    }
}
