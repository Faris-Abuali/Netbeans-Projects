/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingjanuary2020;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class Task1 implements Runnable {

    MainClass lock;

    public Task1() {

    }

    public Task1(MainClass lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            
            synchronized (lock) {

                for (int i = 0; i < 8; i++) {

                    while (lock.flag != 1) {
                        lock.wait();
                    }// end while l

                    System.out.println("A ");

                    lock.flag = 2;

                    lock.notifyAll();

                }

            }// end synchronized

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }// end run

}// end class
