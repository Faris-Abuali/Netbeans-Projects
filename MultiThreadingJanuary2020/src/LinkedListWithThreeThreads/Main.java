package LinkedListWithThreeThreads;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fares Abu Ali
 */
public class Main {

    public int flag = 0;
    public LinkedList<Integer> list ;

    public Main() {
    }

    public Main(LinkedList<Integer> list, int flag) {
        this.list = list;
        this.flag = flag;
    }



}// end Main class
