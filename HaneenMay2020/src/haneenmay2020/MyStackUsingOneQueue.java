package haneenmay2020;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class MyStackUsingOneQueue<E> {

    Queue<E> q = new LinkedList<E>();

    private void frontToLast(int qsize) { // O(n)

        if (qsize <= 0) {
            return;
        }

        q.add(q.remove());

        frontToLast(qsize - 1);

    }// end method

    public void push(E element) { // O(n)

        q.add(element); // O(1)

        frontToLast(q.size() - 1); // O(n)

    }// end method

    public E pop() {// O(1)
        return q.poll();
    }// end method

    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {

        MyStackUsingOneQueue<String> s = new MyStackUsingOneQueue<>();

        s.push("F");
        s.push("A");
        s.push("R");
        s.push("E");
        s.push("S");

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}// end class
