/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plane;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Plane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int sumMin = 0;

        int sumMax = 0;

        Scanner sc = new Scanner(System.in);
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        PriorityQueue<Integer> qmax = new PriorityQueue<>(10, Collections.reverseOrder());
        PriorityQueue<Integer> qmin = new PriorityQueue<>(10);

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();

            qmax.add(a);
            qmin.add(a);

        }

        for (int i = 0; i < n; i++) {
            int x = qmax.poll();

             if (x <= 0) {
                i--;

                continue;
            }

            sumMax += x;
            x--;
            qmax.add(x);
        }

        for (int i = 0; i < n; i++) {
            int x = qmin.poll();

            if (x <= 0) {
                i--;

                continue;
            }

            sumMin += x;
            x--;
            qmin.add(x);
        }

        System.out.println(sumMax + " " + sumMin);

    }

}
