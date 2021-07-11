package genericgraph;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Fares Abu Ali
 */
public class GenericGraph<E> {
   

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // this is the adjacency list
    private Map<E, LinkedList<Vertex<E>>> map = new HashMap<>();

    // this is the adjacency matrix: Actually I wasn't planning to make adjMatrix, but I made it just because I needed it in
    // floyd-warshall algorithm
    private Map<E, Map<E, Integer>> mapOfMapsAsMatrix = new HashMap<>();

    public static final int INFINITY = 1_000_000_000; // 1 billion

    public PriorityQueueMin qminForWeights = new PriorityQueueMin(); // minQueue stores the weights of edges

    private void addVertex(E keyVertex) {  // I don't want this method to be called outside this class
        map.put(keyVertex, new LinkedList<Vertex<E>>());
    }

    public void addEdge(E source, E destination, boolean bidirectional, int weight) {

        qminForWeights.insert(weight);

        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(new Vertex(destination, weight));

        if (bidirectional) {
            map.get(destination).add(new Vertex(source, weight));
        }

        //----------------Finished------------------------------
    }// end method addEdge

    //**********************************************************************************
    public void buildAdjacencyMatrix() {

        for (E currKey : map.keySet()) {

            Map<E, Integer> mapInside = new HashMap<>();

            for (E currKeyInside : map.keySet()) {

                if (currKeyInside.equals(currKey)) {
                    mapInside.put(currKeyInside, 0);
                } else {
                    mapInside.put(currKeyInside, INFINITY);
                }
            }// end inner for

            mapOfMapsAsMatrix.put(currKey, mapInside);

        }// end outer for

        //System.out.println(mapOfMapsAsMatrix);
    }// end method

    public void addEdgeIntoADJMatrix(E source, E destination, boolean bidirectional, int weight) {

        //---------------------Now For the AdjacencyMatrix----------------------
        mapOfMapsAsMatrix.get(source).put(destination, weight);

        if (bidirectional) {
            mapOfMapsAsMatrix.get(destination).put(source, weight);
        }
    }

    public void printAdjacencyMatrx() {

        //-----Print the vertices labels in a row----------------------
        System.out.print("  | ");
        for (E currKey : mapOfMapsAsMatrix.keySet()) {
            System.out.print(currKey + " | ");
        }
        System.out.println("\n--------------------------------------------");
        //-------------------------------------------------------------

        for (E currKey : mapOfMapsAsMatrix.keySet()) {

            System.out.print(currKey + " | ");

            Map<E, Integer> mapInside = mapOfMapsAsMatrix.get(currKey);

            for (E currKeyInside : mapInside.keySet()) {

                int cost = mapInside.get(currKeyInside);

                if (cost > 999999) {// I know that I considered INFINITY to be 1Billion. But sometimes when there are
                    // negative wighted edges. I want to apply the idea of (INF + or - anything will still INF)
                    //Just for aesthetic purposes
                    System.out.print("∞   ");
                } else {
                    System.out.print(mapInside.get(currKeyInside) + "   ");
                }

            }// end forInside

            System.out.println();
        }// end outer for

        System.out.println("--------------------------------------------");
        System.out.println("Remember: matrix[src.][dst.]");
        System.out.println("--------------------------------------------\n\n");

    }// end method

    public void floyd_warshall() {
// O(n^3)
//to find shortest distances between every pair of vertices in a given edge weighted directed Graph.

//We initialize the solution matrix same as the input graph matrix as a first step. 
//Then we update the solution matrix by considering all vertices as an intermediate vertex.
// When we pick vertex number k as an intermediate vertex, 
//we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices.
        System.out.println("---------((( All Pairs Shortest Path (Floyd-Warshall) )))------------");
        System.out.println("--------------------matrix[source][destination]-----------------------");
        int ctr = 0;

        for (E intermediateVertexKey : mapOfMapsAsMatrix.keySet()) {

            // System.out.println("A" + ctr + " Now the row & the column # " + ctr + " will be left unchanged");
            // printAdjacencyMatrx();
            for (E currKey : mapOfMapsAsMatrix.keySet()) {

                Map<E, Integer> mapInside = mapOfMapsAsMatrix.get(currKey);

                if (!currKey.equals(intermediateVertexKey)) {

                    for (E innerCurrentKey : mapOfMapsAsMatrix.keySet()) {

                        if (!innerCurrentKey.equals(intermediateVertexKey) && !currKey.equals(innerCurrentKey)) {

                            // The idea is so simple: if A(x,y) > A(x,intermediate) + A(intermediate,y) 
                            // then update the value of A(x,y) to become A(x,intermediate) + A(intermediate,y) 
                            int pathCostFromXToY = mapOfMapsAsMatrix.get(currKey).get(innerCurrentKey);

                            int pathCostFromXToMiddle = mapOfMapsAsMatrix.get(currKey).get(intermediateVertexKey);

                            int pathCostFromMiddleToY = mapOfMapsAsMatrix.get(intermediateVertexKey).get(innerCurrentKey);

                            int w = pathCostFromXToMiddle + pathCostFromMiddleToY;

                            if (w < pathCostFromXToY) {

                                // make some updates on the mapInside
                                mapInside.put(innerCurrentKey, w);

                            }

                        }// end if

                    }// end forEach innerCurrentKey

                }// end if

                //mapOfMapsAsMatrix.put(currKey, mapInside);
            }// end forEach currKey

            ctr++;

        }//end forEach intermediateKey

        printAdjacencyMatrx();

    }// end  method floyd_Warshall
    //**********************************************************************************

