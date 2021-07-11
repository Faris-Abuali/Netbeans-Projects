package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class DFS_Attributes<E> {

    Set<Vertex<E>> outputSet;
    Map<E, TimeStamp> timeList;
    static StringBuilder parenthesisString = new StringBuilder("");

    LinkedList<Vertex<E>> linkedListForTOPOLOGICAL_SORT = new LinkedList<>();

    public DFS_Attributes(Set<Vertex<E>> outputSet, Map<E, TimeStamp> timeList) {

        this.outputSet = outputSet;
        this.timeList = timeList;
    }

    public String toString() {

        return "DFS OutputSet: " + outputSet + "\nDFS timeList: " + timeList;
    }
  
}// end class
