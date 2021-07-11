/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdatastructureseptoct;

/**
 *
 * @author Fares Abu Ali
 */
public class StackUsingOneQueueTheBestWay<E> {
    
    
    // push() will be costly, O(n)
    // pop() is just dequeu   O(1)
    
    
    MyQueue<E> q =new MyQueue<>();
    
    
    public void push(E element){
        
        // let the element=6
        
        // and the current stack is:
        // 1 2 3 4 5
        pushHelper(element,q.getSize());
        
    }
    
    
    private void pushHelper(E element,int size){
        
        q.enqueue(element); // 1 2 3 4 5 6
        
        // now, one by one dequeue S items from queue, and enqueue them again
        
        for(int i=0;i<size;i++){
            q.enqueue(q.dequeue());
        }
        
        // 2 3 4 5 6 1
        // 3 4 5 6 1 2 
        // 4 5 6 1 2 3
        // 5 6 1 2 3 4
        // 6 1 2 3 4 5
       
    }
    
    
    public E pop(){
        return q.dequeue();
    }
    
    public String toString(){
        
        return q.toString();
    }
    
    
    
    public static void main(String[] args) {
        
        StackUsingOneQueueTheBestWay s = new StackUsingOneQueueTheBestWay();
        
       s.push(1);
              s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
       s.push(6);
       
       
        System.out.println(s);
        
        
        s.pop();
        
        
        System.out.println(s);

              
    }
}
