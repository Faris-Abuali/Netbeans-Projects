package fullfinalproject2ndsemester2019safarini;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sudoku.CheckUserSolution;
import sudoku.ComputerSolver;

/**
 *
 * @author Fares Abu Ali
 */
public class FullFinalProject2ndSemester2019Safarini {
public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void showMenu() {
        System.out.println("Please select one of my projects :-");
        System.out.println("|-----------------------------------|");
        System.out.println("| 1-"+ANSI_PURPLE+"Rock,paper, and scissors        "+ANSI_RESET+"|");
        System.out.println("| 2- "+ANSI_GREEN+"Guess The Number               "+ANSI_RESET+"|");
        System.out.println("| 3- "+ANSI_RED+"Calender                       "+ANSI_RESET+"|");
        System.out.println("| 4- "+ANSI_CYAN+"Tic Tac Toe                    "+ANSI_RESET+"|");
        System.out.println("| 5- "+ANSI_BLUE+"Encryption and Decryption      "+ANSI_RESET+"|");
        System.out.println("| 6- "+ANSI_YELLOW+"Sudoku                         "+ANSI_RESET+"|");
        System.out.println("|-----------------------------------|");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        System.out.println("Hello, I am Fares Abu ALi, a first-year CSE student\nand this is my full and final "
//                + "project for Java Lab course"
//                + "-2nd Semester 2019.\nI am really proud to show you this project as a brief of what I have achieved\n"
//                + "through this wonderfull semester.\nThis work was done under the supervision of my great proffessor:\n"
//                + "Muhammed Safarini:\n");

        showMenu();

        System.out.println("Enter your choice here: ");
        char selection = sc.next().charAt(0);

        while (selection != 'e') {

            switch (selection) {

                case '1':
                    RockPaperScissors.main(args);
                    System.out.println("I hope you win the game:) Now return to the menu");

                    break;

                case '2':
                    GuessTheNumber.main(args);
                    System.out.println("I hope you win the game:) Now return to the menu");

                    break;

                case '3':
                    System.out.println("------------------------------------");
                    System.out.println("Welcome to my Calender program:");
                    System.out.println("------------------------------------");
                    Calendar.main(args);
                    System.out.println("Done. Nice calendar, isn't it:) Now return to the menu");
                    break;

                case '4':
                    System.out.println("------------------------------------");
                    System.out.println("Welcome to my TicTacToe gameplay:");
                    System.out.println("------------------------------------");
                    TicTacToe.main(args);
                    System.out.println("I hope you win the game:) Now return to the menu");

                    break;
                case '5':
                    System.out.println("------------------------------------------------");
                    System.out.println("Welcome to my Encryption and Decryption program:");
                    System.out.println("------------------------------------------------");
                    EncryptionAndDecryption.main(args);
                    System.out.println("wow, this was an amzing way to hide your data:) Now return to the menu ");
                    break;
                case '6':
                    try {
                        CheckUserSolution.main(args);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FullFinalProject2ndSemester2019Safarini.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("I hope you managed to solve the sudoku:) Now return to the menu ");

                    break;

                default:
                    System.out.println("Invalid number");
                    break;

                //---EndOfSwitch
            }

            System.out.println("------------------------------------------------");
            System.out.println("ok,now enter another number or enter 'e' to exit:");
            showMenu();
            System.out.println("Enter your choice here: ");
            selection = sc.next().charAt(0);
        }

        System.out.println("That's it. I hope you enjoyed my project");
        //--EndOfmain
    }
    //--EndOfClass
}
