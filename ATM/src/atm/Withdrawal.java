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
public class Withdrawal extends Transaction {

    File myFile = new File("myBase.txt");
    //inherits accountNumber + bankdatabase + screen from class Transaction
    private int amount;// amount to withdraw: why int not double? because you only have limited choices to withdraw from
    // the choices are: 20$,40$,60$,100$,200$

    //references to associated objects
    private Keypad keypad;// ATM's keypad
    private CashDispenser cashDispenser;// ATM's cashDispenser

    //constant corresponding to main menu to cancel
    private final int CANCELED = 6;

    public Withdrawal() {

    }

    public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser) {
        super(accountNumber, screen, bankDatabase);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        boolean cashDispensed = false; // cash was not dispensed yet
        double availableBalance;

        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        // remember that the attributes(bankDatabase and screen) in super class Transaction were private
        //so the subclass Withdrawal could't access them unless we use the getters

        do {
            amount = displayMenuOfAmounts();

            if (amount != CANCELED) {

                availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

                if (amount <= availableBalance) {

                    if (cashDispenser.isSufficientCashAvailable(amount)) {
                        bankDatabase.debit(getAccountNumber(), amount);
                        cashDispenser.dispenseCash(amount);
                        cashDispensed = true;
                        screen.displayMessageLine("Your cash has been dispensed. Please don't forget to take your cash");

                        //----NOW THE BALANCE HAS BEEN UPDATED,SO WE MUST UPDATE THE FILE"S DATA ALSO------
                        updateUsersDataInTheClientsFile();

                        //--NOW I WILL REWRITE OVER THE OLD DATA----
                        bankDatabase.rewriteTheAllClientsFile();

                    } else {
                        screen.displayMessageLine("Sorry! Insufficient cash available in the ATM rigth now");
                        screen.displayMessageLine("Try to withdraw a smaller amount");
                    }

                } else {
                    screen.displayMessageLine("Insufficient funds in your account! Try to withdraw a smaller amount ");
                }

            } else {
                screen.displayMessageLine("\nCancelling Withdrawal...");
                return;
            }

        } while (!cashDispensed);

    } // end method execute 

    private int displayMenuOfAmounts() {

        int userChoice = 0;
        Screen screen = new Screen();

        int[] amounts = {0, 20, 40, 60, 100, 200};

        while (userChoice == 0) {
            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1- $20");
            screen.displayMessageLine("2- $40");
            screen.displayMessageLine("3- $60");
            screen.displayMessageLine("4- $100");
            screen.displayMessageLine("5- $200");
            screen.displayMessageLine("6- Cancel Withdrawal");
            screen.displayMessageLine("Choose amount of withdrawal:");

            int input = keypad.getInput();

            switch (input) {

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:

                    userChoice = amounts[input];
                    break;

                case CANCELED:
                    userChoice = CANCELED;
                    break;

                default:
                    screen.displayMessageLine("Invalid Selection. Try again");
                //don't change the value of userChoice. It will still 0

            }//end switch

        }//end while

        return userChoice;
    }

}
