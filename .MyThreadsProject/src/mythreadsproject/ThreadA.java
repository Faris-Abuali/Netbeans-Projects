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
public class ThreadA extends Thread{
    
    Main lock;
    
    ThreadA(Main lock){
        this.lock=lock;
    }
    
    
    @Override
    public void run(){
        
        try{
            
            synchronized(lock){
                
                for(int i=0;i<5;i++){
                    
                    while(lock.flag!=1){
                        lock.wait();
                    }
                    
                    System.out.print("A "); 
                    
                    lock.flag=2;
                    lock.notifyAll();
                }
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
