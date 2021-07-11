/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midexam;

/**
 *
 * @author Fares Abu Ali
 */
public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 3;

    private int size;
    private E[] al;

    public MyArrayList() {

        this(DEFAULT_CAPACITY);

    }

    public MyArrayList(int capacity) {

        size = 0;
        al = (E[]) new Object[capacity];

    }

    public void ensureCapacity() {

        if (size == al.length) {

            int updatedSize = size * 2;

            E[] updatedAl = (E[]) new Object[updatedSize];

            for (int i = 0; i < size; i++) {
                updatedAl[i] = al[i];
            }

            al = updatedAl;
        }
    }

    public void add(int index, E element) throws ArrayIndexOutOfBoundsException/*, IOException*/ {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index= " + index + ", size= " + size);
        }

        if (index == size) {
            add(element);
        } else {

            ensureCapacity();

            for (int i = size - 1; i >= index; i--) {

                al[i + 1] = al[i];
            }

            al[index] = element;

            size++;
        }

    }

    public void add(E element) {

        ensureCapacity();
        al[size++] = element;

    }

    public E remove() {

        E removedElement = al[size - 1];
        size--;
        return removedElement;

    }

    public E remove(int index) throws ArrayIndexOutOfBoundsException/*, IOException*/ {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index= " + index + ", size= " + size);
        }

        E removedElement = al[index];

        if (index == size - 1) {
            remove();
        } else {

            for (int i = index; i < size - 1; i++) {

                al[i] = al[i + 1];
            }

            size--;
        }

        return removedElement;
    }

    public void rotateTo(int n) {

        if (n > 0) {
            rotateToRight(n);
        } else if (n < 0) {
            rotateToLeft(n);
        }
    }

    public void rotateToRight(int n) {

        n=n%size;

        while (n > 0) {
            E temp = remove();
            add(0, temp);

            n--;
            
            //System.out.println(toString());
        }

    }

    public void rotateToLeft(int n) {

        n=Math.abs(n);
        
        n=n%size;

        
        while (n > 0) {
            E temp = remove(0); // removeFirst
            add(temp);//addLast

            n--;
            
            //System.out.println(toString());
        }
    }

    public String toString() {

        StringBuilder strB = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            strB.append(al[i] + ", ");
        }

        String res = strB.toString();

        if (res.length() > 2) {
            res = res.substring(0, res.length() - 2);
        }

        res += "]";

        return res;

    }

    public static void main(String[] args) {
        MyArrayList<Integer> ar = new MyArrayList<>();

        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);

       System.out.println(ar);

        ar.rotateTo(-333333);
        
        
        

        System.out.println(ar);
       
       

    }

}//end class
