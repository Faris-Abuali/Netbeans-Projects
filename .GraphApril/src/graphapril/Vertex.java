package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class Vertex<E> {
    // π

    public static final int INFINITY = 1_000_000_000; // 1 billion

    private E label;
    private int weight;
    private boolean isVisited;

    private int d; // distance from the source vertex (root of the tree) to the current vertex
    private Vertex<E> π; // the predecessor(parent) of this vertex

    public Vertex(E label, int weight) {
        this.label = label;
        this.weight = weight;
        this.isVisited = false;

        this.d = INFINITY;
        this.π=null;
    }

    public Vertex(E label, int weight, int d, Vertex<E> π) {
        this.label = label;
        this.weight = weight;
        this.isVisited = false;

        this.d = d;
        this.π = π;
    }

    public E getLabel() {
        return label;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getVisited() {
        return this.isVisited;
    }

    public void setVisited(boolean flag) {
        this.isVisited = flag;
    }

    public int getD() {
        return this.d;
    }
    
    public void setD(int d){
        this.d=d;
    }
    
    public void setπ(Vertex<E> p){
        this.π=p;
    }
    
    public Vertex<E> getπ(){
        return this.π;
    }

    public String toString() {

        return getLabel()+ "";

    }// end mehtod

} //end class
