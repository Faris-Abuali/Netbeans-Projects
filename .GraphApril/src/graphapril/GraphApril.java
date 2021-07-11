package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class GraphApril<E> {

    static boolean theAdjMatrixIsBuilt = false;
    static boolean theTransposeGraphIsBuilt = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final int INFINITY = 1_000_000_000; // 1 billion

    // this is the adjacency list
    public Map<E, LinkedList<Vertex<E>>> AdjList = new HashMap<>();

    protected Map<E, LinkedList<Vertex<E>>> AdjListTranspose = new HashMap<>();

    // this is the adjacency matrix    
    protected Map<E, Map<E, Integer>> AdjMatrix = new HashMap<>();

    public void addVertex(E vertexKey) {  // I don't want this method to be called outside this class
        AdjList.put(vertexKey, new LinkedList<Vertex<E>>());
    }

    public void addEdge(E source, E destination, boolean directed, int weight) {

        //----------------First, Store in The AdjList ------------------------------
        if (!AdjList.containsKey(source)) {
            addVertex(source);
        }

        if (!AdjList.containsKey(destination)) {
            addVertex(destination);
        }

        AdjList.get(source).add(new Vertex(destination, weight));

        if (!directed) {
            AdjList.get(destination).add(new Vertex(source, weight));
        }

        //----------------Finished------------------------------
        //----------------Now, Store in The AdjMatrix ------------------------------
//        if (!AdjMatrix.containsKey(source)) {
//            AdjMatrix.put(source, new HashMap());
//        }
//        if (!AdjMatrix.containsKey(destination)) {
//            AdjMatrix.put(destination, new HashMap());
//        }
//
//        AdjMatrix.get(source).put(source, weight);
//
//        if (!directed) {
//            AdjMatrix.get(destination).put(destination, weight);
//        }
        //----------------Finished------------------------------
    }// end method addEdge

    public void printAdjListWithWeights() {

        for (E currentKey : AdjList.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator itr = AdjList.get(currentKey).listIterator();

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

    }// end method

    public void buildAdjacencyMatrix() {

        //CAUTION: THIS METHOD IS MADE TO BE INVOKED AFTER THE AdjList IS COMPLETELY BUILT
        for (E currKey : AdjList.keySet()) {

            Map<E, Integer> mapInside = new HashMap<>();

            for (E currKeyInside : AdjList.keySet()) {

                if (currKeyInside.equals(currKey)) {
                    mapInside.put(currKeyInside, 0);
                } else {
                    mapInside.put(currKeyInside, INFINITY);
                }
            }// end inner for

            AdjMatrix.put(currKey, mapInside);

        }// end outer for

        //=================================================================
        for (E currKey : AdjList.keySet()) {

            LinkedList<Vertex<E>> currLinkedList = AdjList.get(currKey);

            Iterator<Vertex<E>> itr = currLinkedList.listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                AdjMatrix.get(currKey).put(v.getLabel(), v.getWeight());
            }

        }
        //=================================================================

        theAdjMatrixIsBuilt = true;

    }// end method

    public void printEdgeList() {

        System.out.print("edgeList: ");

        for (E currKey : AdjList.keySet()) {

            Iterator<Vertex<E>> itr = AdjList.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                System.out.print("(" + currKey + ", " + v.getLabel() + "),");

            }
        }// rnd forEach

        System.out.println("");
    }// end method

    //================ AESTHETICS =============================
//    public int giveTheLargestWeight(){
//        
//        int maxWeight = Integer.MIN_VALUE;
//        
//        for(E currKey:AdjList.keySet()){
//            
//            Iterator<Vertex<E>> itr = AdjList.get(currKey).listIterator();
//            
//            while(itr.hasNext()){
//                
//                int wt = itr.next().getWeight();
//                
//                if(wt>maxWeight){
//                    maxWeight=wt;
//                }
//            }
//        }
//        
//        return maxWeight;
//    }
//    
    static int lengthOfLargestWeight = 0;

