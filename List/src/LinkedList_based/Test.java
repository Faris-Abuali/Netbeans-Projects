package LinkedList_based;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        ArrayList al = new ArrayList();

        al.add(1);

        al.add(3);

        al.add(6);

        al.add(9);
        al.add(11);

        LinkedList<Integer> ls = new LinkedList<>();

        ls.add(8);
        ls.add(1);
        ls.add(22);
        ls.add(4);
        ls.add(2);
        
        System.out.println(sumOfLastNnodes(al, 5));

    }

    public static /*<E extends Number>*/ int sumOfLastNnodes(List<Integer> list, int n) {

        if (n < 1 || n > list.size()) {
            throw new ArrayIndexOutOfBoundsException("n=" + n + " and Size=" + list.size());
        }

        int numOfMovements = list.size() - n;

        ListIterator<Integer> it = list.listIterator();

        
       
        
        Integer sum = 0;

        while (numOfMovements != 0) {
            it.next();
            numOfMovements--;
        }

        while (it.hasNext()) {
            sum += it.next();
                    }

        return sum;
    }
}
