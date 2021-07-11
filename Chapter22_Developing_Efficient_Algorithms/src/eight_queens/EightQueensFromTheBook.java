package eight_queens;

import java.util.*;

public class EightQueensFromTheBook {

    final static int N = 8;

    public static boolean solveNQueensUtil(int[][] board, int col) {

        if (col >= N) {
            return true;
        }

        for (int row = 0; row < N; row++) {// the column is fixed and the rows change

            boolean isSafe = isSafe(board, row, col);
            
            if (isSafe) {
                board[row][col] = 1; // 1 means there's a queen in this place, and 0 represents vacancy

                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }

                board[row][col] = 0; // backtrack
            }// end if
        }// end for

        return false;
    }// end method

    public static boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < N; i++) {

            // check upper and lower diagonal
            if ((row + i < N) && (col + i < N) && board[row + i][col + i] == 1) {
                return false; // check upper and lower diagonal
            }
            if ((row + i < N) && (col - i >= 0) && board[row + i][col - i] == 1) {
                return false;
            }
            if ((row - i >= 0) && (col + i < N) && board[row - i][col + i] == 1) {
                return false;
            }
            if ((row - i >= 0) && (col - i >= 0) && board[row - i][col - i] == 1) {
                return false;
            }

            // check row
            if (board[row][i] == 1) {
                return false;
            }

        }// end for

        return true;

    }// end method

    public static void main(String[] args) {

        int[][] board = new int[N][N];

        solveNQueensUtil(board, 0);

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

    }// end main

}// end class
