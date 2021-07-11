package Kruskals_MST;

import graphapril.GraphApril;
import graphapril.Vertex;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class KruskalsMWST<E> {

    GraphApril<E> gr; // Composition relationship
    Map<E, Vertex<E>> V;

    Set<Set<E>> setOfsets;

    Set<Edge<E>> A; // this will hold the (safe edges): the edges who the minimum weight spanning tree consists of.

    ArrayList<Edge<E>> arListOfEdges;

    public KruskalsMWST(GraphApril<E> gr) {

        this.gr = gr;

        V = new HashMap<>();

        setOfsets = new HashSet<>();

        A = new LinkedHashSet();

        for (E currKey : gr.AdjList.keySet()) {

            V.put(currKey, new Vertex(currKey, 0, 0, null));

            Set<E> s = new HashSet();
            s.add(currKey); // put each vertex in a separate set initially

            setOfsets.add(s);

        }//end forEach

        this.arListOfEdges = new ArrayList<>();

        buildListOfEdges();
        // System.out.println(arListOfEdges);

        Collections.sort(arListOfEdges, new EdgeWeightSorter<>()); //sort the edges of G.E into nondecreasing order by weight w

        // System.out.println("sorted:"+arListOfEdges);
    }// end constructor

    public void buildListOfEdges() {

        for (E currKey : gr.AdjList.keySet()) {

            Iterator<Vertex<E>> itr = gr.AdjList.get(currKey).listIterator();

            while (itr.hasNext()) {

                Vertex<E> neighbour = itr.next();

                Edge<E> e = new Edge(V.get(currKey), neighbour, neighbour.getWeight());

                arListOfEdges.add(e);
            }// end while

        }// end forEach
    }// end method

    public Set<E> FIND_SET(E vertex) {
        // returns the address of the set which contains the vertex(v)

        for (Set<E> currSet : setOfsets) {

            if (currSet.contains(vertex)) {
                return currSet;
            }

        }// end forEach

        return null;

    }// end method

    public void UNION(E u, E v) {

        Set<E> setContainsV = FIND_SET(v);
        Set<E> setContainsU = FIND_SET(u);

        Set<E> combinedSet = new HashSet(setContainsV);
        combinedSet.addAll(setContainsU);

        //setContainsV.addAll(setContainsU);
        //  Set<E> combinedSet = new HashSet<>(setContainsV);
        setOfsets.remove(setContainsV);
        setOfsets.remove(setContainsU);

        setOfsets.add(combinedSet);

    }//end method

    public Set<Edge<E>> kruskals() {

        for (Edge<E> e : arListOfEdges) { // taken in nondecreasing order by weight 

            Vertex<E> u = e.source;
            Vertex<E> v = e.destination;

            /*
            checks, for each edge u.v , whether the endpoints u and v belong to the same tree. If they do, 
            then the edge u.v cannot be added to the forest without creating a cycle, so the edge will be discarded
             */
            if (!FIND_SET(v.getLabel()).equals(FIND_SET(u.getLabel()))) {

                A.add(e);  // then this edge (u) is safe edge, so add it to the set A that will contain the MST
                UNION(u.getLabel(), v.getLabel()); // combine the 2 sets (the set that contains the vertex u, and the set that contains vertex v) into one set
            }

        }// end forEach

        //System.out.println("Set of Edges Comprising the MST: "+A);
        
        return A;
    }// end method

    public int giveTotalWeightOf_MST() {

        int sum = 0;

        for (Edge<E> e : A) {
            sum += e.weight;
        }

        return sum;
    }// end method

}// end class
