package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class QuickSort {
    
   // Pivot is choosed from the middle

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {

        int pivot = a[start + (end - start) / 2];
        System.out.println("new come, for pivot = "+pivot);

        int left = start;
        int right = end;


        while (left <= right) {

            while (a[left] < pivot) {
                left++;
            }

            while (a[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(a, left++, right--);
                System.out.println(Arrays.toString(a));
            }

        }

        if (left < end) {
            quickSort(a, left, end);
        }
        if (start < right) {
            quickSort(a, start, right);
        }

    }// end method

    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {

      //  int[] a = new int[]{9, 3, 7, 2, 18, 6, 20, 0};
        //int[] a = new int[]{50,20,60,10,30,40};
        
                int[] a = new int[]{41,62,13,84,35,96,57,28,79};


        quickSort(a);

        System.out.println(Arrays.toString(a));
    }
}
