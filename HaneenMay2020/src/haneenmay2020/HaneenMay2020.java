package haneenmay2020;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class HaneenMay2020 {

    private static void frontToLast(Queue<Integer> q, int qsize) {

        if (qsize <= 0) {
            return;
        }

        q.add(q.remove());

        frontToLast(q, qsize - 1);

    }

    public <E> E fun(LinkedList<E> ll) {

        Iterator<E> itrSlow = ll.listIterator();
        Iterator<E> itrFast = ll.listIterator();

        E prevElement, currElement;

        prevElement = currElement = null;

        while (itrFast.hasNext()) {

            prevElement = itrSlow.next();

            currElement = itrFast.next();

            if (itrFast.hasNext()) {// check again
                currElement = itrFast.next();
            } else {
                break;
            }

        }//end while

        return prevElement;
    }//end method

    public static void main(String[] args) {

        HaneenMay2020 h = new HaneenMay2020();

        LinkedList<String> ll = new LinkedList<>();

        ll.add("Convolution");
        ll.add("FourierSeries");
        ll.add("FourierTransform");
        ll.add("Trigonometric");
        ll.add("Complex");
        ll.add("Expo");//previous
        ll.add("Helbert");
        ll.add("Laplace");
        ll.add("Cristiano");
        ll.add("Khalil");
        ll.add("Yosofo");//current

        System.out.println(h.fun(ll));

    }

}// end class
