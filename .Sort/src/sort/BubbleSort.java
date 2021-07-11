package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class BubbleSort {

    public static void sortAscending(int[] a) {
        
        System.out.println("Original Array:\n" + Arrays.toString(a) + "\n-------------------------------------");

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - 1 - i; j++) {

                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                }
            }

            System.out.println(Arrays.toString(a));
        }

    }// end method

    private static void swap(int a[], int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{41, 62, 13, 84, 35, 96, 57, 28, 79};
        sortAscending(a);

        System.out.println(Arrays.toString(a));
    }
}
