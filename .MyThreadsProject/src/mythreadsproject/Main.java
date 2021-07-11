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
public class Main {
    
    public int flag= 1;
    
    
    public static void main(String[] args) throws InterruptedException {
        
        Main lock = new Main();
        
        ThreadA a = new ThreadA(lock);
        ThreadB b = new ThreadB(lock);
        
        
        a.start();
        b.start();
        
        a.join();
        b.join();
//        
        
    }
    
    
}
