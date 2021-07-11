

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 3;

    private int size;
    private int capacity;
    private int peek;
    private Object[] al;

    public MyStack() {

        size = 0;
        capacity=DEFAULT_CAPACITY;
        peek = -1;
        al = new Object[DEFAULT_CAPACITY];

    }
    
        public MyStack(int capacity) {

        size = 0;
        this.capacity=capacity;
        peek = -1;
        al = new Object[capacity];

    }

    private void ensureCapacity() {

        if (size == al.length) {

            int updatedSize = size * 2;
            E[] updatedAl = (E[]) new Object[updatedSize];

            updatedAl = Arrays.copyOf((E[]) al, updatedSize);
            
            al=updatedAl;
          
        }

    }

    public void push(E element) {

        ensureCapacity();

        size++;
        
        al[++peek] = element; // will increase peek by one then assign the element to al[peek]

    }

    public boolean isEmpty() {
        return (size == 0);  // or return(peek==-1);
    }

    public int size() {
        return size;
    }

    public E peek() {

        if (isEmpty()) {
            return null;
        }

        return (E) al[peek];
    }
    
   public boolean isFull(){
       return(al.length==size);
   }

    public E pop() {

        if (isEmpty()) {
            return null;
        }
        
        size--;
        return (E) al[peek--];  // will return the value then decrease peek by one


    }

    public String toString() {

        String res = null;

        StringBuilder strB = new StringBuilder("\nStack Contents:-\n----------------\n");

        strB.append(al[peek]+" <---peek\n");
        
      for(int i=peek-1;i>=0;i--){
          strB.append(al[i]+"\n");
      }
      
       strB.append("----------------");
       
       res=strB.toString();

        return res;

    }

}
