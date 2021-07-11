

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

//        MyStackAL ms = new MyStackAL<>();
//        System.out.println(ms.getClass());

        MyArrayList<Integer> al = new MyArrayList<>();

        // MyCircularQueue<Integer> m = new MyCircularQueue<>();
        MyQueue<Integer> m = new MyQueue<>();

        m.enqueue(1);

        m.enqueue(2);

        m.enqueue(33);

        m.enqueue(55);
        m.enqueue(54);
        m.enqueue(5445);
        m.enqueue(355);

        m.dequeue();

        System.out.println(m);
        System.out.println("Size=" + m.size());

        m.dequeue();

        System.out.println(m);
        System.out.println("Size=" + m.size());

        m.dequeue();

        System.out.println(m);
        System.out.println("Size=" + m.size());

        m.dequeue();

        System.out.println(m);
        System.out.println("Size=" + m.size());

        m.enqueue(123);
        m.enqueue(12223);
        m.enqueue(123);
        m.enqueue(134883);
        m.enqueue(1277873);

        //  m.dequeue();
        System.out.println(m);
        System.out.println("Size=" + m.size());

        System.out.println("Head: " + m.getHead());

        System.out.println("Last: " + m.getLast());

//        m.enqueue(95);
//        m.enqueue(97);
//        m.enqueue(100);
//
//        System.out.println(m);
//        System.out.println("Size=" + m.size());
//        System.out.println("Original Set:- ");
//        al.add(11);
//        al.add(44);
//        al.add(33);
//        al.add(11);
//        al.add(22);
//        al.add(6);
//        al.add(22);
//        al.add(33);
//        al.add(6);
//        al.add(7);
//        al.add(123);
//        al.add(11);
//        al.add(33);
//        al.add(81);
//        al.add(44);
//        al.add(7);
//        
//        
//        System.out.println("Original ArrayList:- ");
//
//        System.out.println(al);
//        System.out.println("Size= " + al.getSize());
//
//        System.out.println("\nRmove Duplicates:- ");
//
//        al.removeDuplicates();
//
//        System.out.println(al);
//        System.out.println("Size= " + al.getSize());
//
//        System.out.println("\nReverse:- ");
//        al.reverseList();
//
//        System.out.println(al);
//        System.out.println("Size= " + al.getSize());
//        
//        
//        ArrayList<Integer> f =new ArrayList<>();
//        ArrayList<Integer> h =new ArrayList<>();
//        
//        
//        f.add(4);
//        f.add(2);
//        f.add(1);
//        
//        h.add(4);
//        h.add(2);
//        h.add(1);
//        
//        
//        
//        System.out.println(f.equals(h));
    }

}
