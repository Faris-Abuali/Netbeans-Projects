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
public class TestAcc {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0l);

        System.out.println("begin balance: " + account.getBalance());

        Thread withdrawThread = new WithdrawThread();
        Thread depositThread = new DepositThread();

        
        // to gurantee that the 2 threads end completely
        withdrawThread.join();
        depositThread.join();

        System.out.println("end balance: " + account.getBalance());

    }
    
    
    
    public static class WithdrawThread extends Thread{
        
        @Override
        public void run(){
            
        }
        
    }
    
      public static class DepositThread extends Thread{
        
        
    }

}
