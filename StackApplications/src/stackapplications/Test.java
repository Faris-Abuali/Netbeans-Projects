package stackapplications;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {
        
        System.out.println(-13%4);
        
        
        
        new Visual().setVisible(true);
        
        
       // InfixToPostfix i = new InfixToPostfix("105/2     1+  4");
       // i.converToPostfix();
//(  1+ 3   *3   -2)*(1   2/6*5)
//        File f = new File("expression.txt");
//
//        StringBuilder strB = new StringBuilder("");
//        try {
//            Scanner sc = new Scanner(f);
//
//            while (sc.hasNext()) {
//                strB.append(sc.next());
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex);
//        }
//
//        String[] ar = new String[1];
//        ar[0] = strB.toString();
//
//        EvaluateExpression.main(ar);

//Examples:
// 31+4-12/6*13  -->  31 4 + 12 6 / 13 * -
// a-b+c*d       -->   a b - c d * +
//a+c-h/b*r --> a c + h b / r * -
//a+(c-h)/(b*r) --> a c h - b r * / +
//(A+B/C*(D+E)-F) --> A B C / D E + * + F -
// (1+9/3*(4+5)-6)  --> 1 9 3 / 4 5 + * + 6 -
//        InfixToPostfix obj = new InfixToPostfix("(A+B/C*(D+E)-F)");
//
//       String postfixExp = obj.converToPostfix();
//
//       
//        System.out.println(postfixExp);
//        
//        
//        String[] ar = postfixExp.split(" ");
//
//        System.out.println(Arrays.toString(ar));
//        InfixToPostfix obj0 = new InfixToPostfix("a*(c-b)");
//        InfixToPrefix obj1 = new InfixToPrefix("a*(c-b)");
//
//        // System.out.println(obj1.reverseExpression());//d*(b/h)-c+a
//        
//        
//        System.out.println("Infix Expression: 31+4-12/6*13");
//        
//        System.out.println("Postfix Expression: "+obj0.converToPostfix());
//        System.out.println("Prefix Expression: "+obj1.convertToPrefix());
//        InfixToPrefix o1 = new InfixToPrefix("31+    4-12/6*13");
//        System.out.println(o1.convertToPrefix());
//
//         InfixToPrefixTwoStacks o2= new InfixToPrefixTwoStacks("31+    4-12/6*13");
//        System.out.println(o2.convertToPrefix());
//        


//
//        InfixToPrefixTwoStacks f = new InfixToPrefixTwoStacks("11+    90   /3*   (4+   5    )-6");
////
//        // InfixToPrefix obj = new InfixToPrefix("(11+    90   /3*   (4+   5    )-6)");
//
//        InfixToPostfix p = new InfixToPostfix("(11+    90   /3*   (4+   5    )-6)");
//       // System.out.println(f.convertToPrefix());
////
//        //System.out.println(obj.convertToPrefix());
//
//        System.out.println(p.converToPostfix());
    }

}
