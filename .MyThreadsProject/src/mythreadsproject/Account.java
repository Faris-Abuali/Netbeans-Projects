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
public class Account {

    private long balance;

    public Account() {
        this(0L);
    }

    public Account(Long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {

        checkAmountNonNegative(amount);

        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(long amount) {

        checkAmountNonNegative(amount);

        synchronized (this) {
            if (balance < amount) {

            }

            balance -= amount;
        }
    }

    private void checkAmountNonNegative(long amount) {
        if(amount<0){
            
        }
            
    }
    
    public synchronized void waitAndWithdraw(long amount)throws InterruptedException{
        checkAmountNonNegative(amount);
        while(balance<amount){
            wait();
            System.out.println(balance);
        }
        
        balance-=amount;
    }

    
}
