package Ford_Fulkerson;

import graphapril.*;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class FordFulkerson<E> {

    static boolean theAdjListOfEdgesIsBuilt = false;
    static boolean theResidualGraphIsBuilt = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    int maxFlow = 0;

    static class Augmenting_Path_Attributes<E> {

        boolean flag; // when flag=true this means that an augmenting path does exist
        ArrayList<Edge<E>> arList;

        public Augmenting_Path_Attributes(boolean flag, ArrayList<Edge<E>> arList) {

            this.flag = flag;
            this.arList = arList;
        }

    }// end inner class

    GraphApril<E> gr;

    public Map<E, LinkedList<Edge<E>>> AdjListOfEdges = new HashMap<>();
    public Map<E, LinkedList<Edge<E>>> residualNetwork = new HashMap<>();

    public FordFulkerson(GraphApril<E> gr) {

        this.gr = gr;
    }// end constructor

    public void buildAdjListOfEdges() {

        for (E currKey : gr.AdjList.keySet()) {

            if (!AdjListOfEdges.keySet().contains(currKey)) {
                AdjListOfEdges.put(currKey, new LinkedList<Edge<E>>());
            }

            Iterator<Vertex<E>> itr = gr.AdjList.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neighbourVertex = itr.next();

                Edge<E> e = new Edge(new Vertex(currKey, 0), new Vertex(neighbourVertex.getLabel(), 0), neighbourVertex.getWeight(), EdgeType.ORIGINAL);
                e.setEdgeType(EdgeType.ORIGINAL);

                if (!AdjListOfEdges.containsKey(currKey)) {
                    AdjListOfEdges.put(currKey, new LinkedList<Edge<E>>());
                }

                AdjListOfEdges.get(currKey).add(e);
            }

        }// end forEach

        // System.out.println(AdjListOfEdges);
        theAdjListOfEdgesIsBuilt = true;

    }// end method

    public void printAdjListWithWeights() {

        System.out.println("-------- Adj List --------------------");

        for (E currentKey : AdjListOfEdges.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator<Edge<E>> itr = AdjListOfEdges.get(currentKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();

                System.out.print("--{Cap=");

                if (e.getCapacity() < 0) {
                    System.out.print("(" + e.getCapacity() + ")");
                } else {
                    System.out.print(e.getCapacity());
                }

                System.out.print(", flow=");
                System.out.print(e.getFlow());

                System.out.print("}-->[");

                System.out.print(e.getDestination().getLabel() + "]");

            }// end inner for

            System.out.println();

        }// end outer for

        System.out.println("--------------------------------------------\n");

    }// end method

    public void printResidualNetwork() {

        System.out.println("-------- Residual Network --------------------");

        for (E currentKey : residualNetwork.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator<Edge<E>> itr = residualNetwork.get(currentKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();

                if (e.getEdgeType() == EdgeType.ORIGINAL) {
                    System.out.print(ANSI_BLUE);
                } else {
                    System.out.print(ANSI_RED);
                }

                System.out.print("--{Cap=");

                if (e.getCapacity() < 0) {
                    System.out.print("(" + e.getCapacity() + ")");
                } else {
                    System.out.print(e.getCapacity());
                }

                System.out.print(", flow=");
                System.out.print(e.getFlow());

                System.out.print("}-->" + ANSI_RESET + "[");

                System.out.print(e.getDestination().getLabel() + "]");

            }// end inner for

            System.out.println();

        }// end outer for

        System.out.println("\n"+ANSI_BLUE+"Blue = Original Edge.\n"+ANSI_RED+"Red = Residual Edge."+ANSI_RESET);
        System.out.println("--------------------------------------------\n");

    }// end method

    public void buildTheResidualGraph() {

        //==================First, copy everything from adjList ========================================
        for (E currKey : AdjListOfEdges.keySet()) {
            residualNetwork.put(currKey, new LinkedList<Edge<E>>());

            Iterator<Edge<E>> itr = AdjListOfEdges.get(currKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();

                residualNetwork.get(currKey).push(e);

            }
        }// end forEach

        //System.out.println(gr.AdjList.keySet());
        //System.out.println(residualNetwork.keySet());
        //===================================== Now Add reverse edges ================================================
        for (E currKey : residualNetwork.keySet()) {

            Iterator<Edge<E>> itr = residualNetwork.get(currKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();

                LinkedList<Edge<E>> ll = residualNetwork.get(e.getDestination().getLabel());

                boolean reverseEdgeExists = searchForEdge(ll, e.getDestination().getLabel(), e.getSource().getLabel());

                // System.out.println(reverseEdgeExists);
                if (!reverseEdgeExists) {

                    residualNetwork.get(e.getDestination().getLabel()).add(new Edge(e.getDestination(), e.getSource(), e.getCapacity(), EdgeType.RESIDUAL));
                    //e.setEdgeType(EdgeType.RESIDUAL);

                    //ll.add(new Edge(e.getDestination(), e.getSource(), e.getCapacity()));
                }

            }// end while

        }// end for each

        // System.out.println(residualNetwork);
        theResidualGraphIsBuilt = true;
    }// end method

    public boolean searchForEdge(LinkedList<Edge<E>> ll, E source, E dest) {

        Iterator<Edge<E>> itr = ll.listIterator();

        while (itr.hasNext()) {

            Edge<E> e = itr.next();

            if (e.getSource().getLabel().equals(source) && e.getDestination().getLabel().equals(dest)) {
                return true;
            }
        }// end while

        return false;
    }// end method

    public Map<E, Boolean> createMapOfVisitedState() {

        Map<E, Boolean> visited = new HashMap();

        for (E currKey : gr.AdjList.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }

        return visited;
    }// end method

    public void ford_Fulkerson(E source, E sink) {

        if (theAdjListOfEdgesIsBuilt == false) {
            buildAdjListOfEdges();  // it is the same idea as the adjList but here the LinkedList<Edge<E>> instead of LinkedList<Vertex<E>>
        }
        if (theResidualGraphIsBuilt == false) {
            buildTheResidualGraph();
        }

        Map<E, Boolean> visited = createMapOfVisitedState();
        visited.put(source, true);

        // System.out.println("visited = " + visited);
        Iterator<Edge<E>> itr = residualNetwork.get(source).listIterator();

        Augmenting_Path_Attributes<E> aug = seekAugmentingPath(source, sink, false, new ArrayList<Edge<E>>(), visited);

        boolean thereExistsAPath = aug.flag;
        ArrayList<Edge<E>> augmentingPath = aug.arList;

        while (thereExistsAPath) {

            //System.out.println(aug.arList);
            workOnThePath(augmentingPath);

            System.out.println("PATH:" + augmentingPath);

            // Now: seek for another augmenting path
            visited = createMapOfVisitedState();
            visited.put(source, true);

            aug = seekAugmentingPath(source, sink, false, new ArrayList<Edge<E>>(), createMapOfVisitedState());

            // System.out.println("flow = " + maxFlow);
            thereExistsAPath = aug.flag;
            augmentingPath = aug.arList;
        }// end while

        System.out.println("Max Flow = " + maxFlow);

    }// end method

    public Augmenting_Path_Attributes<E> seekAugmentingPath(E sourceVertex, E sinkVertex, boolean flag, ArrayList<Edge<E>> path, Map<E, Boolean> visited) {
        // search if there exists a path (P) from the source "s" to the sink "t" in the residual network Gf:

        if (sourceVertex.equals(sinkVertex)) {
            //return true;            
            return new Augmenting_Path_Attributes(true, path);
        }

        Iterator<Edge<E>> itr = residualNetwork.get(sourceVertex).listIterator();

        while (itr.hasNext()) {

            Edge<E> e = itr.next();

            if (visited.get(e.getDestination().getLabel()) == false) {

                if ((e.getEdgeType() == EdgeType.ORIGINAL && e.capacity > 0) || (e.getEdgeType() == EdgeType.RESIDUAL && e.flow > 0)) {
                    //System.out.print(e);
                    path.add(e);
                    visited.put(e.getDestination().getLabel(), true);
                    //System.out.println("FAFA : " + e);

                    flag = seekAugmentingPath(e.getDestination().getLabel(), sinkVertex, flag, path, visited).flag;
                }

            }// end if visited

            if (flag) {
                // return true;
                return new Augmenting_Path_Attributes(true, path);
            }

        }// end while

        // return false;
        // System.out.println("Now I have to backtrack:  path = " + path);
        if (path.size() > 0) {
            path.remove(path.size() - 1); // remove the last added edge from the path
        }
        // System.out.println("Now I have to backtrack:  path = " + path);

        return new Augmenting_Path_Attributes(false, path);

    }// end method

    public void workOnThePath(ArrayList<Edge<E>> arList) {

        int cf = giveTheResidualCapacityOfThePath(arList);
        //System.out.println("cf = "+cf);
        //cf: is the residual capacity of the augmenting path (bottle neck capacity)
        /* Residual Capacity (cf) of the augmenting path : is the max amount of net flow that we can ship along the 
         edges of the augmenting path. */

        maxFlow += cf;

        for (int i = 0; i < arList.size(); i++) {

            Edge<E> e = arList.get(i);

            //======================================================================================
            Iterator<Edge<E>> itr = residualNetwork.get(e.source.getLabel()).listIterator();

            while (itr.hasNext()) {

                Edge<E> neighbour = itr.next();

                if (neighbour.getDestination().getLabel().equals(e.getDestination().getLabel())) {

                    /*1.*/ neighbour.setFlow(neighbour.getFlow() + cf);

                    //System.out.println("YAYA");
                    if (neighbour.getEdgeType() == EdgeType.ORIGINAL) {
                        /*2.*/ neighbour.setCapacity(neighbour.getCapacity() - cf);
                    } else {
                        /*2.*/ neighbour.setCapacity(neighbour.getFlow());  // make its capacity = its flow
                    }

                }
            }
            //======================================================================================

            Iterator<Edge<E>> itrReverse = residualNetwork.get(e.destination.getLabel()).listIterator();

            while (itrReverse.hasNext()) {

                Edge<E> neighbour = itrReverse.next();

                if (neighbour.getDestination().getLabel().equals(e.getSource().getLabel())) {


                    //neighbour.setCapacity(neighbour.getCapacity() - cf);
                    /*3.*/ neighbour.setFlow(neighbour.getFlow() + cf);
                }
            }

            //======================================================================================
        }// end for regualr

        //  System.out.println(residualNetwork);
    }// end method

    public int giveTheResidualCapacityOfThePath(ArrayList<Edge<E>> arList) {

        /* Residual Capacity (cf) of the augmenting path : is the max amount of net flow that we can ship along the 
         edges of the augmenting path. */
        int min = arList.get(0).getCapacity();

        for (int i = 1; i < arList.size(); i++) {

            if (arList.get(i).getCapacity() < min) {
                min = arList.get(i).getCapacity();
            }

        }

        return min;

    }// end mehtod

    public void printAllEdgesInTheResidualNetwork() {

        for (E currKey : residualNetwork.keySet()) {

            Iterator<Edge<E>> itr = residualNetwork.get(currKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();
                //System.out.println(e.getEdgeType()==EdgeType.ORIGINAL);
                System.out.println("(" + e.getSource().getLabel() + ", " + e.getDestination().getLabel() + ") Type: " + e.getEdgeType());

            }// end while
        }
    }// end method

    
    
        public void printFinalResults() {

        System.out.println("--------Final Results: MaxFlow=("+ANSI_GREEN+maxFlow+ANSI_RESET+")----------\nDetails:");
           //System.out.println("Max Flow = "+ANSI_GREEN+maxFlow+ANSI_RESET);

        for (E currKey : residualNetwork.keySet()) {

            System.out.print("| " + currKey + " |");

            Iterator<Edge<E>> itr = residualNetwork.get(currKey).listIterator();

            while (itr.hasNext()) {

                Edge<E> e = itr.next();

                if (e.getEdgeType() == EdgeType.ORIGINAL) {

                    System.out.print("--{"+ANSI_GREEN+"flow="+ e.getFlow() + ANSI_RESET);

                    System.out.print("}-->[");

                    System.out.print(e.getDestination().getLabel() + "]");
                }

            }// end while

            System.out.println("");
        }// end for each

        System.out.println("--------------------------------------------\n");

    }// end method


}// end class
