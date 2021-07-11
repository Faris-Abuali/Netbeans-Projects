package genericgraph;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class MinimumSpanningTree {

    public static void main(String[] args) {

        GenericGraph<String> gr = new GenericGraph<>();

        //-------------------First Example: Total Minimum Weight = 16 -----------------------------
//        gr.addEdge("a", "d", true, 4);
//        gr.addEdge("a", "b", true, 2);
//        gr.addEdge("a", "f", true, 5);
//
//        gr.addEdge("d", "e", true, 2);
//        gr.addEdge("d", "b", true, 1);
//
//        gr.addEdge("f", "g", true, 1);
//        gr.addEdge("f", "b", true, 8);
//
//        gr.addEdge("b", "e", true, 3);
//        gr.addEdge("b", "c", true, 7);
//        gr.addEdge("b", "g", true, 4);
//
//        gr.addEdge("e", "c", true, 10);
//        gr.addEdge("g", "c", true, 6);
//
//        gr.printAdjacencyListWithWeights();
//
//        gr.minimumSpanningTree();
        //===================================================End=====================================================  
        
        
        //-------------------Second Example: Total Minimum Weight = 37 ----------------------------------------------
        gr.addEdge("V0", "V1", true, 4);
        gr.addEdge("V0", "V7", true, 8);
        gr.addEdge("V1", "V7", true, 11);
        gr.addEdge("V1", "V2", true, 8);
        gr.addEdge("V7", "V6", true, 1);

        gr.addEdge("V7", "V8", true, 7);
        gr.addEdge("V2", "V8", true, 2);
        gr.addEdge("V8", "V6", true, 6);

        gr.addEdge("V2", "V3", true, 7);
        gr.addEdge("V2", "V5", true, 4);
        gr.addEdge("V6", "V5", true, 2);
        gr.addEdge("V3", "V5", true, 14);
        gr.addEdge("V3", "V4", true, 9);
        gr.addEdge("V4", "V5", true, 10);

        gr.printAdjacencyListWithWeights();

        gr.minimumSpanningTree();

        //===================================================End=====================================================    
        //System.out.println(gr.getEdgesCount(true));
        //System.out.println(gr.getVerticesCount());
    }// end main
}// end class
