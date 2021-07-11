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
public class First {
    
    
    public static void main(String[] args) {
        
    
    AtomicInteger a =new AtomicInteger(10);
    
    int b = a.incrementAndGet();
    
        System.out.println(b);
    
    }
            
    
}
