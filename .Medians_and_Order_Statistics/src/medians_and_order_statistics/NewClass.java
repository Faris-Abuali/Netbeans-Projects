package medians_and_order_statistics;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class NewClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, k;

        n = sc.nextInt();
        k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //===============================================
        int sum = 0;
        if (n <= k) {

            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
        } else {

            int ctr = 0;
            int x = 0;

            Arrays.sort(a);

            for (int i = n - 1; i >= 0; i--) {
                sum = sum + a[i] * (1 + x);
                
                ctr++;

                if (ctr == k) {
                    x++;
                    ctr = 0;
                }

            }

        }

        System.out.println(sum);

    }// end main
}// end class
