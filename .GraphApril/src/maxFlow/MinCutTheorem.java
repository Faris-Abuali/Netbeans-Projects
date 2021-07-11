package maxFlow;

import graphapril.GraphApril;
import graphapril.Vertex;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class MinCutTheorem<E> {

//===============================================================
    static class Edge<E> {

        E source, destination;

        public Edge(E source, E destination) {

            this.source = source;
            this.destination = destination;
        }
        
        public String toString(){
            
            return "("+ANSI_GREEN+source+ANSI_RESET+","+ANSI_GREEN+destination+ANSI_RESET+")";
        }// end method

    }// end class
//===============================================================

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    GraphApril<E> gr = new GraphApril<>();

    public MinCutTheorem(GraphApril<E> gr) {

        this.gr = gr;

        //System.out.println(gr.AdjList);
        //System.out.println(gr.AdjList.get("v1").listIterator());
    }

    public int minCut(E sourceLabel, E sinkLabel) {

        int MIN = Integer.MAX_VALUE;
        int minCut = 0;

        // System.out.println(gr.AdjList);
        Set<Vertex<E>> outputSet = gr.BFS(new Vertex(sourceLabel, 0), false);

        Map<E, Vertex<E>> map = new HashMap<>();

        for (Vertex<E> currVertex : outputSet) {
            map.put(currVertex.getLabel(), currVertex);
        }

        //*******************************************************************
        ArrayList<E> arList = new ArrayList<>();

        for (E currkey : map.keySet()) { // copy vertices from map to arList

            if (!currkey.equals(sinkLabel) && !currkey.equals(sourceLabel)) {
                arList.add(map.get(currkey).getLabel());
            }
        }

        Object[] ar = arList.toArray(); // convert arList to array 

        //*******************************************************************
        CombinationsModified<E> c = new CombinationsModified<>();
        for (int i = 1; i <= ar.length; i++) {
            c.printCombination((E[]) ar, ar.length, i);
        }

        //  System.out.println(c.arList);
        for (int i = 0; i < c.arList.size(); i++) {

            ArrayList<E> l = c.arList.get(i);

            l.add(sourceLabel);
        }

        ArrayList<E> f = new ArrayList<>();
        f.add(sourceLabel);

        c.arList.add(f);  // FINALLY: THIS arList contains all possible combinations of vertices. (source "S" must be included in all these combinations)

        System.out.println(c.arList);

        //*******************************************************************
//        //System.out.println(map);
//        //========================================================================


        ArrayList<Edge<E>> edgeList = new ArrayList();  //this list stores the edges where the cut exists
        ArrayList<Edge<E>> edgeListOfMinCut = new ArrayList();  //this list stores the edges where the cut exists


        for (int j = 0; j < c.arList.size(); j++) {

            edgeList = new ArrayList();
            
            ArrayList<E> currentCut = c.arList.get(j);

            System.out.println("Try This Cut: " + ANSI_RED + currentCut + ANSI_RESET);

            //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            //  System.out.println("current cut : " + currentCut);
            minCut = 0;

            for (E currLabel : currentCut) {

                Iterator<Vertex<E>> itr = gr.AdjList.get(currLabel).iterator();

//
                while (itr.hasNext()) {

                    Vertex<E> neightbour = itr.next();

                    if (!currentCut.contains(neightbour.getLabel())) {

                        if (neightbour.getD() < map.get(currLabel).getD()) {
                            continue; // because it is a reverse edge ( going from "t" or (sink) to "s" or (source) ) 
                        }

                        minCut += neightbour.getWeight(); // sum the edge between the (currVertex) and (neighbour)
                        System.out.println("add edge: (" + currLabel + ", " + neightbour.getLabel() + ")");
                        edgeList.add(new Edge(currLabel, neightbour.getLabel()));
                    }
                }// end while

            }// end forEach of currentCut

            System.out.println("minCut = " + minCut);
            System.out.println("===============================================\n");
            if (minCut < MIN) {
                MIN = minCut;
                edgeListOfMinCut=edgeList;
            }
        }// end for

        System.out.println("Value of MinCut = " + ANSI_GREEN+MIN+ANSI_RESET);
        System.out.println("Edges where the min cut exists: "+edgeListOfMinCut+"\n");
        
        return MIN;

    }// end method

}// end class
