package heap;

/**
 *
 * @author Fares Abu Ali
 */
public interface MyPriorityQueue {

    public int parentIndexOf(int index);

    public int leftChildIndexOf(int index);

    public int rightChildIndexOf(int index);

    public void insert(int key);

    public void increaseKey(int key, int index);

    public int remove();

    public void decreaseKey(int key, int index);
    
     public void swap(int i, int j);
    

}
