/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kruskals_MST;

import graphapril.GraphApril;
import java.awt.BorderLayout;

/**
 *
 * @author Fares Abu Ali
 */
public class TestKruskalsJune {

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

        
        KruskalsMWST<String> k = new KruskalsMWST(gr);
        
        
          System.out.println("Set of Edges Comprising the MST:\n"+k.kruskals());

        System.out.println("cost of minimum spanning tree: "+k.giveTotalWeightOf_MST());
    }// end main
//        
}// end class
