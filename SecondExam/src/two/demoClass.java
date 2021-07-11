/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

/**
 *
 * @author Fares Abu Ali
 */
class demoClass {

    int a = 1;

    void func() {
        demo obj = new demo();
        obj.display();
      
       
    }

    class demo {

        int b = 2;

        void display() {
            System.out.println("\na = " + a);
        }
    }
        void get() {
            demo f =new demo();
            System.out.println("\nb = " + f.b);
        }
    

    
}
