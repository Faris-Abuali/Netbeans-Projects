/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresLab;

import java.util.NoSuchElementException;

/**
 *
 * @author Fares Abu Ali
 */
public class SinglyLinkedListLab<E> {

    private static class Node<E> {

        private E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public void setElement(E element) {

            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

    }

    private Node<E> head, tail;
    private int size;

    public SinglyLinkedListLab() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public E getFirst() {

        if (this.getSize() == 0) {
            throw new NoSuchElementException();
        }

        return head.getElement();
    }

    public E getLast() {

        if (this.getSize() == 0) {
            throw new NoSuchElementException();
        }

        return tail.getElement();
    }

    public void addLast(E element) {

        Node<E> createdNode = new Node(element);

        if (size == 0) {
            head = tail = createdNode;
        } else {

            tail.setNext(createdNode);

            tail = createdNode;

        }
        size++;

    }

    public void addFirst(E element) {

        Node<E> createdNode = new Node(element);


        if (size == 0) {
            head = tail = createdNode;
        } else {

            createdNode.setNext(head);

            head = createdNode;

        }
        
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
            temp = getFirst();
            removeFirst();
        } else if (index == size - 1) {
            temp = getFirst();

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

    
    
    public static void main(String[] args) {
        
        
        SinglyLinkedListLab<Integer> sll =new SinglyLinkedListLab<>();
        
        sll.addFirst(3);
        sll.addFirst(-4);
        
        
        sll.addLast(5);
        
                System.out.println(sll);

        sll.removeFirst();
        
        System.out.println(sll);
        
    }

}
