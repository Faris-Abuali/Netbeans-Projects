package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Bellman_Ford<E> {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static class BF_Attributes<E> {

        Map<E, Vertex<E>> V;
        boolean flag = true;

        public BF_Attributes(Map<E, Vertex<E>> V, boolean flag) {
            this.V = V;
            this.flag = flag;
        }

    }// end inner class

    GraphApril<E> gr;

    Map<E, Vertex<E>> V;  // G.V this is the set of vertices

    public Bellman_Ford(GraphApril<E> gr) {
        this.gr = gr;

        V = new HashMap<>();

        // now INITIALIZE-SINGLE-SOURCE(G,s)
        for (E currKey : gr.AdjList.keySet()) {
            V.put(currKey, new Vertex(currKey, 0, gr.INFINITY, null));
            // for each u belongs to G.V :   u.d = ∞   and u.π = NIL
            // BUT... s.d = 0
        }

        // This step is like: 
    }

    public  BF_Attributes<E> bellmanFord(E sourceVertex) {

        V.put(sourceVertex, new Vertex(sourceVertex, 0, 0, null)); // s.d = 0

        int numOfVertices = gr.AdjList.size();

        /*  PseudcCode:
        for i = 1 to |G.V|-1 
                for each edge (u,v) belongs to G.E
                        Relax(u,v,w)
         */
        for (int i = 0; i < numOfVertices - 1; i++) {

            //relax ALL edges
            for (E currKey : gr.AdjList.keySet()) {

                Iterator<Vertex<E>> itr = gr.AdjList.get(currKey).listIterator();

                while (itr.hasNext()) {

                    Vertex<E> neighbour = itr.next();

                    /* Relaxation:   if u.d + cost(u,v) < v.d
                     then v.d <--  u.d + cost(u,v)*/
                    int relax = V.get(currKey).getD() + neighbour.getWeight();

                    if (relax < V.get(neighbour.getLabel()).getD()) {
                        V.get(neighbour.getLabel()).setD(relax);
                        V.get(neighbour.getLabel()).setπ(V.get(currKey));
                    }

                }// end while
            }// end for each
        }// end outer for

        boolean flag = detectNegativeWeightCycle();
        /*
         true: means that there's no negative weight cycles.
         false: means that there's a negative weight cycle deteced !!!
         */

//        for (E currKey : V.keySet()) {
//            System.out.println(currKey + ": " + V.get(currKey).getD());
//            System.out.println(V.get(currKey).getπ());
//        }
        //return V;
        return new BF_Attributes(V, flag); // Bellman-Ford Attributes (the inner class)
    }// end method

    private boolean detectNegativeWeightCycle() {

        /* THIS METHOD SHOULDE ONLY BE INVOKED BY Bellman_Ford METHOD !!! 
        It simply does the process of relaxing all edges for the V-th time, and if any change happens this time,
        this means that there's a negative weighted cycle, and the bellman_ford method will not work properly
         */
        for (E currKey : gr.AdjList.keySet()) {

            Iterator<Vertex<E>> itr = gr.AdjList.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neighbour = itr.next();

                /* Relaxation:   if u.d + cost(u,v) < v.d
                     then v.d <--  u.d + cost(u,v)*/
                int relax = V.get(currKey).getD() + neighbour.getWeight();

                if (relax < V.get(neighbour.getLabel()).getD()) {
                    System.out.println("CAUTION: a negative weight cycle has been detected !!!");
                    return false; // false : means that there's a negative weight cycles detected !!!
                }

            }// end while
        }// end for each

        return true; // true: means that there's no negative weight cycles

    }// end method

    public void printPath(E source, E destination) {
        // recursive, based on the optimal substructure: The subpath of a shortest path is a shortest path :)

        if (destination.equals(source)) {
            System.out.print(source + ", ");
        } else if (V.get(destination).getπ() == null) {
            System.out.println("There's No Path..!");
        } else {
            printPath(source, V.get(destination).getπ().getLabel());
            System.out.print(destination + ", ");
        }

    }// end method

    public StringBuilder toStringPath(E source, E destination, StringBuilder str) {
        // recursive, based on the optimal substructure: The subpath of a shortest path is a shortest path :)

        if (destination.equals(source)) {
            //System.out.print(source + ", ");
            return str.append(source + ", ");
        } else if (V.get(destination).getπ() == null) {
            // System.out.println("There's No Path..!");
            return str.append("There's No Path..!");
        } else {
            printPath(source, V.get(destination).getπ().getLabel());
            //System.out.print(destination + ", ");
            return str.append(destination + ", ");
        }

    }// end method

    public void printAllpaths(E source) {

        System.out.println("----- All Shortest Paths -----\nSource Vertex is: (" +ANSI_CYAN+ source +ANSI_RESET+ ")");

        for (E currKey : gr.AdjList.keySet()) {

            System.out.print("PATH TO (" +ANSI_GREEN+ currKey + ANSI_RESET+"): [");
            //printPath(source, currKey);
            StringBuilder builder = toStringPath(source, currKey, new StringBuilder(""));
            String str = builder.substring(0, builder.length() - 2);
            str += "]";

            System.out.println(str);
        }// end forEach

    }// end method

    public void printFinalResult(E sourceVertex) {

        System.out.println("\n\nBellman-Ford Algorithm");
        System.out.println("----Shortest Paths----");
        System.out.println("Src.\tDest.\tCost\n");

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
