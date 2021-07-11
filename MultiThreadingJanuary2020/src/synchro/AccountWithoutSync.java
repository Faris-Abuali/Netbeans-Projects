package synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fares Abu Ali
 */

/*
This demonstrates the data-corruption problem that occurs when all 
the threads have access to the same data source simultaneously.
 */
public class AccountWithoutSync {

    // THIS ACCOUNT CLASS IS NOT THREAD-SAFE. IT CAUSES A RACE CONDITION WHICH RESULTS IN DATA CORRUPTION
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

        private int balance = 0;

        public int getBalanace() {
            return balance;
        }

        public void deposit(int amount) {

            int newBalane = balance + amount;

            //This delay is deliberately added to magnify the data-corruption problem and make it easy to see. 
//            try {
//                Thread.sleep(3);
//            } catch (InterruptedException ex) {
//                //System.out.println(ex.getMessage());
//            }

            balance = newBalane;
        }

        /*
        
        To avoid race conditions, it is necessary to prevent more than one thread from simultaneously 
        entering a certain part of the program, known as the critical region.
        The critical region here is the entire deposit method.
         */
    }// end inner class

}// end class
