package adjacencymatrixgraph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Fares Abu Ali
 */
public class AdjacencyList {

    int verticesCount;
    LinkedList<Integer>[] adj;

    AdjacencyList(int verticesCount) {

        this.verticesCount = verticesCount;

        adj = new LinkedList[verticesCount];

        for (int i = 0; i < verticesCount; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph 
    // Function to add an edge into the graph 
    void addEdge(int v, int w) {
        adj[v].add(w);
        //adj[w].add(v);
    }

    // A recursive function that uses visited[] and parent to detect 
    // cycle in subgraph reachable from vertex v.
    boolean isCyclicUtil(int currVertex, Boolean[] visited, int parentVer) {

        visited[currVertex] = true;
        Integer i;

        Iterator<Integer> it = adj[currVertex].iterator();

        while (it.hasNext()) {

            i = it.next();

            // If an adjacent is not visited, then recur for that 
            // adjacent 
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, currVertex)) {
                    return true;
                }
            } // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle. 
            else if (i != parentVer) {
                return true;
            }
        }

        return false;

    }//end isCyclicUtil

    // Returns true if the graph contains a cycle, else false. 
    Boolean isCyclic() {
        // Mark all the vertices as not visited and not part of 
        // recursion stack 
        Boolean visited[] = new Boolean[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to detect cycle in 
        // different DFS trees 
        for (int u = 0; u < verticesCount; u++) {
            if (!visited[u]) // Don't recur for u if already visited 
            {
                if (isCyclicUtil(u, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void printAdjacencyList() {

    }

    public void dfsUtil(int v, boolean[] visited) {

        //mark the current node as visited
        visited[v] = true;
        System.out.print(v + " ");

        //recur for all the vertices adjacent to v (children of v)
        Iterator<Integer> itr = adj[v].listIterator();

        while (itr.hasNext()) {

            int n = itr.next();

            if (visited[n] == false) {
                dfsUtil(n, visited);
            }
        }// end while 
        

    }

    public void dfs() {

        System.out.println("DFS: ");
        int ctr = 0;

        boolean[] visited = new boolean[verticesCount];

        for (int i = 1; i < verticesCount; i++) {

            if (visited[i] == false) {
                ctr++;
                System.out.println("\nComponent # " + ctr);
                
                dfsUtil(i, visited);// pass the same boolean array but with i (the child of v)

            }
        }

        System.out.println("\nThe graph has " + ctr + " component(s)");
    }

    // Driver method to test above methods 
    public static void main(String args[]) {
        // Create a graph given in the above diagram 
        AdjacencyList gr = new AdjacencyList(9);

//        gr.addEdge(1, 0);
//        // gr.addEdge(0, 2);
//        gr.addEdge(2, 1);
//        gr.addEdge(0, 3);
//        gr.addEdge(3, 4);
// ------------Test number of components with dfs--------
        gr.addEdge(1, 2);
        gr.addEdge(1, 3);

        gr.addEdge(2, 1);
        gr.addEdge(2, 3);
        gr.addEdge(2, 6);
        gr.addEdge(2, 5);

        gr.addEdge(3, 1);
        gr.addEdge(3, 2);
        gr.addEdge(3, 6);

        gr.addEdge(5, 2);
        gr.addEdge(5, 6);

        gr.addEdge(6, 2);
        gr.addEdge(6, 3);
        gr.addEdge(6, 5);

        gr.addEdge(4, 7);
        gr.addEdge(7, 4);
        gr.addEdge(7, 8);
        gr.addEdge(8, 7);

        gr.dfs();

// ------------End Test number of components with dfs--------



//        if (gr.isCyclic()) {
//            System.out.println("Graph contains cycle");
//        } else {
//            System.out.println("Graph doesn't contains cycle");
//        }
    }//end main

}
