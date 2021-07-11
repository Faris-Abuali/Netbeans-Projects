package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestTopologicalSort {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("undershorts", "pants", true, 0);
        gr.addEdge("pants", "belt", true, 0);
        gr.addEdge("belt", "jacket", true, 0);
        gr.addEdge("shirt", "belt", true, 0);
        gr.addEdge("shirt", "tie", true, 0);
        gr.addEdge("tie", "jacket", true, 0);
        gr.addEdge("undershorts", "shoes", true, 0);
        gr.addEdge("pants", "shoes", true, 0);
        gr.addEdge("socks", "shoes", true, 0);
        gr.addVertex("watch");
        
        
        
        gr.printAdjListWithWeights();
        gr.printAdjacencyMatrix();
        
        
        DFS_Attributes<String> dfs = gr.DFS("shirt", true);
        
        System.out.println(dfs.outputSet);
        System.out.println(dfs.timeList);
        
        
        gr.sortTimeListAccordingToFinishTimes(new Vertex("shirt", 0));
        
        
        System.out.println(gr.TOPOLOGICAL_SORT("shirt", true));
        
        
        
        

    }// end main
}//end class
