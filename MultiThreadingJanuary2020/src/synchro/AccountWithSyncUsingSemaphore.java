/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fares Abu Ali
 */
public class AccountWithSyncUsingSemaphore {
       //Thread synchronization suffices to avoid race conditions
    
    private static Account account = new Account();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();  // shut down executor

        // Wait until all tasks are finished 
        while (!executor.isTerminated()) {  // I think this is similar to join method which is in Thread Class 
        }

//The account balance is displayed  after all tasks are completed.
        System.out.println("What is Balance? " + account.getBalance());

        //The balance of the account is initially 0.
        // When all the threads are finished, the balance should be 100 but the output is unpredictable
    }// end main

    private static class AddAPennyTask implements Runnable {

        @Override
        public void run() {

            synchronized (account) {
                account.deposit(1);
            }
        }

    }// end inner class

    private static class Account {

        private static Semaphore semaphore = new Semaphore(1);

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {

            try {
                semaphore.acquire(); // aquire a permit

                int newBalance = balance + amount;

                // this delay is deliberately added to magnify the data-corruption problem 
                // and make it easy to see
                Thread.sleep(5);
                balance = newBalance;

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                semaphore.release();

            /*
             A thread first acquires a permit when executing the deposit method.
             After the balance is updated, the thread releases the permit 
                

            It is a good practice to always place the release() method in the finally 
            clause to ensure that the permit is finally released even in the case of exceptions.

            */
            }

        }// end method

    }// end class Inner

}