    public int getVerticesCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirectional) {

        int edgesCount = 0;

        for (E currentKey : map.keySet()) {
            edgesCount += map.get(currentKey).size();
        }

        if (bidirectional) {
            edgesCount = edgesCount / 2;
        }

        return edgesCount;

    }

    public boolean hasVertex(E key) {

        if (map.containsKey(key)) {
            return true;
        }

        return false;
    }

    public boolean hasEdge(E source, E destination) {

        //Firstly, check wheter the two vertices exist or not
        if (!hasVertex(source)) {
            System.out.println("Vertex (" + source + ") does not exist in the graph");
            return false;
        }
        if (!hasVertex(destination)) {
            System.out.println("Vertex (" + destination + ") does not exist in the graph");
            return false;
        }

        // if the program reaches here, then we are sure that both vertices, source and destination exist in the graph
        for (Vertex currentVertex : map.get(source)) {

            if (currentVertex.getLabel().equals(destination)) {
                return true;
            }
        }// inner for

        return false;

    }// end method

    public E[] getChildrenOf(E parent) {

        //First, 
        if (!hasVertex(parent)) {
            throw new RuntimeException("This Vertex: (" + parent + ") does not exist in the graph...!!!");
        }

        E[] ar = (E[]) (new Object[map.get(parent).size()]);

        Iterator itr = map.get(parent).listIterator();

        int i = 0;
        while (itr.hasNext()) {

            Vertex currVertex = (Vertex) itr.next();

            ar[i] = (E) currVertex.getLabel();
            i++;
        }

        return ar;
    }

    public void printAdjacencyList() {

        for (E currentKey : map.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator itr = map.get(currentKey).listIterator();

            while (itr.hasNext()) {

                System.out.print("--> ");
                Vertex<E> v = (Vertex<E>) itr.next();
                System.out.print(v.getLabel() + " ");
            }// end inner for

            System.out.println();

        }// end outer for

        System.out.println("--------------------------------------------\n");

    }

    public void printAdjacencyListWithWeights() {

        for (E currentKey : map.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator itr = map.get(currentKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = (Vertex<E>) itr.next();

                System.out.print("--");

                if (v.getWeight() < 0) {
                    System.out.print("(" + v.getWeight() + ")");
                } else {
                    System.out.print(v.getWeight());
                }

                System.out.print("-->[");

                System.out.print(v.getLabel() + "]");

            }// end inner for

            System.out.println();

        }// end outer for

        System.out.println("--------------------------------------------\n");

    }

    public int getWeight(E sourceLabel, E destinationLabel) {

        if (hasEdge(sourceLabel, destinationLabel)) {

            int w = 0;

            Iterator<Vertex<E>> itr = map.get(sourceLabel).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                if (v.getLabel().equals(destinationLabel)) {
                    w = v.getWeight();
                    break;
                }
            }

            return w;
        } else {
            throw new RuntimeException("There's no edge from (" + sourceLabel + ") to (" + destinationLabel + ")");
        }

    }

    //-----------------------------------------------------------------------------------
    public Vertex<E> getChildIfNotVisitedYet(Vertex currVertex, Map<E, Boolean> visited) {

        Iterator itr = map.get(currVertex.getLabel()).listIterator();

        while (itr.hasNext()) {

            Vertex<E> v = (Vertex<E>) itr.next();

            if (visited.get(v.getLabel()).equals(false)) {

                visited.put(v.getLabel(), Boolean.TRUE);
                return v;
            }

        }
        return null;
    }

    public Vertex<E> getAnyVertexWhoseLabelIs(E label) {

        if (hasVertex(label)) {

            for (E currKey : map.keySet()) {

                Iterator itr = map.get(currKey).listIterator();

                while (itr.hasNext()) {
                    Vertex<E> v = (Vertex<E>) itr.next();

                    if (v.getLabel().equals(label)) {
                        return v;
                    }
                }
            }
        }
        return null;// when the function returns null, this means that the vertex with label(label) does not exist

    }

    public Vertex<E> getAnyArbitraryVertexToStartFrom() {

        // this function is useful when I just want to start from any vertex I face in the graph
        Set<E> s = map.keySet();
        E arbitraryKey = s.iterator().next(); // get the first key in the keySet

        Vertex<E> arbiraryVertex = map.get(arbitraryKey).getFirst(); // get the first vertex from this LinkedList<Vertex<E>>

        return arbiraryVertex;

    }

    // when I want to call the dfs from (main) method, I usually pass a the startLabel not the startVertex
    public void printDfsUsingStack(E startLabel) {

        Vertex<E> v = getAnyVertexWhoseLabelIs(startLabel);

        System.out.print("DFS: ");
        if (v != null) {
            printDfsHelperUsingStack(v);
        } else {
            System.out.println("The Vertex whose label is (" + startLabel + ") does not exist in this graph...!!!");
        }

    }

    private void printDfsHelperUsingStack(Vertex startVertex) {

        //-----------------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currentKey : map.keySet()) {
            visited.put(currentKey, Boolean.FALSE);
        }

        //-----------------------------------------------------------
        System.out.print(startVertex.getLabel() + " ");
        visited.put((E) startVertex.getLabel(), Boolean.TRUE);

        Stack<Vertex<E>> st = new Stack<>();

        st.push(startVertex);

        while (!st.isEmpty()) {

            Vertex currVertex = st.peek();

            Vertex currChild = getChildIfNotVisitedYet(currVertex, visited);

            while (currChild != null) {

                st.push(currChild);
                //currChild.setVisited(true);
                visited.put((E) currChild.getLabel(), Boolean.TRUE);
                System.out.print(currChild.getLabel() + " ");

                currChild = getChildIfNotVisitedYet(currChild, visited);
            }

            st.pop();
        }

        System.out.println();
    }

    public void printDfsRecursiveHelper(E startLabel) {

        //-----------------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }
        //-----------------------------------------------------------

        Vertex<E> v = getAnyVertexWhoseLabelIs(startLabel);

        System.out.print("DFS: ");

        if (v != null) {
            printDfsRec(v, visited);
        } else {
            System.out.println("The Vertex whose label is (" + startLabel + ") does not exist in this graph...!!!");
        }

        System.out.println("");
    }

    private void printDfsRec(Vertex<E> currVertex, Map<E, Boolean> visited) {

        visited.put(currVertex.getLabel(), Boolean.TRUE);
        System.out.print(currVertex.getLabel() + " ");

        Vertex<E> child = getChildIfNotVisitedYet(currVertex, visited);

        while (child != null) {

            printDfsRec(child, visited);

            child = getChildIfNotVisitedYet(currVertex, visited);
        }

    }// end method 

    public void printBfs(E startLabel) {

        //-----------------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }
        //-----------------------------------------------------------

        Vertex<E> v = getAnyVertexWhoseLabelIs(startLabel);

        System.out.print("BFS: ");

        if (v != null) {
            printBfs(v, visited);
        } else {
            System.out.println("The Vertex whose label is (" + startLabel + ") does not exist in this graph...!!!");
        }

        System.out.println();

    }

    private void printBfs(Vertex<E> startVertex, Map<E, Boolean> visited) {

        visited.put(startVertex.getLabel(), Boolean.TRUE);
        System.out.print(startVertex.getLabel() + " ");

        Queue<Vertex<E>> q = new LinkedList<>();

        q.add(startVertex);

        while (!q.isEmpty()) {

            Vertex<E> currVertex = q.peek();

            Vertex<E> child = getChildIfNotVisitedYet(currVertex, visited);

            while (child != null) {

                //Enqueue,Visited,Print
                q.add(child);
                visited.put(child.getLabel(), Boolean.TRUE);
                System.out.print(child.getLabel() + " ");

                child = getChildIfNotVisitedYet(currVertex, visited);
            }

            q.poll(); // dequeue
        }// end while

    }// end method bfs

    //$$$$$$$$$$$$$$$$$$$$$$ BFS But returns ArrayList of the labels instead of printing the labels $$$$$$$$$$$$$$$$$$$$$$
    public ArrayList<E> bfs(E startLabel) {

        //-----------------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }
        //-----------------------------------------------------------

        Vertex<E> v = getAnyVertexWhoseLabelIs(startLabel);

        ArrayList<E> arList = new ArrayList<E>();

        // System.out.print("BFS: ");
        if (v != null) {
            bfs(v, visited, arList);
        } else {
            System.out.println("The Vertex whose label is (" + startLabel + ") does not exist in this graph...!!!");
        }

        return arList;
    }

    private void bfs(Vertex<E> startVertex, Map<E, Boolean> visited, ArrayList<E> arList) {

        visited.put(startVertex.getLabel(), Boolean.TRUE);
        //System.out.print(startVertex.getLabel() + " ");
        arList.add(startVertex.getLabel());

        Queue<Vertex<E>> q = new LinkedList<>();

        q.add(startVertex);

        while (!q.isEmpty()) {

            Vertex<E> currVertex = q.peek();

            Vertex<E> child = getChildIfNotVisitedYet(currVertex, visited);

            while (child != null) {

                //Enqueue,Visited,Print
                q.add(child);
                visited.put(child.getLabel(), Boolean.TRUE);
                //System.out.print(child.getLabel() + " ");
                arList.add(child.getLabel());

                child = getChildIfNotVisitedYet(currVertex, visited);
            }

            q.poll(); // dequeue
        }// end while

    }// end method bfs

    //-----$$$$$$$$$$$$$--DFS But returns ArrayList of the labels instead of printing the labels--------$$$$$$$$$$----
    //Version1: To call from main
    public ArrayList<E> dfs(E startLabel) {

        Vertex<E> currVertex = getAnyVertexWhoseLabelIs(startLabel);

        //------------------------Create A boolean map for visited state---------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currentKey : map.keySet()) {
            visited.put(currentKey, Boolean.FALSE);
        }

        //--------------------now create an arrayList to store the traversed labels-----------------------------
        ArrayList<E> arList = new ArrayList<>();

        if (currVertex != null) {
            dfsRec(currVertex, visited, arList);
        } else {
            System.out.println("The Vertex whose label is (" + startLabel + ") does not exist in this graph...!!!");
        }

        return arList;

    }// end method 

    // Version2: I used this inside getNumOfComponents() method
    private ArrayList<E> dfs(Vertex<E> currVertex, Map<E, Boolean> visited) {

        ArrayList<E> arList = new ArrayList<>();

        if (currVertex != null) {
            dfsRec(currVertex, visited, arList);
        } else {
            System.out.println("The Vertex  does not exist in this graph...!!!");
        }
        return arList;

    }// end method 

    // This is the real recursive dfs method: THE KING!
    private void dfsRec(Vertex<E> currVertex, Map<E, Boolean> visited, ArrayList<E> arList) {

        visited.put(currVertex.getLabel(), Boolean.TRUE);
        arList.add(currVertex.getLabel());
        //System.out.print(currVertex.getLabel() + " ");

        Vertex<E> child = getChildIfNotVisitedYet(currVertex, visited);

        while (child != null) {

            dfsRec(child, visited, arList);

            child = getChildIfNotVisitedYet(currVertex, visited);
        }

    }// end method 

    //=============================================The End===================================================
