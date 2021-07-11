/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresLab;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    public static void main(String[] args) {

        LinkedList<String> ls = new LinkedList<String>();

        ls.add("Fares");
        ls.add("Qutada");

        System.out.println("Size=" + ls.size());

        System.out.println(ls);

        ls.add("Linear2");

        ls.add("Circuits");
        
        ls.add(1,"Haha...!");

        System.out.println(ls);

        System.out.println(ls.contains("Circuits"));

        Iterator it = ls.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ls.remove();
        System.out.println(ls);
        ls.removeFirst();

        System.out.println(ls);
        
      

    }
}
