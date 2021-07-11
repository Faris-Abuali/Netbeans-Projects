
package midexam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Fares Abu Ali
 */
public class Question5 {

    public static int sumOfEven(Queue<Integer> q) {

        Iterator it = q.iterator();

        return sumOfEvenRec(q, it, 0);
    }

    private static int sumOfEvenRec(Queue<Integer> q, Iterator it, int sum) {

        if (it.hasNext()) {

            int element = (int) it.next();

            if (element % 2 == 0) {
               sum= element + sumOfEvenRec(q, it,0);
            } else {
                sum= sumOfEvenRec(q, it, 0);
            }

        }
        
        return sum;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
//
//        q.add(2);
//        q.add(5);
//        q.add(4);
//        q.add(8);
//        q.add(7);
//        q.add(3);


        q.add(1);
        q.add(51);
        q.add(41);
        q.add(81);
        q.add(71);
        q.add(31);

        System.out.println(sumOfEven(q));

    }
    
    
    
    
    
    
//    private static int sumOfEvenRec(Queue<Integer> q, Iterator it, int sum) {
//
//        if (it.hasNext()) {
//
//            int element = (int) it.next();
//
//            if (element % 2 == 0) {
//                return element + sumOfEvenRec(q, it, 0);
//            } else {
//                return sumOfEvenRec(q, it, 0);
//            }
//
//        } else {
//            return sum;
//        }
//
//    }
}
