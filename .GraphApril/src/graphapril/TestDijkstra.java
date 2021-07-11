package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestDijkstra {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("A", "B", true, 50);
        gr.addEdge("A", "C", true, 45);
        gr.addEdge("A", "D", false, 10);

        gr.addEdge("B", "D", true, 15);
        gr.addEdge("D", "E", true, 15);
        gr.addEdge("E", "B", true, 20);
        gr.addEdge("B", "C", true, 10);

        gr.addEdge("C", "E", true, 30);
        gr.addEdge("E", "C", true, 35);
        gr.addEdge("F", "E", true, 3);

        gr.printAdjListWithWeights();

        gr.printAdjacencyMatrix();

        Dijkstra<String> dij = new Dijkstra(gr);

        System.out.println(dij.dijkstra("A", false));

        dij.printFinalResult("A");
        
        dij.printShortestPathForEachVertex();

    }// end main
}// end class
