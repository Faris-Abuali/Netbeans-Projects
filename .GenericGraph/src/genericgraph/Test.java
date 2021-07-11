package genericgraph;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        GenericGraph<String> gr = new GenericGraph<>();

        gr.addEdge("A", "F", true, 1);
        gr.addEdge("F", "C", true, 1);
        gr.addEdge("C", "G", true, 1);
        gr.addEdge("C", "E", true, 1);
        gr.addEdge("G", "E", true, 1);
        gr.addEdge("B", "R", true, 1);
        gr.addEdge("B", "D", true, 1);
        gr.addEdge("R", "D", true, 1);

        
        

        gr.printAdjacencyList();
//        
//        System.out.println(gr.getEdgesCount(true));
//        System.out.println(gr.getVerticesCount());
//        
//        System.out.println(gr.hasEdge("B","R"));   
//        
//        gr.dfsRecursive("R");
//        

        System.out.println(gr.getNumberOfComponents());
        
        
       gr.printDfsRecursiveHelper("A");
       
        System.out.println(gr.dfs("A"));
        
        
        System.out.println(gr.isConnected());
        
        System.out.println("isCyclic? "+gr.isCyclic());


        //System.out.println(Arrays.toString(gr.getChildrenOf("C")));
    }// end main

}// end Class
