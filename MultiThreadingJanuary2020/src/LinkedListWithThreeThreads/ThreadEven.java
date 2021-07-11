/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListWithThreeThreads;

import java.util.Iterator;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadEven implements Runnable {

    Main lock;

    public ThreadEven() {

    }

    public ThreadEven(Main lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        Iterator<Integer> itr = lock.list.listIterator();
 
        synchronized (lock) {

            try {
                while (itr.hasNext()) {

                    while (lock.flag != 2) {
                        lock.wait();
                    }

                    int n = itr.next();

                    if (n % 2 == 0 && n%5!=0) {
                        System.out.println("Thread 2 : "+n);
                    }

                    lock.flag=3;
                    lock.notifyAll();

                }

            } catch (InterruptedException ex) {

            }

        }
    }

}
