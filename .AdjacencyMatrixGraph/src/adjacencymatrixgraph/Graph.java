package adjacencymatrixgraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class Graph {

    Vertex[] vertices;
    int vertisesCount;
    int size;

    int[][] matrix;

    public Graph(int verticesCount) {

        this.vertisesCount = verticesCount;
        vertices = new Vertex[verticesCount];
        size = 0;

        matrix = new int[verticesCount][verticesCount];

    }

    public void addVertex(String label) {
        vertices[size++] = new Vertex(label);
    }

    //--------------------------------------------------------------------------------------------  
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

    //-----------------------------------------------Add Letters--------------------------------
    public void addEdgeUndirectedUnweighted(char source, char destination) { // initial , terminal

        addEdgeUndirectedWeighted(source, destination, 1);

    }

    public void addEdgeUndirectedWeighted(char source, char destination, int cost) { // initial , terminal

        char chSource = 0, chDest = 0;

        if (Character.isLetter(source)) {
            chSource = (char) (Character.toUpperCase(source) - 'A');
            chDest = (char) (Character.toUpperCase(destination) - 'A');

        } else if (Character.isDigit(source)) {
            chSource = (char) (source - '0');
            chDest = (char) (destination - '0');

        }

        matrix[chSource][chDest] = cost;
        matrix[chDest][chSource] = cost;

    }

    //--------------------------------------------------------------------------------------------  
    public void printGraph() {

        System.out.print(" | ");

        for (int i = 0; i < vertisesCount; i++) {
            System.out.print(vertices[i].getLabel() + " ");
        }
        System.out.println("\n-------------------");

        for (int i = 0; i < vertisesCount; i++) {

            System.out.print(vertices[i].getLabel() + "| ");

            for (int j = 0; j < vertisesCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();

    }// end print

    //--------------------------------------------------------------------------------------------  
    public Vertex getChild(Vertex v) {

        char ch = v.getLabel().charAt(0);
        int row = ch;

        //*************************************************
        if (Character.isLetter(ch)) {
            row = v.getLabel().charAt(0) - 'A';
        } else if (Character.isDigit(ch)) {
            row = v.getLabel().charAt(0) - '0';
        }
        //*************************************************

        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] == 1 && vertices[col].isVisited == false) {
                vertices[col].setVesited(true);
                return vertices[col];
            }
        }

        return null;
    }

    //--------------------------------------------------------------------------------------------  
    public void bfs() {

        System.out.print("BFS: ");

        Queue<Vertex> q = new LinkedList<Vertex>();

        // E V P
        // Enqueu, Visited, Print
        q.add(vertices[0]);
        vertices[0].setVesited(true);

        while (!q.isEmpty()) {

            Vertex currentVertex = q.poll();
            System.out.print(currentVertex.getLabel() + " ");

            Vertex vvv = getChild(currentVertex);
        // returns the child of the currentVertex only if this child is not visited yet
            while (vvv != null) {

                q.add(vvv);
                vvv.setVesited(true);
                //System.out.println(vvv.getLabel());
                vvv = getChild(currentVertex);
            }

        }

        System.out.println();
        // reset
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setVesited(false);
        }

    }
    //--------------------------------------------------------------------------------------------  

    public void dfs() {

        System.out.print("DFS: ");

        Stack<Vertex> st = new Stack<>();

        st.push(vertices[0]);
        vertices[0].setVesited(true);
        System.out.print(vertices[0].getLabel() + " ");

        while (!st.isEmpty()) {

            Vertex currentVertex = st.peek();

            //System.out.print(currentVertex.getLabel() + " ");
            Vertex vvv = getChild(currentVertex);
    // returns the child of the currentVertex only if this child os not visited yet

            while (vvv != null) {

                st.push(vvv);
                vvv.setVesited(true);
                System.out.print(vvv.getLabel() + " ");
                vvv = getChild(vvv);

            }

            st.pop();
        }

        System.out.println();
        // reset
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setVesited(false);
        }

    }// end dfs
    
    //--------------------------------------------------------------------------------------------
    

    public void topologicalGraph() {

        System.out.print("DFS: ");
        int ctr = vertisesCount - 1;

        Stack<Vertex> st = new Stack<>();

        st.push(vertices[0]);
        vertices[0].setVesited(true);
        System.out.print(vertices[0].getLabel() + " ");

        while (!st.isEmpty()) {

            Vertex currentVertex = st.peek();

            //System.out.print(currentVertex.getLabel() + " ");
            Vertex vvv = getChild(currentVertex);// returns the child of the currentVertex only if this child os not visited yet

            while (vvv != null) {

                st.push(vvv);
                vvv.setVesited(true);
                System.out.print(vvv.getLabel() + " ");
                vvv = getChild(vvv);

            }

            System.out.println(ctr - 1 + ": ");
            st.pop();
            ctr--;

        }

        // reset
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setVesited(false);
        }

    }

//-------------------------------------------------------------------------------------------- 
    public boolean isConnectedGraph() {
        return isConnectedGraph(matrix, 0, vertisesCount - 1);
    }

    public boolean isConnectedGraph(int[][] matrix, int start, int end) {

        vertices[start].setVesited(true);

        if (matrix[start][end] != 0) {
            System.out.println("Yes connected....");
            // System.out.println(matrix[start][end]);
            //System.out.println(start+"  "+end);
            return true;
        }

        for (int col = 0; col < matrix.length; col++) {

            if (matrix[start][col] != 0 && vertices[col].isVisited == false) {
                vertices[col].setVesited(true);
                if (isConnectedGraph(matrix, col, end)) {// we will repeat the same process for a new row of the matrix
                    return true;
                }

            }
        }
        return false;

    }// end isConnected method
}
