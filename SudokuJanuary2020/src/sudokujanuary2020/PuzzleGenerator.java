package sudokujanuary2020;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fares Abu Ali
 */
public class PuzzleGenerator {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static final int N = 9;
    static final int EMPTY = 0;

    public static LinkedList<Integer> shiftLeft(LinkedList<Integer> source, int times) {

        LinkedList<Integer> newList = new LinkedList<>(source);

        for (int i = 0; i < times; i++) {
            int n = newList.removeFirst();
            newList.add(n);
        }

        //System.out.println("shift " + times + " times:\n" + lin);
        return newList;

    }// end method

    public static Integer[][] fillGrid(Integer[][] grid) {

        grid = new Integer[N][N];
        /*
        There is an easy way to fill in a complete Sudoku puzzle - group filling and circular shift.

            1.Fill the first row with nine different numbers.
            2.Fill the second row which is a shift of the first line by three slots.
            3.Fill the third row which is a shift of the second line by three slots.
            4.Fill the fourth row which is a shift of the third by one slot.
        
                line 1: 8 9 3  2 7 6  4 5 1
                line 2: 2 7 6  4 5 1  8 9 3 (shift 3)
                line 3: 4 5 1  8 9 3  2 7 6 (shift 3)

                line 4: 5 1 8  9 3 2  7 6 4 (shift 1)
                line 5: 9 3 2  7 6 4  5 1 8 (shift 3)
                line 6: 7 6 4  5 1 8  9 3 2 (shift 3)

                line 7: 6 4 5  1 8 9  3 2 7 (shift 1)
                line 8: 1 8 9  3 2 7  6 4 5 (shift 3)
                line 9: 3 2 7  6 4 5  1 8 9 (shift 3)

         */
        LinkedList<Integer>[] arrayOfLinkedLists = new LinkedList[9];  // each LinkedList in this array will represent a row of the grid

        for (int i = 0; i < 9; i++) {
            arrayOfLinkedLists[i] = new LinkedList<>();
        }

        arrayOfLinkedLists[0].add(1);
        arrayOfLinkedLists[0].add(2);
        arrayOfLinkedLists[0].add(3);
        arrayOfLinkedLists[0].add(4);
        arrayOfLinkedLists[0].add(5);
        arrayOfLinkedLists[0].add(6);
        arrayOfLinkedLists[0].add(7);
        arrayOfLinkedLists[0].add(8);
        arrayOfLinkedLists[0].add(9);

        Collections.shuffle(arrayOfLinkedLists[0]);

        //-----------------------------------------------
        for (int i = 1; i < 9; i++) {

            int numberOfShifts = 3;

            if (i == 3 || i == 6) {
                numberOfShifts = 1;
            }

            arrayOfLinkedLists[i] = shiftLeft(arrayOfLinkedLists[i - 1], numberOfShifts);
        }

        for (int i = 0; i < 9; i++) {

            System.out.println(arrayOfLinkedLists[i]);

            for (int j = 0; j < 9; j++) {

                grid[i][j] = arrayOfLinkedLists[i].get(j);
            }
        }

        System.out.println("Original Grid: ");
        printGrid(grid);
        
        return grid;

    }// end method

    public static Integer[][] rotateGrid90Degrees(Integer[][] grid) {

        Integer[][] gridLocal = createNewCopy(grid);// new separate matrix

        ArrayList<Integer> arList = new ArrayList<>();

        int[][] m = new int[N][N];

        for (int r = N - 1; r >= 0; r--) {

            for (int c = 0; c < N; c++) {

                if (gridLocal[c][r] == null) {
                    arList.add(EMPTY);
                } else {
                    arList.add(gridLocal[c][r]);
                }
            }
        }

        System.out.println("Rotate 90: " + arList);

        fillGridFromList(arList, gridLocal);
        printGrid(gridLocal);

        return gridLocal;

    }// end method

    public static Integer[][] rotateGrid270Degrees(Integer[][] grid) {

        Integer[][] gridLocal = createNewCopy(grid);// new separate matrix

        ArrayList<Integer> arList = new ArrayList<>();

        int[][] m = new int[N][N];

        for (int c = 0; c < N; c++) {

            for (int r = N - 1; r >= 0; r--) {

                if (gridLocal[r][c] == null) {
                    arList.add(EMPTY);
                } else {
                    arList.add(gridLocal[r][c]);
                }
            }
        }

        System.out.println("Rotate 270: " + arList);

        fillGridFromList(arList, gridLocal);
        printGrid(gridLocal);

        return gridLocal;

    }// end method

