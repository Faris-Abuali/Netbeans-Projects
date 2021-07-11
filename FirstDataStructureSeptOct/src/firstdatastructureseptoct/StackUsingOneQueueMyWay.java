/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstdatastructureseptoct;

/**
 *
 * @author Fares Abu Ali
 */
public class StackUsingOneQueueMyWay<E> {

    MyQueue<E> q = new MyQueue<>();

    public void push(E element) {//O(1)
        q.enqueue(element);
    }

    public E pop() {
        E poppedElem = funRec(null);

        q.reverse();

        return poppedElem;
    }

    public E funRec(E save) {

        if (q.getSize() == 1) {
            save = q.dequeue();
            return save;
        }
        if (q.getSize() == 0) {
            return null;
        }

        E x = q.dequeue();
        save = funRec(save);
        q.enqueue(x);
        return save;
    }

    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {
        StackUsingOneQueueMyWay<Integer> s = new StackUsingOneQueueMyWay<>();

        s.push(11);
        s.push(22);
        s.push(33);
        s.push(44);
        s.push(55);

        System.out.println(s);

        s.pop();

        System.out.println(s);

    }
}
