/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionlab;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Fares Abu Ali
 */
public class DSrecursion {

    //-----------------------------My Solution------------------------------------
    public static boolean isSorted(Stack<Integer> st, boolean flag) {

        if (st.size() <= 1) {
            flag = true;
        } else {
            int x = st.pop();
            if (x < st.peek()) {
                flag = false;
            } else {
                flag = isSorted(st, false);
            }
            st.push(x);
        }

        return flag;

    }

    public static void sortStack(Stack<Integer> st) {

        while (!isSorted(st, false)) {
            sortRec(st);
        }

    }

    private static void sortRec(Stack<Integer> st) {

        if (st.size() <= 1) {
            return;
        }

        int x = st.pop();
        sortRec(st);
        if (x < st.peek()) {
            int temp = st.pop();
            st.push(x);
            st.push(temp);
        } else {
            st.push(x);
        }

    }

    //--------------------------------------------------------------------------  
    //------------------------Best Sol-------------------------------------  
    public static void sortStackk(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }

        int x = st.pop();
        sortStackk(st);
        insertInSortedOreder(st, x);

    }

    private static void insertInSortedOreder(Stack<Integer> st, int element) {

        if (!st.isEmpty() && element < st.peek()) {

            int temp = st.pop();
            insertInSortedOreder(st, element);
            st.push(temp);
        } else {
            st.push(element);
        }

    }
    //--------------------------------------------------------------------------  

    //-----------------------------Sort a queue-------------------------------  
    private static void frontToLast(Queue<Integer> q, int qsize) {

        if (qsize <= 0) {
            return;
        }

        q.add(q.remove());

        frontToLast(q, qsize - 1);

    }

    private static void pushInQueue(Queue<Integer> q, int temp, int qsize) {

        if (q.isEmpty() || qsize == 0) {
            q.add(temp);
            return;
        } else if (temp <= q.peek()) {

            q.add(temp);

            //System.out.println("queue before enter fToL" + q);
            frontToLast(q, qsize);
            // System.out.println("queue after enter fToL" + q);

        } else if (temp > q.peek()) {

            q.add(q.remove());

            pushInQueue(q, temp, qsize - 1);
        }

    }

    public static void sortQueue(Queue<Integer> q) {

        if (q.isEmpty()) {
            return;
        }

        int temp = q.remove();
        sortQueue(q);
        pushInQueue(q, temp, q.size());

    }

    //--------------------------------------------------------------------------  
    //--------------------reverse a queue-----------------------------------  
    public static void reverseQueue(Queue<Integer> q) {

        if (q.isEmpty()) {
            return;
        }

        int temp = q.remove();
        reverseQueue(q);
        q.add(temp);
    }

    //--------------------reverse a stack-----------------------------------  
    public static void reverseStack(Stack<Integer> st) {

        if (st.isEmpty()) {
            return;
        }

        int temp = st.pop();
        reverseStack(st);
        insertAtBottom(st, temp);
    }

    private static void insertAtBottom(Stack<Integer> st, int element) {

        if (st.isEmpty()) {
            st.push(element);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, element);
        st.push(temp);
    }

    //-----------------------------------------------------------------------  
    public static Iterator midNode(LinkedList ls) {

        Iterator first = ls.iterator();
        Iterator second = ls.iterator();

        return midNodeRec(ls, first, second, null);

    }

    private static Iterator midNodeRec(LinkedList ls, Iterator first, Iterator second, Iterator mid) {

        if (second == null || !second.hasNext()) {
            mid = first;
            System.out.println("now mid=first" + mid.next());
        } else {

            second.next();

            if (second.hasNext()) {
                mid = first;
            } else {
                second.next();
                first.next();
                mid = midNodeRec(ls, first, second, mid);

            }
        }

        return mid;
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

//        st.push(30);
//        st.push(-5);
//        st.push(18);
//        st.push(14);
//        st.push(-3);
//
//        System.out.println(st);
//
//        reverseStack(st);
//        System.out.println(st);
//
//        //System.out.println(isSorted(st, false));
//        
//        //sortStack(st);
//        
//        sortStackk(st);
//        
//        System.out.println(st);
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(1);
        q.add(2);
        q.add(3);
        
        System.out.println(q);
        
        frontToLast(q, 1);
        
                System.out.println(q);
                
                        frontToLast(q, 1);

        System.out.println(q);


//        q.add(3);
//        q.add(2);
//        q.add(4);
//        q.add(1);
//        q.add(5);
        //sortQueue(q);
        //reverseQueue(q);
        //System.out.println(q);
//        LinkedList ls = new LinkedList();
//
//        ls.add(3);
//        ls.add(2);
//        ls.add(4);
//        ls.add(1);
//        ls.add(5);
//
//        Iterator it = midNode(ls);
//        System.out.println(it.next());
    }

}// end class
