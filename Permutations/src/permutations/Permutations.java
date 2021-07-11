package permutations;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Permutations {

    public static void permu(String str) {
        permu(str, 0, str.length() - 1);

    }

    private static void permu(String str, int low, int high) { // O(n!)

        if (low == high) {
            System.out.println(str);
        } else {

            for (int i = low; i <= high; i++) {

                str = swap(str, i, low);
                permu(str, low + 1, high);
                str = swap(str, i, low);

            }// end for

        }
    }// end method 

    private static void printPermutationsIterative(String string) {
        int[] factorials = new int[string.length() + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length(); i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation = "";
            String temp = string;
            int positionCode = i;
            
            for (int position = string.length(); position > 0; position--) {
                int selected = positionCode / factorials[position - 1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position - 1];
                temp = temp.substring(0, selected) + temp.substring(selected + 1);
            }
            System.out.println(onePermutation);
        }
    }

    public static String swap(String str, int i, int j) {

        char[] ar = str.toCharArray();

        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

        return new String(ar);
    }// end method

    public static void main(String[] args) {

        String temp ="FRS";
        
         

          permu("FRS");
          System.out.println("=====================");
         printPermutationsIterative("FRS");
        //permu("FARES");
    }// end main

}// end class
