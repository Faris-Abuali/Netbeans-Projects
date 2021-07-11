package fullfinalproject2ndsemester2019safarini;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class EncryptionAndDecryption {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter '0' to enter the encryption mode, or enter '1' to enter the decryption mode:  ");
        char input = sc.next().charAt(0);

        if (input == '0') {

            System.out.println("Please enter the text which you want to encrypt: ");
            String enteredText = sc.next();

            char[] encryptedText = new char[enteredText.length()];

            for (int i = 0; i < enteredText.length(); i++) {
                String str = Integer.toBinaryString(enteredText.charAt(i));
// first, convert the decimal int to binary 

                //System.out.println(Integer.toBinaryString('a')); //DecimalToBinary
//now shuffle between the first and the last halves of the binary string and combine them together
                String firstHalf = str.substring(0, str.length() / 2 + 1);
                String lastHalf = str.substring(str.length() / 2 + 1, str.length());
                String combined = lastHalf + firstHalf;

                //System.out.println(firstHalf);
                //System.out.println(lastHalf);
                //System.out.println(combined);
//now express this new binary string  as a decimal number
                int encryptedNumber = Integer.parseInt(combined, 2);
// now after working on the binary, it is the time to return the new binaty to its corresponding decimal form

                //System.out.println((char)incryptedNumber);
                encryptedText[i] = (char) encryptedNumber;
                //System.out.println((char)incryptedNumber);  

            }

            System.out.println("Your entered text will be after encryption: ");
            System.out.println(encryptedText);  // or Arrays.toString(encryptedText)
        } //*************************************Encryption Done*******************************
        // h.\>
        else if (input == '1') {
            System.out.println("Please enter the text which you want to decrypt: ");
            String enteredText = sc.next();
            char[] decryptedText = new char[enteredText.length()];

            for (int i = 0; i < enteredText.length(); i++) {

                int encryptedNumber = enteredText.charAt(i);
                String strIncrypted = Integer.toBinaryString(encryptedNumber);  //28--> 11100 NOT 0011100 unfortunately

                while (strIncrypted.length() < 7) {
                    strIncrypted = "0" + strIncrypted;
                    // if the string is 101110 for example ,this while loop will make it become 0101110
                }
// now 28-> 0011100
                // System.out.println(strIncrypted);

                String firstHalfIncrypted = strIncrypted.substring(0, strIncrypted.length() / 2);
                String lastHalfIncrypted = strIncrypted.substring(strIncrypted.length() / 2, strIncrypted.length());
                String original = lastHalfIncrypted + firstHalfIncrypted;

                int originalDecimal = Integer.parseInt(original, 2);

                decryptedText[i] = (char) originalDecimal;
            }

            System.out.print("so the original text is :");
            System.out.println(decryptedText);
        }

//*************************************Decryption Done*******************************        
        //EndOfmain
    }
    //EndOfClass
}