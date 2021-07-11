
package Kruskals_MST;

import java.util.Comparator;

/**
 *
 * @author Fares Abu Ali
 */
public class EdgeWeightSorter<E> implements Comparator<Edge<E>>{

    @Override
    public int compare(Edge<E> e1, Edge<E> e2) {
        
        if(e1.weight>e2.weight){
            return 1;
        }
        else if(e1.weight<e2.weight){
            return -1;
        }
        
        return 0;
        
    }// end method

    
}// end class
