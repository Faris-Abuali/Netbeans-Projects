package recursionjanuary20;

/**
 *
 * @author Fares Abu Ali
 */
public class RecursionJanuary20 {

    /**
     * @param args the command line arguments
     */
    
    
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

    public static String swap(String str, int i, int j) {

        char[] ar = str.toCharArray();

        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

        return new String(ar);
    }// end method

    public static void main(String[] args) {

        permu("Fares");
        
        
        

    }// end main

}// end class
