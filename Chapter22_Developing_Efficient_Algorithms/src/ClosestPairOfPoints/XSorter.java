
package ClosestPairOfPoints;

import java.util.Comparator;

/**
 *
 * @author Fares Abu Ali
 */
public class XSorter implements Comparator<Point>{

    @Override
    public int compare(Point p1, Point p2) {
       
        return Double.compare(p1.x,p2.x);  // returns +1 when the 1st argument is greater than the 2nd
    }
    
    
  
    
}
