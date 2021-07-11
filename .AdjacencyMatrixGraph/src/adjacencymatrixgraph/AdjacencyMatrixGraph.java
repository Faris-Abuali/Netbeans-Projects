package adjacencymatrixgraph;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class AdjacencyMatrixGraph {

    int vertices;
    int[][] matrix;

    public AdjacencyMatrixGraph(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];

    }

    public void addEdgeUndirectedUnweighted(int source, int destination) { // initial , terminal

        addEdgeUndirectedWeighted(source, destination, 1);

    }

    public void addEdgeUndirectedWeighted(int source, int destination, int cost) { // initial , terminal

        matrix[source][destination] = cost;
        matrix[destination][source] = cost;

    }

    public void addEdgeDirectedUnweighted(int source, int destination) { // initial , terminal

        addEdgeDirectedWeighted(source, destination, 1);

    }

    public void addEdgeDirectedWeighted(int source, int destination, int cost) { // initial , terminal

        matrix[source][destination] = cost;

    }

    public void printGraph() {

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AdjacencyMatrixGraph gr = new AdjacencyMatrixGraph(5);

        gr.addEdgeUndirectedUnweighted(0, 0);
        gr.addEdgeUndirectedUnweighted(1, 1);
        gr.addEdgeUndirectedUnweighted(2, 2);
        gr.addEdgeUndirectedUnweighted(3, 3);
        gr.addEdgeUndirectedUnweighted(4, 4);

        gr.printGraph();

    }// end main

}// end class
