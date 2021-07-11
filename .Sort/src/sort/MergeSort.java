package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MergeSort {

    public int[] merge(int[] arrLeft, int[] arrRight) {

        int[] res = new int[arrLeft.length + arrRight.length];

        int l, r;
        l = r = 0;

        for (int i = 0; i < res.length; i++) {
            
            if (l < arrLeft.length && r < arrRight.length) {
                if (arrLeft[l] < arrRight[r]) {
                    res[i] = arrLeft[l++];
                } else {
                    res[i] = arrRight[r++];
                }
            } else {
                if (l == arrLeft.length) {

                    res[i] = arrRight[r++];
                } else {
                    res[i] = arrLeft[l++];
                }
            }

        }
        return res;

    }

    public int[] mergeSort(int[] a) {

        if (a.length > 1) {

            int mid = a.length / 2;

            int[] left = Arrays.copyOfRange(a, 0, mid);
            int[] right = Arrays.copyOfRange(a, mid, a.length);

            int[] arrLeft = mergeSort(left);
            int[] arrRight = mergeSort(right);

            a = merge(arrLeft, arrRight);
            //System.out.println(Arrays.toString(a));
        }

        return a;

    }
    
    
    public static void main(String[] args) {

        MergeSort ms = new MergeSort();

        //int[]ar=new int[]{3,7,1,9,2,0};
       int[] ar = new int[]{4,1,19,12,16,7};
        
        int[] res = ms.mergeSort(ar);

        System.out.println(Arrays.toString(res));
    }

}
