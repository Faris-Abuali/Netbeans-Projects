package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class QuickSortPivotFromBeginning {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static int partition(int[] arr, int leftPtr, int rightPtr) {

        int pivotPtr = leftPtr;

        while (leftPtr < rightPtr) {

            if (arr[leftPtr] > arr[rightPtr]) {
                swap(arr, leftPtr, rightPtr);
                //System.out.println(Arrays.toString(arr));

                if (pivotPtr == leftPtr) {
                    pivotPtr = rightPtr;
                    leftPtr++;
                } else {
                    pivotPtr = leftPtr;
                    rightPtr--;
                }

                printArrayWithPivotColored(arr, pivotPtr);

            } else {
                if (pivotPtr == leftPtr) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }

        }

        return pivotPtr;

    }

    private static void swap(int[] arr, int leftPtr, int rightPtr) {
        int temp = arr[leftPtr];
        arr[leftPtr] = arr[rightPtr];
        arr[rightPtr] = temp;
    }

    public static void quickSort(int[] arr) {
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);

    }

    public static void quickSort(int[] arr, int left, int right) {

        System.out.println("new Pivot: " + arr[left]);

        if (left < right) {

            int currentPivot = partition(arr, left, right);

            quickSort(arr, left, currentPivot - 1);
            quickSort(arr, currentPivot + 1, right);
        }

    }// end quickSort method

    private static void printArrayWithPivotColored(int[] arr, int pivLoc) {

        System.out.print("[ ");

        int i = 0;

        for (i = 0; i < arr.length - 1; i++) {

            if (i != pivLoc) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(ANSI_RED + arr[pivLoc] + ANSI_RESET + ", ");
            }
        }

        if (i != pivLoc) {
            System.out.println(arr[arr.length - 1] + " ]");
        } else {
            System.out.println(ANSI_RED + arr[pivLoc] + ANSI_RESET + ", ");
        }

    }

    public static void main(String[] args) {

        int[] a = new int[]{41, 62, 13, 84, 35, 96, 57, 28, 79};
        quickSort(a);

        System.out.println(Arrays.toString(a));
    }
}
