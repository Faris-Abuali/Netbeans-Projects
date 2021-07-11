package chapter22_developing_efficient_algorithms;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Point {

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(double x1, double y1, double x2, double y2) {

        double d = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));

        return d;

    }// end method

    public static void closestPairOfPoints(Point[] ar) {// O(n)

        double minDistance = Double.MAX_VALUE;
        double currDistance = Double.MAX_VALUE;

        //to mark the pair of the nearest points 
        int p1 = -999;
        int p2 = -999;

        for (int i = 0; i < ar.length; i++) {

            for (int j = i + 1; j < ar.length; j++) {

                currDistance = distance(ar[i].x, ar[i].y, ar[j].x, ar[j].y);

                if (currDistance < minDistance) {

                    minDistance = currDistance;
                    p1 = i;
                    p2 = j;
                }

            }//inner for

        }// outer for

        System.out.println("The closest pair of points is : (" + ar[p1].x + ", " + ar[p1].y + ")" + " and (" + ar[p2].x + ", " + ar[p2].y + ")");
        System.out.println("and the distance between them = " + minDistance);

    }// end method

    public static void enterPointsCoordinates(Point[] ar) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < ar.length; i++) {

            double x = sc.nextDouble();
            double y = sc.nextDouble();

            ar[i] = new Point(x, y);
        }

    }// end method

    public static void printPoints(Point[] ar) {

        for (int i = 0; i < ar.length; i++) {

            System.out.println("Point " + i + " : (" + ar[i].x + ", " + ar[i].y + ")");

        }
    }// end method

    public static void main(String[] args) {

        /* -1 3 -1 -1 1 1 2 0.5 2 -1 3 3 4 2 4 -0.5
        
         */
        Point[] ar = new Point[8];

        Point.enterPointsCoordinates(ar);

        Point.printPoints(ar);

        Point.closestPairOfPoints(ar);

    }// end main

}// end class
