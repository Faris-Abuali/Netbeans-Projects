package Ford_Fulkerson;

import graphapril.Vertex;

/**
 *
 * @author Fares Abu Ali
 */
enum EdgeType {
    ORIGINAL, RESIDUAL;
}

public class Edge<E> {

    Vertex<E> source, destination;
    int capacity;
    int flow;
    EdgeType edgeType;

    public Edge(Vertex<E> source, Vertex<E> destination, int capacity, EdgeType type) {

        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.flow = 0;
        this.edgeType=type;

    }// end constructor

    public Vertex<E> getSource() {
        return source;
    }

    public void setSource(Vertex<E> source) {
        this.source = source;
    }

    public Vertex<E> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<E> destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    
    public void setEdgeType(EdgeType e){
        this.edgeType=e;
    }
    
    public EdgeType getEdgeType(){
        return this.edgeType;
    }
    
    public String toString() {

        return "{(" + source.getLabel() + ", " + destination.getLabel() + "), Cap = " + capacity + ", flow = " + flow + "}";

    }// end method

}// end class
