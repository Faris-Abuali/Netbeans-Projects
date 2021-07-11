package based_on_LinkedList;

import java.util.NoSuchElementException;

/**
 *
 * @author Fares Abu Ali
 */
public class MyDoublyLinkedList<E> {

    //---------------- nested Node class ---------------
    private static class Node<E> {

        private Node<E> next;
        private Node<E> previous;
        private E element;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return this.element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

    }

    //---------------- end of nested Node class ---------------
    Node<E> head;
    Node<E> tail;
    int size;

    public MyDoublyLinkedList() {

        head = tail = null;
        size = 0;
    }

//        public MyDoublyLinkedList(E[] ar) {
//
//        Node<E> current = head;
//        int i = 0;
//
//        while (current != null) {
//            addLast(ar[i]);
//
//            current = current.getNext();
//            i++;
//        }
//
//    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public E getFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("The Doubly LinkedList is empty!!!");
        }

        return head.getElement();
    }

    public E getLast() {

        if (isEmpty()) {
            throw new NoSuchElementException("The Doubly LinkedList is empty!!!");
        }

        return tail.getElement();
    }

    public void addFirst(E element) {

        Node<E> createdNode = new Node<>(element);

        if (isEmpty()) {
            head = tail = createdNode;
        } else {
            createdNode.setNext(head);
            head.setPrevious(createdNode);

            head = createdNode;

        }

        size++;
    }

    public void addLast(E element) {

        Node<E> createdNode = new Node<>(element);

        if (isEmpty()) {
            head = tail = createdNode;
        } else {

            tail.setNext(createdNode);
            createdNode.setPrevious(tail);

            tail = createdNode;

        }

        size++;

    }

    public void add(int index, E element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {

            Node<E> createdNode = new Node<>(element);

            Node<E> prev = head;

            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            Node<E> current = prev.getNext();

            createdNode.setPrevious(prev);
            createdNode.setNext(current);
            prev.setNext(createdNode);
            current.setPrevious(createdNode);

            size++;

        }

    }

    public E removeFirst() {// O(1)

        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedList is Empty!!!");
        }

        E deletedElement = head.getElement();

        if (size == 1) {
            head = tail = null;
        } else {
            Node<E> temp = head.getNext();
            temp.setPrevious(null);
            head = temp; // or = head.getNext();          
        }

        size--;

        return deletedElement;
    }

    public E removeLast() { // O(1)

        if (isEmpty()) {
            throw new NoSuchElementException("The LinkedList is Empty!!!");
        }

        E deletedElement = tail.getElement();

        if (size == 1) {
            head = tail = null;
        } else {

            Node<E> temp = tail.getPrevious();

            temp.setNext(null);
            tail = temp;
        }

        size--;

        return deletedElement;

    }

    public E remove(int index, E element) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index. Index=" + index + ", but Size=" + size);
        }

        E deletedElement;

        if (index == size - 1) {
            deletedElement = removeLast();
        } else if (index == 0) {
            deletedElement = removeFirst();
        } else {

            Node<E> current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            deletedElement = current.getElement();

            Node<E> backNode = current.getPrevious();
            Node<E> frontNode = current.getNext();

            backNode.setNext(frontNode);
            frontNode.setPrevious(backNode);

            size--;
        }

        return deletedElement;
    }

    public boolean removeFirstOccurenceOf(E element) {

        boolean flag = false;

        Node<E> current = head;

        while (current != null) {

            if (current.getElement().equals(element)) {

                flag = true;

                if (current == head) {
                    removeFirst();

                } else if (current == tail) {
                    removeLast();
                } else {

                    Node<E> backNode = current.getPrevious();
                    Node<E> frontNode = current.getNext();

                    backNode.setNext(frontNode);
                    frontNode.setPrevious(backNode);

                    size--;
                }

                break;

            }

            current = current.getNext();

        }

        return flag;
    }

    public boolean removeLastOccurenceOf(E element) {

        boolean flag = false;

        Node<E> current = tail;

        while (current != null) {

            if (current.getElement().equals(element)) {

                flag = true;

                if (current == tail) {
                    removeLast();
                } else if (current == head) {
                    removeFirst();
                } else {

                    Node<E> frontNode = current.getNext();
                    Node<E> backNode = current.getPrevious();

                    backNode.setNext(frontNode);
                    frontNode.setPrevious(backNode);

                    size--;
                }

                break;
            }

            current = current.getPrevious();

        }

        return flag;

    }

    public boolean removeAllOccurencesOf(E element) {

        boolean flag = false;

        Node<E> current = head;

        while (current != null) {

            if (current.getElement().equals(element)) {

                if (current == head) {
                    removeFirst();
                    current = head;
                } else if (current == tail) {
                    removeLast();
                    current = null;
                    break;
                } else {

                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());

                    size--;

                }

            }

            current = current.getNext();

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

        int location = -1;

        int ctr = 0;

        Node<E> current = head;

        while (current != null) {

            if (current.getElement().equals(element)) {
                location = ctr;
                break;
            }

            current = current.getNext();
            ctr++;
        }

        return location;

    }

    public int lastIdexOf(E element) {

        int location = -1;

        int ctr = 0;

        Node<E> current = tail;

        while (tail != null) {

            if (tail.getElement().equals(element)) {
                location = ctr;
                break;
            }

            current = current.getPrevious();
            ctr++;
        }
        
        return location;
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

       
       public void reverse(){
           // reverse a doubly linkedlist
           Node<E> saveNext;
           Node<E> current=head;
           
           while(current!=null){
               
               saveNext=current.getNext();
               
               current.setNext(current.getPrevious());
               current.setPrevious(saveNext);
               
               
               current=saveNext;
               
           }
           
           Node<E> temp=head;
           head=tail;
           tail=temp;
             
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
    
    
    public void print2(){
        print2(head);
    }
    
    private void print2(Node<E> start){
        
        if(start==null)
            return;
        
        System.out.println(start.getElement()+" ");
        
        if(start.next!=null)
        print2(start.next.next);
        
        System.out.println(start.getElement()+" ");
    }

    public static void main(String[] args) {

        MyDoublyLinkedList<Integer> dls = new MyDoublyLinkedList<>();

        
        dls.addLast(1);
                dls.addLast(2);
        dls.addLast(3);
        dls.addLast(4);
        dls.addLast(5);
                dls.addLast(6);


        
        
        
//        dls.addFirst(2);
//
//        //System.out.println("Size=" + dls.size());
//        dls.addFirst(0);
//
//        dls.addLast(3);
//
//        dls.addLast(5);
//
//        // System.out.println(dls);
//        //  System.out.println("Size=" + dls.size());
//        dls.add(3, 4);
//
//        // System.out.println(dls);
//        // System.out.println("Size=" + dls.size());
//        dls.add(3, 5);
//
//        dls.add(dls.size(), 5);
//
//        dls.addFirst(5);
//        System.out.println(dls);
//        System.out.println("Size=" + dls.size());
//
//        dls.addLast(43);
//        
//        
//
//        
//        
//        System.out.println("First= "+dls.getFirst());
//        
//        System.out.println("Last= "+dls.getLast());
//        
//        
//        
//        System.out.println("reverse: ");
//        
//        dls.reverse();
//        
//        System.out.println(dls);
//         System.out.println("First= "+dls.getFirst());
//        
//        System.out.println("Last= "+dls.getLast());
//        
        
        
        dls.print2();
        
        
//        dls.removeAllOccurencesOf(5);
//
//        System.out.println(dls);
//        System.out.println("Size=" + dls.size());
        
        
        

//        dls.removeFirst();
//        System.out.println(dls);
//        System.out.println("Size=" + dls.size());
//
//        dls.removeLast();
//        System.out.println(dls);
//        System.out.println("Size=" + dls.size());
//
//        dls.removeFirstOccurenceOf(5);
//
//        System.out.println(dls);
//        System.out.println("Size=" + dls.size());
    }

}// end of MyDoublyLinkedList class
