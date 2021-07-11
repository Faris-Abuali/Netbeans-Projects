/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericgraph;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class TestDijkstra {

    public static void main(String[] args) {

        GenericGraph<String> gr = new GenericGraph<>();

//---------------Fisrt Example--------------------
//        gr.addEdge("A", "B", false, 2);
//        gr.addEdge("A", "D", false, 4);
//        gr.addEdge("B", "D", false, 1);
//        gr.addEdge("B", "C", false, 7);
//        gr.addEdge("D", "E", false, 3);
//        gr.addEdge("E", "C", false, 2);
//        gr.addEdge("E", "F", false, 5);
//        gr.addEdge("C", "F", false, 1);
////        
//        gr.printAdjacencyList();
////        
//        gr.printAdjacencyListWithWeights();
//        
//        System.out.println(gr.getWeight("B","D"));
//---------------------------------------------
//---------------Second Example--------------------
//        gr.addEdge("A", "B", false, 50);
//        gr.addEdge("A", "C", false, 45);
//        gr.addEdge("B", "C", false, 10);
//        gr.addEdge("A", "D", true, 10);
//        gr.addEdge("D", "E", false, 15);
//
//        gr.addEdge("E", "B", false, 20);
//
//        gr.addEdge("B", "D", false, 15);
//        gr.addEdge("E", "C", false, 35);
//        gr.addEdge("C", "E", false, 30);
//
//        gr.addEdge("F", "E", false, 3);
//
//        
//        // The code below is  for floyd-warshall algorithm 
//        gr.buildAdjacencyMatrix();
//
//        gr.addEdgeIntoADJMatrix("A", "B", false, 50);
//        gr.addEdgeIntoADJMatrix("A", "C", false, 45);
//        gr.addEdgeIntoADJMatrix("B", "C", false, 10);
//        gr.addEdgeIntoADJMatrix("A", "D", true, 10);
//        gr.addEdgeIntoADJMatrix("D", "E", false, 15);
//
//        gr.addEdgeIntoADJMatrix("E", "B", false, 20);
//
//        gr.addEdgeIntoADJMatrix("B", "D", false, 15);
//        gr.addEdgeIntoADJMatrix("E", "C", false, 35);
//        gr.addEdgeIntoADJMatrix("C", "E", false, 30);
//
//        gr.addEdgeIntoADJMatrix("F", "E", false, 3);
//
//        gr.printAdjacencyListWithWeights();
//
//        gr.allPairsShortestPathBasedOnDijkstra();
//
//        gr.floyd_warshall();
// ---------------------------------------------       
//        
//---------------Third Example: Negative Weights--------------------
//        gr.addEdge("A", "B", false, 3);
//        gr.addEdge("A", "C", false, 5);
//        gr.addEdge("C", "D", false, 2);
//        gr.addEdge("D", "B", false, -10);
// ---------------------------------------------  
//---------------Fourth Example: from Bellman Video: The Dijkstra will fail here--------------------
//        gr.addEdge("1", "2", false, 6);
//        gr.addEdge("1", "3", false, 5);
//        gr.addEdge("1", "4", false, 5);
//
//        gr.addEdge("3", "2", false, -2);
//        gr.addEdge("4", "3", false, -2);
//
//        gr.addEdge("2", "5", false, -1);
//        gr.addEdge("3", "5", false, 1);
//        gr.addEdge("4", "6", false, -1);
//
//        gr.addEdge("6", "7", false, 3);
//        gr.addEdge("5", "7", false, 3);
//
//        //-------------------------------Now For Floyd-Warshall I will build the adjMatrix
//        gr.buildAdjacencyMatrix();
//
//        gr.addEdgeIntoADJMatrix("1", "2", false, 6);
//        gr.addEdgeIntoADJMatrix("1", "3", false, 5);
//        gr.addEdgeIntoADJMatrix("1", "4", false, 5);
//
//        gr.addEdgeIntoADJMatrix("3", "2", false, -2);
//        gr.addEdgeIntoADJMatrix("4", "3", false, -2);
//
//        gr.addEdgeIntoADJMatrix("2", "5", false, -1);
//        gr.addEdgeIntoADJMatrix("3", "5", false, 1);
//        gr.addEdgeIntoADJMatrix("4", "6", false, -1);
//
//        gr.addEdgeIntoADJMatrix("6", "7", false, 3);
//        gr.addEdgeIntoADJMatrix("5", "7", false, 3);
//
//        gr.floyd_warshall();
//
//        //-----------------------------------------------------------------------
//        gr.printAdjacencyListWithWeights();
//
//        //gr.printAdjacencyMatrx();
//        // gr.dijkstraDisplayShortestPaths("1");
//        System.out.println("");
//        gr.bellmanDisplayShortestPaths("1");

// ---------------------------------------------
//------------Fifth Example: a cycle with negative total weight!!!!-------------------
//        gr.addEdge("1", "2", false, 4);
//        gr.addEdge("1", "4", false, 5);
//        gr.addEdge("4", "3", false, 3);
//        gr.addEdge("3", "2", false, -10);
//        gr.addEdge("2", "4", false, 5);
//---------------------------------------
//        gr.printAdjacencyListWithWeights();
//
//        // gr.bellmanFord("1");
//        gr.dijkstraDisplayShortestPaths("1");
//
//        gr.bellmanDisplayShortestPaths("1");
//
//        //gr.edgesList();
        //gr.floyd();
//------------------------------------------- All Pairs Shortest Path (Floyd-Warshall) - Dynamic Programming ---------
//        gr.addEdge("1", "2", false, 3);
//        gr.addEdge("2", "1", false, 8);
//
//        gr.addEdge("1", "4", false, 7);
//        gr.addEdge("4", "1", false, 2);
//
//        gr.addEdge("3", "4", false, 1);
//        gr.addEdge("3", "1", false, 5);
//
//        gr.addEdge("2", "3", false, 2);
//
//        gr.printAdjacencyList();
//
//        gr.printAdjacencyListWithWeights();
//
//        gr.buildAdjacencyMatrix();
//
//        gr.addEdgeIntoADJMatrix("1", "2", false, 3);
//        gr.addEdgeIntoADJMatrix("2", "1", false, 8);
//
//        gr.addEdgeIntoADJMatrix("1", "4", false, 7);
//        gr.addEdgeIntoADJMatrix("4", "1", false, 2);
//
//        gr.addEdgeIntoADJMatrix("3", "4", false, 1);
//        gr.addEdgeIntoADJMatrix("3", "1", false, 5);
//
//        gr.addEdgeIntoADJMatrix("2", "3", false, 2);
//
////        System.out.println("A0");
////        gr.printAdjacencyMatrx();
//
//        gr.floyd_warshall();
//--------------------------------------------------------
    }// end main

}
