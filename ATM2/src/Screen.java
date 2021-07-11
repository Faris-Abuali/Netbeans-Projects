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
public class Screen {
    
    
    public Screen(){}
    
    public void displayMessage(String message){
        System.out.print(message);
    }
    public void displayMessageLine(String message){
        System.out.println(message);
    }
    public void displayDollarAmount(double amount){
        System.out.printf( "$%,.2f", amount );  //1000.5 --> $1,000.50.20
        
        // the (,) is just to divide the number every 3places together which makes it easier to read
    }
    
   
            
}
