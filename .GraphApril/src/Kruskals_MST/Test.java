package Kruskals_MST;

import graphapril.GraphApril;
import graphapril.Vertex;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        
        
        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("a", "b", true, 4);
        gr.addEdge("a", "h", true, 8);
        gr.addEdge("b", "h", true, 11);
        gr.addEdge("b", "c", true, 8);
        gr.addEdge("c", "d", true, 7);

        gr.addEdge("d", "e", true, 9);
        gr.addEdge("e", "f", true, 10);
        gr.addEdge("f", "g", true, 2);

        gr.addEdge("g", "h", true, 1);
        gr.addEdge("h", "i", true, 7);
        gr.addEdge("i", "c", true, 2);
        gr.addEdge("g", "i", true, 6);
        gr.addEdge("c", "f", true, 4);
        gr.addEdge("d", "f", true, 14);

        KruskalsMWST<String> k = new KruskalsMWST(gr);


        System.out.println("Set of Edges Comprising the MST:\n"+k.kruskals());

        System.out.println(k.giveTotalWeightOf_MST());

//        gr.addEdge("s", "t", true, 6); // source,destination,isDirected?,weight
//        gr.addEdge("s", "y", true, 7);
//        gr.addEdge("t", "y", true, 8);
//        gr.addEdge("t", "x", true, 5);
//        gr.addEdge("x", "t", true, -2);
//        gr.addEdge("t", "z", true, -4);
//        gr.addEdge("y", "z", true, 9);
//        gr.addEdge("z", "x", true, 7);
//        gr.addEdge("y", "x", true, -3);
//        gr.addEdge("z", "s", true, 2);
//
//        KruskalsMWST<String> k = new KruskalsMWST(gr);
//
//        System.out.println(k.setOfsets);
////
////        System.out.println(k.FIND_SET(new Vertex("s", 0)));
////        System.out.println(k.FIND_SET(new Vertex("s", 0)));
//        //  System.out.println(k.FIND_SET(new Vertex("s", 0)).equals(k.FIND_SET(new Vertex("s", 0))));
//        k.UNION("s", "t");
//
//        System.out.println(k.setOfsets);
//
//        k.UNION("t", "z");
//
//        System.out.println(k.setOfsets);
//
//        k.UNION("t", "y");
//        System.out.println(k.setOfsets);
    }// end main

}// end class
