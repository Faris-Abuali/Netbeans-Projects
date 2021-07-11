package graphapril;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Fares Abu Ali
 */
public class DijkstraTheBest<E> {

    /* This is the best and the final implementation I have made :) and it's completely dependent on priorityQueue, and here
    I have followed the same steps written in the book. */

 /*
    The algorithm repeatedly selects the vertex u belongs to  V-{S} with the minimum shortest-path estimate, 
    adds u to S, and relaxes all edges leaving u. In the following implementation:
    
    we use a min-priority queue Q of vertices, keyed by their d values.

     */
    //---- Attributes:
    GraphApril<E> gr;  // Composition Relationship 

    PriorityQueue<Vertex<E>> q;
    //a min-priority queue Q of vertices, keyed by their d values. ( d = shortest path estimate)

    Map<E, Vertex<E>> V; // set of vertices G.V

    
    Set<E> setOfSelectedVertices;
    
    //---Constructor:
    public DijkstraTheBest(GraphApril<E> gr) {

        q = new PriorityQueue(new costSorterDijkstra());

        V = new HashMap(); // G.V

        this.gr = gr;

        // this is the only thing I need. It is the set of vertices  (G.V)
        for (E currKey : gr.AdjList.keySet()) {
            V.put(currKey, new Vertex(currKey, 0, gr.INFINITY, null));
        }
        
        setOfSelectedVertices=new LinkedHashSet<>(); // set of vertices whose their final shortest paths have already been determined

    }// end constructor

    // Methods:
    public Map<E, Vertex<E>> dijkstraBook(E sourceVertex) {

        V.put(sourceVertex, new Vertex(sourceVertex, 0, 0, null));

        //System.out.println(V);
        // When I add the vertices to the queue, I add the same addresses in the G.V
        for (E currKey : V.keySet()) {   // Q = G.V
            q.add(V.get(currKey));
        }

        //=========================================================
        while (!q.isEmpty()) {

//            System.out.println("q now: "+q);
//            System.out.println("remove: "+q.peek().getD());
            Vertex<E> u = q.poll();
            setOfSelectedVertices.add(u.getLabel());
           

            Iterator<Vertex<E>> itr = gr.AdjList.get(u.getLabel()).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neigbour = itr.next();

                int relaxation = V.get(u.getLabel()).getD() + neigbour.getWeight();

                if (relaxation < V.get(neigbour.getLabel()).getD()) {

                    V.get(neigbour.getLabel()).setD(relaxation);
                    V.get(neigbour.getLabel()).setπ(V.get(u.getLabel()));

                    // neigbour.setD(relaxation);
                    // neigbour.setπ(u);
                }
            }// end while iterator

        }// end while Q

        for (E currKey : V.keySet()) {
            System.out.println(currKey + ": " + V.get(currKey).getD());

            //System.out.println(V.get(currKey).getπ());
        }

        
        System.out.println("set: "+setOfSelectedVertices);
        return V;

    }// end method

    public void printPath(E source, E destination) {
 // recursive, based on the optimal substructure: The subpath of a shortest path is a shortest path :)
        
        if (destination.equals(source)) {
            System.out.print(source + " ");
        }

        else if (V.get(destination).getπ() == null) {
            System.out.println("There's No Path..!");
        } 
        else {
            printPath(source, V.get(destination).getπ().getLabel());
            System.out.print(destination+" ");
        }

    }// end method
    
    
    
    
       public void printFinalResult(E sourceVertex) {

        System.out.println("\n\nDijkstra's Algorithm");
        System.out.println("----Shortest Paths----");
        System.out.println("Src.\tDest.\tCost");

        for (E currKey : V.keySet()) {

            int cost = V.get(currKey).getD();

            if (cost == gr.INFINITY) {
                System.out.println(sourceVertex + "\t" + currKey + "\t∞");

            } else {
                System.out.println(sourceVertex + "\t" + currKey + "\t" + cost);
            }

        }// end forEach

        System.out.println("----------------------");

    }//end method

}// end class