//*********************************Number Of Components********************************
    public int getNumberOfComponents() {

        //---------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currentKey : map.keySet()) {
            visited.put(currentKey, Boolean.FALSE);
        }

        //---------------------------------------------------
        int ctr = 0;

        for (E currKey : map.keySet()) {

            if (visited.get(currKey).equals(false)) {

                ctr++;

                Vertex<E> v = getAnyVertexWhoseLabelIs(currKey);
                dfs(v, visited);
            }

        }// end for each

        return ctr;
    }// end method

//**********************************Check If Connected********************************
    public boolean isConnected() {

        //---------------Create a map for visited state--------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }
        //------------------------------------------------------

        Set<E> s = map.keySet();
        E arbitraryKey = s.iterator().next(); // get the first key

        dfs(map.get(arbitraryKey).getFirst(), visited);// it doesn't matter where you start from, so here I can start from 
        //the 1st vertex I face in the 1st LinkedList<Vertex<E>> I face

        if (checkIfAllVerticesHaveBeenVisited(visited) == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkIfAllVerticesHaveBeenVisited(Map<E, Boolean> visited) {
        for (E currKey : visited.keySet()) {
            if (visited.get(currKey).equals(false)) {
                return false;
            }
        }

        return true;
    }

    public Vertex<E> getAVertexThatStillNotVisited(Map<E, Boolean> visited) {

        // I made this method because I needed it during the development of (isCyclic()) mehtod.
        // this method is useful when the graph consists of multiple components. By using this method, you can gurantee
        // that all components have been traversed(visited) and taken into consideration.
        // this method checks if there's a vertex in the graph(in the adjacency map) that still not visited and returns it.
        // If all vertices have been visited, then return null.
        for (E currKey : map.keySet()) {

            if (visited.get(currKey).equals(false)) {
                Vertex<E> v = getAnyVertexWhoseLabelIs(currKey);
                return v;
            }

        }// end for each

        return null;
    }

    public boolean isCyclic() {

        // ==========This method looks complicated, but actually it's pretty simple===========
        //---------------Create a map for visited state--------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);
        }
        //-----------------------------------------------------------

        Vertex<E> arbitraryVertex = getAnyArbitraryVertexToStartFrom();

        boolean flag = isCyclic(arbitraryVertex, arbitraryVertex, visited, false);// in the beginning, the parentVertex is null

//-----------------In case the graph consists of multiple components:
        Vertex<E> v = getAVertexThatStillNotVisited(visited); // this method returns null when all vertices have been visited

        while (flag == false && v != null) {

            flag = isCyclic(v, v, visited, false);

            if (flag == false) {
                v = getAVertexThatStillNotVisited(visited);
            }
        }
//-------------------------------------------------------------------------

        return flag;
    }// end mehtod

    //**********************************Check If Cyclic********************************
    //NOTICE: This method is not responsible whether the graph consists of one component or more!
    private boolean isCyclic(Vertex<E> currentVertex, Vertex<E> parentVertex, Map<E, Boolean> visited, boolean flag) {

        visited.put(currentVertex.getLabel(), Boolean.TRUE);
        //System.out.println(currentVertex.getLabel());
        Iterator<Vertex<E>> itr = map.get(currentVertex.getLabel()).listIterator();

        while (itr.hasNext()) {

            Vertex<E> currentChild = itr.next();

            if (visited.get(currentChild.getLabel()).equals(false)) {

                flag = isCyclic(currentChild, currentVertex, visited, false);

                if (flag == true) {
                    break;
                }

                // System.out.println("remove last");
            } else if (!currentChild.getLabel().equals(parentVertex.getLabel())) {
                flag = true;
                break;
            }

        }// end while

        return flag;

    }// end method isCyclic

    //=======================================================Algorithms: Dijkstra===========================================
    public Map<E, Integer> dijkstra(E sourceLabel) {

        //------------------------------------------------------
        Map<E, Integer> distance = new HashMap<>();

        for (E currKey : map.keySet()) {

            if (!currKey.equals(sourceLabel)) {
                distance.put(currKey, INFINITY);

            }

        }

        //System.out.println("dis "+distance);
        //------------------------------------------------------
        Map<E, Boolean> visited = new HashMap<>();

        for (E currKey : map.keySet()) {
            visited.put(currKey, Boolean.FALSE);// the only one who changes the values to true is the 
            //getChildIfNotVisitedYet() method
        }
        //System.out.println("vis "+visited);
        //------------------------------------------------------
        Map<E, Boolean> explored = new HashMap<>();

        for (E currKey : distance.keySet()) {

            explored.put(currKey, Boolean.FALSE);// the only one who changes the values to true is the 
            //getChildIfNotVisitedYet() method
        }
        //System.out.println("expl "+explored);
        //------------------------------------------------------

        boolean firstTime = true;

        //Vertex<E> currentVertex = getAnyVertexWhoseLabelIs(sourceLabel);
        Vertex<E> currentVertex = new Vertex(sourceLabel, -999);  // NOTICE: This is just an arbitrary vertex. It's not important
        // for me because it's not included in the map

        while (currentVertex != null) {

            if (!currentVertex.getLabel().equals(sourceLabel)) {
                explored.put(currentVertex.getLabel(), Boolean.TRUE);
            }

            // reset all vertices' visited state to false
            for (E currKey : map.keySet()) {
                visited.put(currKey, Boolean.FALSE);// the only one who changes the values to true is the 
                //getChildIfNotVisitedYet() method
            }
            //--------------------------------------------------

            Vertex<E> child = getChildIfNotVisitedYet(currentVertex, visited);

            while (child != null) {

                if (firstTime) {// initial fill: special case for the children of the sourceVertex
                    distance.put(child.getLabel(), child.getWeight());
                } else if (!child.getLabel().equals(sourceLabel)) {

                    int distanceU = distance.get(currentVertex.getLabel());

                    int edgeCostUtoV = child.getWeight();

                    int distanceV = distance.get(child.getLabel());

                    if ((distanceU + edgeCostUtoV) < distanceV) {
                        distance.put(child.getLabel(), distanceU + edgeCostUtoV);
                    }

                }

                child = getChildIfNotVisitedYet(currentVertex, visited);
            }// end while

            firstTime = false;

            E smallestCostLabel = null;
            int smallestCost = INFINITY;

            for (E currKey : distance.keySet()) {

                if (distance.get(currKey) < smallestCost && explored.get(currKey).equals(false)) {
                    smallestCost = distance.get(currKey);
                    smallestCostLabel = currKey;
                }
            }

            currentVertex = getAnyVertexWhoseLabelIs(smallestCostLabel);

        }// end outer while

        //System.out.println(distance);
        return distance;
    }// end method

    public void dijkstraDisplayShortestPaths(E sourceLabel) {

        Map<E, Integer> distance = dijkstra(sourceLabel);

        System.out.println("Dijkstra's Algorithm");
        System.out.println("----Shortest Paths----");
        System.out.println("Src.    Dest.    Cost");

        for (E currKey : map.keySet()) {// I took the keySet from map not from distances just because I want to
            // print that the distance from src. to src. is zero ( just for aesthetic purposes :)

            if (currKey.equals(sourceLabel)) {
                System.out.print(" " + sourceLabel + "       " + currKey + "        0" + "\n");
            } else {
                int cost = distance.get(currKey);
                if (cost == INFINITY) {
                    System.out.print(" " + sourceLabel + "       " + currKey + "        INF" + "\n");
                } else {
                    System.out.print(" " + sourceLabel + "       " + currKey + "        " + distance.get(currKey) + "\n");
                }
            }
        }// end forEach

        System.out.println("----------------------");

    }// end method

    public void allPairsShortestPathBasedOnDijkstra() {
        //O(n^3)

        for (E currKey : map.keySet()) {

            dijkstraDisplayShortestPaths(currKey);
        }

    }// end method

    //------------------------------The End Of Dijkstra--------------------------------
    //----------------------------Now Bellman-Ford----------------------------------
    public Map<E, Integer> bellmanFord(E sourceLabel) {

        //---------------------------------------------------
        Map<E, Integer> distances = new HashMap<>();

        for (E currKey : map.keySet()) {

            if (currKey.equals(sourceLabel)) {
                distances.put(currKey, 0);
            } else {
                distances.put(currKey, INFINITY);
            }

        }// end for each
        //---------------------------------------------------   

        // We must start from the srcVertex for the first time, because the srcVertex's cost=0 while other vertices' costs=INF---
        Iterator<Vertex<E>> sourceLabelItr = map.get(sourceLabel).listIterator();

        while (sourceLabelItr.hasNext()) {

            Vertex<E> v = sourceLabelItr.next();

            if (distances.get(sourceLabel) + v.getWeight() < distances.get(v.getLabel())) {
                distances.put(v.getLabel(), distances.get(sourceLabel) + v.getWeight());
            }

        }
        //------------------------------------------------------------------------------

        //----- We have to relax all vertices |V|-1 times; such that |V|=number of vertices
        int V = getVerticesCount() - 1; // map.size()

        while (V > 0) {

            for (E currKey : map.keySet()) {

                Iterator<Vertex<E>> itr = map.get(currKey).listIterator();

                while (itr.hasNext()) {

                    Vertex<E> v = itr.next();

                    if (distances.get(currKey) + v.getWeight() < distances.get(v.getLabel())) {
                        distances.put(v.getLabel(), distances.get(currKey) + v.getWeight());
                    }
                }// end while
            }

            //System.out.println(distances);
            V--;
        }

        detectIfThereIsACycleWithNegativeTotalWeight(distances);

        return distances;
    }// end method bellman

    public void detectIfThereIsACycleWithNegativeTotalWeight(Map<E, Integer> distances) {

        //called inside bellman-ford method:
        // this method detects if there's a cycle in the graph with a negative total weight, if so, then the 
        // graph cannot be solved to give the final shortest paths' costs, because there's a vertex whose weight 
        // keeps getting reduced even after performing |v|-1  times of relaxation
        // the procedure is so simole, just perform another iteration of relaxation.
        //We have already performed relaxation in bellman_ford function |V|-1 times,
        // so perform the |V|th iteraton relaxation, if you find that any of the vertices costs have been changed
        // then there's a problem of a cycle with negative total weight
        for (E currKey : map.keySet()) {

            Iterator<Vertex<E>> itr = map.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                if (distances.get(currKey) + v.getWeight() < distances.get(v.getLabel())) {
                    System.err.println("Problem detected in the graph: there's a cycle with negative total weight!!\n"
                            + "The vertex (" + v.getLabel() + ")'s cost keeps getting reduced even after performing |v|-1  times of relaxation");
                    return;
                    //distances.put(v.getLabel(), distances.get(currKey) + v.getWeight());
                }
            }// end while
        }
    }// end method detect

    public void bellmanDisplayShortestPaths(E sourceLabel) {

        Map<E, Integer> distance = bellmanFord(sourceLabel);

        System.out.println("Bellman-Ford Algorithm");
        System.out.println("----Shortest Paths----");
        System.out.println("Src.    Dest.    Cost");

        for (E currKey : distance.keySet()) {

            int cost = distance.get(currKey);

            if (cost == INFINITY) {
                System.out.print(" " + sourceLabel + "       " + currKey + "        INF" + "\n");
            } else {
                System.out.print(" " + sourceLabel + "       " + currKey + "        " + distance.get(currKey) + "\n");
            }
        }// end forEach

        System.out.println("----------------------");

    }// end method

    //==========================================================================================================================
    public void edgesList() {

        Set<String> s = new LinkedHashSet<>();

        for (E currKey : map.keySet()) {

            Iterator<Vertex<E>> itr = map.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();
                String str = "(" + currKey + ",";
                str += v.getLabel();
                str += ")";

                s.add(str);
            }// end while

        }// end for

        System.out.println("EdgesList: " + s);
        System.out.println("#of edges: " + s.size());

    }// end method

    public void minimumSpanningTree() {

        //1- Keep including the minimum edges as long as no cycles are formed. Once we cover all the vertices, we stop.
        System.out.println(ANSI_PURPLE + "Minimum Spanning Tree" + ANSI_RESET);

        Set<Set<E>> kingSet = new HashSet<>();
        int totalMinimumWeight = 0;

        int minCost = 0;

        while (!thereIsASetContainsAllVertices(kingSet)) { // stop when there is a set contains all vertices of the graph

            minCost = qminForWeights.remove();

            totalMinimumWeight = includeEdgeWhoseCostIs(minCost, totalMinimumWeight, kingSet);
            // include this edge to my  MST (minimum spanning tree)

        }// end while

        System.out.println(ANSI_PURPLE + "Total Minimum Weight = " + totalMinimumWeight + ANSI_RESET);

    }// end method

    public boolean thereIsASetContainsAllVertices(Set<Set<E>> kingSet) {

        for (Set<E> currSet : kingSet) {

            if (currSet.size() == getVerticesCount()) {
                return true;
            }
        }

        return false;
    }// end method

    public int includeEdgeWhoseCostIs(int minCost, int totalMinimumWeight, Set<Set<E>> kingSet) {

        // first of all, find the edge whose cost is minCost, and know what are the 2 vertices which this edge is between.
        for (E currKey : map.keySet()) {

            Iterator<Vertex<E>> itr = map.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                if (v.getWeight() == minCost) {

                    //HERE
                    boolean shallWeIncludeThisEdge = addTheTwoVerticesToASet(currKey, v.getLabel(), kingSet);

                    if (shallWeIncludeThisEdge == true) {
                        System.out.println(ANSI_GREEN + "include edge (" + currKey + " , " + v.getLabel() + ") whose cost = " + v.getWeight() + ANSI_RESET);
                        totalMinimumWeight += v.getWeight();
                        return totalMinimumWeight;
                    }

                }
            }

        }

        return totalMinimumWeight;
    }

    public boolean addTheTwoVerticesToASet(E srcLabel, E destLabel, Set<Set<E>> kingSet) {

        boolean foundSrcLabel = false;
        boolean foundDestLabel = false;
        Set<E> saveSetWhereSrcLabelWasFound = null;
        Set<E> saveSetWhereDestLabelWasFound = null;

        int indexWhenSetOfSrcLabelWasFound = 0;
        int indexWhenSetOfDestLabelWasFound = 0;
        int i = 0;

        for (Set<E> currSet : kingSet) {

            if (currSet.contains(srcLabel)) {
                foundSrcLabel = true;
                saveSetWhereSrcLabelWasFound = currSet;
                indexWhenSetOfSrcLabelWasFound = i;
            }

            if (currSet.contains(destLabel)) {
                foundDestLabel = true;
                saveSetWhereDestLabelWasFound = currSet;
                indexWhenSetOfDestLabelWasFound = i;
            }

            i++;
        }// end forEach

        if (!foundSrcLabel && !foundDestLabel) {

            Set<E> s = new HashSet<>();
            s.add(srcLabel);
            s.add(destLabel);

            kingSet.add(s);
        } else if (foundSrcLabel && !foundDestLabel) {

            saveSetWhereSrcLabelWasFound.add(destLabel);
        } else if (foundDestLabel && !foundSrcLabel) {

            saveSetWhereDestLabelWasFound.add(srcLabel);
        } else if (foundSrcLabel && foundDestLabel && indexWhenSetOfSrcLabelWasFound != indexWhenSetOfDestLabelWasFound) {

            // then I have found both vertices but every vertex was found in a different set
            //saveSetWhereSrcLabelWasFound.addAll(saveSetWhereDestLabelWasFound);
            saveSetWhereDestLabelWasFound.addAll(saveSetWhereSrcLabelWasFound);

            //Set<E> concatSet = saveSetWhereSrcLabelWasFound;
            // kingSet.remove(saveSetWhereDestLabelWasFound);
            boolean done = kingSet.remove(saveSetWhereSrcLabelWasFound);

//            System.out.println(done);
//            if (done == false) {
//                done = saveSetWhereSrcLabelWasFound.addAll(saveSetWhereDestLabelWasFound);
//                kingSet.remove(saveSetWhereDestLabelWasFound);
//            }
            ///*******I DON'T KNOW WHAT'S THE PROBLEM HERE! SOMETIMES IT FAILS TO DELETE THE SET THAT WE DON'T
            // NEED AFTER CONCATINATING THE TWO SETS INTO ONE. BUT FORTUNATELY THIS DOESN'T MAKE A BIG PROBLEM
            // AT THE END THE ALGORITHM ENDS WHEN THERE'S A SET WHICH COVERS ALL VERTICES OF THE GRAPH
            //kingSet.add(concatSet);
        } else if (foundSrcLabel && foundDestLabel && indexWhenSetOfSrcLabelWasFound == indexWhenSetOfDestLabelWasFound) {
            // then I have found both vertices in the set. So I will not include this edge
            // which is between srcLabel Vertex and destLabel vertex
            // beacause if I included it, there would be a cycle in the minimum spanning tree which is not allowed

            System.out.println("No Change On The Sets. " + kingSet);
            return false;

        }

        System.out.println("The Set Of Sets: " + kingSet + ". Number Of Sets(Components) = " + kingSet.size());

        return true;

    }// end method


    public static void main(String[] args) {

        GenericGraph<String> gr = new GenericGraph<>();

        // edges are added. 
        // Since the graph is bidirectional, 
        // so boolean bidirectional is passed as true. 
        gr.addEdge("A", "B", true, 1);
        gr.addEdge("A", "C", true, 1);
        gr.addEdge("A", "X", true, 1);

        gr.addEdge("B", "E", true, 1);
        gr.addEdge("B", "D", true, 1);

        gr.addEdge("C", "D", true, 1);
        gr.addEdge("C", "X", true, 1);

        gr.addEdge("D", "E", true, 1);
        gr.addEdge("D", "P", true, 1);

        gr.addEdge("P", "X", true, 1);

        //gr.addEdge("X", "L", true, 1);
        //---------------------------
        gr.printAdjacencyList();
        //-----------------------------

        // gives the no of vertices in the graph. 
        System.out.println(gr.getVerticesCount());

        // gives the no of edges in the graph. 
        System.out.println(gr.getEdgesCount(true));

        // tells whether the edge is present or not. 
        System.out.println(gr.hasEdge("B", "P"));

        // tells whether vertex is present or not 
        System.out.println(gr.hasVertex("C"));

        //System.out.println("DFS: ");
        gr.printDfsUsingStack("A");

        gr.printDfsRecursiveHelper("A");
        System.out.println(gr.dfs("A"));

        gr.printBfs("A");
        System.out.println(gr.bfs("A"));

        System.out.println(gr.getNumberOfComponents());

        System.out.println(gr.isConnected());

        System.out.println("isCyclic? " + gr.isCyclic());

    }

}
