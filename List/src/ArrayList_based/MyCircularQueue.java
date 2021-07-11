package ArrayList_based;

import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author Fares Abu Ali
 */
public class MyCircularQueue<E> {

    // when head==last that means the queue contains only one element
    private final static int DEFAULT_CAPACITY = 3;
    private int capacity;
    private int head;// front
    private int last;// rear
    private Object[] al;
    private int size;

    public MyCircularQueue() {

        this(DEFAULT_CAPACITY);
    }

    public MyCircularQueue(int capacity) {

        al = new Object[capacity];
        head = 0;
        last = -1;
        size = 0;

        this.capacity = capacity;

    }

    public void ensureCapacity() {

        if (size == capacity) {
            int updatedSize = size * 2;

            Object[] updatedAl = new Object[updatedSize];

            updatedAl = Arrays.copyOf(al, updatedSize);
            
            capacity=updatedSize;

            al = updatedAl;
        }
    }

    public void enqueue(E element) {

        ensureCapacity();

        last = (last + 1) % capacity;

        al[last] = element;

        size++;
        
        
 

    }

    boolean isEmpty() {
        return (size == 0); // or return(last==-1) // or return (head==0)
    }

    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        E dequeuedElement = (E) al[head];

        head = (head + 1) % capacity;
        size--;

        return dequeuedElement;

    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    ;
    
    public E getHead() {

        if (isEmpty()) {
            return null;
        }

        return (E) al[head];
    }

    public E getLast() {

        if (isEmpty()) {
            return null;
        }

        return (E) al[last];
    }

    public String toString() {

        String res ="";

        StringBuilder strB = new StringBuilder("[");

        for (int i = head; i != (last+1)%capacity; i=(i+1)%capacity) {
            strB.append(al[i] + ", ");
        }

        if (strB.length() > 2) {
            res = strB.substring(0, strB.length() - 2);
        }
        else{
            res=strB.toString();
        }

        res += "]";

        return res;
    }

}
