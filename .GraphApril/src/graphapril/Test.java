package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {


    public static void main(String[] args) {


                GraphApril<String> g = new GraphApril<>();
//
//        g.addEdge("A", "B", false, 5);
//        g.addEdge("A", "E", false, 2);
//        g.addEdge("B", "D", false, 4);
//        g.addEdge("B", "E", false, 10);
//        g.addEdge("B", "C", false, 3);
//        g.addEdge("D", "E", false, 16);
//        g.addEdge("D", "C", false, 7);
//        
//        
//        g.printAdjListWithWeights();
//        
//        
//        
//       // g.buildAdjacencyMatrix();
//        g.printAdjacencyMatrx();
//       // System.out.println(g.getNeighboursOfThisVertex("B"));        
//      //  System.out.println("BFS: "+g.breadth_firstSearch(new Vertex("D", 0)));
//        
//        g.BFS(new Vertex("C",0));
//        
        //==================================== NOW Test BFS example from the BOOK ==================
//        GraphApril<String> g = new GraphApril<>();
//
//        g.addEdge("r", "s", false, 5);
//        g.addEdge("r", "v", false, 2);
//        g.addEdge("s", "w", false, 4);
//        g.addEdge("w", "t", false, 10);
//        g.addEdge("w", "x", false, 3);
//        g.addEdge("x", "u", false, 16);
//        g.addEdge("x", "y", false, 7);
//        g.addEdge("t", "x", false, 74);
//        g.addEdge("u", "y", false, 7);
//        g.addEdge("u", "t", false, 7);
//
//        g.printAdjListWithWeights();
//
//        // g.buildAdjacencyMatrix();
//        g.printAdjacencyMatrix();
//        // System.out.println(g.getNeighboursOfThisVertex("B"));        
//         // System.out.println("BFS: "+g.breadth_firstSearch(new Vertex("r", 0)));
//
////        System.out.println( g.breadth_firstSearch(new Vertex("s",0)) );
////        
////        
//    System.out.println(g.BFS(new Vertex("s",0)));
////        
//         g.PRINT_PATH("s", "y");
////         
//        //========================================= NOW DFS: ===========================================================
//        System.out.println(g.depth_firstSearch(new Vertex("s", 0)));
//
//        System.out.println(g.getPredecessorListDFS("s"));
        //==============================================================================================================
        // =============== DFS book example (Directed Graph)
//        g.addEdge("1", "2", true, 5);
//        g.addEdge("1", "4", true, 2);
//        g.addEdge("4", "2", true, 2);
//        g.addEdge("2", "5", true, 2);
//        g.addEdge("5", "4", true, 4);
//        g.addEdge("3", "6", true, 2);
//        g.addEdge("3", "5", true, 2);
//        g.addEdge("6", "6", true, 2);
//
//        g.printAdjListWithWeights();
//
//        g.printAdjacencyMatrix();
//
//        System.out.println(g.DFS(new Vertex("1", 0)));
//        
        //=============Parenthesis Example from PowerPoint Slide # 53 =====================================

        g.addEdge("y", "x", true, 5);
        g.addEdge("x", "z", true, 2);
        g.addEdge("w", "x", true, 2);
        g.addEdge("z", "y", true, 2);
        g.addEdge("z", "w", true, 4);
        g.addEdge("s", "z", true, 2);
        g.addEdge("s", "w", true, 2);
        g.addEdge("v", "w", true, 2);
        g.addEdge("v", "s", true, 2);
        g.addEdge("t", "u", true, 2);
        g.addEdge("t", "v", true, 2);
        g.addEdge("u", "v", true, 2);
        
        g.printAdjListWithWeights();
        g.printAdjacencyMatrix();

        DFS_Attributes obj = g.DFS("s", true);

        System.out.println("DFS: "+obj.outputSet);
        System.out.println("\n"+DFS_Attributes.parenthesisString);

       // System.out.println(obj.timeList);
        
        new TimeStamp().printTimeList(obj.timeList);
        

     //   g.sortTimeListAccordingToFinishTimes(new Vertex("s", 3));

        //======================================================================================================== 
    }// end main
}// end class
