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
public class Fest {
    int a=10;
    static int b=20;
    
    public static void main(String[] args) {
        Fest t1=new Fest();
        t1.a=100;
        t1.b=200;
        
        Fest t2=new Fest();
        
        System.out.println("t1.a="+t1.a+"  t1.b="+t1.b);
                System.out.println("t2.a="+t2.a+"  t2.b="+t2.b);

    }
}
