package logic_circuits_design;

/**
 *
 * @author Fares Abu Ali
 */
public class LogicCircuitsDesign {

    public static String diminished_radix_complement(String str, int radix) {

        radix = radix - 1; // because it is (r-1)'s complement

        char[] ar = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {

            int n = (int) (str.charAt(i) - '0');

            n = radix - n;

            n = n + '0';

            ar[i] = (char) (n);

        }

        return new String(ar);

    }// end method

    public static String radix_complement(String str, int radix) {

        int r = radix - 1; // because it is (r-1)'s complement

        /*
         can be formed by leaving all least significant 0’s unchanged, subtracting the first nonzero least significant digit 
        from (radix), and subtracting all higher significant digits from (radix-1).
  
         */
        boolean firstNonzeroLSDFound = false; // LSD = Least Significant Digit

        char[] ar = str.toCharArray();

        for (int i = str.length() - 1; i >= 0; i--) {

            if (ar[i] == '0' && !firstNonzeroLSDFound) {
                continue;//leaving all least significant 0’s unchanged
            } else if (ar[i] != '0' && !firstNonzeroLSDFound) {

                firstNonzeroLSDFound = true;

                int n = (radix - Integer.parseInt(ar[i] + ""));
                n += '0';

                ar[i] = (char) n;
            } else {

                int n = (r - Integer.parseInt(ar[i] + ""));
                n += '0';

                ar[i] = (char) n;
            }

        }

        return new String(ar);

    }// end method

    public static String OnesComplement(String bitString) {

        char[] ch = bitString.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') {
                ch[i] = '1';
            } else {
                ch[i] = '0';
            }
        }

        return new String(ch);

    }// end method

    public static String twosComplement(String bitString) {

        boolean firstNonzeroLSDFound = false; // LSD = Least Significant Digit

        char[] ar = bitString.toCharArray();

        for (int i = bitString.length() - 1; i >= 0; i--) {

            if (ar[i] == '0' && !firstNonzeroLSDFound) {
                continue;//leaving all least significant 0’s unchanged
            } else if (ar[i] != '0' && !firstNonzeroLSDFound) {
                firstNonzeroLSDFound = true;
            } else {

                if (ar[i] == '0') {
                    ar[i] = '1';
                } else {
                    ar[i] = '0';
                }
            }

        }

        return new String(ar);

    }// end method

    
    
    public int[] divANDmod(int a,int d){
        
        // d: is the divisor, must be positive
        // a: is the dividened, integer
        
        int q=0; // quotient
        int r = Math.abs(a);
        
        while(r>=d){
            r=r-d;
            q++;
        }
        
        if(a<0 && r>0){
            r=d-r;
            q = -(q+1);
        }
        
        
        
        int[] ar = new int[2];
        
        ar[0]=q;
        ar[1]=r;
        
        return ar;
    }// end method
    public static void main(String[] args) {

        System.out.println(OnesComplement("10110100"));
        System.out.println(diminished_radix_complement("10110100", 2));
        
          System.out.println(twosComplement("10110100"));
        System.out.println(radix_complement("10110100", 2));


        //System.out.println(diminished_radix_complement("2389", 10));
        // System.out.println(radix_complement("246700", 10));
        //System.out.println(radix_complement("012398", 10));
    }// end main

}// end class
