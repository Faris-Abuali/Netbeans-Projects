/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Fares Abu Ali
 */
public class BalanceInquiry extends Transaction{
    //BalanceInquiry does not have any attributes of its own
    //private int accountNumber, private Screen screen, private BankDatabase bankDatabase;
    // getAccountNumber()+getBankDatabase()+getScreen()
    
   public BalanceInquiry(){}

    public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        super(accountNumber, screen, bankDatabase);
    }
   
   @Override
    public void execute(){
        
       BankDatabase bankDatabase= getBankDatabase();//this method returns an object of class BankDatabase
       Screen screen=getScreen();
       
       //get references to the bank database and the ATM’s screen by invoking methods 
       //inherited from superclass Transaction.
       double availableBalance=bankDatabase.getAvailableBalance(getAccountNumber());
       double totalBalance=bankDatabase.getTotalBalance(getAccountNumber());
       
    
       
        screen.displayMessageLine( "\nBalance Information:" );
        screen.displayMessage( " - Available balance: " ); 
        screen.displayDollarAmount( availableBalance ); 
        screen.displayMessage( "\n - Total balance: " );
        screen.displayDollarAmount( totalBalance ); 
        screen.displayMessageLine( "" ); 
    }
    
}