//    public void format(){
//        
//        int maxWeight = giveTheLargestWeight();
//        int length = String.valueOf(maxWeight).length();
//        
//        lengthOfLargestWeight=length;
//        
//    }
//    
//    public String addZerosToTheLeft(int n){
//        
//        int currLength = String.valueOf(n).length();
//        
//        String str = n+"";
//        
//        while(str.length()<lengthOfLargestWeight){
//            str+="0";
//        }
//        
//        return str;
//    }
//    
    //================ END AESTHETICS =============================
    public void printAdjacencyMatrix() {

        if (!theAdjMatrixIsBuilt) {
            buildAdjacencyMatrix();
        }

        //format();
        //-----Print the vertices labels in a row----------------------
        System.out.print("  | ");
        for (E currKey : AdjMatrix.keySet()) {
            System.out.print(currKey + " | ");
        }
        System.out.println("\n--------------------------------------------");
        //-------------------------------------------------------------

        for (E currKey : AdjMatrix.keySet()) {

            System.out.print(currKey + " | ");

            Map<E, Integer> mapInside = AdjMatrix.get(currKey);

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

    //===================================================================
    public Set<E> getNeighboursOfThisVertex(E vertexLabel) {

        Set<E> set = new HashSet<>();

        if (AdjList.containsKey(vertexLabel)) {
            LinkedList<Vertex<E>> ll = AdjList.get(vertexLabel);

            Iterator<Vertex<E>> itr = ll.listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                set.add(v.getLabel());
            }

        }// end if

        return set;
    }// end method

//================================= Transpose Graph ==============================================
    public void buildTheTransposeOfThisGraph() {

        for (E currKey : AdjList.keySet()) {

            AdjListTranspose.put(currKey, new LinkedList<Vertex<E>>());// initialize the LinkedList

        }// end for each

        for (E currKey : AdjList.keySet()) {

            Iterator<Vertex<E>> itr = AdjList.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> v = itr.next();

                AdjListTranspose.get(v.getLabel()).add(new Vertex(currKey, v.getWeight()));
            }

        }

    }// end method

    public void printTransposeAdjListWithWeights() {

        for (E currentKey : AdjListTranspose.keySet()) {

            System.out.print("| " + currentKey + " |");

            Iterator itr = AdjListTranspose.get(currentKey).listIterator();

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

    }// end method

    //================================= End Transpose Graph ==============================================
//===================================Chapter 22: Graph Algorithms=============================
    public Set<E> breadth_firstSearch(Vertex<E> source) {

        Map<E, Boolean> visited = createNewVisitedList();

        visited.put(source.getLabel(), true);

        Set<E> outputSet = new LinkedHashSet<>();

        Queue<Vertex<E>> q = new LinkedList<>();

        q.add(source);
        outputSet.add(source.getLabel());

        while (!q.isEmpty()) {

            Vertex<E> currPredecessor = q.peek();

            Iterator<Vertex<E>> itr = AdjList.get(currPredecessor.getLabel()).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neighbour = itr.next();

                if (visited.get(neighbour.getLabel()) == false) {
                    q.add(neighbour);
                    visited.put(neighbour.getLabel(), true);
                }

            }// end iterator while

            outputSet.add(q.remove().getLabel());

        }// end while

        return outputSet;
    }// end method

    public Set<Vertex<E>> BFS(Vertex<E> source, boolean printDetails) { // from the book

        Map<E, Boolean> visited = createNewVisitedList();

        visited.put(source.getLabel(), true);

        Set<Vertex<E>> outputSet = new LinkedHashSet<>();

        Queue<Vertex<E>> q = new LinkedList<>();

        source.setD(0);
        source.setπ(null);

        q.add(source);
        outputSet.add(source);

        while (!q.isEmpty()) {

            Vertex<E> currPredecessor = q.peek();

            Iterator<Vertex<E>> itr = AdjList.get(currPredecessor.getLabel()).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neighbour = itr.next();

                if (visited.get(neighbour.getLabel()) == false) {
                    q.add(new Vertex(neighbour.getLabel(), neighbour.getWeight(), currPredecessor.getD() + 1, currPredecessor));
                    visited.put(neighbour.getLabel(), true);
                }

            }// end iterator while

            outputSet.add(q.remove());

        }// end while

        if (printDetails) {
            for (Vertex<E> v : outputSet) {

                System.out.println("( " + v.getLabel() + ", π = " + v.getπ() + ", d = " + v.getD() + " )");
            }
        }
        return outputSet;

        /*
        The results of breadth-first search may depend upon the order in which the neighbors of a given vertex are visited.
       The breadth-first tree may vary, but the distances d computed by the algorithm will not.
         */
    }// end method

    public Map<E, E> getPredecessorListBFS(E sourceLabel) {

        Set<Vertex<E>> set = BFS(new Vertex(sourceLabel, INFINITY),false);

        Map<E, E> π = new HashMap<>();

        // Vertex<E> sourceVertex, destVertex;
        Iterator<Vertex<E>> itr = set.iterator();

        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (currVertex.getπ() == null) {
                π.put(currVertex.getLabel(), null);
            } else {
                π.put(currVertex.getLabel(), currVertex.getπ().getLabel());
            }
        }

        //  System.out.println(π);
        return π;

    }

    public void PRINT_PATH(E sourceLabel, E destLabel) {

        System.out.print("ShortestPath: δ(" + sourceLabel + ", " + destLabel + ") : ");

        Map<E, E> π = getPredecessorListBFS(sourceLabel);

        print_pathRec(sourceLabel, destLabel, π);

    }

    public void print_pathRec(E sourceLabel, E destLabel, Map<E, E> π) {

        if (sourceLabel.equals(destLabel)) {
            System.out.print(sourceLabel + " ");
        } else {

            if (π.get(destLabel).equals(null)) {
                System.out.println("no path from” source “to” dest “exist");
            } else {
                print_pathRec(sourceLabel, π.get(destLabel), π);
                System.out.print(destLabel + " ");
            }
        }

    }// end method

    //=============================================== END BFS =================================================
    //=============================================== NOW: DFS =================================================
    static int time = 0;

    // StringBuilder parenthesisString = new StringBuilder("");
    public /*Set<Vertex<E>>*/ DFS_Attributes<E> DFS(E sourceVertex, boolean flag) { // no source vertex needed

        boolean wantSpecificSourceVertex = flag;

        time = 0;

        //System.out.println("DFS: ");
        Map<E, Boolean> visited = createNewVisitedList();
        Map<E, TimeStamp> timeList = createTimeStampList();
        Map<E, E> π = createNewπList();

        //sourceVertex.setπ(null);
        Set<Vertex<E>> outputSet = new LinkedHashSet<>();

        DFS_Attributes<E> obj = new DFS_Attributes(outputSet, timeList);

        for (E currKey : AdjList.keySet()) {

            if (wantSpecificSourceVertex) { // this is just for the case when I want  a SPECIFIC vertex to be the source
                //currKey = sourceVertex;
                // Vertex<E> vtemp = AdjList.get(sourceVertex).getFirst();

                obj = DFSrec(new Vertex(currKey, 0), visited, obj.outputSet, timeList, π);
                wantSpecificSourceVertex = false;
            }
            // If any undiscovered vertices remain, then one of them is chosen as a 
            // new source and search is repeated from that source.
            if (visited.get(currKey) == false) {
                //System.out.println("tree++");

                π.put(currKey, null); // nevermind

                // Vertex<E> vtemp = AdjList.get(currKey).getFirst();
                obj = DFSrec(new Vertex(currKey, 0), visited, obj.outputSet, timeList, π);
            }
        }
        //return obj.outputSet;
        return obj;

    }// end method

    private DFS_Attributes<E> DFSrec(Vertex<E> sourceVertex, Map<E, Boolean> visited, Set<Vertex<E>> outputSet,
            Map<E, TimeStamp> timeList, Map<E, E> π) {

        //d[v] = discovery time (v turns from white to gray)
        //f [v] = finishing time (v turns from gray to black)
        DFS_Attributes.parenthesisString.append("(" + sourceVertex.getLabel() + " ");
        time = time + 1;      // white vertex u has just been discovered 
        //sourceVertex.setD(time);
        timeList.get(sourceVertex.getLabel()).setD(time);  // d = discovery time

        visited.put(sourceVertex.getLabel(), true);

        outputSet.add(sourceVertex);
        //System.out.print(sourceVertex.getLabel()+" ");
        Iterator<Vertex<E>> itr = AdjList.get(sourceVertex.getLabel()).listIterator();

        /*
        A vertex is “discovered” the first time it is encountered during the search.
        A vertex is “finished” if it is a leaf node or all vertices adjacent to it have been finished.
         */
        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (visited.get(currVertex.getLabel()) == false) {

                currVertex.setπ(sourceVertex);
                π.put(currVertex.getLabel(), sourceVertex.getLabel()); // every vertex points at its parent

                DFSrec(new Vertex(currVertex.getLabel(), currVertex.getWeight()), visited, outputSet, timeList, π);
            }

        }// end while

        // HERE WE BLACKEN THE VERTEX (sourceVertex) because its adjList (adjList[sourceVertex]) has been completely examined
        time = time + 1;
        timeList.get(sourceVertex.getLabel()).setF(time); // f = finish time: time when the adjList[v] has been entirely examined

        DFS_Attributes.parenthesisString.append(sourceVertex.getLabel() + ") ");

        return new DFS_Attributes(outputSet, timeList);
        // return new DFS_Attributes(outputSet, timeList);

    }// end method DFS

    public void sortTimeListAccordingToFinishTimes(Vertex<E> sourceVertex) {

        // this is NOT the OPTIMAL topological sort algorithm, this receives the timeList(discovery,finish time for each vertex)
        // from the DFS() method, and sorts it  in order of decreasing fnishing time.
        // But as I said, this is not optimal, as it requires O(n lgn) for sort, and the optimal topologicalSort requires
        // only O(E + V)
        /*   
        1- call DFS(G) to compute finishing times v.f for each vertex v.
        2- as each vertex is finished, insert it onto the front of a linked list .
        3- return the linked list of vertices.
         */
        DFS_Attributes<E> obj = DFS(sourceVertex.getLabel(), true);

        Map<E, TimeStamp> timeList = obj.timeList;

        ArrayList<Pair<E>> arlist = new ArrayList<>();

        for (E currKey : timeList.keySet()) {
            arlist.add(new Pair(currKey, timeList.get(currKey).getF()));
        }

        System.out.println(arlist);

        Collections.sort(arlist, new TimeSorter());

        System.out.println("Sorted: " + arlist);

    }// end mehtod

    public LinkedList<Vertex<E>> TOPOLOGICAL_SORT(E sourceVertex, boolean flag) {

        /*   
        1- call DFS(G) to compute finishing times v.f for each vertex v.
        2- as each vertex is finished, insert it onto the front of a linked list .
        3- return the linked list of vertices.
        
        Look Fares: the following method and also topologicaRec is LITTERALLY THE SAME AS DFS() and DFSrec() algorithm
         */
        LinkedList<Vertex<E>> linkedList = new LinkedList<>();

        boolean wantSpecificSourceVertex = flag;

        time = 0;

        //System.out.println("DFS: ");
        Map<E, Boolean> visited = createNewVisitedList();
        Map<E, TimeStamp> timeList = createTimeStampList();
        Map<E, E> π = createNewπList();

        //sourceVertex.setπ(null);
        Set<Vertex<E>> outputSet = new LinkedHashSet<>();

        DFS_Attributes<E> obj = new DFS_Attributes(outputSet, timeList);

        for (E currKey : AdjList.keySet()) {

            if (wantSpecificSourceVertex) { // this is just for the case when I want  a SPECIFIC vertex to be the source
                currKey = sourceVertex;
                wantSpecificSourceVertex = false;
            }
            // If any undiscovered vertices remain, then one of them is chosen as a 
            // new source and search is repeated from that source.
            if (visited.get(currKey) == false) {
                π.put(currKey, null); // nevermind
                linkedList = topologicalRec(new Vertex(currKey, 0), visited, obj.outputSet, timeList, π, linkedList);
            }
        }

        // System.out.println(obj.timeList);
        //return obj.outputSet;
        return linkedList;

    }// end method topologicalSort

    private LinkedList<Vertex<E>> topologicalRec(Vertex<E> sourceVertex, Map<E, Boolean> visited, Set<Vertex<E>> outputSet, Map<E, TimeStamp> timeList, Map<E, E> π, LinkedList<Vertex<E>> llist) {

        //d[v] = discovery time (v turns from white to gray)
        //f [v] = finishing time (v turns from gray to black)
        time = time + 1;      // white vertex u has just been discovered 
        //sourceVertex.setD(time);
        timeList.get(sourceVertex.getLabel()).setD(time);  // d = discovery time

        visited.put(sourceVertex.getLabel(), true);

        outputSet.add(sourceVertex);
        //System.out.print(sourceVertex.getLabel()+" ");
        Iterator<Vertex<E>> itr = AdjList.get(sourceVertex.getLabel()).listIterator();

        /*
        A vertex is “discovered” the first time it is encountered during the search.
        A vertex is “finished” if it is a leaf node or all vertices adjacent to it have been finished.
         */
        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (visited.get(currVertex.getLabel()) == false) {

                currVertex.setπ(sourceVertex);
                π.put(currVertex.getLabel(), sourceVertex.getLabel()); // every vertex points at its parent

                topologicalRec(currVertex, visited, outputSet, timeList, π, llist);
            }

        }// end while

        // HERE WE BLACKEN THE VERTEX (sourceVertex) because its adjList (adjList[sourceVertex]) has been completely examined
        time = time + 1;
        timeList.get(sourceVertex.getLabel()).setF(time); // f = finish time: time when the adjList[v] has been entirely examined
        llist.addFirst(sourceVertex);

        return llist;
        // return new DFS_Attributes(outputSet, timeList);

    }// end method

    //==================================== Strongly Connected Components ===========================================
    public /*void*/ ArrayList<ArrayList<Vertex<E>>> STRONGLY_CONNECTED_COMPONENTS(E sourceLabel, boolean flag) {

        if (!theTransposeGraphIsBuilt) {
            buildTheTransposeOfThisGraph();
        }

        // *** A directed graph is strongly connected if there's a path between all pairs of vertices ***
        // *** A strongly connected component (SCC) of a directed graph is: a maximal strongly connected subgraph.
        // if flag==true then the we MUST start from the sourceLabel that is passed to the function
        /*
        
        STRONGLY-CONNECTED-COMPONENTS:
        1. call DFS(G) to compute finishing times u.f for each vertex u 
        2. compute G transpose  (G^T) 
        3. call DFS(G^T), but in the main loop of DFS, consider the vertices in order of decreasing u.f (as computed in line 1) 
        4. output the vertices of each tree in the depth-first forest formed in line 3 as a separate strongly connected component 
        
         */
        DFS_Attributes<E> dfs = DFS(sourceLabel, flag);

        ArrayList<Pair<E>> arList = new TimeStamp().sortDFSTimeListInOrderOfDecreasingFinishTimes(dfs.timeList);

        // System.out.println("arList: "+arList);
        ArrayList<ArrayList<Vertex<E>>> listOfAllComponents = secondDFS_SCC(arList);

//        System.out.println("List Of All Components: ");
//
//        for (int i = 0; i < listOfAllComponents.size(); i++) {
//
//            ArrayList<Vertex<E>> currList = listOfAllComponents.get(i);
//            System.out.println(listOfAllComponents.get(i));
//
//            for (int j = 0; j < currList.size(); j++) {
//                System.out.print(currList.get(j).getWeight() + " ");
//            }
//
//            System.out.println();
//        }// end for outer
        return listOfAllComponents;

    } // end method

    public /*DFS_Attributes<E>*/ ArrayList<ArrayList<Vertex<E>>> secondDFS_SCC(ArrayList<Pair<E>> arList) { // no source vertex needed

        /*
        arList contains all the vertices of the graph in the order they were traversed when
        we invoked DFS() for the first time for the graph G.
        
        Remember the 3rd Step in STRONGLY_CONNECTED_COMPONENTS() algorithm.
        3. call DFS(G^T), but in the main loop of DFS, consider the vertices in order of decreasing u.f (as computed in line 1)      
         */
        //SCC = Strongly Connected Components
        time = 0;

        ArrayList<ArrayList<Vertex<E>>> listOfAllComponents = new ArrayList<>();

        //System.out.println("DFS: ");
        Map<E, Boolean> visited = createNewVisitedList();
        Map<E, TimeStamp> timeList = createTimeStampList();
        Map<E, E> π = createNewπList();

        //sourceVertex.setπ(null);
        Set<Vertex<E>> outputSet = new LinkedHashSet<>();

        DFS_Attributes<E> obj = new DFS_Attributes(outputSet, timeList);

        for (Pair<E> p : arList) {

            // If any undiscovered vertices remain, then one of them is chosen as a 
            // new source and search is repeated from that source.
            if (visited.get(p.key) == false) {

                π.put(p.key, null); // nevermind

                //Vertex<E> vtemp = new Vertex(p.key, AdjListTranspose.get(p.key).getFirst().getWeight());
                obj = secondDFS_SCC_Rec(new Vertex(p.key, 0), visited, obj.outputSet, obj.timeList, π);

                /*
                in the DFS of G, forefather of an SCC is the:
                -first vertex discovered in the SCC
                - last vertex finished in the SCC
                 */
                // System.out.println("One Component: " + outputSet);
                ArrayList<Vertex<E>> componentArList = new ArrayList(outputSet);
                listOfAllComponents.add(componentArList);

                outputSet.clear();
            }
        }// end for each

        // System.out.println(obj.timeList);
        //return obj.outputSet;
        //new TimeStamp().printTimeList(obj.timeList);
        return listOfAllComponents;

    }// end method

    private DFS_Attributes<E> secondDFS_SCC_Rec(Vertex<E> sourceVertex, Map<E, Boolean> visited, Set<Vertex<E>> outputSet, Map<E, TimeStamp> timeList, Map<E, E> π) {

        //SCC = Strongly Connected Components
        //d[v] = discovery time (v turns from white to gray)
        //f [v] = finishing time (v turns from gray to black)
        DFS_Attributes.parenthesisString.append("(" + sourceVertex.getLabel() + " ");
        time = time + 1;      // white vertex u has just been discovered 
        //sourceVertex.setD(time);
        timeList.get(sourceVertex.getLabel()).setD(time);  // d = discovery time

        visited.put(sourceVertex.getLabel(), true);

        outputSet.add(sourceVertex);
        //System.out.print(sourceVertex.getLabel()+" ");

        // CAUTION: WE ARE NOW DOING DFS FOR THE (TRANSPOSE GRAPH) NOT THE ORIGINAL GRAPH!! so use AdjListTranspose
        Iterator<Vertex<E>> itr = AdjListTranspose.get(sourceVertex.getLabel()).listIterator();

        /*
        A vertex is “discovered” the first time it is encountered during the search.
        A vertex is “finished” if it is a leaf node or all vertices adjacent to it have been finished.
         */
        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (visited.get(currVertex.getLabel()) == false) {

                currVertex.setπ(sourceVertex);
                π.put(currVertex.getLabel(), sourceVertex.getLabel()); // every vertex points at its parent

                secondDFS_SCC_Rec(currVertex, visited, outputSet, timeList, π);
            }

        }// end while

        // HERE WE BLACKEN THE VERTEX (sourceVertex) because its adjList (adjList[sourceVertex]) has been completely examined
        time = time + 1;
        timeList.get(sourceVertex.getLabel()).setF(time); // f = finish time: time when the adjList[v] has been entirely examined

        DFS_Attributes.parenthesisString.append(sourceVertex.getLabel() + ") ");

        return new DFS_Attributes(outputSet, timeList);
        // return new DFS_Attributes(outputSet, timeList);

    }// end method 

    //=====================================================================================================================
    public boolean isAcyclic() {
        //Lemma : A directed graph G is acyclic if and only if a depth-first search of G yields no back edges.

        boolean flag = true;

        Map<E, Boolean> visited = createNewVisitedList();
        Map<E, E> π = createNewπList();

        for (E currKey : AdjList.keySet()) {

            // if (visited.get(currKey) == false) {
            flag = isAcyclicRec(currKey, visited, π, true);
            //}

            if (flag == false) { // a CYCLE detected! No need to examine further
                break;
            }

        }// end for each

        return flag;

    }// end method

    public boolean isAcyclicRec(E sourceVertex, Map<E, Boolean> visited, Map<E, E> π, boolean flag) {

        visited.put(sourceVertex, true);

        Iterator<Vertex<E>> itr = AdjList.get(sourceVertex).listIterator();

        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (visited.get(currVertex.getLabel()) == false) {

                // currVertex.setπ(sourceVertex);
                π.put(currVertex.getLabel(), sourceVertex); // every vertex points at its parent               

                flag = isAcyclicRec(currVertex.getLabel(), visited, π, flag);

                if (flag == false) {
                    break; // a CYCLE detected! No need to examine further
                }
            } else {// then the currVertex has been discovered previously (it is non-white)

                E parentOfCurrVertex = π.get(currVertex.getLabel());
                E parentOfSourceVertex = π.get(sourceVertex);

                if (parentOfCurrVertex != null && parentOfSourceVertex != null && !parentOfCurrVertex.equals(parentOfSourceVertex)) {
                    return false;  // there's a CYCLE detected
                }

            }

        }// end while

        return flag;

    }// end method

    public Map<E, E> getPredecessorListDFS(E sourceLabel) {

        Set<Vertex<E>> set = DFS(sourceLabel, true).outputSet;

        Map<E, E> π = new HashMap<>();

        // Vertex<E> sourceVertex, destVertex;
        Iterator<Vertex<E>> itr = set.iterator();

        while (itr.hasNext()) {

            Vertex<E> currVertex = itr.next();

            if (currVertex.getπ() == null) {
                π.put(currVertex.getLabel(), null);
            } else {
                π.put(currVertex.getLabel(), currVertex.getπ().getLabel());
            }
        }

        //  System.out.println(π);
        return π;

    }

    public Map<E, TimeStamp> createTimeStampList() {

        Map<E, TimeStamp> map = new HashMap<>(AdjList.keySet().size());

        for (E currKey : AdjList.keySet()) {
            map.put(currKey, new TimeStamp(0, 0));
        }

        return map;
    }// end method
    //=======================================================================================================

    public Map<E, Boolean> createNewVisitedList() {

        Map<E, Boolean> map = new HashMap<>(AdjList.keySet().size());

        for (E currKey : AdjList.keySet()) {
            map.put(currKey, false);
        }

        return map;
    }// end method

    //=======================================================================================================
    public Map<E, E> createNewπList() {

        Map<E, E> map = new HashMap<>(AdjList.keySet().size());

        for (E currKey : AdjList.keySet()) {
            map.put(currKey, null);
        }

        return map;
    }// end method

    //=======================================================================================================
    public void sumOfWeightsOfStronglyConnectedComponents() {

        ArrayList<ArrayList<Vertex<E>>> listOfAllComponents = STRONGLY_CONNECTED_COMPONENTS(null, false);

        for (int i = 0; i < listOfAllComponents.size(); i++) {

            ArrayList<Vertex<E>> currList = listOfAllComponents.get(i);

            System.out.println(currList);

            int sum = 0;

            for (int j = currList.size() - 1; j > 0; j--) {

                LinkedList<Vertex<E>> ll = AdjList.get(currList.get(j).getLabel());
                Vertex<E> v = getVertexWhoseLabelIs(currList.get(j - 1).getLabel(), ll);

                System.out.print(v.getWeight() + "  ");

                sum += v.getWeight();
            }
            // don't forget that SCC is (circular) component, I mean: the first vertex in the currList is connected with an edge
            // to the last vertec in the currList

            LinkedList<Vertex<E>> ll = AdjList.get(currList.get(0).getLabel());
            Vertex<E> v = getVertexWhoseLabelIs(currList.get(currList.size() - 1).getLabel(), ll);
            System.out.print(v.getWeight() + "  ");

            sum += v.getWeight();

            System.out.println("\nsum of this SCC: " + currList + " = " + sum);
        }// end outer for

    }// end method

    public Vertex<E> getVertexWhoseLabelIs(E label, LinkedList<Vertex<E>> ll) {

        // this method recieves a linkedList and serches about a vertex whose label is (label) 
        //and then returns the vertex if it's found.
        Iterator<Vertex<E>> itr = ll.listIterator();

        while (itr.hasNext()) {

            Vertex<E> v = itr.next();

            if (v.getLabel().equals(label)) {
                return v;
            }
        }

        return null;
    }// end method

//=========================================================================
    public static void main(String[] args) {

    }// end main

}// end class
