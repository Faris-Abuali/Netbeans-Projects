package shahd;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shahd {

    private static void fun(int[][] x) throws FileNotFoundException {
        File f = new File("initial.txt"); // here put: .txt not .text
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    x[i][j] = sc.nextInt();

                }

            }
        }
    }

    public static void print(int x[][]) {
        System.out.println("   0 1 2   3 4 5   6 7 8");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + "*|");
            for (int j = 0; j < 9; j++) {
                if (x[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(x[i][j] + " ");
                }
                if (j == 2 || j == 5 || j == 8) {
                    System.out.print("| ");
                }
            }

            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("--------------------------");
            }

        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-");
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

        Scanner s = new Scanner(System.in);

        int[][] x = new int[9][9];
        fun(x);
        int[][] b = new int[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                b[r][c] = x[r][c];
            }
        }
        print(x); // this is your method
        System.out.println("This is the initial grid: ");

        printGrid(x); // this is mine
        System.out.println("This is the initial grid: ");

        int r1 = 0;

        int w = 49;
        while (w > 0) {
            r1 = 0;
            System.out.println("Enter the row");
            int r = s.nextInt();
            System.out.println("Enter the columbe");
            int c = s.nextInt();
            int n = 0;
            System.out.println("Enter the number");
            if (b[r][c] == 0) {
                n = s.nextInt();
            } else {
                System.out.println("**chang the place** ");
                continue;
            }
            for (int i = 0; i < 9; i++) {
                if (i != c) {

                    if (x[r][i] == n) {
                        System.out.println("pleas chnge the number ,the number is repeated in the row ");
                        r1++;
                    }

                }
            }
            for (int i = 0; i < 9; i++) {
                if (i != r) {

                    if (x[i][c] == n) {
                        System.out.println("pleas chnge the number ,the number is repeated in the columbe");
                        r1++;

                    }

                }
            }
            int q = r - r % 3;
            int y = c - c % 3;

            for (int i = q; i < q + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if (i != q && j != y) {
                        if (x[i][j] == n) {

                            System.out.println("pleas chnge the number ,the number is repeated in the box");
                            r1++;

                        }

                    }
                }
            }

            if (r1 != 0) {
                x[r][c] = 0;
            } else {
                x[r][c] = n;
            }

            print(x);
            System.out.println("ok, this is the current shape");

            //---------------------------------------------------------------------------
//            System.out.println("   0 1 2  3 4 5  6 7 8");
//            System.out.println("*-*-*-*-*-*-*-*-*-*-*-");
//            for (int i = 0; i < 9; i++) {
//                System.out.print(i + "*");
//                for (int j = 0; j < 9; j++) {
//
//                    System.out.print(" " + a[i][j]);
//
//                    if (j == 2 || j == 5) {
//                        System.out.print("|");
//                    }
//                }
//
//                System.out.println();
//                if (i == 2 || i == 5) {
//                    System.out.println("-----------------------");
//                }
//
//            }
//            System.out.println("*-*-*-*-*-*-*-*-*-*-*-");
//            w--;
//
//        }
        }

        try {
            fun(x);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        print(x);
    }

}
