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
public class MyLinkedListt<E> { // Q1

    private Node<E> head;
    private Node<E> tail;

    private int size;

    private static class Node<E> {

        E element;    
        Node<E> next; 

        public Node(E element) {
            this.element = element;
        }

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
    }    // end Node

    public MyLinkedListt() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
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

    public E valueAtNthNodeFromLast(int n) {

        E result=null;
        
        if(n<=0 || n>size){
            System.out.println("Index Out Of Range, index="+n+" but size="+size);
        }
        else{
        int numOfMovements = size - n;

        Node<E> curr = head;

        while (numOfMovements > 0) {
            curr = curr.next;
            
            numOfMovements--;
        }

        result=curr.element;
        }
        
        return result;
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


    public static void main(String[] args) {
        MyLinkedListt<Integer> mls = new MyLinkedListt();

        mls.addLast(2);
        mls.addLast(5);
        mls.addLast(7);
        mls.addLast(4);
        mls.addLast(6);
        
        
        System.out.println(mls);
        
        System.out.println(mls.valueAtNthNodeFromLast(2));

    }

}// end class
