package dynamicprog;

/**
 *
 * @author Fares Abu Ali
 */
public class DynamicProg {

    static int x;
    int var_l;
    int l_var;
    
   
    public static void getDecimal(String str, int n) {

        if (str.length() == n) {
            System.out.println(str);
        } 
        else {
            getDecimal(str + "0", n);
            getDecimal(str + "1", n);
            getDecimal(str + "2", n);
            getDecimal(str + "3", n);
            getDecimal(str + "4", n);
            getDecimal(str + "5", n);
            getDecimal(str + "6", n);
            getDecimal(str + "7", n);
            getDecimal(str + "8", n);
            getDecimal(str + "9", n);
        }

    }// end method

    public static void getBinary(String str, int n) {

        if (str.length() == n) {
            System.out.println(str);
        } 
        else {
            getBinary(str + "0", n);
            getBinary(str + "1", n);
        }

    }// end method

    public static void main(String[] args) {

        
        System.out.println(DynamicProg.x);
       // getBinary("", 25);
       
      // byte x=(byte) 300;
       //
        //System.out.println(x);
        
       // getDecimal("", 2);
    }

}// end class
