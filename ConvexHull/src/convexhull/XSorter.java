/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import java.awt.Point;
import java.util.Comparator;

/**
 *
 * @author Fares Abu Ali
 */
public class XSorter  implements Comparator<Point>{

    @Override
    public int compare(Point p1, Point p2) {
        // compare depending on X coordinate. We want to sort the points increasingly depending on X 
        
        if(p1.x>p2.x){
            return 1;
        }
        else if(p1.x<p2.x){
            return -1;
        }
        else{
            return 0;
        }  
    }
    
    
    
    
    
    
}// end class
