package multithreadingjanuary2020;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class MainClass {

    public int flag = 1;

    public static void main(String[] args) {

        MainClass lock = new MainClass();

        Task1 t1 = new Task1(lock); // object of Task1 which implements Runnable
        Task2 t2 = new Task2(lock);// object of Task2 which implements Runnable

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        

        thread1.start();

        thread2.start();


//        try {
//            thread1.join();
//            thread2.join();
//
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }// end method

}
