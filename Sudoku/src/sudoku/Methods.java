package sudoku;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Methods {

    public static int[] clear(int[] a) {
        a = new int[0];
        return a;
    }

    public static int sumOfArrayElements(int[] a) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;

    }

    public static boolean isUnique(int[] a, int value) {

        Arrays.sort(a);
        if (Arrays.binarySearch(a, value) >= 0) {
            return false;
        }
        return true;

    }

    public static int[] addIfUnique(int[] a, int value) {

        if (!isUnique(a, value)) {
            return a;
        }

        a = Arrays.copyOfRange(a, 0, a.length + 1);
        a[a.length - 1] = value;

        return a;
    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 4};

        System.out.println(Arrays.toString(a));

    }
}
