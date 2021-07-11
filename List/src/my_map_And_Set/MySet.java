
package my_map_And_Set;

/**
 *
 * @author Fares Abu Ali
 */
public interface MySet<E> extends Iterable<E>{
    
    
    public void clear();
    
    public boolean contains(E element);  //Returns true if the element is in the set.
    
    
    public boolean add(E element);  //Adds the element to the set and returns true if the element is added successfully.
    
    public boolean remove(E element); //Removes the element from the set and returns true if the set    contained the element
    
    public boolean isEmpty();
    
    public int size();
    
    public int capacity();
    
   
    
}// end interface
