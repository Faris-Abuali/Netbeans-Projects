package ClosestPairOfPoints;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        /*List<Point> points = Arrays.asList(new Point(1,1),new Point(1,2),
        new Point(2,1),new Point(2,2),new Point(2,3),new Point(3,3));
         */
        // -1 3 -1 -1 1 1 2 0.5 2 -1 3 3 4 2 4 -0.5
        List<Point> points = Arrays.asList( new Point(3, 3), new Point(-1, 3), new Point(2, 0.5), new Point(1, 1),
                new Point(2, -1),new Point(-1,-1) /*,new Point(4, 2),new Point(4, -0.5)*/);

        ClosestPairAlgorithm c = new ClosestPairAlgorithm(points);

        System.out.println(c.solveProblem());

    }// end main

}// end class
