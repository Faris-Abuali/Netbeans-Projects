

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Fares Abu Ali
 */
public class MySinglyLinkedList<E> implements Iterable<E> {

    //---------------- nested Node class ---------------
    private static class Node<E> {

        private E element;    // reference to the element stored at this node
        private Node<E> next; // reference to the susequent node in the list

        public Node(E element) {
            this.element = element;
        }

//        public Node(E e,Node<E> n){
//            
//            element=e;
//            next=n;
//        }
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    //----------- end of nested Node class --------------

    private Node<E> head;  // reference to the first node of the list (or null if empty)
    private Node<E> tail;  // reference to the last node of the list (or null if empty)

    private int size;

    public MySinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public MySinglyLinkedList(E[] ar) {

        Node<E> current = head;
        int i = 0;

        while (current != null) {
            addLast(ar[i]);

            current = current.getNext();
            i++;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public E first() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException("The Singly LinkedList is empty!!!");
        }

        E firstElement = head.getElement();

        return firstElement;
    }

    public E last() {// or tail

        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedList is empty!!!");
        }

        E lastElement = tail.getElement();

        return lastElement;
    }

    public void addFirst(E element) {

        Node<E> createdNode = new Node<>(element);

        if (size == 0) {
            head = tail = createdNode;
//            createdNode.setNext(null);
        } else {
            createdNode.setNext(head);
            head = createdNode;
        }

        size++;
    }

    public void addLast(E element) {

        Node<E> createdNode = new Node(element);

        if (isEmpty()) {
            head = tail = createdNode;
        } else {
            tail.setNext(createdNode);
            tail = createdNode;
        }

        // createdNode.setNext(null);
        size++;
    }

    public void add(int index, E element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        if (index == size) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {

            Node<E> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            Node<E> createdNode = new Node<>(element);

            createdNode.setNext(current.getNext());
            current.setNext(createdNode);
            size++;
        }

    }

    public E removeFirst() { // O(1)

        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedList is Empty!!!");
        }

