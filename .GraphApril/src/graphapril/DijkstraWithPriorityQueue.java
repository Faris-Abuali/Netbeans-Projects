package graphapril;

import java.util.ArrayList;
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

/*  The Optimal Substructure Property of Shortest Paths states that:
    --> Subpaths of shortest paths are shortest paths.    
 */
public class DijkstraWithPriorityQueue<E> {

    /*
    The algorithm repeatedly selects the vertex u belongs to  V-{S} with the minimum shortest-path estimate, 
    adds u to S, and relaxes all edges leaving u. In the following implementation:
    
    we use a min-priority queue Q of vertices, keyed by their d values.

     */
    PriorityQueue<Vertex<E>> q = new PriorityQueue(new costSorterDijkstra());
    //a min-priority queue Q of vertices, keyed by their d values. ( d = shortest path estimate)

    //====================================================================================================================    
    Set<E> setOfSelectedVertices;
    //Dijkstra's Algorithm maintains a set S of vertices whose final shortest-path weights from the source s have already been determined.
    //because in Dijkstra, each vertex is allowed to be relaxed (updated) once only.
//====================================================================================================================     

    GraphApril<E> gr;  // Composition Relationship 

    Map<E, Integer> shortestPathsMap;

    int d = 0; // d[u] : cumulative distance  

    ArrayList<Vertex<E>> arOfVertices = new ArrayList<>();

    Map<E, Set<E>> paths;  // this is an additional feature (my idea)

    /* nevermind, this is my idea [an additon to the algorithm, to make it possible to know not only the
         cost of the shortest path, but also to know the path itself( the vertices which the shortest path consists of) ] */
    public DijkstraWithPriorityQueue(GraphApril<E> gr) {

        this.gr = gr;

        shortestPathsMap = new HashMap();
        setOfSelectedVertices = new LinkedHashSet();
        paths = new HashMap<>();

        for (E currKey : gr.AdjList.keySet()) {
            shortestPathsMap.put(currKey, gr.INFINITY);
            paths.put(currKey, null);
        }

        //===============================================================
        for (E currKey : gr.AdjList.keySet()) {
            arOfVertices.add(new Vertex(currKey, gr.INFINITY));
        }
        //=================================================================

    }// end constructor

    public E getNextVertexWithMinCost_andVisitIt() {

        // first I should determine which (non-selected yet) vertex has the least cost
//        int minCost = Integer.MAX_VALUE;
//        E selectedVertex = null;
//
//        for (E currKey : shortestPathsMap.keySet()) {
//
//            if (!setOfSelectedVertices.contains(currKey)) {
//
//                int i = shortestPathsMap.get(currKey);
//
//                if (i < minCost) {
//                    minCost = i;
//                    selectedVertex = currKey;
//                }
//
//            }
//        }// end forEach
//
        // d = minCost;
        Vertex<E> vertexWithMinCost = q.poll();
        System.out.println("q = " + q);
        System.out.println("remove: " + vertexWithMinCost.getLabel() + " with d = " + vertexWithMinCost.getD());

        d = vertexWithMinCost.getD();

        setOfSelectedVertices.add(vertexWithMinCost.getLabel()); // to gurantee that I will not choose it gain in the future

        return vertexWithMinCost.getLabel();

    }// end method

    public Map<E, Integer> dijkstra(E sourceVertex, boolean printDetails) {

        if (printDetails) {
            printDetails(sourceVertex, sourceVertex, true);
        }

        setOfSelectedVertices.add(sourceVertex);

//=================================================================================================================
        //q.add(new Vertex(sourceVertex, shortestPathsMap.get(sourceVertex)));
//=================================================================================================================
        shortestPathsMap.put(sourceVertex, 0);  // s.d=0

        E selectedVertex = sourceVertex;

        int numOfVertices = gr.AdjList.size();  //# of vertices in the graph

        /*
        Relaxation: if (d[u] + c(u,v) < d[v])
                    then d[v] <-- d[u]+c(u,v)
         */
        Iterator<Vertex<E>> itr;

        for (int i = 0; i < numOfVertices - 1; i++) { // because I have to viisit all vertices of the graph

            itr = gr.AdjList.get(selectedVertex).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                if (setOfSelectedVertices.contains(v.getLabel())) {
                    continue;
                    // if the neighbouring vertex v was already selected, 
                    //then there's no need to check it gain, because I am sure that I have found the shortest path to it.
                }

                if (d + v.getWeight() < shortestPathsMap.get(v.getLabel())) {  //if (d[u] + c(u,v) < d[v])
                    shortestPathsMap.put(v.getLabel(), d + v.getWeight());     //  then d[v] <-- d[u]+c(u,v)
                    q.add(new Vertex(v.getLabel(), 0, d + v.getWeight(), null));
                    System.out.println("q = " + q);
                    paths.put(v.getLabel(), new LinkedHashSet<>(setOfSelectedVertices));// (this is my idea) not necessary
                }

            }// end while


            /* Now I have to select the next vertex with the minimum cost*/
            selectedVertex = getNextVertexWithMinCost_andVisitIt();
            // of course when I visit it, I will add the cost to reach it, to the cumulative sum: (d).

            if (printDetails) {
                printDetails(sourceVertex, selectedVertex, false);
            }

        }// end for

