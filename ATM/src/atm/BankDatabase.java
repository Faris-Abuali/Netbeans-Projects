/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author Fares Abu Ali
 */
// Recall that class BankDatabase serves as an intermediary between class ATM and the actual Account objects 
//that contain a user’s account information. Thus, the methods of class BankDatabase
//do nothing more than invoke the corresponding methods of the Account object belonging to the current ATM user.
public class BankDatabase {

    static final int dataBaseCapacity = 10000;
    int numberOfClients = 0;
    File clientsFile[];
    
    
    String allFileContents = "";
    String allClientsData[] = new String[dataBaseCapacity];
    //$$$$because a bank account contains sensitive information, we do not allow the ATM to access accounts directly. 
    //$$$$The database acts as an intermediary between the ATM and the account data, thus preventing unauthorized access.

    private static Account[] accounts;// each object in this array has: accountNumber+PIN+availableBalance+totalBalance

    //private LinkedList<Account> accounts;
    public BankDatabase() {
        accounts = new Account[dataBaseCapacity];
        clientsFile = new File[dataBaseCapacity];
        // just 2 accounts for testing
        //accounts[0] = new Account(0002, 0000, 100, 100);
        //accounts[1] = new Account(0001, 1111, 200, 200);
    }

    public void addAccount(String userName, int PIN) {

        int newAccountNum = dataBaseCapacity - numberOfClients;
        //String fileName =  newAccountNum+ ".txt";

//        try (PrintWriter output = new PrintWriter(fileName);) {
//            output.println(userName);
//            output.println(dataBaseCapacity - numberOfClients);
//            output.println(0);
//            output.println(0);
//        } catch (FileNotFoundException e) {
//
//        }
        Account newAccount = new Account(dataBaseCapacity - numberOfClients, PIN, 0, 0);
        accounts[numberOfClients] = newAccount;
        //clientsFile[numberOfClients]=new File(fileName);

        String newUserLine = userName + " " + newAccountNum + " " +PIN+" "+ "0\n";
        allFileContents += newUserLine;
        allClientsData[numberOfClients] = newUserLine;

        numberOfClients++;
        //System.out.println(allFileContents);

      rewriteTheAllClientsFile();

    }


    public void rewriteTheAllClientsFile() {
        try (PrintWriter output = new PrintWriter("myBase.txt");) {

            for (int i = 0; i < numberOfClients; i++) {
                output.println(allClientsData[i]);
            }

        } catch (FileNotFoundException e) {

        }
    }

    public Account getAccount(int accountNumber) {

        for (Account currentAccount : accounts) {
            if (currentAccount != null) {
                if (currentAccount.getAccountNumber() == accountNumber) {
                    return currentAccount;
                }
            }
        }

        return null;// if no matching account was found, return null 
    }

    // class ATM invokes the operations of class BankDatabase, each of which in turn invokes the operation with the same name in class Account.
    public boolean authenticateUser(int UserAccountNumber, int UserPIN) {

        Account userAccount = getAccount(UserAccountNumber);

        if (userAccount == null) {
            System.out.println("No account matching this number found in the bank's database");
            return false;
        } else {

            return (userAccount.validatePIN(UserPIN));
        }
    }

    double getAvailableBalance(int UserAccountNumber) {
        return getAccount(UserAccountNumber).getAvailableBalance();
    }

    double getTotalBalance(int UserAccountNumber) {
        return getAccount(UserAccountNumber).getTotalBalance();
    }

    public void credit(int UserAccountNumber, double amount) {//“credits a deposit amount to an account
        getAccount(UserAccountNumber).credit(amount);
    }

    public void debit(int UserAccountNumber, double amount) {//{“debits a withdrawal amount from an account.” 
        getAccount(UserAccountNumber).debit(amount);

    }

//    public static void main(String[] args) {
//
//        System.out.println(BankDatabase.numberOfClients);
//        System.out.println(BankDatabase.dataBaseCapacity);
//    }
}
