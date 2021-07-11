/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythreadsproject;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Fares Abu Ali
 */
public class ProducerConsumerProblem {

    public static void main(String[] args) throws InterruptedException {

        PC pc = new PC();

        //Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // start both threads        
        t1.start();
        t2.start();

        // t1 finishes before t2
//        t1.join();
//        t2.join();

        // the class has a list, producer(adds items to list) and consumer(removes items)
    }// end main

    public static class PC {

        // LinkedList<Integer> list = new LinkedList<>();
        int capacity = 5;
        int[] ar = new int[capacity];
        int index = 0;

        public void fill() {
//            for (int i = 0; i < capacity; i++) {
//                if (ar[i] == 0) {
//                    ar[i] = 1;
//                     index=i;
//                    break;
//                }
//            }

            for (int i = capacity - 1; i >= 0; i--) {
                if (ar[i] == 0) {
                    ar[i] = 1;
                    index = 4 - i;
                    break;
                }
            }
        }

        public void eat() {
            for (int i = capacity - 1; i >= 0; i--) {
                if (ar[i] == 1) {
                    ar[i] = 0;
                    index = i;
                    break;
                }
            }

        }

        // function called by producer thread
        public void produce() throws InterruptedException {

            int value = 1;

            while (true) {

                synchronized (this) {

                    //producer thread waits while list is full
                    if (isFull()) {
                        System.out.println("The List is Full");
                        //wait();
                    } else {
                        fill();
                        System.out.println("PRODUCER: store size = " + storeSize());

                    }

                    // System.out.println("Producer produced: " + Arrays.toString(ar));
                    // to insert the jobs in the list
                    //notifies the consumer thread that now it can start consuming
                    // notify();
                    // makes the working of program easier to understand
                    Thread.sleep(500);
                }
            }
        }// end method produce

        boolean isEmpty() {

            for (int i = 0; i < capacity; i++) {
                if (ar[i] == 1) {
                    return false;
                }
            }

            return true;
        }

        boolean isFull() {

            for (int i = 0; i < capacity; i++) {
                if (ar[i] == 0) {
                    return false;
                }
            }

            return true;
        }

        public int storeSize() {

            int ctr = 0;
            for (int i = 0; i < capacity; i++) {
                if (ar[i] == 1) {
                    ctr++;
                }
            }
            return ctr;
        }

        public void consume() throws InterruptedException {

            while (true) {

                synchronized (this) {

                    // consumer thread waits while list is empty
                    if (isEmpty()) {
                        System.out.println("The List is Empty");
                        // wait();
                    } else {
                        eat();
                        System.out.println("CONSUMER: store size = " + storeSize());

                    }

                    // wake up producer thread
                    //notify();
                    Thread.sleep(500);
                }
            }
        }

    }

}
