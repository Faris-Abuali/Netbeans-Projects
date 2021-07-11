package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestBellmanMoodleAssignment {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        System.out.println("My Full Name: Fares Hatem Tawfiq AbuAli.");
        System.out.println("My Graph Consists of 7 Vertices: ");

        GraphApril<String> gr = new GraphApril<>();

        //------------- My Graph ------------------------
        /* This graph consists of 7 vertices:
        / 1-Fares, 2-Hatem, 3-Tawfiq, 4-AbuAli, 5-Fofo  6-Bellman  7-Yosof */
        gr.addEdge("Fares", "Hatem", true, 6);
        gr.addEdge("Fares", "Tawfiq", true, 5);
        gr.addEdge("Fares", "AbuAli", true, 5);

        gr.addEdge("Hatem", "Fofo", true, -1);
        gr.addEdge("Tawfiq", "Hatem", true, -2);
        gr.addEdge("Tawfiq", "Fofo", true, 1);
        gr.addEdge("AbuAli", "Tawfiq", true, -2);
        gr.addEdge("AbuAli", "Bellman", true, -1);
        gr.addEdge("Fofo", "Yosof", true, 3);
        gr.addEdge("Bellman", "Yosof", true, 3);

        System.out.println("\n------ AdjList With Weights ------");

        gr.printAdjListWithWeights();

        //gr.printEdgeList();
        Bellman_Ford<String> bel = new Bellman_Ford(gr);

        Bellman_Ford.BF_Attributes<String> output = bel.bellmanFord("Fares"); // source vertex is: (Fares)

        System.out.println("Contains Negative Weight Cycles? ");

        if (output.flag == true) {
            System.out.println(ANSI_GREEN+"No, there're no negative weight cycles"+ANSI_RESET);
        } else {
            System.out.println(ANSI_RED+"Yes, there's a negative weight cycle!!!"+ANSI_RESET);
        }

        bel.printFinalResult("Fares"); // source vertex is: (Fares)
        System.out.println();

        //   bel.printPath("Fares", "Fofo");
        bel.printAllpaths("Fares");// source vertex is: (Fares)

    }// end main
}// end class
