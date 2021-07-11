
package adjacencymatrixgraph;

/**
 *
 * @author Fares Abu Ali
 */
public class Vertex {
    
    private String label;
    boolean isVisited;
    
    
    public Vertex(String label){
        this.label=label;
        this.isVisited=false;
    }
    
    public void setLabel(String label){
        this.label=label;
               
    }
    
    public void setVesited(boolean flag){
        this.isVisited=flag;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public boolean isVisited(){
        return this.isVisited;
    }
    
    
    
}
