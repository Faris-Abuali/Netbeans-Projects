package eight_queens;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class EightQueens {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Map<Integer, Integer> queensMap = new HashMap<>();  // key is the row and value is the column

    final static int N = 8;

    //static String[][] emptyMatrix = new String[8][8];
    public static void printMatrix(String[][] m) {

        System.out.print("   ");
        for (int i = 0; i < m.length; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+");

        for (int i = 0; i < m.length; i++) {

            System.out.print(i + " |");
            for (int j = 0; j < m[i].length; j++) {

                if (m[i][j].equals("T")) {
                    System.out.print(ANSI_GREEN + " X " + ANSI_BLACK + "|" + ANSI_RESET);
                } else if (m[i][j].equals("X")) {
                    System.out.print(ANSI_RED + " X " + ANSI_BLACK + "|" + ANSI_RESET);
                } else {
                    System.out.print(ANSI_CYAN + " Q " + ANSI_BLACK + "|" + ANSI_RESET);
                }
            }

            System.out.println("\n  +---+---+---+---+---+---+---+---+");

        }

        System.out.println("\n");

    }// end method

    public static void resetMatrix(String[][] m) {

        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {

                m[i][j] = "T";
            }

        }

    }// end method

    public static void putNewQueenAndMarkProhibitedPlaces(int r, int c, String[][] m) {

        queensMap.put(r, c);

        for (int row = 0; row < m.length; row++) {

            for (int col = 0; col < m[row].length; col++) {

                if (row == r || col == c || (row - col) == (r - c) || row + col == r + c) {
                    m[row][col] = "X";
                }
            }

        }

        //place the new queen
        m[r][c] = "Q";   //\u265B

    }// end method

    public static void removeQueen(int r, int c, String[][] m) {

        System.out.println("remove the queen in row = " + r + ", col = " + c + " :");

        queensMap.remove(r, c);   //remove(key,value)

        resetMatrix(m);

        //Now: after removing the queen, you need to updateProhibitedPlaces
        for (int currKey : queensMap.keySet()) {

            putNewQueenAndMarkProhibitedPlaces(currKey, queensMap.get(currKey), m);
        }

        printMatrix(m);
    }// end method

    //==================================================================================================================
    public static boolean solve(String[][] m) {
        return solveRec(0, m);
    }

    private static boolean solveRec(int row, String[][] m) {
        // you have to start from row #0

        if (row >= m[0].length) {
            return true;
        }

        for (int col = 0; col < m[0].length; col++) {

            if (m[row][col].charAt(0) == 'T') {

                putNewQueenAndMarkProhibitedPlaces(row, col, m);
                System.out.println("place a queen in row = " + row + ", col = " + col + " :");
                printMatrix(m);
                boolean flag = solveRec(row + 1, m); // move to the next row

                if (flag == false) { // then we need to backtrack
                    removeQueen(row, col, m);// printMatrix(m) will be invoked 
                } else {
                    return true;
                }
            }

        }// end for col

        return false;

    }// end method

    //==================================================================================================================
    public static boolean solveStartingFromAnyRow(int row, String[][] m) {
        return solveRecStartingFromAnyRow(row, m, 1);
    }

    private static boolean solveRecStartingFromAnyRow(int row, String[][] m, int queensCtr) {

        //queensCtr counts the number of queens inserted to the chessBoard
        if (queensCtr > N) {
            return true;
        }

        for (int col = 0; col < m[0].length; col++) {

            if (m[row][col].charAt(0) == 'T') {

                putNewQueenAndMarkProhibitedPlaces(row, col, m);
                System.out.println("place a queen in row = " + row + ", col = " + col + " :");
                printMatrix(m);
                boolean flag = solveRecStartingFromAnyRow((row + 1) % N, m, queensCtr + 1); // move to the next row

                if (flag == false) { // then we need to backtrack
                    removeQueen(row, col, m);// printMatrix(m) will be invoked 
                } else {
                    return true;
                }
            }

        }// end for col

        return false;

    }// end method

    //==================================================================================================================
    public static boolean solveStartingFromAnyRow$AnyColumn(int row, int col, String[][] m) {

        return solveRecStartingFromAnyRow$AnyColumn(row, m, 1, col);
    }

    private static boolean solveRecStartingFromAnyRow$AnyColumn(int row, String[][] m, int queensCtr, int startColumn) {

        //queensCtr counts the number of queens inserted to the chessBoard
        if (queensCtr > N) {
            return true;
        }

        int columnsDiscovered = 0;

        for (int col = startColumn; columnsDiscovered < N; col = (col + 1) % N) {

            if (m[row][col].charAt(0) == 'T') {

                putNewQueenAndMarkProhibitedPlaces(row, col, m);
                System.out.println("place a queen in row = " + row + ", col = " + col + " :");
                printMatrix(m);
                boolean flag = solveRecStartingFromAnyRow$AnyColumn((row + 1) % N, m, queensCtr + 1, 0); // move to the next row

                if (flag == false) { // then we need to backtrack
                    removeQueen(row, col, m);// printMatrix(m) will be invoked 
                } else {
                    return true;
                }
            }

            columnsDiscovered++;

        }// end for col

        return false;

    }// end method

    //==================================================================================================================
//    public static void findASolutionEachTimeStartFromADifferentPlace(String[][] m) {
//
//        ArrayList<String[][]> list = new ArrayList<>();
//
//        //for (int r = 0; r < N; r++) {
//        for (int c = 0; c < N; c++) {
//
//            boolean solFound = solveStartingFromAnyRow$AnyColumn(0, c, m);
//            if (solFound) {
//                list.add(m);
//            } else {
//                System.out.println("NO Solution Found Starting from row: " + 0 + ", col: " + c);
//            }
//
//            resetMatrix(m);
//
//        }
//        //}
//
//        System.out.println(list.size());
//
//    }// end method

    public static void main(String[] args) {

        String[][] m = new String[N][N];
        resetMatrix(m);

//        putNewQueenAndMarkProhibitedPlaces(0, 2, m);
//        solveRec(1, m);
        // solveStartingFromAnyRow(3, m);
        //solveStartingFromAnyRow$AnyColumn(3, 6, m);

        boolean solFound = solveStartingFromAnyRow$AnyColumn(5, 6, m);
       // System.out.println(solFound);

//=============Maximum Number of Nodes============
//        int n = 8;
//        int sum = 1;
//        for (int i = 0; i < n; i++) {
//
//            int product = 1;
//
//            for (int j = 0; j <= i; j++) {
//                product *= (n - j);
//            }
//
//            sum += product;
//        }
//
//        System.out.println(sum);
//===================================================
    }// end main
//    

}// end class
