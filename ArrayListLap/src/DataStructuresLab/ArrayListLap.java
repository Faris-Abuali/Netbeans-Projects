package DataStructuresLab;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Fares Abu Ali
 */
public class ArrayListLap<T> {

    private int size;
    private T[] al;

    public ArrayListLap() {

        size = 0;

        al = (T[]) new Object[3];
    }

    public void ensureCapacity() {

        if (size == al.length) {

            T[] updatedAl = (T[]) new Object[size * 2];

            for (int i = 0; i < size; i++) {
                updatedAl[i] = al[i];
            }

            al = updatedAl;
        }

    }

    public void add(T element) {

        ensureCapacity();

        al[size] = element;

        size++;

    }

    public void add(int index, T element) {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + index + ", while size=" + size);
        }

        ensureCapacity();

        for (int i = size - 1; i >= index; i--) {

            al[i + 1] = al[i];

        }

        al[index] = element;

        size++;
    }

    public T remove(int index) {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + index + ", while size=" + size);
        }

        T temp = al[index];

        for (int i = index; i < size - 1; i++) {

            al[i] = al[i + 1];
        }

        size--;
        

        return temp;

    }

    private int firstOccurence(T element) {

        for (int i = 0; i < size; i++) {

            if (al[i] == element) {
                return i;
            }

        }

        return -1;

    }

    private int lastOccurence(T element) {

        for (int i = size - 1; i >= 0; i--) {

            if (al[i] == element) {
                return i;
            }

        }

        return -1;

    }

    public boolean removeLast(T element) {

        boolean flag = false;

        int location = lastOccurence(element);

        if (location != -1) {
            flag = true;
            remove(location);
        }

        return flag;

    }

    public boolean removeFirst(T element) {

        boolean flag = false;

        int location = firstOccurence(element);

        if (location != -1) {
            flag = true;
            remove(location);
        }

        return flag;

    }

    public boolean removeAll(T element) {

        boolean flag = false;

        for (int i = 0; i < size; i++) {

            if (al[i] == element) {
                flag = true;
                remove(i);
                i = 0;
            }

        }

        return flag;

    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + index + ", while size=" + size);
        }

        return al[index];

    }

    public void set(int index, T element) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + index + ", while size=" + size);
        }

        al[index] = element;

    }

    public boolean contains(T element) {

        for (int i = 0; i < size; i++) {

            if (al[i] == element) {
                return true;
            }

        }
        return false;

    }

    public void swap(int i, int j) {

        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + i + ", while size=" + size);
        }

        if (j < 0 || j >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index. Index=" + j + ", while size=" + size);
        }
        
        T temp= al[i];
        al[i]=al[j];
        al[j]=temp;

    }

    @Override
    public String toString() {

        StringBuilder strB = new StringBuilder("[ ");

        for (int i = 0; i < size; i++) {

            strB.append(al[i] + ", ");
        }

        String res = strB.toString();

        res = res.substring(0, res.length() - 2);

        res += " ]";

        return res;

    }
    
    
    public void clear(){
        
        T[] mama=(T[])new Object[0];
        
        al=mama;
        
        size=0;
        
    }

    public static void main(String[] args) {

        ArrayListLap<Integer> al = new ArrayListLap<>();

        al.add(2);

        al.add(33);

        al.add(3);

        al.add(1, 12);

        al.add(0, 1);

        al.add(1, 3);

        al.add(3);

        al.add(3);
        
        
        System.out.println(al);

        
        al.remove(3);
        
        System.out.println(al);
        
        
        
        
//        al.removeAll(3);
//
//        System.out.println(al);
//        System.out.println("Size= " + al.size);

    }// end main

}// end class
