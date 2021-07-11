package Kruskals_MST;


import graphapril.Vertex;
import java.util.ArrayList;


/**
 *
 * @author Fares Abu Ali
 */
public class Edge<E> {
    
    Vertex<E> source,destination;
    int weight;
    
    
    public Edge(Vertex<E> source,Vertex<E> destination,int weight){
        
        this.source=source;
        this.destination=destination;
        this.weight=weight;
       
        
    }// end constructor
    
    
    
    public String toString(){
        
        return "("+source.getLabel()+", "+destination.getLabel()+")";
        
    }// end method
    
    
}// end class
