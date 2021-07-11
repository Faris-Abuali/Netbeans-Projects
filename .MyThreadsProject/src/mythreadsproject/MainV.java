/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythreadsproject;

/**
 *
 * @author Fares Abu Ali
 */
public class MainV {

    public volatile int ctr = 0;

    public static void main(String[] args) {

        
        MainV obj = new MainV();
        
        Thread2 t2 = new Thread2(obj);
        Thread1 t1 = new Thread1(obj);
        
        t1.start();
        t2.start();
        
        

    }

}
