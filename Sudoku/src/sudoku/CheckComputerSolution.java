package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class CheckComputerSolution {

    static int[] a = new int[0];

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
    }

    public static void printGrid(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("-------------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 0 || j == 3 || j == 6) {
                    System.out.print("| ");
                }
                if (grid[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        long finishTime;

        int[][] grid = new int[9][9];

        try {
            inputFromFile(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("This is the initial grid:");
        printGrid(grid);

        while (thereAreEmptyCells(grid)) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (grid[i][j] == 0) {
                        a = Methods.clear(a);

                        countOfNumbersInTheSameBox(grid, i, j);
                        countOfNumbersInTheSameRow(grid, i);
                        countOfNumbersInTheSameColumn(grid, j);

                        if (9 - a.length == 1) {
                            grid[i][j] = 45 - Methods.sumOfArrayElements(a);
                            System.out.println("I will put [" + (45 - Methods.sumOfArrayElements(a)) + "] in row " + i + " and col " + j);
                        }
                        if (9 - a.length == 0) { // I am not sure of this part
                            System.out.println("This is an improper sudoku. It is unsolvable.");
                        }

                    }

                    //-EndOfTheInternalForLoop
                }
                //-EndOfTheExternalForLoop   
            }

            printGrid(grid);

            if (thereAreEmptyCells(grid)) {
                System.out.println("Now I had gone through all cells in the matrix and this is the current shape.\n"
                        + " If there still empty cells,I will start again from the beginning of the matrix ");

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                finishTime = System.currentTimeMillis();
                System.out.println("Done.The computer solved this sodoku within "
                        + (finishTime - startTime) + " milliseconds.");
            }

        }

        //--EndOfmain    
    }
    //Everything above is ok
    //Now I will statrt solving the initial sudoku

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

    public static void countOfNumbersInTheSameBox(int[][] grid, int i, int j) {

        for (int row = i - (i % 3); row < i - (i % 3) + 3; row++) {
            for (int column = j - (j % 3); column < j - (j % 3) + 3; column++) {
                if (grid[row][column] > 0) {
                    a = Methods.addIfUnique(a, grid[row][column]);
                }
            }
        }
    }

    public static void countOfNumbersInTheSameRow(int[][] grid, int row) {

        for (int j = 0; j < 9; j++) {
            if (grid[row][j] > 0) {
                a = Methods.addIfUnique(a, grid[row][j]);
            }
        }
    }

    public static void countOfNumbersInTheSameColumn(int[][] grid, int column) {

        for (int i = 0; i < 9; i++) {
            if (grid[i][column] > 0) {
                a = Methods.addIfUnique(a, grid[i][column]);
            }
        }
    }

    //EndOfClass
}
