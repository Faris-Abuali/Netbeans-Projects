package multithreadingjanuary2020;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fares Abu Ali
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        MainClass lock = new MainClass();

        Task1 t1 = new Task1(lock); // object of Task1 which implements Runnable
        Task2 t2 = new Task2(lock);// object of Task2 which implements Runnable

        ExecutorService executor = Executors.newFixedThreadPool(3);
        //creates a thread pool executor with a total of three threads maximum

        executor.execute(new Task1());// makes an object of Task1 Runnable Class adds it to the pool. 
        executor.execute(t2);
//The executor creates two threads to execute two tasks concurrently. 

        executor.shutdown();

        /*
        Suppose that you replace line 19 with
        ExecutorService executor = Executors.newFixedThreadPool(1);
    What will happen? The three runnable tasks will be executed sequentially because there is only one thread in the pool.
       
         */
        
        
//        The shutdown() method in line 
//       tells the executor to shut down. No new tasks can be accepted, but any existing tasks will continue to finish.


    }// end main
}// end class
