package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class SelectionSort {

    public static void sortAscending(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }

            swap(a, minIndex, i);
            //System.out.println(Arrays.toString(a));
        }

    }// end method

    private static void swap(int a[], int minIndex, int i) {

        int temp = a[minIndex];
        a[minIndex] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{41, 62, 13, 84, 35, 96, 57, 28, 79};
        sortAscending(a);

        System.out.println(Arrays.toString(a));
    }
}
