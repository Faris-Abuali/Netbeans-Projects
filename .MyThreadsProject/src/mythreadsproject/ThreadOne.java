/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythreadsproject;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadOne extends Thread {

    LinkedList<Integer> list;
    int i;
    
    Fares obj;

    public ThreadOne(LinkedList<Integer> l){
        this.list=l;
    }

    @Override
    public void run() {

        while (Fares.i.get() < Fares.list.size()) {

            synchronized (list) {

               
                int currentInt = (int) Fares.list.get(Fares.i.get());

                while (currentInt % 2 != 1 || currentInt % 5 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }

                System.out.println("by ThreadOne:" + currentInt);
                Fares.i.incrementAndGet();

                notify();

            }

        }
    }
}
