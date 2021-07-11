

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class MyQueue<E> {

    private int head;
    private static final int DEFAULT_CAPACITY = 3;
    private Object[] al;
    private int size;
    private int capacity;

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    public MyQueue(int capacity) {

        this.capacity = capacity;
        size = 0;
        al = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E dequeue() {

        E dequeuedElement = null;

        if (!isEmpty()) {

            dequeuedElement = (E) al[0];

            for (int i = 0; i < size - 1; i++) {
                al[i] = al[i + 1];
            }

            size--;
        }

        return dequeuedElement;

    }

    public void ensureCapacity() {
        if (size == capacity) {

            int updatedSize = size * 2;

            Object[] updatedAl = new Object[updatedSize];

            updatedAl = Arrays.copyOf(al, updatedSize);

            al = updatedAl;

            capacity=updatedSize;
        }
    }

    public void enqueue(E element) {

        ensureCapacity();

        al[size] = element;

        size++;

    }

    public E getHead() {

        E headItem = null;
        if (!isEmpty()) {
            headItem = (E) al[0];
        }

        return headItem;
    }

    public E getLast() {

        E lastItem = null;
        if (!isEmpty()) {
            lastItem = (E) al[size-1];
        }

        return lastItem;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public String toString() {

        String res = "";

        StringBuilder strB = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            strB.append(al[i] + ", ");
        }

        if (strB.length() > 2) {
            res = strB.substring(0, strB.length() - 2);
        }
        else{
            res=strB.toString();
        }
        
        res+=']';

        return res;
    }

}
