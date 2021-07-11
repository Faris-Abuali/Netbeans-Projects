package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class TestPriorityQueue<E> {

    public static void main(String[] args) {

        PriorityQueue<Vertex<String>> q = new PriorityQueue(new costSorterDijkstra());

//        q.add(new Vertex("B", 50));
//        q.add(new Vertex("C", 45));
//        q.add(new Vertex("D", 10));
//
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
        Map<String, Vertex<String>> V = new HashMap();

        V.put("A", new Vertex("A", 11, 99, null));
        V.put("B", new Vertex("B", 13, 99, null));
        V.put("C", new Vertex("C", 4, 99, null));
        V.put("D", new Vertex("D", 15, 99, null));

        for (String currKey : V.keySet()) {

            q.add(V.get(currKey));

        }

        System.out.println(q);
        
        
        q.remove(V.get("B"));
        System.out.println(q);
        
      //V.put("B", new Vertex("B", 13, 3, null));
      
      
      
        while (!q.isEmpty()) {

            System.out.println(q.poll().getD());
        }

    }// end main
}// end class
