/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListWithThreeThreads;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fares Abu Ali
 */
public class Fares {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add((int) (Math.random() * 20));
        }

        System.out.println("List Contents: " + list);
        System.out.println("Thread 1 : Prints  odd numbers if they are not multiples of five");
        System.out.println("Thread 2 : Prints  even numbers if they are not multiples of five");
        System.out.println("Thread 3 : Prints numbers multiples of five");
        System.out.println("-------------------------------------------------------------------------------------\n");
    
        
        //==================================================================================
        Main obj = new Main(list, 1);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new ThreadEven(obj));
        executor.execute(new ThreadOdd(obj));
        executor.execute(new ThreadFiveMultiples(obj));

    }// end main
}
