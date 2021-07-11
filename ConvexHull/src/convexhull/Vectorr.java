package convexhull;

import java.awt.Point;

/**
 *
 * @author Fares Abu Ali
 */
public class Vectorr {

    Point startPoint, endPoint;

    public Vectorr(Point startPoint, Point endPoint) {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public static int crossProduct(Vectorr v1, Vectorr v2) {

        /*
         v1 and v2 have the same startPoint
        int ax = v1.startPoint.x;
        int ay = v1.startPoint.y;

        int bx = v1.endPoint.x;
        int by = v1.endPoint.y;

        int cx = v2.endPoint.x;
        int cy = v2.endPoint.y;

        int X1 = ax - bx;
        int X2 = ax - cx;

        int Y1 = ay - by;
        int Y2 = ay - cy;
        
        int result = X1*Y2 - X2*Y1;
        return result;
         */
        
        
        // write each vector on the component form ( a vector is said to be on the component form (standard form) when 
        // its startPoint is the origin (0,0)
        int v1x = v1.endPoint.x - v1.startPoint.x;
        int v1y = v1.endPoint.y - v1.startPoint.y;

        int v2x = v2.endPoint.x - v2.startPoint.x;
        int v2y = v2.endPoint.y - v2.startPoint.y;

        return (v1x * v2y - v1y * v2x);

    }// end method

    public static void main(String[] args) {
        Vectorr ab = new Vectorr(new Point(1, 1), new Point(3, 2));
        Vectorr ac = new Vectorr(new Point(1, 1), new Point(2, 3));

        System.out.println(Vectorr.crossProduct(ab, ac));
    }

    
    public String toString(){
        
        String str="";
        
        str+="<"+this.startPoint+", "+this.endPoint+">";
        
        return str;
    }
}
