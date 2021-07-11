package numberconverter;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class IntegerRepresentation {

    //=================================================== From Decimal ============================================
    public static String fromDecimalToBinary(String str) {

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            int n = Integer.parseInt(ar[0]);

            Stack<Integer> st = new Stack<>();

            while (n > 0) {

                st.push(n % 2);

                n /= 2;

            }

            while (!st.isEmpty()) {
                builder.append(st.pop());
            }

        }
        //===================================================
        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            ar[1] = "0." + ar[1];
            Double fraction = Double.parseDouble(ar[1]);
            //System.out.println(fraction);

            Queue<Integer> q = new LinkedList<>();

            while (fraction.doubleValue() != fraction.intValue()) {
                // method of successive multiplication by 2 . Take the integer value as a (carry) and multiply the fraction by 2
                // repeat the process until you get 1.0 

                fraction *= 2;

                q.add(fraction.intValue());

                if (fraction > 1) {
                    fraction -= 1;
                }

            }

            builder.append(".");

            while (!q.isEmpty()) {
                builder.append(q.poll());
            }
        }

        //===================================================
        //System.out.println(builder);
        return builder.toString();
    }

    public static String fromDecimalToOctal(String str) {

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            int n = Integer.parseInt(ar[0]);

            Stack<Integer> st = new Stack<>();

            while (n > 0) {

                st.push(n % 8);

                n /= 8;

            }

            while (!st.isEmpty()) {
                builder.append(st.pop());
            }

        }
        //===================================================
        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            ar[1] = "0." + ar[1];
            Double fraction = Double.parseDouble(ar[1]);
            //System.out.println(fraction);

            Queue<Integer> q = new LinkedList<>();

            while (fraction.doubleValue() != fraction.intValue()) {
                // method of successive multiplication by 2 . Take the integer value as a (carry) and multiply the fraction by 2
                // repeat the process until you get 1.0 

                fraction *= 8;

                q.add(fraction.intValue());

                fraction -= fraction.intValue();

            }

            builder.append(".");

            while (!q.isEmpty()) {
                builder.append(q.poll());
            }
        }

        //===================================================
        // System.out.println(builder);
        return builder.toString();
    }

    public static String fromDecimalToHexa(String str) {

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            int n = Integer.parseInt(ar[0]);

            Stack<String> st = new Stack<>();

            while (n > 0) {

                int remainder = n % 16;

                if (remainder > 9) {

                    st.push(String.valueOf((char) (remainder + 'A' - 10)));
                } else {
                    st.push(String.valueOf(remainder));
                }

                n /= 16;

            }

            while (!st.isEmpty()) {
                builder.append(st.pop());
            }

        }
        //===================================================
        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            ar[1] = "0." + ar[1];
            Double fraction = Double.parseDouble(ar[1]);
            //System.out.println(fraction);

            Queue<String> q = new LinkedList<>();

            while (fraction.doubleValue() != fraction.intValue()) {
                // method of successive multiplication by 2 . Take the integer value as a (carry) and multiply the fraction by 2
                // repeat the process until you get 1.0 

                fraction *= 16;

                int carry = fraction.intValue();

                if (carry > 9) {
                    q.add(String.valueOf((char) (carry + 'A' - 10)));
                } else {
                    q.add(String.valueOf(carry));
                }

                fraction -= fraction.intValue();

            }

            builder.append(".");

            while (!q.isEmpty()) {
                builder.append(q.poll());
            }
        }

        //===================================================
        System.out.println(builder);

        return builder.toString();
    }

    //=================================================== To Decimal ============================================
    public static String fromBinaryToDecimal(String str) {

        //--------- get rid of zeros on the left ( HAS NO VALUE )
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '0') {
                str = str.substring(i);
                break;
            }
        }
        //---------------------------------------

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        //System.out.println(Arrays.toString(ar));
        String[] result = new String[ar.length];

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            Stack<Integer> st = new Stack<>();

            int numOfShifts = 0;

            for (int i = ar[0].length() - 1; i >= 0; i--) {

                int bit = Integer.parseInt(ar[0].charAt(i) + "");

                if (bit == 1) {
                    st.push(1 << numOfShifts);
                }

                numOfShifts++;
            }

            int sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }

            //System.out.println(sum);
            result[0] = sum + "";
            builder.append(sum);

        }// end if

        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            Stack<Float> st = new Stack<>();

            int numOfShifts = -1;

            for (int i = 0; i < ar[1].length(); i++) {

                int bit = Integer.parseInt(ar[1].charAt(i) + "");

                if (bit == 1) {
                    st.push((float) (Math.pow(2, numOfShifts)));
                }

                numOfShifts--;
            }

            float sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }
            //System.out.println(sum);

            result[1] = sum + "";

            sum = Integer.parseInt(result[0]) + Float.parseFloat(result[1]);
            builder = new StringBuilder(sum + "");

        }

        return builder.toString();
    }// end method

   public static String fromOctalToDecimal(String str) {

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        String[] result = new String[ar.length];

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            Stack<Integer> st = new Stack<>();

            int numOfShifts = 0;

            for (int i = ar[0].length() - 1; i >= 0; i--) {

                int n = Integer.parseInt(ar[0].charAt(i) + "");

                st.push((int) (n * Math.pow(8, numOfShifts)));

                numOfShifts++;
            }

            int sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }

            //System.out.println(sum);
            result[0] = sum + "";
            //builder.append(sum);
            
            builder.append(result[0]);
            
        }// end if

        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            Stack<Double> st = new Stack<>();

            int numOfShifts = -1;

            for (int i = 0; i < ar[1].length(); i++) {

                int n = Integer.parseInt(ar[1].charAt(i) + "");

                st.push((double) (n * Math.pow(8, numOfShifts)));

                numOfShifts--;
            }

            double sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }
            //System.out.println(sum);

            result[1] = sum + "";

            sum = Integer.parseInt(result[0]) + Double.parseDouble(result[1]);
            
            builder=new StringBuilder(sum+"");

        }

        return builder.toString();
    }// end method

    public static String fromHexaToDecimal(String str) {

        String[] ar = str.split("[.]"); // separate the integer(left side of the decimal part)
        // from the fraction (right side of the decimal part)  (if there exists a fraction)

        String[] result = new String[ar.length];

        //System.out.println(Arrays.toString(ar));
        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            Stack<Integer> st = new Stack<>();

            int numOfShifts = 0;

            for (int i = ar[0].length() - 1; i >= 0; i--) {

                char ch = ar[0].charAt(i);
                int n = 0;

                if (Character.isLetter(ch)) {
                    ch = Character.toUpperCase(ch);
                    n = ch - 'A' + 10;
                } else {
                    n = Integer.parseInt(ar[0].charAt(i) + "");

                }

                st.push((int) (n * Math.pow(16, numOfShifts)));

                numOfShifts++;
            }

            int sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }

            //System.out.println(sum);
            result[0] = sum + "";
            builder.append(sum);

        }// end if

        if (ar.length > 1) {
            // then there's a fraction (numbers on the right side of the decimal point)

            Stack<Double> st = new Stack<>();

            int numOfShifts = -1;

            for (int i = 0; i < ar[1].length(); i++) {

                char ch = ar[1].charAt(i);
                int n = 0;

                if (Character.isLetter(ch)) {
                    ch = Character.toUpperCase(ch);
                    n = ch - 'A' + 10;
                } else {
                    n = Integer.parseInt(ar[1].charAt(i) + "");

                }

                st.push((double) (n * Math.pow(16, numOfShifts)));

                numOfShifts--;
            }

            double sum = 0;

            while (!st.isEmpty()) {
                sum += st.pop();
            }
            // System.out.println(sum);

            result[1] = sum + "";

            sum = Integer.parseInt(result[0]) + Double.parseDouble(result[1]);

            builder=new StringBuilder(sum+"");

        }

        return builder.toString();
    }// end method

    //======================================================================================================
    public static String fromBinaryToOctal(String str) {

        //--------- get rid of zeros on the left ( HAS NO VALUE )
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '0') {
                str = str.substring(i);
                break;
            }
        }
        //---------------------------------------

        String[] ar = str.split("[.]");

        // System.out.println(Arrays.toString(ar));
        Map<String, Integer> map = new HashMap<>();//binaryOfThreeBitsToDecimal

        map.put("000", 0);
        map.put("001", 1);
        map.put("010", 2);
        map.put("011", 3);
        map.put("100", 4);
        map.put("101", 5);
        map.put("110", 6);
        map.put("111", 7);

        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            while (ar[0].length() % 3 != 0) {
                ar[0] = "0" + ar[0];
            }

            for (int i = ar[0].length() - 1; i >= 0; i -= 3) {

                String threeBits = ar[0].charAt(i - 2) + "" + ar[0].charAt(i - 1) + "" + ar[0].charAt(i);

                builder.append(map.get(threeBits));

            }

            builder = builder.reverse();

            //System.out.println(builder);
        }

        if (ar.length > 1) {// then there's a fraction

            builder.append(".");

            while (ar[1].length() % 3 != 0) {
                ar[1] += "0";
            }

            for (int i = 0; i < ar[1].length(); i += 3) {

                String threeBits = ar[1].charAt(i) + "" + ar[1].charAt(i + 1) + "" + ar[1].charAt(i + 2);

                builder.append(map.get(threeBits));

            }

        }

        return builder.toString();
    }// end method

    //======================================================================================================
    public static String fromBinaryToHexa(String str) {

        //--------- get rid of zeros on the left ( HAS NO VALUE )
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '0') {
                str = str.substring(i);
                break;
            }
        }
        //---------------------------------------

        String[] ar = str.split("[.]");

        // System.out.println(Arrays.toString(ar));
        Map<String, String> map = new HashMap<>();//binaryOfFourBitsToDecimal

        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");

        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            while (ar[0].length() % 4 != 0) {
                ar[0] = "0" + ar[0];
            }

            for (int i = ar[0].length() - 1; i >= 0; i -= 4) {

                String fourBits = ar[0].charAt(i - 3) + "" + ar[0].charAt(i - 2) + "" + ar[0].charAt(i - 1) + "" + ar[0].charAt(i);

                builder.append(map.get(fourBits));

            }

            builder = builder.reverse();

            //System.out.println(builder);
        }

        if (ar.length > 1) {// then there's a fraction

            builder.append(".");

            while (ar[1].length() % 4 != 0) {
                ar[1] += "0";
            }

            for (int i = 0; i < ar[1].length(); i += 4) {

                String fourBits = ar[1].charAt(i) + "" + ar[1].charAt(i + 1) + "" + ar[1].charAt(i + 2) + "" + ar[1].charAt(i + 3);

                builder.append(map.get(fourBits));

            }

        }
        return builder.toString();
    }// end method

    //======================================================================================================
    public static String fromOctalToBinary(String str) {

        Map<Integer, String> map = new HashMap<>();

        map.put(0, "000");
        map.put(1, "001");
        map.put(2, "010");
        map.put(3, "011");
        map.put(4, "100");
        map.put(5, "101");
        map.put(6, "110");
        map.put(7, "111");

        String[] ar = str.split("[.]");
        

        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            for (int i = 0; i < ar[0].length(); i++) {

                int octalNum = Integer.parseInt(ar[0].charAt(i) + "");

                builder.append(map.get(octalNum));
            }

            // System.out.println(builder);
        }

        if (ar.length > 1) {
            // then there's a fraction

            builder.append(".");

            for (int i = 0; i < ar[1].length(); i++) {

                int octalNum = Integer.parseInt(ar[1].charAt(i) + "");

                builder.append(map.get(octalNum));
            }

        }

        return builder.toString();
    }// end method

    public static String fromHexaToBinary(String str) {

        Map<String, String> map = new HashMap<>();

        map.put("0", "0000");
        map.put("1", "0001");
        map.put("2", "0010");
        map.put("3", "0011");
        map.put("4", "0100");
        map.put("5", "0101");
        map.put("6", "0110");
        map.put("7", "0111");
        map.put("8", "1000");
        map.put("9", "1001");
        map.put("A", "1010");
        map.put("B", "1011");
        map.put("C", "1100");
        map.put("D", "1101");
        map.put("E", "1110");
        map.put("F", "1111");

        String[] ar = str.split("[.]");

        StringBuilder builder = new StringBuilder("");

        if (ar[0].length() > 0) {

            for (int i = 0; i < ar[0].length(); i++) {

                char ch = ar[0].charAt(i);

                if (Character.isLetter(ch)) {
                    ch = Character.toUpperCase(ch);

                    builder.append(map.get(ch + ""));

                } else {
                    int hexaNum = Integer.parseInt(ch + "");

                    builder.append(map.get(hexaNum + ""));

                }

            }

            // System.out.println(builder);
        }

        if (ar.length > 1) {
            // then ther's a fraction

            builder.append(".");

            for (int i = 0; i < ar[1].length(); i++) {

                char ch = ar[1].charAt(i);

                if (Character.isLetter(ch)) {
                    ch = Character.toUpperCase(ch);

                    builder.append(map.get(ch + ""));
                } else {
                    int hexaNum = Integer.parseInt(ch + "");

                    builder.append(map.get(hexaNum + ""));

                }
            }

        }

        return builder.toString();
    }// end method
    //======================================================================================================

    public static String fromHexaToOctal(String hexString) {

        String bitString = fromHexaToBinary(hexString);
        String octString = fromBinaryToOctal(bitString);

        return octString;

    }// end method

    public static String fromOctalToHexa(String octString) {

        String bitString = fromOctalToBinary(octString);
        String hexString = fromBinaryToHexa(bitString);

        return hexString;

    }// end method

    //======================================================================================================
    public static String add(String str1, String str2, boolean discardLastCarry) {

        while (str1.length() < str2.length()) {

            str1 = "0" + str1;
        }

        while (str2.length() < str1.length()) {

            str2 = "0" + str2;
        }

        //-------------------------------
        while (str1.length() < 8) {

            str1 = "0" + str1;
        }

        while (str2.length() < 8) {

            str2 = "0" + str2;
        }
        //-------------------------------

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        StringBuilder builder = new StringBuilder("");

        int carry = 0;

        for (int i = str1.length() - 1; i >= 0; i--) {

            int i1, i2;

            i1 = c1[i] - '0';
            i2 = c2[i] - '0';

            int n = i1 + i2 + carry;

            if (n > 1) {
                carry = 1;
            } else {
                carry = 0;
            }

            n = n % 2;

            builder.append(n);

        }// end for

        if (discardLastCarry == false) {
            builder.append(carry); //  A carry out of the sign‐bit position is discarded.    :(
        }

        builder = builder.reverse();

        //System.out.println(builder);
        return builder.toString();
    }// end method

    public static String subtract(String minuend, String subtrahend) {

        // if the minuend is bigger than  the subtrahend, the result will be a positive number
        // but if the minuend is less than the subtrahend, the result will be a negative number, and will be written in
        // two's complement form 
        String subtrahendComplement = twosComplement(subtrahend);

        // System.out.println("2's Comp. of "+subtrahend+" is "+subtrahendComplement);
        String result = add(minuend, subtrahendComplement, true);

        return result;

    }// end method

