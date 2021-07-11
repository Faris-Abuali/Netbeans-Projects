package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class ShellSort {

//    public static void shellSort(int[] a) {
//
//        for (int gap = a.length / 2; gap > 0; gap /= 2) {
//
//            for (int i = gap; i < a.length; i++) {
//
//                int temp = a[i];
//
//                int j;
//                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
//                    a[j] = a[j - gap];
//                }
//
//                a[j] = temp;
//            }
//
//        }
//    }
    public static void shellSortAscending(int[] a) {

        int gap = a.length / 2;

        while (gap > 0) {

            //---------------------From here, it is exactly the same as the insertion sort algorithm :) 
            // the only change is to put replace every '1' you face with 'gap'   ( in insertionSort, gap was always 1)
            for (int i = gap; i < a.length; i++) {

                int currentElement = a[i];
                int rp = i - gap; // reversing pointer

                while (rp >= 0 && a[rp] > currentElement) {
                    a[rp + gap] = a[rp];
                    rp -= gap;
                }

                a[rp + gap] = currentElement;

            }
            //---------------------To here:) ---------------------------------------

            gap /= 2;
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{41, 62, 13, 84, 35, 96, 57, 28, 79};

        shellSortAscending(a);

        System.out.println(Arrays.toString(a));
    }

    //------------------------------------------------------------------------------------------------------------------------
    public static int[] generateRandomArray(int arraySize) {

        int[] a = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {

            // Generate a random array with values between
            // 10 and 59
            a[i] = (int) (Math.random() * 50) + 10;

        }

        return a;

    }// end generate

    public static void printHorzArray(int[] a, int i, int j, int h) {

        if (i == j) {
            i = i - h;
        }

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < a.length; n++) {

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < a.length; n++) {

            System.out.print("| " + a[n] + " ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        if (i != -1) {

            // Number of spaces to put before the F
            int spacesBeforeFront = 5 * i + 1;

            for (int k = 0; k < spacesBeforeFront; k++) {
                System.out.print(" ");
            }

            System.out.print("I");

            // Number of spaces to put before the R
            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++) {
                System.out.print(" ");
            }

            System.out.print("O");

            System.out.println("\n");

        }

    }

}
