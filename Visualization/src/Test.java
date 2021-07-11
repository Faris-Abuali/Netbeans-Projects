/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        MyQueue<String> q = new MyQueue<>();

        q.enqueue("Fares");
        q.enqueue("Hatem");
        q.enqueue("Tawfiq");
        q.enqueue("Abu Ali");
        
        
        System.out.println(q);
        
        reverseQ(q);
        
        System.out.println(q);

    }

    public static <E> void reverseQ(MyQueue<E> q) {

        if (q.getSize() == 0) {
            return;
        }

        E x = q.dequeue();
        reverseQ(q);
        q.enqueue(x);
    }

}
