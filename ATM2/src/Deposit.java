/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Fares Abu Ali
 */
public class Deposit extends Transaction {
    //private int accountNumber, private Screen screen, private BankDatabase bankDatabase;

    File myFile = new File("myBase.txt");

    private double amount;

    private Keypad keypad;// ATM's keypad
    private DepositSlot depositSlot;

    private final static int CANCELLED = 0;

    public Deposit() {
    }

    public Deposit(int currentAccountNumber,BankDatabase bankDatabase) {

        super(currentAccountNumber, null, bankDatabase);
       // this.depositSlot = depositSlot;
        //this.keypad = keypad;
    }

    @Override
    public void execute() {

        BankDatabase bankDatabase = getBankDatabase();
        //Screen screen = getScreen();

        amount = promptForDepositAmount();

        if (amount != CANCELLED) {

           // screen.displayMessageLine("Please insert a deposit envelope containing ");
            //screen.displayDollarAmount(amount);
            //screen.displayMessageLine(" .");

            boolean envelopeReceived = depositSlot.isEnveleopeReceived();

            if (envelopeReceived) {
                //screen.displayMessageLine("Your envelope has been received.\n");
                //screen.displayMessageLine(NOTE: The money just deposited will not be available until we verify the amount of any 
                //enclosed cash and your checks clear.");             
                bankDatabase.credit(getAccountNumber(), amount);

                //----NOW THE BALANCE HAS BEEN UPDATED,SO WE MUST UPDATE THE FILE"S DATA ALSO------
                
                updateUsersDataInTheClientsFile();
                //File currentUserFile = bankDatabase.clientsFile[bankDatabase.numberOfClients - 1];
                //--NOW I WILL REWRITE OVER THE OLD DATA----
                bankDatabase.rewriteTheAllClientsFile();

            } else {
                //screen.displayMessageLine("You didn't insert an envelope! The ATM has cancelled your deposit process");
            }
        } else {
            //screen.displayMessageLine("\nCancelling Deposit Process");
        }
    }

    private double promptForDepositAmount() {

        Screen screen = getScreen();

        screen.displayMessageLine("Please Enter deposit amount in CENTS, (or enter 0 to cancel): ");
        // why ask the user to input in cents?? because the keypad doesn't have the (.) key
        int input = keypad.getInput();

        if (input == 0) {
            return CANCELLED;
        } else {
            return input / 100.0;
        }

    }



}
