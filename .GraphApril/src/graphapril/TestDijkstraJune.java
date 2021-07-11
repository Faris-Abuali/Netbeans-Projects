package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestDijkstraJune {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("s", "t", true, 6); // source,destination,isDirected?,weight
        gr.addEdge("s", "y", true, 7);
        gr.addEdge("t", "y", true, 8);
        gr.addEdge("t", "x", true, 5);
        gr.addEdge("x", "t", true, -2);
        gr.addEdge("t", "z", true, -4);
        gr.addEdge("y", "z", true, 9);
        gr.addEdge("z", "x", true, 7);
        gr.addEdge("y", "x", true, -3);
        gr.addEdge("z", "s", true, 2);

        DijkstraTheBest<String> d = new DijkstraTheBest(gr);
        
        d.dijkstraBook("s");
        
        d.printFinalResult("s");
        
        
    }// end main
}// end class
