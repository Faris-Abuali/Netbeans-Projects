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
public class QueueUsingTwoStacks<E> {

    MyStack<E> st1;

    MyStack<E> st2;

    public QueueUsingTwoStacks() {
        st1 = new MyStack<>();
        st2 = new MyStack<>();
    }

    public void enqueue(E element) {
        // Method 1 (By making enQueue operation costly)  O(n)

        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        st1.push(element);

        while (!st2.isEmpty()) {

            st1.push(st2.pop());
        }

        
        //Here time complexity will be O(n)
    }

    public E dequeue() { // O(1)

        if (st1.isEmpty()) {
            return null;
        }

        return st1.pop();
    }

    public String toString() {

        String res = "[";

        MyStack<E> temp = new MyStack<>();
        
        while (!st1.isEmpty()) {
            res += st1.getPeek() + ", ";
            temp.push(st1.pop());
        }

        if (res.length() > 2) {
            res = res.substring(0, res.length() - 2);
        }

        res += "]";
        
        
        while(!temp.isEmpty()){
            st1.push(temp.pop());
        }
        return res;
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks<Integer> q = new QueueUsingTwoStacks();

        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        //q.enqueue(44);
      //  q.enqueue(55);
      
      

       System.out.println(q);

//        q.dequeue();
//
//        System.out.println(q);

    }
}
