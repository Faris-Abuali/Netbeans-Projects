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
public class Fares {

    static LinkedList list;
    public static int i = 0;

    public Fares(LinkedList<Integer> list) {
        this.list = list;
        i = 0;
    }

    public static void incrementI() {
        i++;
    }

    public static int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(5);
        l.add(3);
        l.add(15);

        Fares f = new Fares(l);


        ThreadOne a = new ThreadOne(list, 0);
        ThreadSecond b = new ThreadSecond(list, 0);
        ThreadThree c = new ThreadThree(list, 0);

//        ThreadThree c = new ThreadThree(list, 0);
//
        a.start();
        b.start();
        c.start();
//
        a.join();
        b.join();
        c.join();

//      
    }

}
