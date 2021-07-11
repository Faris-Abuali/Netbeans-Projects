
package atm;

/**
 *
 * @author Fares Abu Ali
 */
public class Account {
    
   
    //$$$$because a bank account contains sensitive information, we do not allow the ATM to access accounts directly. 
    //$$$$The database acts as an intermediary between the ATM and the account data, thus preventing unauthorized access.

    // class ATM invokes the operations of class BankDatabase, each of which in turn invokes the operation with the same name in class Account.
    private int accountNumber;
    private int PIN;// Personal Identification Number

    private double availableBalance; // tracks the amount of money that a user can withdraw from the account.
    private double totalBalance; //availableBalance +  the amount waiting to be verified or cleared

    public Account() {
    }

    
    public Account(int accountNumber, int PIN, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.PIN = PIN;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }
    
      
    

    public boolean validatePIN(int userPIN) {// class Account must provide a service to validate
        //a PIN obtained through user input against a PIN stored in an 
        return userPIN == PIN;                                     //Account object
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }

    public void credit(double amount) {//“credits a deposit amount to an account
        totalBalance += amount;
        availableBalance+=amount;
        
        //The money credited to an account during a deposit does not become a vailable immediately
        //,so we modify only the totalBalance
        //.We assume that the bank updates the available balance appropriately at a later time. 
    }

// crediting an account (as in a deposit) adds an amount only to the totalBalance attribute.
//Debiting an account(as in a withdrawal),on the other hand,subtracts the amount from both balance attributes.
    public void debit(double amount) {//“debits a withdrawal amount from an account.” 
        availableBalance -= amount;
        totalBalance -= amount;
        
       //availableBalance represents the amount of funds available for withdrawal. 
      //totalBalance represen the amount of funds available,plus the amount of deposited funds
      //still pending confirmation or clearance
    }
    
    

}
