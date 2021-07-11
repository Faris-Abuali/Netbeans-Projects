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
public class JoinConcept {
    
   static int ctr=0;
    
    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                for(int i=0;i<7000;i++){      
                    System.out.println(ctr);
                    ctr++;
                }
            }
        });
        
        
        
        t1.start();
        
      // t1.join();
        
        System.out.println("ctr = "+ctr);
        
    }
    
}
