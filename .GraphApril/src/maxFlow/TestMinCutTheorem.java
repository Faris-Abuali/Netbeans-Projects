package maxFlow;

import graphapril.GraphApril;
import graphapril.Vertex;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Fares Abu Ali
 */
public class TestMinCutTheorem {

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

//        Set<Vertex<String>> outputSet = gr.BFS(new Vertex("s", 0), false);
//        Map<String, Vertex<String>> map = new HashMap<>();
//
//        for (Vertex<String> currVertex : outputSet) {
//            map.put(currVertex.getLabel(), currVertex);
//        }
//
//        for (String currKey : map.keySet()) {
//
//            System.out.println(currKey + ": " + map.get(currKey).getD());
//
//        }



//gr.BFS(new Vertex("s", 0), true);


       // System.out.println(gr.AdjList);
        
        
       //System.out.println(gr.AdjList);
        
        
        MinCutTheorem<String> m = new MinCutTheorem(gr);
        
        m.minCut("s","t");
        System.out.println("Fares Abu Ali 201810408");

    }// end main

}// end class
