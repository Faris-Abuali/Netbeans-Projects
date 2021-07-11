package LinkedListWithThreeThreads;

import java.util.Iterator;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadOdd implements Runnable {

    Main lock;

    public ThreadOdd() {

    }

    public ThreadOdd(Main lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        Iterator<Integer> itr = lock.list.listIterator();

        synchronized (lock) {

            try {
                while (itr.hasNext()) {

                    while (lock.flag != 1) {
                        lock.wait();
                    }

                    int n = itr.next();

                    if (n % 2 == 1 && n%5!=0) {
                        System.out.println("Thread 1 : "+n);
                    }

                    lock.flag = 2;
                    lock.notifyAll();

                }

            } catch (InterruptedException ex) {

            }

        }
    }

}
