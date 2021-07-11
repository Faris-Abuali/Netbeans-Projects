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
public class ThreadFiveMultiples implements Runnable{
    
    
    Main lock;

    public ThreadFiveMultiples() {

    }

    public ThreadFiveMultiples(Main lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        Iterator<Integer> itr = lock.list.listIterator();

        synchronized (lock) {

            try {
                while (itr.hasNext()) {

                    while (lock.flag != 3) {
                        lock.wait();
                    }

                    int n = itr.next();

                    if (n % 5 == 0) {
                        System.out.println("Thread 3 : "+n);
                    }

                    lock.flag = 1;
                    lock.notifyAll();

                }

            } catch (InterruptedException ex) {

            }

        }
    }
}
