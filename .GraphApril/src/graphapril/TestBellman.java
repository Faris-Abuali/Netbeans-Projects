package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class TestBellman {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        //------------- Example From Abdul Bari YouTube ------------------------
//        gr.addEdge("1", "2", true, 6);
//        gr.addEdge("1", "3", true, 5);
//        gr.addEdge("1", "4", true, 5);
//
//        gr.addEdge("2", "5", true, -1);
//        gr.addEdge("3", "2", true, -2);
//        gr.addEdge("3", "5", true, 1);
//        gr.addEdge("4", "3", true, -2);
//        gr.addEdge("4", "6", true, -1);
//        gr.addEdge("5", "7", true, 3);
//        gr.addEdge("6", "7", true, 3);
//
//        gr.printAdjListWithWeights();
//        Bellman_Ford<String> bel = new Bellman_Ford(gr);
//
//        bel.bellmanFord("1");
//        
//        bel.printFinalResult("1");
        
//        1 2 6
//        1 3 5
//        1 4 5
//        2 5 -1
//        3 2 -2
//        3 5 1
//        4 3 -2
//        4 6 -1
//        5 7 3
//        6 7 3


        //------------- Example From The Book page: 652 ------------------------
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
//        
//        
//        
//        // 10 edges, 5 vertices
////        s t 6
////        s y 7
////        t y 8
////        t x 5
////        x t -2
////        t z -4
////        y z 9
////        z x 7
////        y x -3
////        z s 2
//        
//        
//        gr.printAdjListWithWeights();
//        
        Bellman_Ford<String> bel = new Bellman_Ford(gr);
//
       Bellman_Ford.BF_Attributes<String> outputs = bel.bellmanFord("s");
//        
//        System.out.println(outputs.flag);
//        
//        
        bel.printFinalResult("s");
//        
//        bel.printAllpaths("z");
//        
//       // bel.printPath("s", "x");
//



        //------------- Example For a NEGATIVE WEIGHT CYCLE (Huthaifa) ------------------------
//        gr.addEdge("A", "B", true, 4);
//        gr.addEdge("A", "C", true, 4);
//        gr.addEdge("D", "A", true, 3);
//        gr.addEdge("D", "C", true, 2);
//        gr.addEdge("C", "E", true, 4);
//        gr.addEdge("E", "D", true, 1);
//
//        gr.addEdge("F", "B", true, 3);
//        gr.addEdge("F", "E", true, -3);
//        gr.addEdge("C", "F", true, -2);
//
//        gr.addEdge("G", "F", true, 2);
//        gr.addEdge("G", "H", true, 2);
//        gr.addEdge("H", "E", true, -2);
//        gr.addEdge("E", "G", true, -2);
//
//        gr.printAdjListWithWeights();
////        
//      Bellman_Ford<String> bel = new Bellman_Ford(gr);
////        
////        
//      Bellman_Ford.BF_Attributes<String> outputs = bel.bellmanFord("A");
//        System.out.println(outputs.flag);
////        
////         System.out.println(outputs.flag);
//        bel.printFinalResult("A");
        
       // bel.printAllpaths("A");

    }// end method
}// end class
