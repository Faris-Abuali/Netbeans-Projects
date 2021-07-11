/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericgraph;

/**
 *
 * @author Fares Abu Ali
 */
public class TestQueue {

    public static void main(String[] args) {

        PriorityQueueMin q = new PriorityQueueMin();

        q.insert(4);
        q.insert(2);
        q.insert(5);
        q.insert(2);

        q.insert(1);

        q.insert(1);

        q.insert(8);

        q.insert(3);
        q.insert(7);
        q.insert(4);

        q.insert(10);
        q.insert(6);

        System.out.println(q);

       while(!q.isEmpty()){
           System.out.println(q.remove());
       }



    }// end main
}// end class
