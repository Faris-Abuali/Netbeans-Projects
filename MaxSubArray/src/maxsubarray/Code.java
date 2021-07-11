package maxsubarray;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Code {

    public static boolean isEquivalent(String str1, String str2) {

//        if (str1.equals(str2)) {
//            return true;
//        }
        if (str1.length() <= 1) {
            return false;
        }

        int mid = str1.length() / 2;

        String str1Low = str1.substring(0, mid);
        String str1High = str1.substring(mid, str1.length());

        String str2Low = str2.substring(0, mid);
        String str2High = str2.substring(mid, str2.length());

        if ((str1Low.equals(str2Low) && str1High.equals(str2High)) || (str1Low.equals(str2High) && str1High.equals(str2Low))) {
            return true;
        } //=============================================================================
        else if (isEquivalent(str1Low, str2Low) && isEquivalent(str1High, str2High)) {
            return true;
        } else if (isEquivalent(str1Low, str2High) && isEquivalent(str1High, str2Low)) {
            return true;
        } else {
            return false;
        }

    }// end method

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        if (str1.equals(str2)) {
            System.out.println("YES");
        } 
        
        else {
            
            if (isEquivalent(str1, str2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }// end main
}// end class
