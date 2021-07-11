package ClosestPairOfPoints;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class ClosestPairAlgorithm {

    private List<Point> points;

    public ClosestPairAlgorithm() {
    }

    public ClosestPairAlgorithm(List<Point> points) {
        this.points = points;
    }

    public void sortByX(List<Point> points) {

        Collections.sort(points, new XSorter());

    }// end method

    public double distance(Point p1, Point p2) {

        double xDistance = Math.abs(p1.x - p2.x);
        double yDistance = Math.abs(p1.y - p2.y);

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);

    }// end mathod

    public double solveProblem() {

        List<Point> sortedXPoints = new ArrayList<>();
        List<Point> yPoints = new ArrayList<>();

        for (Point point : this.points) {
            sortedXPoints.add(point);
            yPoints.add(point);
        }

//        for(Point p:sortedXPoints){
//            System.out.print(p.toString());
//        }
        
        sortByX(sortedXPoints);
        
//        System.out.println("after");
//        for(Point p:sortedXPoints){
//            System.out.print(p.toString());
//        }

        return findClosestPoints(sortedXPoints, yPoints, sortedXPoints.size());

    }// end method

    public double findClosestPoints(List<Point> pointsSortedX, List<Point> pointsY, int numOfPoints) {

        //System.out.println(numOfPoints);
//        System.out.println(pointsSortedX.size());
        
        if (numOfPoints <= 3) {
            return bruteForceApproach(pointsSortedX);
        }

        int middleIndex = numOfPoints / 2;

        Point middlePoint = pointsSortedX.get(middleIndex);

        List<Point> leftSubPointsY = new ArrayList<>();
        List<Point> leftSubPointsSortedX = new ArrayList<>();
        List<Point> rightSubPointsY = new ArrayList<>();
        List<Point> rightSubPointsSortedX = new ArrayList<>();

        //divide the points to left and right subarray
        for (int index = 0; index < numOfPoints; index++) {

            if (pointsY.get(index).x <= middlePoint.x) {

                leftSubPointsY.add(pointsY.get(index));
                leftSubPointsSortedX.add(pointsSortedX.get(index));
            } else {

                rightSubPointsY.add(pointsY.get(index));
                rightSubPointsSortedX.add(pointsSortedX.get(index));
            }

        }// end for

        double sigmaLeft = findClosestPoints(leftSubPointsSortedX, leftSubPointsY, middleIndex);
        double sigmaRight = findClosestPoints(rightSubPointsSortedX, rightSubPointsY, numOfPoints - middleIndex);
        double sigma = Math.min(sigmaLeft, sigmaRight);
      
        
        //===============================================================================================
        List<Point> pointsInStrip = new ArrayList<>();
        
        for(int index=0;index<numOfPoints;index++){
            
            if(Math.abs(pointsY.get(index).x - middlePoint.x) < sigma){
                pointsInStrip.add(pointsY.get(index));
            }
        }
        
        double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip,sigma);
        //===============================================================================================
        
        return Math.min(sigma, minDistanceStrip);

    }// end method

    public double bruteForceApproach(List<Point> points) {// O(n*n)

        //Point[] ar = (Point[]) list.toArray();
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.size(); i++) {

            for (int j = i + 1; j < points.size(); j++) {

                double d = distance(points.get(i), points.get(j));
                if (d < minDistance) {
                    minDistance = d;
                }
            }

        }// outer for

        return minDistance;
    }// end method
    
    
    public double findMinimumDistanceInStrip(List<Point> pointsInStrip, double sigma){
        
        double minDistance = sigma;
        
        for(int i=0;i<pointsInStrip.size();i++){
            
            for(int j=i+1;j<pointsInStrip.size() && (pointsInStrip.get(j).y - pointsInStrip.get(i).y < minDistance) ;j++){
                
                double d = distance(pointsInStrip.get(i), pointsInStrip.get(j));
                if(d < minDistance){
                    minDistance = d;
                }
            }
        }
        
        
        return minDistance;
    }// end method

}// end class
