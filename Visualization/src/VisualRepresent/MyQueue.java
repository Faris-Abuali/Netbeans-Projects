package VisualRepresent;




/**
 *
 * @author Fares Abu Ali
 */
public class MyQueue<E> {
    
    
    MySinglyLinkedList<E> msl; // composition relationship
    
    public MyQueue(){
        
        
        msl=new MySinglyLinkedList<>();
    }
    
    public int getSize(){
        return msl.size();
    }
    public void clear(){
        msl.clear();
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
    
 
    
    public E get(int index){
        return msl.get(index);
        
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
