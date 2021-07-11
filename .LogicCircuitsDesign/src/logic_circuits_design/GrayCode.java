package logic_circuits_design;

/**
 *
 * @author Fares Abu Ali
 */
public class GrayCode {

    public static String fromBinaryToGrayCode(String str) {

        StringBuilder builder = new StringBuilder("");

        builder.append(str.charAt(0));

        for (int i = 0; i < str.length() - 1; i++) {

            int b0 = Integer.parseInt(str.charAt(i) + "");
            int b1 = Integer.parseInt(str.charAt(i + 1) + "");

            builder.append(b0 ^ b1);  // Xor

        }

        return builder.toString();

    }// end method

    public static String fromGrayCodeToBinary(String str) {

        StringBuilder builder = new StringBuilder("");

        builder.append(str.charAt(0));

        for (int i = 0; i < str.length() - 1; i++) {

            int b0 = Integer.parseInt(builder.charAt(i) + "");
            int b1 = Integer.parseInt(str.charAt(i + 1) + "");

            builder.append(b0 ^ b1);  // Xor

        }

        return builder.toString();

    }// end method

    public static void main(String[] args) {
        
        //        System.out.println(0 ^ 0);
        //        System.out.println(0 ^ 1);
        //        System.out.println(1 ^ 0);
        //        System.out.println(1 ^ 1);

        //  System.out.println(fromBinaryToGrayCode("11000110"));
        System.out.println(fromGrayCodeToBinary("11001101"));

    }

}// end class
