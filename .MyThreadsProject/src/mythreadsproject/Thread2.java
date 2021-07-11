/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythreadsproject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Fares Abu Ali
 */
public class Thread2 extends Thread {

   MainV obj;

    public Thread2(MainV obj) {
        this.obj=obj;
    }

    @Override
    public void run() {

        while (obj.ctr < 100) {
            System.out.println(obj.ctr);

            obj.ctr++;
        }
    }

}
