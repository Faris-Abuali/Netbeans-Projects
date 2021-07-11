package synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fares Abu Ali
 */
public class AccountWithSync {

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
        System.out.println("What is Balance? " + account.getBalanace());

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

        private static Lock lock = new ReentrantLock(); // create a lock

        private int balance = 0;

        public int getBalanace() {
            return balance;
        }

        public void deposit(int amount) {

            lock.lock(); // Acquire the lock

            int newBalane = balance + amount;

            //This delay is deliberately added to magnify the data-corruption problem and make it easy to see. 
            try {
                Thread.sleep(5);
                balance = newBalane;

            } catch (InterruptedException ex) {
                //System.out.println(ex.getMessage());
            }
            finally{
                lock.unlock(); // release the lock
            }

        }// end method

        /*
        
        To avoid race conditions, it is necessary to prevent more than one thread from simultaneously 
        entering a certain part of the program, known as the critical region.
        The critical region here is the entire deposit method.
         */
    }// end inner class

}// end class
