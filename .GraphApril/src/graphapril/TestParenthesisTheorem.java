package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestParenthesisTheorem {
//@author Fares Abu Ali
    public static void main(String[] args) {
        
        GraphApril<String> gr = new GraphApril<>();
        //=============Parenthesis Example from PowerPoint Slide # 53 =====================================
        gr.addEdge("y", "x", true, 5); // (source, destination, isDirected?, weight)
        gr.addEdge("x", "z", true, 2);
        gr.addEdge("w", "x", true, 2);
        gr.addEdge("z", "y", true, 2);
        gr.addEdge("z", "w", true, 4);
        gr.addEdge("s", "z", true, 2);
        gr.addEdge("s", "w", true, 2);
        gr.addEdge("v", "w", true, 2);
        gr.addEdge("v", "s", true, 2);
        gr.addEdge("t", "u", true, 2);
        gr.addEdge("t", "v", true, 2);
      //  gr.addEdge("u", "v", true, 2);

        gr.printAdjListWithWeights();
        gr.printAdjacencyMatrix();
        DFS_Attributes obj = gr.DFS("s", true);  // sourceVertex is (s)

        System.out.println("DFS: " + obj.outputSet);
        System.out.println("\nParenthesis:\n" + DFS_Attributes.parenthesisString);

        // System.out.println(obj.timeList);
        new TimeStamp().printTimeList(obj.timeList);
    }
}// end class
