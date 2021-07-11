package graphapril;

import java.util.Comparator;

/**
 *
 * @author Fares Abu Ali
 */
public class costSorterDijkstra<E> implements Comparator<Vertex<E>> {

    // d: distance from the source vertex (root of the tree) to the current vertex. (also named: shortest path estimate)
    // used in Dijkstra
    @Override
    public int compare(Vertex<E> v1, Vertex<E> v2) {

        if (v1.getD() > v2.getD()) {
            return 1;
        } else if (v1.getD() < v2.getD()) {
            return -1;
        }
        return 0;
    }// end method

}// end class
