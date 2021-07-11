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
public class CashDispenser {
    //the cash dispenser begins each day loaded with 500 $20 bills.
    private final static int INITIAL_COUNT=500; //the default initial number of bills in the cash dispenser 
    private int count;// number of $20 bills remaining 
    
    
    //The cash dispenser must keep track of the number of bills it 
    //contains to determine whether enough cash is on hand to satisfy withdrawal requests. 
    
    public CashDispenser(){
        count=INITIAL_COUNT;
    }
    
    public void dispenseCash(int amount){
        int billsRequired=amount/20;
        count-=billsRequired;
    }
    
    public boolean isSufficientCashAvailable(int amount){
        int billsRequired=amount/20;
        
        if(count>=billsRequired)
            return true;
        return false;
    }
    
    

}
