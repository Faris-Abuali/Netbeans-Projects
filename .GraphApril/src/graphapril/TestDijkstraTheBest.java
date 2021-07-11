package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestDijkstraTheBest {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        // -------------------------------- Example from Abdul Bari YouTube --------------------------------
//        gr.addEdge("A", "B", true, 50);
//        gr.addEdge("A", "C", true, 45);
//        gr.addEdge("A", "D", false, 10);
//
//        gr.addEdge("B", "D", true, 15);
//        gr.addEdge("D", "E", true, 15);
//        gr.addEdge("E", "B", true, 20);
//        gr.addEdge("B", "C", true, 10);
//
//        gr.addEdge("C", "E", true, 30);
//        gr.addEdge("E", "C", true, 35);
//        gr.addEdge("F", "E", true, 3);
//
//        gr.printAdjListWithWeights();
//
//        gr.printAdjacencyMatrix();
//
//       DijkstraTheBest<String> dij = new DijkstraTheBest(gr);
//
//        dij.dijkstraBook("A");
//
//        dij.printPath("A", "B");
//
//        dij.printFinalResult("A");
        //=============================================================================================================
        // -------------------------------- Example from The Book --------------------------------
        gr.addEdge("s", "t", true, 10);
        gr.addEdge("s", "y", true, 5);
        gr.addEdge("t", "y", true, 2);
        gr.addEdge("y", "t", true, 3);
        gr.addEdge("t", "x", true, 1);
        gr.addEdge("y", "z", true, 2);
        gr.addEdge("z", "x", true, 6);
        gr.addEdge("x", "z", true, 4);
        gr.addEdge("z", "s", true, 7);
        gr.addEdge("y", "x", true, 9);
        
        gr.printAdjListWithWeights();
        
       
        DijkstraTheBest<String> dij = new DijkstraTheBest(gr);

        dij.dijkstraBook("s");

        //dij.printPath("A", "B");

        dij.printFinalResult("s");
        
        
        dij.printPath("s","x");

        //---------------------------------------------------------------------------------------------
    }// end main

}// end class