        E temp = head.getElement();

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
        }

        size--;
        return temp;

    }

    public E removeLast() { // O(n)

        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedList is Empty!!!");
        }

        E temp = tail.getElement();

        if (size == 1) {
            head = tail = null;
        } else {

            Node<E> previous = null;
            Node<E> current = head;

            while (current.getNext() != null) {

                previous = current;
                current = current.getNext();
            }

            tail = previous;
            tail.setNext(null); // or previous.setNext(null)

        }

        size--;
        return temp;
    }

    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        E temp;

        if (index == 0) {
            temp = first();
            removeFirst();
        } else if (index == size - 1) {
            temp = first();

            removeLast();
        } else {

            Node<E> previous = head;
            Node<E> current = head.getNext();

            for (int i = 0; i < index - 1; i++) {
                previous = current;
                current = current.getNext();
            }

            temp = current.getElement();

            previous.setNext(current.getNext());
//            current.setNext(null);  // not necessary

            size--;
        }

        return temp;

    }

    public boolean removeFirstOccurence(E element) {

        boolean flag = false;

        Node<E> previous = null;
        Node<E> current = head;

        while (current != null) {

            if (current.getElement().equals(element)) {

                flag = true;

                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {

                    previous.setNext(current.getNext());

                    size--;

                }

                break;

            }

            previous = current;
            current = current.getNext();
        }

        return flag;

    }

    public boolean removeLastOccurence(E element) {

        boolean flag = false;

        Node<E> current = head;
        int location = -1;
        int ctr = 0;

        while (current != null) {

            if (current.getElement().equals(element)) {
                flag = true;
                location = ctr;

            }

            current = current.getNext();
            ctr++;
        }

        if (location != -1) {
            remove(location);
        }

        return flag;

    }

    public boolean removeAllOccurences(E element) {

        boolean flag = false;

        Node<E> previous = null;
        Node<E> current = head;

        while (current != null) {
            if (current.getElement().equals(element)) {

                flag = true;

                if (current == head) {
                    removeFirst();
                    current=head;
                } else if (current == tail) {
                    removeLast();
                    current=null;
                } else {

                    previous.setNext(current.getNext());
                    current = current.getNext(); // move the (current) only. Don't move the (previous)

                    size--;

                }

               
            } else {

                previous = current;
                current = current.getNext();

            }
        }

        return flag;

    }

    public void clear() {
        size = 0;
        head = tail = null;
    }

    public boolean contains(E element) {

        boolean flag = false;

        Node<E> current = head;

        while (current != null) {

            if (current.element.equals(element)) {
                flag = true;
                break;
            }

            current = current.getNext();
        }

        return flag;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();

    }
    
    

    public void set(int index, E element) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setElement(element);

    }

    public int indexOf(E element) {

        int index = -1;
        int ctr = 0;

        Node<E> current = head;

        while (current != null) {
            if (current.getElement().equals(element)) {
                index = ctr;
                break;
            }

            current = current.getNext();
            ctr++;
        }

        return index;
    }

    public int lastIndexOf(E element) {

        int index = -1;
        int ctr = 0;

        Node<E> current = head;

        while (current != null) {
            if (current.getElement().equals(element)) {
                index = ctr;
            }

            current = current.getNext();
            ctr++;
        }

        return index;

    }

    public String toString() {

        String res = "[";

        Node<E> current = head;

        while (current != null) {

            res += current.getElement() + ", ";

            current = current.getNext();
        }

        if (res.length() > 2) {
            res = res.substring(0, res.length() - 2);
        }

        res += "]";

        return res;
    }

    public Object[] toArray() {

        Object[] ar = new Object[size];

        Node<E> current = head;
        int i = 0;

        while (current != null) {
            ar[i] = current.getElement();

            current = current.getNext();
            i++;
        }

        return ar;
    }

    public void reverse() {

        Node<E> previous = null;
        Node<E> current = head;
        Node<E> save = head.getNext();

        tail = head;

        while (save != null) {

            current.setNext(previous);

            previous = current;
            current = save;
            save = save.getNext();

        }

        // last step: now the (current) reference is pointing at the last node
        current.setNext(previous);

        head = current;

    }
    
    
    public MySinglyLinkedList<E> merge(MySinglyLinkedList<E> sll){
        
        MySinglyLinkedList<E> newLList=this;
        
        Node<E> current=sll.head;
        
        while(current!=null){
            newLList.addLast(current.getElement());
            
            current=current.getNext();
        }
        
        
        return newLList;
    }

    @Override
    public Iterator<E> iterator() {
        return new MySinglyLinkedListIterator();
    }

    private class MySinglyLinkedListIterator implements Iterator<E> {

        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            return current.getElement();
        }

    }

    public static void main(String[] args) {

//        LinkedList<Integer> ls = new LinkedList<>();
//
//        System.out.println(ls.removeFirst());
        MySinglyLinkedList<Integer> sl = new MySinglyLinkedList<>();

        sl.addFirst(15);
        sl.addFirst(7);
        sl.addFirst(2);
        
        sl.addLast(22);
        
        
        MySinglyLinkedList<Integer>  toBeMerged=new MySinglyLinkedList<>();
        
        toBeMerged.add(0,99);
        toBeMerged.addLast(100);
        toBeMerged.addLast(101);
        
        MySinglyLinkedList<Integer> mergedList = sl.merge(toBeMerged);
        
        
        
        System.out.println(mergedList);
        System.out.println("Size="+mergedList.size());

//        Iterator it = sl.iterator();
//
//        sl.addFirst(12);
//
//        sl.addLast(15);
//
//        sl.addFirst(11);
//
//        sl.add(3, 15);
//
//        sl.addLast(44);
//
//        sl.add(5, 563);
//
//        sl.addLast(44);
//
//        sl.addFirst(11);
//
//        sl.addFirst(46);
//
//        sl.add(4, 11);
//
//        System.out.println(sl);
//        System.out.println("Size=" + sl.size());
//
//        System.out.println(sl.removeAllOccurences(44));

//        System.out.println(sl);
//        System.out.println("Size=" + sl.size());

//        System.out.println("Reverse: ");
//
//        sl.reverse();
//
//        System.out.println(sl);
//
//        System.out.println("Size=" + sl.size());
//        System.out.println("indexOf(11) = " + sl.indexOf(11));
//        System.out.println("lastIndexOf(11) = " + sl.lastIndexOf(11));
//
//        System.out.println(sl);
//        System.out.println("Size=" + sl.size());
//
//        System.out.println("\n\n");
//
//        sl.removeLastOccurence(11);
//        System.out.println(sl);
//
//        System.out.println("Size=" + sl.size());
//
//        System.out.println(sl.get(7));
//
//        sl.set(7, 777);
//
//        System.out.println(sl);
//
//        Object[] m = sl.toArray();
//
//        Arrays.toString(m);
//        System.out.println(m.length);
    }

}//end class