    public static Integer[][] rotateGrid180Degrees(Integer[][] grid) {

        Integer[][] gridLocal = createNewCopy(grid);// new separate matrix

        ArrayList<Integer> arList = new ArrayList<>();

        int[][] m = new int[N][N];

        for (int r = N - 1; r >= 0; r--) {

            for (int c = N - 1; c >= 0; c--) {

                if (gridLocal[r][c] == null) {
                    arList.add(EMPTY);
                } else {
                    arList.add(gridLocal[r][c]);
                }
            }
        }

        System.out.println("Rotate 180: " + arList);

        fillGridFromList(arList, gridLocal);
        printGrid(gridLocal);

        return gridLocal;

    }// end method

    public static void fillGridFromList(ArrayList<Integer> arList, Integer[][] grid) {

        Iterator<Integer> it = arList.listIterator();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                grid[i][j] = it.next();
            }
        }

    }// end method

    public static void printGrid(Integer[][] grid) {

        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        for (int i = 0; i < N; i++) {

            System.out.print(i + " |");
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == EMPTY) {
                    System.out.print("   " + "|");
                } else {

                    System.out.print(ANSI_CYAN + " " + grid[i][j] + " " + ANSI_RESET + "|");

                }

            }
            System.out.println("\n  +---+---+---+---+---+---+---+---+---+");

        }// end for outer

        System.out.println("\n");

    }// end method

    public static Integer[][] createNewCopy(Integer[][] originalMAtrix) {

        Integer[][] newMatrix = new Integer[originalMAtrix.length][originalMAtrix.length];

        for (int i = 0; i < originalMAtrix.length; i++) {
            newMatrix[i] = Arrays.copyOf(originalMAtrix[i], originalMAtrix.length);
        }

        return newMatrix;

    }// end method

    public static Integer[][] removeEntriesRandomlyFromEachBox(Integer[][] grid) {

        Integer[][] newMatrix = createNewCopy(grid);

        int row = 0;
        int col = 0;

        while (row < N) {

            col = 0; //reset col
            while (col < N) {

                // --- Where shall this box start from?---
                int R = (row / 3) * 3;
                int C = (col / 3) * 3;

                //=====================a whole box =================================
                int numbersOfEntriesWillBeErased = (int) (Math.random() * 4) + 4;

                while (numbersOfEntriesWillBeErased > 0) {

                    int randCOLUMN = (int) (Math.random() * 3 + C);
                    int randRow = (int) (Math.random() * 3 + R);

                    while (newMatrix[randRow][randCOLUMN] == EMPTY) {
                        randCOLUMN = (int) (Math.random() * 3 + C);
                        randRow = (int) (Math.random() * 3 + R);
                    }

                    newMatrix[randRow][randCOLUMN] = EMPTY;

                    numbersOfEntriesWillBeErased--;
                }

                System.out.println();

                //===========================================================
                // ------------ Finished a whole box -------------
                col += 3;
            }

            row += 3;
        }

        int random = (int) (Math.random() * 2);

        if (random == 0) {
            newMatrix = rotateGrid90Degrees(newMatrix);
        } else {
            newMatrix = rotateGrid270Degrees(newMatrix);
        }
        
        printGrid(newMatrix);
        return newMatrix;
    }// end method

    public static void main(String[] args) {

//         LinkedList<Integer> lin = new LinkedList<>();
//        
//        lin.add(1);
//        lin.add(2);
//        lin.add(3);
//        lin.add(4);
//        lin.add(5);
//        lin.add(6);
//        lin.add(7);
//        lin.add(8);
//        lin.add(9);
//        
//        Collections.shuffle(lin);
//        
//        
//        System.out.println(lin);
//        
//        shiftLeft(lin,3);
        Integer[][] grid = new Integer[9][9];
//
        fillGrid(grid);
        removeEntriesRandomlyFromEachBox(grid);

////        
        //rotateGrid90Degrees(grid);
        // rotateGrid270Degrees(grid);
        // rotateGrid180Degrees(grid);
//        
//        
//        
//
////        rotateGrid270Degrees(grid);
////        
////        printGrid(grid);
//        Integer[][] m1 = new Integer[3][3];
//
//        Integer[][] m2 = createNewCopy(m1);
//
//        m1[0][0] = 333;
//
//        System.out.println(Arrays.deepToString(m1));
//        System.out.println(Arrays.deepToString(m2));
    }// end main
}// end class
