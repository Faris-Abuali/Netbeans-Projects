package genericgraph;

/**
 *
 * @author Fares Abu Ali
 */
public class Vertex<E> {

    private E label;
    private int weight;
    boolean isVisited;

    public Vertex(E label, int weight) {
        this.label=label;
        this.weight=weight;
        this.isVisited=false;
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
    
    
    public boolean getVisited(){
        return this.isVisited;
    }
    
    public void setVisited(boolean flag){
        this.isVisited=flag;
    }
    
    

}
