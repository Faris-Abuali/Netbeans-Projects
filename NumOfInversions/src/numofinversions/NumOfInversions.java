package numofinversions;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class NumOfInversions {
//
//    public static int merge(int[] ar, int leftIndex, int midIndex, int rightIndex) {
//
//        int[] leftArr = Arrays.copyOfRange(ar, leftIndex, midIndex + 1);
//
//        int[] rightArr = Arrays.copyOfRange(ar, midIndex + 1, rightIndex + 1);
//
//        int i, j, k;
//        i = j = k = 0;
//        int ctr = 0;
//
//        while (i < leftArr.length && j < rightArr.length) {
//
//            if (leftArr[i] <= rightArr[j]) {
//                ar[k] = leftArr[i];
//                i++;
//            } else {
//
//                ar[k] = rightArr[j];
//                j++;
//                ctr += (midIndex + 1) - (leftIndex + i); 
//            }
//
//            k++;
//        }// end while
//
//        while (i < leftArr.length) {
//            ar[k] = leftArr[i];
//            i++;
//            k++;
//        }
//
//        while (j < rightArr.length) {
//            ar[k] = rightArr[j];
//            j++;
//            k++;
//        }
//
//        return ctr;
//
//    }// end method

    private static int merge(int[] arr, int l, int m, int r) {

        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, ctr = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                ctr += (m + 1) - (l + i);
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        return ctr;
    }

    public static int mergeSort(int[] ar, int l, int r) {

        int ctr = 0;

        if (l < r) {

            int mid = (l + r) / 2;

            ctr += mergeSort(ar, l, mid);

            ctr += mergeSort(ar, mid + 1, r);

            ctr += merge(ar, l, mid, r);

        }// end if

        return ctr;

    }// end method

    public static void main(String[] args) {

      //   int[] a = {1, 9, 6, 4, 5};
      
               int[] a = {9, 6, 5, 4,1,0,-2};


        System.out.println(mergeSort(a, 0, a.length - 1));

    }// end main

}// end class
