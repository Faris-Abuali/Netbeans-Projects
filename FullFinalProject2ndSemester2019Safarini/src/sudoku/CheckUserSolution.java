package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CheckUserSolution {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int[][] initialMatrixWithFixedNumbersOnly = new int[9][9];
    static String[] repeatedIn = new String[1];

    public static void copyArray(int[][] original) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                initialMatrixWithFixedNumbersOnly[i][j] = original[i][j];
            }
        }

    }

    public static boolean thereAreEmptyCells(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValidValue(int x) {
        if (x < 1 || x > 9) {
            return false;
        }
        return true;
    }

    public static boolean isValidIndex(int r, int c) {
        if (r < 0 || r > 8 || c < 0 || c > 8) {
            return false;
        }
        return true;
    }

    public static boolean isFixedPlace(int[][] initialMatrixWithFixedNumbersOnly, int r, int c) {
        if (initialMatrixWithFixedNumbersOnly[r][c] != 0) {
            return true;
        }
        return false;
    }

// 
    public static boolean isRepeated(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (isRepeated(grid, i, j, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRepeated(int[][] grid, int row, int col, int num) {

        //Now I will ensure that the cell is not repeated in the same row
        //I will let the row be fixed, and move through the columns
        for (int j = 0; j < 9; j++) {
            if (grid[row][j] == num) {
                repeatedIn[0] = "row";
                return true;
            }
        }

        //Now I will ensure that the cell is not repeated in the same column
        //I will let the column be fixed, and move through the rows
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                repeatedIn[0] = "column";
                return true;
            }
        }

        //Now I will compare the cell with all the other 8 cells in the same box
        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++) {
            for (int j = col - (col % 3); j < col - (col % 3) + 3; j++) {
                if (grid[i][j] == num) {
                    repeatedIn[0] = "box";
                    return true;
                }
            }
        }

        return false;
    }

    private static void inputFromFile(int[][] grid) throws FileNotFoundException {

        File f = new File("initial.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = sc.nextInt();

                }
            }

        }

        copyArray(grid);

    }

    public static void printGrid(int[][] grid) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  | a b c | d e f | g h i |");
        for (int i = 0; i < 9; i++) {

            if (i == 0 || i == 3 || i == 6) {
                System.out.print("---------------------------\n");
            }
            System.out.print((char) (i + 'a') + " ");
            for (int j = 0; j < 9; j++) {
                if (j == 0 || j == 3 || j == 6) {
                    System.out.print("| ");
                }
                if (grid[i][j] == 0) {
                    System.out.print("- ");
                } else if (initialMatrixWithFixedNumbersOnly[i][j] == 0) {
                    System.out.print(ANSI_GREEN + grid[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_RED + grid[i][j] + " " + ANSI_RESET);
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to my Sudoku game:\n\n");
        System.out.println("-----------------------------------");
        long startTime = System.currentTimeMillis() / 1000;
        long finishTime;
        long timeTakenInMinutes;

        int[][] grid = new int[9][9];
        Scanner sc = new Scanner(System.in);
        char row, col;
        int enteredValue;
        char enteredChar;

        inputFromFile(grid);

        //initialMatrixWithFixedNumbersOnly=grid;
        System.out.println("This is the initial sudoku:");
        printGrid(initialMatrixWithFixedNumbersOnly);
        System.out.println("Notice that that " + ANSI_RED + "the fixed initial numbers will be colored in red,\n"
                + ANSI_RESET + ANSI_GREEN + "while the numbers entered by the user will be colored in green:"
                + ANSI_RESET);

        while (true) {
            //the check mode
            while (true) {
                //the solving mode
                System.out.println("Enter the row and then the column respectively:(from [a] to [i])");
                row = sc.next().charAt(0);
                row = Character.toLowerCase(row);
//                if(row<'a'||row>'i')
//                    System.out.println("invalid row index. Please enter from 'a' to 'i' only:");
                col = sc.next().charAt(0);
                col = Character.toLowerCase(col);
//                if(col<'a'||col>'i')
//                    System.out.println("invalid column index. Please enter from 'a' to 'i' only:");

                row -= 'a';
                col -= 'a';
                while (!isValidIndex(row, col) || isFixedPlace(initialMatrixWithFixedNumbersOnly, row, col)) {

                    if (!isValidIndex(row, col)) {
                        System.out.println("invalid index. Please enter indices from 'a' to 'i' only:");
                    } else if (isFixedPlace(initialMatrixWithFixedNumbersOnly, row, col)) {
                        System.out.println("this place contains a fixed number which cannot be overwritten."
                                + "Please choose another place:");
                    }
                    row = sc.next().charAt(0);
                    col = sc.next().charAt(0);
                    row -= 'a';
                    col -= 'a';

                }

                System.out.println("Now enter the number you want to store  in this place: (from 1 to 9)");
                enteredChar = sc.next().charAt(0);
                enteredValue = enteredChar - '0';
                while (!isValidValue(enteredValue) || isRepeated(grid, row, col, enteredValue)) {
                    if (!isValidValue(enteredValue)) {
                        System.out.println("invalid number. Please enter a number from 1 to 9 only:");
                    } else if (isRepeated(grid, row, col, enteredValue)) {
                        System.out.println("this number is repeated in the same " + repeatedIn[0] + ". Please"
                                + " enter another number.");
                    }
                    enteredChar = sc.next().charAt(0);
                    enteredValue = enteredChar - '0';
                }

                grid[row][col] = enteredValue;

                printGrid(grid);
                System.out.println("ok! this is the current shape:");
                System.out.println();

                if (!thereAreEmptyCells(grid)) {
                    System.out.println("The grid is full now. Print 'e' if you want to exit and go to to check your solution\n"
                            + ", or print any other key to continue:");

                    char ch = sc.next().charAt(0);
                    if (ch == 'e' || ch == 'E') {
                        break;
                    }

                }

            }

            //Now I am in the check mode
            if (!isRepeated(grid)) {
                finishTime = System.currentTimeMillis() / 1000;
                timeTakenInMinutes = (finishTime - startTime) / 60;
                long remainingSeconds = (finishTime - startTime) % 60;
                System.out.println("Congratulations! Done.You filled the grid with the true solution.\n"
                        + "You solved this sudoku in " + timeTakenInMinutes + " minutes," + remainingSeconds + " seconds!");
                System.out.println("This is your solution: ");
                printGrid(grid);
                break;
            } else {
                System.out.println("Sorry. There are some repeated cells in the same row,column, or box."
                        + "Press 'a' to return to your sodoku or 'e to give up!");

                char chc = sc.next().charAt(0);
                if (chc == 'e' || chc == 'E') {
                    break;
                }

            }
        }

        //--EndOfmain
    }
    //--EndOfClass
}