        //********************************************************************
        paths.put(sourceVertex, new LinkedHashSet<>());
        modifyPaths();
        /* nevermind, this is my idea [an additon to the algorithm, to make it possible to know not only the
         cost of the shortest path, but also to know the path itself( the vertices which the shortest path consists of) ] */
        //********************************************************************

        return shortestPathsMap;

    }// end method

    public Map<E,Vertex<E>> dijkstraBook(E sourceVertex, boolean printDetails) {

        Map<E, Vertex<E>> V = new HashMap(); // set of vertices G.V

        for (E currKey : gr.AdjList.keySet()) {
            V.put(currKey, new Vertex(currKey, 0, gr.INFINITY, null));
        }
       
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
            
           Iterator<Vertex<E>> itr =  gr.AdjList.get(u.getLabel()).listIterator();
           
           while(itr.hasNext()){
               
               Vertex<E> neigbour = itr.next();
               
               
               int relaxation = V.get(u.getLabel()).getD() +neigbour.getWeight();
               
               if(relaxation < V.get(neigbour.getLabel()).getD()){
                   
                   V.get(neigbour.getLabel()).setD(relaxation);
                   V.get(neigbour.getLabel()).setπ(V.get(u.getLabel()));
                   
                   
                  // neigbour.setD(relaxation);
                  // neigbour.setπ(u);
               }
           }// end while iterator

        }// end while Q
        
        for(E currKey: V.keySet()){
            System.out.println(currKey+": "+V.get(currKey).getD());
            
            System.out.println(V.get(currKey).getπ());
        }
         
        return V;

    }// end method
    
    public void printDetails(E sourceVertex, E selectedVertex, boolean firstTime) {

        if (firstTime) {
            System.out.print("Selected Vertex |");

            for (E currKey : shortestPathsMap.keySet()) {
                if (!currKey.equals(sourceVertex)) {
                    System.out.print("  " + currKey + "  |");
                }
            }
            System.out.println("\n----------------+-----+-----+-----+-----+-----+-----");
        } else {

            System.out.print("       " + selectedVertex + "        |");
            for (E currKey : shortestPathsMap.keySet()) {
                if (!currKey.equals(sourceVertex)) {

                    int cost = shortestPathsMap.get(currKey);
                    if (cost == gr.INFINITY) {
                        System.out.print("  ∞  |");
                    } else {
                        System.out.print("  " + cost + " |");

                    }
                }
            }
            System.out.println("\n----------------+-----+-----+-----+-----+-----+-----");
        }
    }//end method

    public void printFinalResult(E sourceVertex) {

        System.out.println("\nDijkstra's Algorithm");
        System.out.println("----Shortest Paths----");
        System.out.println("Src.\tDest.\tCost");

        for (E currKey : shortestPathsMap.keySet()) {

            int cost = shortestPathsMap.get(currKey);

            if (cost == gr.INFINITY) {
                System.out.println(sourceVertex + "\t" + currKey + "\t∞");

            } else {
                System.out.println(sourceVertex + "\t" + currKey + "\t" + cost);
            }

        }// end forEach

        System.out.println("----------------------");

    }//end method

    public void printShortestPathForEachVertex() {

        System.out.println("\n---How To Reach Every Shortest Path---");

        for (E currKey : paths.keySet()) {
            System.out.println(currKey + ": " + paths.get(currKey));
        }

        System.out.println("---------------------------------------");
    }// end method

    public void modifyPaths() { // nevermind:)
        for (E currKey : paths.keySet()) {

            if (paths.get(currKey) != null) {
                paths.get(currKey).add(currKey);
            }
        }
    }

}// end class
