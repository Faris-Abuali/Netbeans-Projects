package sudokujanuary2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Fares Abu Ali
 */
public class SudokuRemastered {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static final int N = 9;  // N is a complete square: 4,9,16,25,...etc
    static final int EMPTY = 0;

    static int[][] grid = new int[N][N];
    static boolean[][] fixedCells = new boolean[N][N];// this is not necessary, just needed this because whenever I
    // print the grid, I want the fixed numbers to be marked with red color  (AESTHETIC PURPOSES ONLY)

    public static void fillGrid() {

        try {
            File f = new File("initialGrid.txt");
            Scanner sc = new Scanner(f);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        markFixedCells();

        System.out.println("======= THIS IS HOW THE INITIAL GRID LOOKS LIKE ========");
        printGrid();
        System.out.println("========================================================");

    }// end method

    public static void markFixedCells() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    fixedCells[i][j] = true;
                }
            }
        }
    }// end method

    public static void printGrid() {

        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        for (int i = 0; i < N; i++) {

            System.out.print(i + " |");
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == EMPTY) {
                    System.out.print("   " + ANSI_BLACK + "|");
                } else {

                    if (fixedCells[i][j] == true) {
                        System.out.print(ANSI_RED + " " + grid[i][j] + " " + ANSI_BLACK + "|");
                    } else {
                        System.out.print(ANSI_CYAN + " " + grid[i][j] + " " + ANSI_BLACK + "|");
                    }
                }

            }
            System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        }// end for outer

        System.out.println("\n");

    }// end method

    public static void solve() {

        if (solveRec()) {
            System.out.println(ANSI_CYAN + "Congrats! The Sudoku Has Been Solved Successfully! " + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "This Sudoku seems to be IMPROPER!!! No Solution Was Found :( " + ANSI_RESET);
        }

    }// end method

    public static boolean solveRec() {

//        if (gridIsFull()) {// then we have completed the sudoku
//            return true;
//        }
        for (int row = 0; row < N; row++) {

            for (int col = 0; col < N; col++) {

                if (grid[row][col] == EMPTY) {

                    Set<Integer> set = getProhibitedNumbers(row, col);

                    for (int num = 1; num <= N; num++) {

                        if (!set.contains(num)) {// if this num is unique (did not appear in the same row,col or box), then try it 

                            grid[row][col] = num;
                            System.out.println("put [" + num + "] in the cell of row: " + row + ", col: " + col);
                            printGrid();

                            //===================================
                            boolean flag = solveRec(); // invoke the function for the next cell
                            //===================================

                            if (flag == false) { // then we have to change the number in this cell (grid[row][col])
                                grid[row][col] = EMPTY;// erase the current number 
                                System.out.println("erase [" + num + "] from the cell of row: " + row + ", col: " + col);
                                printGrid();
                            } else {
                                return true;
                            }

                        }// end if 

                    }// end for num

                    /*
                    if the method reaches here, this means that we have tried all possible numbers from 1 to 9 and
                    no number is vailid to be filled in this cell, so we have to "backtrack" (return to the preceding cell
                    and try to fill it with another number)
                     */
                    return false;

                }

            }// end for cols
        }// end for rows

        return true;// if the program reaches here, this means that that all cells have been filled. CONGRATS!

    }// end method

    public static Set<Integer> getProhibitedNumbers(int row, int col) {

        // this method returns a set of the numbers that are in the same row,col and nonet(box) with grid[row][col]
        Set<Integer> set = new HashSet<>();

        //----------------------- SEARCH THE BOX in which grid[row][col] is located ---------------------
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < (r + 3); i++) {
            for (int j = c; j < (c + 3); j++) {

                if (grid[i][j] != EMPTY) {
                    set.add(grid[i][j]);
                }
            }
        }

        //----------------------- NOW SEARCH THE ROW in which grid[row][col] is located ------------------------
        for (int j = 0; j < N; j++) {

            if (grid[row][j] != EMPTY) {
                set.add(grid[row][j]);
            }
        }
        //----------------------- NOW SEARCH THE COLUMN in which grid[row][col] is located ---------------------

        for (int j = 0; j < N; j++) {

            if (grid[j][col] != EMPTY) {
                set.add(grid[j][col]);
            }
        }

        return set;

    }// end method

    public static boolean gridIsFull() {

        boolean isFull = true;

        for (int row = 0; row < N; row++) {

            for (int col = 0; col < N; col++) {

                if (grid[row][col] == EMPTY) {
                    isFull = false;
                    break;
                }
            }

        }

        return isFull;

    }// end method

    public static boolean checkRow(int r) {

        int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
        // if there's a number who has appeared more than once, then there's a problem

        for (int c = 0; c < N; c++) {

            if (grid[r][c] != EMPTY) {
                occurences[grid[r][c] - 1]++; // store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                if (occurences[grid[r][c] - 1] > 1) {
                    //JOptionPane.showMessageDialog(null, "You have made some mistakes in row " + r + ";  [" + (grid[r][c]) + "] appeard more than once");
                    System.out.println("You have made some mistakes in row " + r + ";  [" + (grid[r][c]) + "] appeard more than once");
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkColumn(int c) {

        int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
        // if there's a number who has appeared more than once, then there's a problem

        for (int r = 0; r < N; r++) {

            if (grid[r][c] != EMPTY) {
                occurences[grid[r][c] - 1]++; // store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                if (occurences[grid[r][c] - 1] > 1) {
                    //JOptionPane.showMessageDialog(null, "You have made some mistakes in column " + c + ";  [" + (grid[r][c]) + "] appeard more than once");
                    System.out.println("You have made some mistakes in column " + c + ";  [" + (grid[r][c]) + "] appeard more than once");
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkBoxes() {

        int c = 0;
        int r = 0;

        while (r < N) {

            c = 0;

            while (c < N) {

                //--- START NEW BOX ---
                int[] occurences = new int[N];// store how many times each number from 1 to 9 has appeared int this row
                // if there's a number who has appeared more than once, then there's a problem
                for (int i = r; i < (r + 3); i++) {

                    for (int j = c; j < (c + 3); j++) {

                        if (grid[i][j] != EMPTY) {

                            occurences[grid[i][j] - 1]++;// store 1's in ar[0], 2's in ar[1], ..... 9's in ar[8] 

                            if (occurences[grid[i][j] - 1] > 1) {
                                // JOptionPane.showMessageDialog(null, "You have made some mistakes in Box of row " + i + " and column " + j + "  [" + (grid[i][j]) + "] appeard more than once");
                                System.out.println("You have made some mistakes in Box of row " + i + " and column " + j + "  [" + (grid[i][j]) + "] appeard more than once");
                                return false;
                            }

                        }
                    }
                }

                c += 3;
            }

            r += 3;
        }

        return true;

    }// end method

    public static boolean howAmIDoing() {

        boolean flag = true;

        for (int r = 0; r < N; r++) {
            flag = checkRow(r);

            if (flag == false) {
                break;
            }
        }

        for (int c = 0; c < N; c++) {
            flag = checkColumn(c);

            if (flag == false) {
                break;
            }
        }

        flag = checkBoxes();

        return flag;

    }// end method

    public static void generateRandomPuzzle() {

        int totalFixedNums = 0;

        grid = new int[N][N]; // reset
        fixedCells=new boolean[N][N]; //reset
        
        int c = 0;
        int r = 0;

        while (r < N) {

            c = 0;

            while (c < N) {

                //--- START NEW BOX ---
                int numOfFixedNumbers = (int) (Math.random() * 4 + 2);  //  2 3 4 5
                totalFixedNums += numOfFixedNumbers;

                while (numOfFixedNumbers > 0) {

                    int R = (int) (Math.random() * 3 + r);
                    int C = (int) (Math.random() * 3 + c);

                    while (grid[R][C] != EMPTY) {
                        R = (int) (Math.random() * 3 + r);
                        C = (int) (Math.random() * 3 + c);
                    }

                    Set<Integer> setProhibitedNumbers = getProhibitedNumbers(R, C);
                    Set<Integer> setAllowedNumbers = new HashSet<>();

                     for (int i = 1; i <= N; i++) {
                         setAllowedNumbers.add(i);
                     }
                     
                    for (int i = 1; i <= N; i++) {
                        
                        setAllowedNumbers.removeAll(setProhibitedNumbers);
//                        if (!setProhibitedNumbers.contains(i)) {
//                            setAllowedNumbers.add(i);
//                        }
                    }

                    if (!setAllowedNumbers.isEmpty()) {
                        int randomIndex = (int) (Math.random() * setAllowedNumbers.size());
                        ArrayList<Integer> list = new ArrayList(setAllowedNumbers);
                        int num = list.get(randomIndex);

                        grid[R][C] = num;
                        fixedCells[R][C] = true;

                        numOfFixedNumbers--;
                    }
                    else {

                         generateRandomPuzzle(); // try again from the beginning

//                        if(c>0){
//                           grid[r][c-1]=EMPTY; 
//                           c--;
//                        }
//                       
                    }

                }

                c += 3;
            }

            r += 3;
        }


        markFixedCells();
        printGrid();
        System.out.println("Total Fixed Numbers: " + totalFixedNums);

    }// end method

    public static void main(String[] args) {

        //fillGrid();
//        grid = new int[][]{
//        {2, 0, 0, 0, 0, 0, 0, 0, 3},
//        {0, 1, 4, 0, 0, 0, 9, 5, 0},
//        {0, 0, 0, 7, 8, 1, 0, 0, 0},
//        {0, 0, 7, 3, 5, 6, 8, 0, 0},
//        {0, 5, 0, 0, 0, 0, 0, 4, 2},
//        {0, 0, 3, 4, 2, 8, 7, 0, 0},
//        {6, 0, 0, 5, 7, 9, 0, 0, 0},
//        {0, 4, 2, 0, 0, 0, 6, 9, 0},
//        {8, 0, 0, 0, 0, 0, 0, 0, 1}
//        };
        //System.out.println(howAmIDoing());
        //generateRandomPuzzle();
        //System.out.println(howAmIDoing());

        fillGrid();
        //printGrid();
        //System.out.println(getProhibitedNumbers(0, 3));
        solve();
    }// end main

}// end class
