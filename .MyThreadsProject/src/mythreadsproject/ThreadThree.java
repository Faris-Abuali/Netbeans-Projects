/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythreadsproject;

import java.util.LinkedList;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadThree extends Thread {

    LinkedList<Integer> list;
    int i;

    public ThreadThree(LinkedList list, int i) {

        this.list = list;
        this.i = i;
    }

    @Override
    public void run() {

        while (Fares.i.get() < Fares.list.size()) {

            synchronized (Fares.list) {

                int currentInt = list.get(Fares.i.get());

                while (currentInt % 2!=0 && currentInt%5!=0) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }

                System.out.println("by ThreadThree:" + currentInt);
                Fares.i.incrementAndGet();

                notify();

            }

        }
    }
}