//    public static String divide(String dividend,String divisor){
//        
//        
//        String subDividend = dividend.substring(0,divisor.length());
//        
//        if(Integer.parseInt( fromBinaryToDecimal(subDividend) ) <  Integer.parseInt( fromBinaryToDecimal(divisor) )){
//            
//            if(dividend.length()>=divisor.length()+1)
//            subDividend =  dividend.substring(0,divisor.length() + 1);
//        }
//        
//        
//        
//        
//    }// end method
    public static String multiply(String str1, String str2) {

        while (str1.length() < str2.length()) {

            str1 = "0" + str1;
        }

        while (str2.length() < str1.length()) {

            str2 = "0" + str2;
        }

        LinkedList<String> partialProducts = new LinkedList<>();

        //============================================
        char[] zeroArray = new char[str1.length()];

        String zeroString = "";
        for (int i = 0; i < zeroArray.length; i++) {
            zeroArray[i] = '0';
        }

        zeroString = new String(zeroArray);
        //============================================

        StringBuilder builder = new StringBuilder("");

        int numOfShifts = 0;

        for (int i = str2.length() - 1; i >= 0; i--) {

            int n = Integer.valueOf(str2.charAt(i) + "");

            if (n == 1) {

                String s = str1;

                int shifts = numOfShifts;

                while (shifts > 0) {
                    s += 0;

                    shifts--;
                }

                partialProducts.add(s);
            } else {
                partialProducts.add(zeroString);
            }

            numOfShifts++;
        }

        //System.out.println(partialProducts);
        //================= NOW SUM THE PARTIAL PRODUCTS TO GET THE FINAL RESULT ==============================
        while (partialProducts.size() > 1) {

            String s1 = partialProducts.removeFirst();
            String s2 = partialProducts.removeFirst();

            String sum = add(s1, s2, false);

            partialProducts.add(sum);
        }

        System.out.println(partialProducts);

        return partialProducts.getFirst();

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

        while (bitString.length() < 8) {
            bitString = "0" + bitString;
        }

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

    public static int[] divANDmod(int a, int d) {

        // d: is the divisor, must be positive
        // a: is the dividened, integer
        int q = 0; // quotient
        int r = Math.abs(a);

        while (r >= d) {
            r = r - d;
            q++;
        }

        if (a < 0 && r > 0) {
            r = d - r;
            q = -(q + 1);
        }

        int[] ar = new int[2];

        ar[0] = q;
        ar[1] = r;

        return ar;
    }// end method

    public static void main(String[] args) {

        // System.out.println(Arrays.toString("111.123".split("[.]")));
        //System.out.println(Arrays.toString("356.25".split("[.]")));
        // fromDecimalToBinary("356.6875");
        // fromDecimalToBinary("356.513");
        //fromDecimalToOctal("153.513");
        //fromDecimalToHexa("6784.513");
        //add("1110", "1011");
        //multiply("1110", "1011");
        // System.out.println( fromBinaryToDecimal("0110101.1101") );
        // System.out.println(fromDecimalToBinary("53.6875"));
       // System.out.println(fromOctalToDecimal("7016.254"));
        // System.out.println(fromHexaToDecimal("C42A.e0f"));
        //System.out.println(fromBinaryToOctal("010101100101.1001011101"));
        //System.out.println(fromBinaryToHexa("010101100101.1001011101"));
        //System.out.println(fromOctalToBinary("7351.124"));
        //System.out.println(fromHexaToBinary("f315.c2A"));
//        String oct = fromHexaToOctal("f315.C2a");
//        
//        System.out.println("oct = "+oct);
//        
//        String bin = fromOctalToBinary(oct);
//        
//        System.out.println("bin = "+bin);
        //System.out.println(add("11111010", "11110011",false));
        //  System.out.println(fromOctalToHexa("171425.6052"));
        // System.out.println(fromDecimalToBinary("77"));
        // System.out.println(fromDecimalToBinary("43"));
        //==========================================================
////1001101  = 77
////101011  = 43
////77 - 43 =  34
//        String s = subtract("1001101", "101011");
//
//        System.out.println(s);
//        System.out.println(fromBinaryToDecimal(s));
        //==========================================================
        // System.out.println(subtract("11011001","10101011"));
        //System.out.println(Arrays.toString(divANDmod(177147,5)));
        //System.out.println(fromDecimalToHexa("127.15"));
//                System.out.println(fromHexaToDecimal("7f.266"));
//                System.out.println(fromBinaryToOctal("1101.1101"));
//                
//                
//                System.out.println(fromOctalToDecimal("231.25"));
//
//                
//                System.out.println(fromDecimalToOctal("49.21875"));
//                
//                System.out.println(fromDecimalToBinary("185"));
//                
        //System.out.println(fromBinaryToDecimal("11000011"));
       // System.out.println(fromBinaryToOctal("0000000000000000110"));
        //System.out.println(fromBinaryToHexa("00110"));

        
       // System.out.println(fromOctalToBinary("31"));
       // System.out.println(fromOctalToDecimal("31"));
       
        System.out.println(fromHexaToBinary("AC"));
        

    }// end main

}// end class
