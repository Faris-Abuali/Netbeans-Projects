package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class ComputerSolver {

    static int[][] initialMatrixWithFixedNumbersOnly = new int[9][9];

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int timesTheProgramWentBack = 0;

    public static void copyArray(int[][] original) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                initialMatrixWithFixedNumbersOnly[i][j] = original[i][j];
            }
        }

    }

    public static boolean isUnique(int[][] grid, int row, int col, int num) {

        // This method ensures that the number(num) is unique in the same row,column,
        // and the same subgrid(box)
        // unique means that the number must appear only once in the same row,column,
        // and the same subgrid(box)
        // Now I will ensure that the cell is not repeated in the same row
        // I will let the row be fixed, and move through the columns
        for (int j = 0; j < 9; j++) {
            if (grid[row][j] == num) {
                return false;
            }
        }

        // Now I will ensure that the cell is not repeated in the same column
        // I will let the column be fixed, and move through the rows
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        // Now I will compare the cell with all the other 8 cells in the same box
        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++) {
            for (int j = col - (col % 3); j < col - (col % 3) + 3; j++) {

                if (grid[i][j] == num) {
                    return false;
                }

            }
        }

        return true;
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

//    public static void printGrid(int[][] grid) {
//
//        for (int i = 0; i < 9; i++) {
//            if (i == 0 || i == 3 || i == 6) {
//                System.out.print("-------------------------\n");
//            }
//            for (int j = 0; j < 9; j++) {
//                if (j == 0 || j == 3 || j == 6) {
//                    System.out.print("| ");
//                }
//                if (grid[i][j] == 0) {
//                    System.out.print("- ");
//                } else {
//                    System.out.print(grid[i][j] + " ");
//                }
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------------------");
//    
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

    // public static boolean recursive(int[][] grid) {}
    public static void main(String[] args) {

        int[][] grid = new int[9][9];
        try {
            inputFromFile(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("This is the initial grid:");
        printGrid(grid);
        //

        if (recursive(grid)) {
            System.out.println("Congrats! the soduku has been solved");
            printGrid(grid);

            System.out.println("the program went back " + timesTheProgramWentBack + " times!");

        } else {
            System.out.println(ANSI_CYAN + "Unfortunately, this sudoku seems to be improper,\n"
                    + "which means it has no true solution" + ANSI_RESET);
        }

        // --EndOfmain
    }

    public static boolean recursive(int[][] grid) {

        int row = -1, col = -1;
        boolean allCellsAreFull = true;

        // these 2 nested for loops will traverse through all cells in the grid to check
        // if there is an empty cell or no
        // if the program found an empty cell, he will save its coordinates(row,col) and
        // will go down and try to fill
        // this cell with the proper number.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;

                    allCellsAreFull = false;
                    break;
                }

            }

            if (allCellsAreFull == false) {
                break;
            }
        }

        if (allCellsAreFull) {
            return true; // because there are no more empty cells
        }
        //here I will try all the numbers probabilities for the empty cell which I found
        for (int num = 1; num <= 9; num++) {
// I will check every number if it is unique or not, the first unique number I find, will put it in the cell
// As you know from the sudoku rules, the number is considered unique if it has not appeared in the same row
// or the same column or the same subGrid(Box) in which the cell is located.
            if (isUnique(grid, row, col, num)) {

                grid[row][col] = num;
                System.out.println("I will put[" + num + "] in row=" + row + " and col=" + col);
                printGrid(grid);
                //every time the compiler reaches here then becomes involved in a new invokation
                if (recursive(grid)) {
                    return true; // I am sure the method will not return true unless all cells are full
                } else {
                    // when my program reaches here, I know that he tried all the numbers from1 to 9
                    // but there was no unique number to be placed
                    // in the cell. So he went back to the preceding cell in order to empty it and
                    // try to fill it with another number .
                    System.out.println("Unfortunately I have to go back to the preceding cell in  row: " + row
                            + " and col: " + col + " to empty it and try another number");
                    grid[row][col] = 0;
                    printGrid(grid);
                    timesTheProgramWentBack++;
                }

            }

        }
        return false;

        // --Finally this recursive method ends :(
    }

    // --EndOfClass
}
