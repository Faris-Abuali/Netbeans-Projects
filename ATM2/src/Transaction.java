/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public abstract class Transaction {
    
    File myFile=new File("myBase.txt");

    private int accountNumber;

    //references to associated objects
    private BankDatabase bankDatabase;
    private Screen screen;
    
    public Transaction(){
        
    }

    public Transaction(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        this.accountNumber = accountNumber;
        this.bankDatabase = bankDatabase;
        this.screen = screen;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Screen getScreen() {
        return screen;
    }

    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    public abstract void execute();
    
    
        public void updateUsersDataInTheClientsFile() {
        BankDatabase bankDatabase = getBankDatabase();
        

        try ( //try-with-resources
                // read the old data and store the useName and the accountNumber only
                Scanner sc = new Scanner(myFile);) {

            String str = "";

            while (sc.hasNext()) {

                String line = "";

                String name = sc.next();
                String accountNum = sc.next();
                String PIN = sc.next();

                if (Integer.parseInt(accountNum) == getAccountNumber()) {
                    //String updatedAvailableBalance = bankDatabase.getAvailableBalance(getAccountNumber())+"";
                    String updatedTotalBalance = bankDatabase.getTotalBalance(getAccountNumber()) + "";
                    line = name + " " + accountNum + " " + PIN + " " + updatedTotalBalance;
                    bankDatabase.allClientsData[10000 - getAccountNumber()] = line;
                } else {
                    line = name + " " + accountNum + " " + PIN + " " + sc.next();
                }

                sc.nextLine();
            }
        } catch (FileNotFoundException ex) {

        }
    }
}
