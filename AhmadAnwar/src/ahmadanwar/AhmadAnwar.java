package ahmadanwar;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class AhmadAnwar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of Array#1:");
        int size1 = sc.nextInt();

        int[] ar1 = new int[size1];/*{1, 2, 3};*/
        for (int i = 0; i < size1; i++) {
            ar1[i] = sc.nextInt();
        }

        System.out.println("Enter the Size of Array#2:");
        int size2 = sc.nextInt();

        int[] ar2 = new int[size2];/*{2, 3, 6};*/

        for (int i = 0; i < size2; i++) {
            ar2[i] = sc.nextInt();
        }

        
        
        
        
        int[] x = new int[size2];

        int toIndex = 1;

        while (toIndex <= ar1.length) {

            for (int i = 0; i < toIndex; i++) {

                x[i] = ar2[i];

            }

            // System.out.println(Arrays.toString(x));
            x = reverse(x, 0, toIndex - 1);

            //System.out.println(Arrays.toString(x));
            int result = sumOfProductOfTwoMatrices(ar1, x);

            System.out.println("\nX" + toIndex + "=" + result);

            toIndex++;
        }// end while

    }

    public static int[] reverse(int[] x, int lowPtr, int highPtr) {

        while (lowPtr < highPtr) {
            int temp = x[lowPtr];
            x[lowPtr] = x[highPtr];
            x[highPtr] = temp;

            lowPtr++;
            highPtr--;
        }
        return x;
    }

    public static int sumOfProductOfTwoMatrices(int[] ar1, int[] x) {

        int sum = 0;

        for (int i = 0; i < ar1.length; i++) {
            sum += ar1[i] * x[i];
        }
        return sum;

    }

}
