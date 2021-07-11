package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class ATM {

    private boolean userAuthenticated = false;//the database authenticates a user by 
    //comparing the account number and PIN entered by the user with those of an account in the database. 
    private int currentAccountNumber;

    // references to associated objects
    private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase;

    //constants corresponding to main menu objects
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATM() {
        userAuthenticated = false;
        currentAccountNumber = 0;

        //Class ATM has Composition relationships with:
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        //so class ATM is responsible for their creation. --------------------------------------
        bankDatabase = new BankDatabase();
        //[Note: If this were a real ATM system, the ATM class would receive a reference to an existing 
        //database object created by the bank. However, in this implementation we’re only simulating
        //the bank’s database, so class ATM creates the BankDatabase object with which it interacts.]

    }

    public void run() {

        while (true) {

            screen.displayMessageLine("\nPlease enter your account number (NEW user? Press 1 to create a new account):-");
            if (keypad.getInput() == 1) {
                do {
                    createNewAccount();
                    screen.displayMessageLine("\nIf you still want to create another account, press 1 again,\nElse press any other number to exit:-");
                } while (keypad.getInput() == 1);
            }

            while (!userAuthenticated) {

                screen.displayMessage("\nWelcome!");
                authenticateUser();

            }

            performTransactions();

            //reset the attributes and awaite the next ATM user
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessage("\nThank you! Goodbye!");
        }//end while

    }
    //use an infinite loop here to simulate the fact that an ATM appears to run continuously
    //until the bank turns it off

    public void authenticateUser() {

        screen.displayMessage("\nPlease enter your account number:- ");
        int accountNumber = keypad.getInput();
        screen.displayMessage("\nEnter your PIN:- ");
        int PIN = keypad.getInput();

        userAuthenticated = bankDatabase.authenticateUser(accountNumber, PIN);

        if (userAuthenticated) {
            currentAccountNumber = accountNumber;//The other ATM methods use this variable whenever an ATM session requires access to the user’s account number.
            welcomeUser(accountNumber);

        } else {
            screen.displayMessage("Invalid account number or PIN. Please Enter again:");
        }
    }

    public void welcomeUser(int currentAccountNumber) {
        File myFile = new File("myBase.txt");
        try {
            Scanner sc = new Scanner(myFile);

            while (sc.hasNext()) {
                String name = sc.next();
                if (Integer.parseInt(sc.next()) == currentAccountNumber) {
                    screen.displayMessageLine("Welcome " + name + "");
                    break;
                }
                sc.nextLine();
            }
        } catch (FileNotFoundException ex) {

        }

    }

    public void performTransactions() {

        Transaction currentTransaction = null;// the FATHER 
        //We use a Transaction variable here to allow us to take advantage of polymorphism

        boolean userExited = false; // user has not chosen to exit 

        while (!userExited) {

            int mainMenuSelection = displayMainMenu();

            // This variable(userExited) controls a while loop
            //that allows the user to execute an unlimited number of transactions before choosing to exit.
            switch (mainMenuSelection) {

                case BALANCE_INQUIRY:
                case DEPOSIT:
                case WITHDRAWAL:

                    currentTransaction = createTransaction(mainMenuSelection);
// will return a newly instantiated object of the type that corresponds to the selected transaction

                    currentTransaction.execute();
                    break;

                case EXIT:
                    screen.displayMessageLine("\nExiting The System...");
                    userExited = true;
                    break;

                default:
                    screen.displayMessageLine("You didn't enter a valid selection. Try again");
                    break;

            }//end switch

        }//end while
    } // end method performTransactions

    public int displayMainMenu() {
        screen.displayMessageLine("\nMain Menu:");
        screen.displayMessageLine("1- View my balance");
        screen.displayMessageLine("2- Withdraw cash");
        screen.displayMessageLine("3- Deposit Funds");
        screen.displayMessageLine("4- Exit\n");

        screen.displayMessage("Enter a choice: ");
        return keypad.getInput();

    }

    public Transaction createTransaction(int type) {

        Transaction temp = null;

        switch (type) {
            // Each constructor has a unique parameter list
            case BALANCE_INQUIRY:
                temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                break;

            case WITHDRAWAL:
                //temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
                break;

            case DEPOSIT:
                //temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
                break;

        }

        return temp;
    }

    private void createNewAccount() {
        int currentNumberOfClients = bankDatabase.numberOfClients;
        Scanner sc = new Scanner(System.in);
        screen.displayMessageLine("\n\n---CREATING A New ACCOUNT---");
        screen.displayMessageLine("Enter the account's userName: ");
        String userName = sc.next();
        screen.displayMessageLine("Enter your PIN (NUMBERS ONLY):");
        int PIN = sc.nextInt();
        bankDatabase.addAccount(userName, PIN);
        screen.displayMessageLine("Congrats! Your account has been created");

        screen.displayMessage("Your Account Number is : ");
        screen.displayMessageLine((BankDatabase.dataBaseCapacity - currentNumberOfClients) + "\n------------------------------------");
    }

    //--EndOFClass
}
