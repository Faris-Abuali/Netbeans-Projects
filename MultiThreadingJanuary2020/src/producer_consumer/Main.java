package producer_consumer;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.management.Notification;

/**
 *
 * @author Fares Abu Ali
 */
public class Main {

    private static PC pc = new PC();
    private static KhalilsIdea kh = new KhalilsIdea();

    public static void main(String[] args) {

        // Create a thread pool with two threads 
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        //executor.shutdown();

    }// end main

    private static class ProducerTask implements Runnable {

        @Override
        public void run() {

            kh.produceKhalil();

        }//end while

    }// end run

    private static class ConsumerTask implements Runnable {

        @Override
        public void run() {

            kh.consumeKhalil();

        }//end run

    }// end class

    private static class PC {

        Lock lock = new ReentrantLock();

        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        Queue<Integer> q = new LinkedList<>();

        private static final int CAPACITY = 5;

        public void produce() {

            lock.lock();   // acquire the lock

            try {

                while (true) {

                    while (q.size() == CAPACITY) {
                        System.out.println("Wait for notFull condition");
                        notFull.await(); // wait for the queue to become (notFull)
                    }

                    q.add(1);
                    System.out.println("PRODUCER: " + q);

                    notEmpty.signal();  // notify/Signal notEmpty condition 

                }//end big while

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }

        }// end produce

        public void consume() {

            lock.lock();   // acquire the lock

            try {

                while (true) {

                    Thread.sleep((int) (Math.random() * 1000));

                    while (q.isEmpty()) {
                        System.out.println("Wait for notEmpty condition");
                        notEmpty.await(); // wait for the queue to become (notEmpty)
                    }

                    q.remove();
                    System.out.println("CONSUMER: " + q);

                    notFull.signal();  // notify/Signal notEmpty condition 

                }//end big while

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }

        }// end consume

    }// end PC

    private static class KhalilsIdea {

        //Queue<Integer> q = new LinkedList<>();
        private static final int CAPACITY = 5;
        int[] ar = new int[CAPACITY];
        int i = 0;

        public void produceKhalil() {

            try {

                while (true) {

                    Thread.sleep((int) (Math.random() * 3000) + 1);

                    while (i >= CAPACITY ) {
                        System.out.println("PRODUCER: Queue is FULL!");
                        Thread.sleep((int) (Math.random() * 3000) + 1);
                    }

                    if (i < CAPACITY) {
                        ar[i] = 1;
                        i++;
                        System.out.println("PRODUCER: " + Arrays.toString(ar));
                    }
                }

            } catch (InterruptedException ex) {

            }
        }// end while true


    public void consumeKhalil() {

        try {

            while (true) {

                Thread.sleep((int) (Math.random() * 3000) + 1);
                while (i==0) {
                    System.out.println("CONSUMER: Queue is EMPTY!");
                    Thread.sleep((int) (Math.random() * 3000) + 1);
                }

                if (i>0 && i<=CAPACITY) {
                    ar[i-1] = 0;
                    i--;
                    System.out.println("CONSUMER: " + Arrays.toString(ar));
                }

            }
        } catch (InterruptedException ex) {

        }

    }// end while true


}// end class Khalil

}// end class

