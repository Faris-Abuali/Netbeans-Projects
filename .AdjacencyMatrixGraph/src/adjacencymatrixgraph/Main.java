/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacencymatrixgraph;

/**
 *
 * @author Fares Abu Ali
 */
public class Main {

    public static void main(String[] args) {

        Graph gr = new Graph(7);

//        gr.addVertex("A");
//        gr.addVertex("B");
//        gr.addVertex("C");
//        gr.addVertex("D");
//        gr.addEdgeUndirectedUnweighted('A', 'C');
//        gr.addEdgeUndirectedUnweighted('A', 'D');
//
//        gr.addEdgeUndirectedUnweighted('D', 'B');
//
        // the same graph but numbers instead of letters
//        gr.addVertex("0");
//        gr.addVertex("1");
//        gr.addVertex("2");
//        gr.addVertex("3");
//
//        gr.addEdgeUndirectedUnweighted('0', '2');
//        gr.addEdgeUndirectedUnweighted('0', '3');
//
//        gr.addEdgeUndirectedUnweighted('3', '1');
//


//----------My Best Graph------------------

//        gr.addVertex("0");
//        gr.addVertex("1");
//        gr.addVertex("2");
//        gr.addVertex("3");
//        gr.addVertex("4");
//        gr.addVertex("5");
//        gr.addVertex("6");
//
//        gr.addEdgeUndirectedUnweighted('0', '1');
//        gr.addEdgeUndirectedUnweighted('0', '3');
//        gr.addEdgeUndirectedUnweighted('0', '4');
//
//        gr.addEdgeUndirectedUnweighted('1', '2');
//        gr.addEdgeUndirectedUnweighted('1', '5');
//        gr.addEdgeUndirectedUnweighted('1', '6');

//----------My Best Graph------------------


        gr.addVertex("0");
        gr.addVertex("1");
        gr.addVertex("2");
        gr.addVertex("3");
        gr.addVertex("4");
        gr.addVertex("5");

gr.addEdgeUndirectedUnweighted('0', '1');
gr.addEdgeUndirectedUnweighted('0', '3');

gr.addEdgeUndirectedUnweighted('1', '2');
gr.addEdgeUndirectedUnweighted('1', '0');

gr.addEdgeUndirectedUnweighted('2', '1');
gr.addEdgeUndirectedUnweighted('2', '3');

gr.addEdgeUndirectedUnweighted('4', '5');

        gr.printGraph();

        gr.bfs();
        gr.dfs();
        
        System.out.println(gr.isConnectedGraph());
        

//        while (true) {
//            Vertex v = gr.getChild(gr.vertices[3]);
//
//            if (v == null) {
//                break;
//            }
//            System.out.println(v.getLabel());
//        }
    }// end main

}
