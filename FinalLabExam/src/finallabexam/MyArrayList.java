package finallabexam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 3;

    private int size;
    private T[] al;

    public MyArrayList() {

        this(DEFAULT_CAPACITY);

    }

    public MyArrayList(int capacity) {

        size = 0;
        al = (T[]) new Object[capacity];

    }

    public void add(T element) {

        ensureCapacity();// this method will assert if the array is full, then it will make a new array
        // and move all the elements into this new array

        al[size++] = element;

    }

    public void add(int index, T element) throws ArrayIndexOutOfBoundsException/*, IOException*/ {

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

    public void addRec(int index, T element) /*throws ArrayIndexOutOfBoundsException*/ {

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index, index=" + index + ", while size= " + size);
        }

        ensureCapacity();

        addRecHelper(index, size, element);

    }

    private void addRecHelper(int index, int high, T element) {

        if (high == index) {
            al[high] = element;
            size++;
        } else {
            al[high] = al[high - 1];
            addRecHelper(index, high - 1, element);

        }
    }

    public T removeRec(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index, index=" + index + ", while size= " + size);
        }

        T temp = al[index];

        removeRecHelper(index, index);

        return temp;
    }

    private void removeRecHelper(int index, int low) {

        if (low == size - 1) {
            size--;

        } else {

            al[low] = al[low + 1];
            removeRecHelper(index, low + 1);
        }

    }

    public void ensureCapacity() {

        if (size == al.length) {

            int updatedSize = size * 2;

            T[] updatedAl = (T[]) new Object[updatedSize];

            for (int i = 0; i < size; i++) {
                updatedAl[i] = al[i];
            }

            al = updatedAl;
        }
    }

    public T remove() {

        T removedElement = al[size - 1];
        size--;
        return removedElement;

    }

    public T remove(int index) throws ArrayIndexOutOfBoundsException/*, IOException*/ {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index= " + index + ", size= " + size);
        }

        T removedElement = al[index];

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

    public boolean contains(T element) {

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (al[i] == element) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public boolean isEmpty(){
        return size==0;
    }
    
    public boolean containsAll(MyArrayList<T> list) {

        boolean flag = false;

        for (int i = 0; i < list.size; i++) {

            flag = contains(list.get(i));
            if (!flag) {
                break;
            }
        }

        return flag;
    }

    int firstOccurenceOf(T element) {

        int position = -1;

        for (int i = 0; i < size; i++) {

            if (al[i] == element) {
                position = i;
                break;
            }

        }

        return position;

    }

    int lastOccurenceOf(T element) {

        int position = -1;

        for (int i = size - 1; i >= 0; i--) {

            if (al[i] == element) {
                position = i;
                break;
            }

        }

        return position;

    }

    public boolean removeFirst(T element) {

        //Removes the first occurrence of the specified element from this list
        // if the element does not exist, nothing happens to the arrayList, and the method returns false
        int location = firstOccurenceOf(element);

        if (location == -1) {
//            throw new Exception("The element: " + element + " was NOT found in the ArrayList to be removed");
            return false;
        }

        if (location == size - 1) {
            remove();
        } else {

            for (int i = location; i < size - 1; i++) {

                al[i] = al[i + 1];
            }

            size--;
        }

        return true;

    }

    public boolean removeLast(T element) {

        //Removes the last occurrence of the specified element from this list
        // if the element does not exist, an exception will be thrown
        int location = lastOccurenceOf(element);

        if (location == -1) {
//            throw new Exception("The element: " + element + " was NOT found in the ArrayList to be removed");
            return false;

        }

        if (location == size - 1) {
            remove();
        } else {

            for (int i = location; i < size - 1; i++) {

                al[i] = al[i + 1];
            }

            size--;
        }

        return true;
    }

    public boolean removeAll(T element) {

        boolean elementFound = false;

        for (int i = 0; i < size; i++) {

            if (al[i] == element) {

                elementFound = true;

                remove(i);

                i = 0;

//
//                for (int k = i; k < size - 1; k++) {
//
//                    al[k] = al[k + 1];
//                }
//
//                size--;
            }

        }

        return elementFound;
    }

    public void set(int index, T element) throws ArrayIndexOutOfBoundsException, IOException {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Can't set the element " + element + " in index:" + index + ", size:" + size);
        }

        al[index] = element;

    }

    public T get(int index) throws ArrayIndexOutOfBoundsException/*, IOException*/ {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index= " + index + ", while size= " + size);
        }

        return al[index];

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

    public int getSize() {
        return size;
    }

    public void clear() {

        al = (T[]) new Object[0];
        size = 0;
    }

    public int indexOf(T element) {
        return firstOccurenceOf(element);
    }

    public int lastIndexOf(T element) {
        return lastOccurenceOf(element);
    }

    public void removeAllFirstOccurence(MyArrayList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {

            removeFirst(list.get(i));
        }
    }

    public void removeAllLastOccurence(MyArrayList<T> list) {
        for (int i = list.getSize() - 1; i >= 0; i--) {

            removeLast(list.get(i));
        }
    }

    public void removeAll(MyArrayList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {

            removeAll(list.get(i));
        }
    }

    public void retainAll(MyArrayList<T> list) {

        for (int i = 0; i < this.size; i++) {

            if (!list.contains(al[i])) {
                this.removeAll(al[i]);
                i = 0;
            }
        }
    }

    public void removeDuplicates() {

        for (int i = 0; i < size; i++) {

            for (int j = i + 1; j < size; j++) {
                if (al[i] == al[j]) {

                    remove(j);

                }
            }

        }

    }

    public void swap(int i, int j) {

        T temp = al[i];
        al[i] = al[j];
        al[j] = temp;
    }

    public void reverseList() {
        for (int i = 0; i < size / 2; i++) {
            swap(i, size - 1 - i);
        }
    }

    public void addAll(MyArrayList<T> list) {

        for (int i = 0; i < list.getSize(); i++) {
            add(list.get(i));
        }
    }

    public void addAll(int index, MyArrayList<T> list) {

        for (int i = 0; i < list.getSize(); i++) {
            add(index, list.get(i));
            index++; // this is necessary !!!!
        }
    }

    boolean equalsExactly(MyArrayList<T> list) {

        boolean flag = true;

        if (this.size != list.getSize()) {
            flag = false;
        } else {

            for (int i = 0; i < size; i++) {
                if (al[i] != list.get(i)) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public MyArrayList<T> subList(int from, int to) {

        if (from < 0 || to > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Range. From=" + from + ". To=" + to + ". Size=" + size);
        }

        MyArrayList<T> theSubList = new MyArrayList<>();

        for (int i = from; i < to; i++) {
            theSubList.add(al[i]);
        }

        return theSubList;
    }

    public T[] toArray() {

        T[] asArray = (T[]) new Object[this.size];

        for (int i = 0; i < this.size; i++) {
            asArray[i] = al[i];
        }

        //System.out.println(Arrays.toString(asArray));
        return asArray;

    }

    public int getCapacity() {
        return al.length;
    }

    public static void main(String[] args) {

        MyArrayList<Integer> al = new MyArrayList<>();

        al.add(22);
        al.add(44);
        al.add(33);
        al.add(11);
        al.add(88);
        al.add(22);
        al.add(44);
        al.add(22);
        al.add(88);

        System.out.println(al);
        System.out.println("size: " + al.getSize());

        MyArrayList<Integer> tail = new MyArrayList<>();
        tail.add(97);
        tail.add(91);
        tail.add(95);

        al.addAll(tail);

        System.out.println(al);
        System.out.println("size: " + al.getSize());

        System.out.println("AddAll by index: ");
        al.addAll(2, tail);

        System.out.println(al);
        System.out.println("size: " + al.getSize());

        MyArrayList<Integer> sub = al.subList(1, 15);

        System.out.println(sub);
        System.out.println("Size=" + sub.getSize());

        System.out.println("Arrays Operations: ");

        // Arrays.sort(arr);
        //System.out.println(arr);
        // Arrays.binarySearch(arr,33);
//        al.equals(tail);
//        
//        System.out.println("Rmove all:");
//        
//        al.removeAllLastOccurence(tail);
//        
//        System.out.println(al);
//        System.out.println("size: " + al.getSize());
//        
//        System.out.println("Retain All:- ");
//        
//        al.retainAll(tail);
//        
//        System.out.println(al);
//        System.out.println("size: " + al.getSize());
//
//        System.out.println("Remove:  ");
//
//        al.removeAll(44);
//
//        System.out.println(al);
//        System.out.println("size: " + al.getSize());
//
//        System.out.println("set:  ");
//
//        try {
//            al.set(6, 33);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//        System.out.println(al);
//
//        al.clear();
//
//        System.out.println(al);
    }// end main

}// end class
