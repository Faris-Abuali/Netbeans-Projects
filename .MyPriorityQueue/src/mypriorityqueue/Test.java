package mypriorityqueue;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

//        MyMaxPriorityQueue q = new MyMaxPriorityQueue(13);
//
//        //7, 16, 10, 8, 2, 4, 3, 14, 9, 12
//        q.MAX_HEAP_INSERT(7);
//        q.MAX_HEAP_INSERT(16);
//        q.MAX_HEAP_INSERT(10);
//        q.MAX_HEAP_INSERT(8);
//        q.MAX_HEAP_INSERT(2);
//        q.MAX_HEAP_INSERT(4);
//        q.MAX_HEAP_INSERT(3);
//        q.MAX_HEAP_INSERT(14);
//        q.MAX_HEAP_INSERT(9);
//        q.MAX_HEAP_INSERT(12);
//        
//        System.out.println("Initial Shape :\n"+q);
//
//        
//        while(!q.isEmpty()){
//           System.out.println("Remove: "+q.HEAP_EXTRACT_MAX());
//            System.out.println(q);
//        }
//        
//        
        //=======================================================
        MyMinPriorityQueue m = new MyMinPriorityQueue(13);

        m.MIN_HEAP_INSERT(7);
        m.MIN_HEAP_INSERT(16);
        m.MIN_HEAP_INSERT(10);
        m.MIN_HEAP_INSERT(8);
        m.MIN_HEAP_INSERT(2);
        m.MIN_HEAP_INSERT(2);

        m.MIN_HEAP_INSERT(4);
        m.MIN_HEAP_INSERT(3);
        m.MIN_HEAP_INSERT(14);
        m.MIN_HEAP_INSERT(9);
        m.MIN_HEAP_INSERT(12);

        System.out.println("Initial Shape After dec:\n" + m);

        while (!m.isEmpty()) {
            System.out.println("Remove: " + m.HEAP_EXTRACT_MIN());
            System.out.println(m);
        }

    }// end main
}// end class
