package fullfinalproject2ndsemester2019safarini;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static boolean isValidIndex(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(char[][] grid, int r, int c) {

        if (grid[r][c] != 'X' && grid[r][c] != 'O') {
            return true;
        }

        return false;
    }

    public static void printCurrentGrid(char[][] grid) {

        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isEmpty(grid, i, j)) {
                    System.out.print("|-|" + " ");
                } else {
                    if (grid[i][j] == 'X') {
                        System.out.print("|" + ANSI_CYAN + grid[i][j] + ANSI_RESET + "| ");
                    } else if (grid[i][j] == 'O') {
                        System.out.print("|" + ANSI_PURPLE+ grid[i][j] + ANSI_RESET + "| ");
                    }

                }
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static boolean thereIsAWinner(char[][] grid, char[] theWinner) {

        //compare the column
        int row = 0;
        for (int j = 0; j < 3; j++) {
            if (!isEmpty(grid, row, j) && grid[row][j] == grid[row + 1][j] && grid[row][j] == grid[row + 2][j]) {
                theWinner[0] = grid[row][j];
                return true;
            }
        }

        //compare the row
        int column = 0;
        for (int i = 0; i < 3; i++) {
            if (!isEmpty(grid, i, column) && grid[i][column] == grid[i][column + 1] && grid[i][column] == grid[i][column + 2]) {
                theWinner[0] = grid[i][column];
                return true;
            }
        }

        //the diagonal
        if (!isEmpty(grid, 0, 0) && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            theWinner[0] = grid[0][0];
            return true;
        }

        //the anti diagonal
        if (!isEmpty(grid, 0, 2) && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            theWinner[0] = grid[0][2];
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char[] theWinner = new char[1];
        Scanner sc = new Scanner(System.in);

        char[][] grid = new char[3][3];
        char r, c;
        int ctr = 0;

        while (true) {

            if (ctr % 2 == 0) {
                System.out.println("ok\nIt's player 1's turn.\nEnter the coordinates(row then column) from '0' to '2' :");
            } else {
                System.out.println("ok\nIt's player 2's turn.\nEnter the coordinates(row then column) from '0' to '2' :");
            }

            r = sc.next().charAt(0);
            int row = r - '0';
            c = sc.next().charAt(0);
            int col = c - '0';

            // System.out.println("row="+row);
            //System.out.println("col="+col);
//        while(!isValidIndex(row,col)){
//            
//            if(!isValidIndex(row,col))
//        System.out.println("wrong index, please enter indices from '0' to '2' only");
//           else if(!isEmpty(grid,row,col))
//        System.out.println("this place is full, please enter again in another place from '0' to '2'");
//            
//        r=sc.next().charAt(0);  row=r-'0'; 
//        c=sc.next().charAt(0);  col=c-'0';
//        
//        while(isValidIndex(row, col) && !isEmpty(grid, row, col)){
//            System.out.println("This place is full. Please choose another place from '0' to '2'");
//             r=sc.next().charAt(0);  row=r-'0'; 
//             c=sc.next().charAt(0);  col=c-'0';
//            
//        } 
//        
//    }
//        
//            
//        
            while (true) {

                while (!isValidIndex(row, col)) {
                    if (row != -9999) {
                        System.out.println("wrong index, please enter indices from '0' to '2' only");
                    }
                    r = sc.next().charAt(0);
                    row = r - '0';
                    c = sc.next().charAt(0);
                    col = c - '0';
                }

                if (isEmpty(grid, row, col)) {
                    break;
                }

                System.out.println(ANSI_RED + "This place is full. Please choose another place from '0' to '2'" + ANSI_RESET);
                row = -9999;
                col = -9999;
            }

            if (ctr % 2 == 0) {
                grid[row][col] = 'X';
            } else {
                grid[row][col] = 'O';
            }

            ctr++;

            printCurrentGrid(grid);

            if (/*ctr >= 5 &&*/ thereIsAWinner(grid, theWinner)) {
                if (theWinner[0] == 'X') {
                    System.out.println(ANSI_YELLOW + "player 1  won" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_YELLOW + "player 2  won" + ANSI_RESET);
                }
                break;
            }

            if (ctr >= 9) {
                System.out.println(ANSI_YELLOW + "It is a tie" + ANSI_RESET);
                break;
            }

        }

        //--EndOfmain  
    }
    //--EndOfClass
}
