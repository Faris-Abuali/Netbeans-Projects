package SetVsList;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class SetVsListPerformanceTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static final int N = 50000;

    public SetVsListPerformanceTest() {
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        //===============================================================================================================
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println(ANSI_CYAN+"Member test time for hash set is " + getTestTime(set1) + " milliseconds"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Remove element time for hash set is " + getRemoveTime(set1) + " milliseconds");

        //===============================================================================================================
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println(ANSI_CYAN+"Member test time for Linked Hash set is " + getTestTime(set2) + " milliseconds"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Remove element time for LinkedHashSet is " + getRemoveTime(set2) + " milliseconds"+ANSI_RESET);

        //===============================================================================================================
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println(ANSI_CYAN+"Member test time for tree set is " + getTestTime(set3) + " milliseconds"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Remove element time for tree set is " + getRemoveTime(set3) + " milliseconds"+ANSI_RESET);

        //===============================================================================================================
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println(ANSI_CYAN+"Member test time for ArrayList is " + getTestTime(list1) + " milliseconds"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Remove element time for ArrayList is " + getRemoveTime(list1) + " milliseconds"+ANSI_RESET);
        //===============================================================================================================

        Collection<Integer> list2 = new LinkedList<>(list);

        System.out.println(ANSI_CYAN+"Member test time for LinkedList is " + getTestTime(list2) + " milliseconds"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Remove element time for LinkedList is " + getRemoveTime(list2) + " milliseconds"+ANSI_RESET);
        //===============================================================================================================

    }// end main

    public static long getTestTime(Collection<Integer> c) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.contains((int) (Math.random() * 2 * N));  // test membership
        }

        return System.currentTimeMillis() - startTime;

    }// end method
    
    
      public static long getRemoveTime(Collection<Integer> c) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.remove(i);  //remove from container
        }

        return System.currentTimeMillis() - startTime;

    }// end method
      
      
      

}// end class
