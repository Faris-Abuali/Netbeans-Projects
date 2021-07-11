package Ford_Fulkerson;

import graphapril.*;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class TestFulkerson {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("s", "v1", true, 16);
        gr.addEdge("s", "v2", true, 13);
        gr.addEdge("v2", "v1", true, 4);
        gr.addEdge("v1", "v2", true, 10);

        gr.addEdge("v1", "v3", true, 12);
        gr.addEdge("v3", "v2", true, 9);
        gr.addEdge("v2", "v4", true, 14);
        gr.addEdge("v4", "v3", true, 7);
        gr.addEdge("v4", "t", true, 4);
        gr.addEdge("v3", "t", true, 20);

        //System.out.println(gr.AdjList.keySet());
        FordFulkerson<String> ff = new FordFulkerson(gr);

        //ff.buildAdjListOfEdges();

        //ff.printAdjListWithWeights();

        //ff.buildTheResidualGraph();

       // ff.printResidualNetwork();
        
       
       ff.ford_Fulkerson("s","t");
       
      ff.printResidualNetwork();
      
      ff.printFinalResults();
      
//        
 //       ff.printAllEdgesInTheResidualNetwork();

        
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
//        ArrayList<Edge<String>> path = ff.seekAugmentingPath("s", "t", false, new ArrayList<Edge<String>>(), ff.createMapOfVisitedState()).arList;
//        System.out.println(path);
//        ff.workOnThePath(path);
//        System.out.println("flow = " + ff.maxFlow);
//
//        path = ff.seekAugmentingPath("s", "t", false, new ArrayList<Edge<String>>(), ff.createMapOfVisitedState()).arList;
//        System.out.println(path);
//        ff.workOnThePath(path);
//        System.out.println("flow = " + ff.maxFlow);
//
//        // ff.printResidualNetwork();
//        path = ff.seekAugmentingPath("s", "t", false, new ArrayList<Edge<String>>(), ff.createMapOfVisitedState()).arList;
//        System.out.println(path);
//        ff.workOnThePath(path);
//        System.out.println("flow = " + ff.maxFlow);
//
//        ff.printResidualNetwork();
//
//        
//        
//        
//        
//        path = ff.seekAugmentingPath("s", "t", false, new ArrayList<Edge<String>>(), ff.createMapOfVisitedState()).arList;
//
//        System.out.println(path);
//        ff.workOnThePath(path);
//        System.out.println("flow = " + ff.maxFlow);
//        ff.printResidualNetwork();
//
//        
//        
//       path = ff.seekAugmentingPath("s", "t", false, new ArrayList<Edge<String>>(), ff.createMapOfVisitedState()).arList;

// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
       
       
    }// end main
}// end class
