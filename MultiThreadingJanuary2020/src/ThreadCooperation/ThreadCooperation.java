package ThreadCooperation;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadCooperation {

    private static Account account = new Account();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());

        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");

    }// end main

    public static class DepositTask implements Runnable {

        @Override
        public void run() {

            try {

                while (true) {

                    account.deposit((int) (Math.random() * 10) + 1);

                    Thread.sleep(1000);
                }// end while

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }// end run

    }// end class

    public static class WithdrawTask implements Runnable {

        @Override
        public void run() {

            while (true) {

                account.withdraw((int) (Math.random() * 10) + 1);

            }// end while

        }// end run

    }// end class

    private static class Account {

        // create a lock
        private static Lock lock = new ReentrantLock();

        // create a condition
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {

            
            lock.lock(); // Acquire the lock 
            
            /*
            A condition is created from a Lock object. To invoke its method (e.g., await(), signal(), and signalAll()),
            you must first own the lock (Acquire the lock). If you invoke these methods without acquiring the lock, 
            an IllegalMonitorStateException will be thrown.
            */

            try {

                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                    
                    //When wait() is invoked, it pauses the thread and simultaneously releases the lock on the object. 
                    //When the thread is restarted after being notified, the lock is automatically reacquired. 
                    
                    
                    /*
                    You can invoke the await() method on the monitor object to release the lock so that 
                    some other thread can get in the monitor and perhaps change the monitor’s state.
                    
                    When the condition is right, the other thread can invoke the signal() or signalAll() method to 
                    signal one or all waiting threads to regain the lock and resume execution      
                    */
                }

                balance -= amount;

                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock(); // release the lock
            }

        }// end method

        public void deposit(int amount) {

            lock.lock(); // acquire the lock

            try {
                balance += amount;

                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());

                // Signal thread waiting on the condition 
                newDeposit.signalAll();
                
                /*
                Once a thread invokes await() on a condition, the thread waits for a signal to resume.
                If you forget to call signal() or signalAll() on the condition, the thread will wait forever.
                */

            }
            finally{
                lock.unlock();
            }
        }// end method

    }//end class
    
}// end big class
