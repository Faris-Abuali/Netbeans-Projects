package finallabexam;

/**
 *
 * @author Fares Abu Ali
 */
public class MyQueue<E> {
    
    
    MySinglyLinkedList<E> msl; // composition relationship
    
    public MyQueue(){
        msl=new MySinglyLinkedList<>();
    }
    
    
    public boolean isEmpty(){
        return getSize()==0;
    }
    
    
    public E getFirst(){
        return msl.first();
    }
    
    public E getLast(){
        return msl.last();
    }
    
    public E dequeue(){
        return msl.removeFirst();
    }
    
    public void enqueue(E element){
        msl.addLast(element);
        
    }
    
    public int getSize(){
        return msl.size();
    }
    
    public String toString(){
        return msl.toString();
    }
    
    public static void main(String[] args) {
        
        MyQueue<Integer> q=new MyQueue<>();
        
        
        q.enqueue(2);
                q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(55);
        
        System.out.println(q);
        
        System.out.println(q.getSize());
        
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
        
        System.out.println( q.dequeue());
        
        System.out.println(q
        );

        
        
    }
}
