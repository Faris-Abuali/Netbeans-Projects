package linearalgebra;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fares Abu Ali
 */
// Types Of Systems:
// 1. Over-determined : number of rows(equations) > number of columns (variables)
//   usually inconsistent (has no solution), and it could be consistent with unique solution or with infinitely many solutions
// 2. Under-determined : number of rows(equations) < number of columns (variables)
// usually consistent with infinitely many solutions, and IT IS IMPOSSIBLE TO HAVE A UNIQUE SOLUTION ( as there always 
// will be at least one free variable)
// and it could be inconsistent
// 3. Square System: number of rows(equations) == number of columns (variables)
// If det(A)!=0 (non-singular) then the sys. has a unique solution
public class LinearAlgebra {

    // 1 2 1 2 -1 1 4 3 3 2 -1 3
    static Double[][] matrix = new Double[3][4];
    static int sign = 1; // I made this for determinant() method, becasue when two rows are swapped, this affects the 
    // sign of the determinant.

    static Scanner sc = new Scanner(System.in);

    public static boolean isInteger(double n) {

        int i = (int) n;
        return i == n;
    }

    public static void printMatrix() {

        System.out.println("---------------------------------");
        for (Double[] ar : matrix) {
            int ctr = 0;
            for (double i : ar) {

                if (isInteger(i)) {

                    if (i < 0) {
                        System.out.print((int) i + " ");
                    } else {
                        System.out.print(" " + (int) i + " ");
                    }

                } else {
                    if (i < 0) {
                        System.out.printf("%.2f ", i);

                    } else {
                        System.out.printf(" %.2f ", i);

                    }

                }

                ctr++;

                if (ctr == ar.length - 1) {
                    System.out.print("|");
                }
            }// end innerFor

            System.out.println();
        }// end outerFor
        System.out.println("---------------------------------");

    }

    public static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
    }

    public static void rearrangeRows() {

        // this method achieves the principle: the number of leading zeros in row k is less than or equal to 
        // the number of leading zeros in row (k+1)
        for (int i = 0; i < matrix.length - 1; i++) {

            int maxNumOfLeadingZeros = 0;
            int numOfLeadingZeros = 0;
            int rowIndex = i;

            for (int row = 0; row < matrix.length - i; row++) {

                numOfLeadingZeros = 0;

                for (int col = 0; col < matrix[row].length; col++) {

                    if (matrix[row][col] != 0) {
                        break;
                    } else {
                        numOfLeadingZeros++;
                    }

                }// end forInner

                if (numOfLeadingZeros >= maxNumOfLeadingZeros) { // Why >=  not >  ? Answer: because when there are two rows with 
                    sign *= -1;                                  // the same number of leadung zeros, keep them as they are
                    maxNumOfLeadingZeros = numOfLeadingZeros;
                    rowIndex = row;
                }

            }// end forMiddle

            // now I know the index of the row who has the largest number of leading zeros
            if (maxNumOfLeadingZeros != 0) {
                swapRows(rowIndex, matrix.length - 1 - i);
            }
            //printMatrix();

        }// end forOuter

    }// end method

    public static void swapRows(int rowX, int rowY) {

        for (int col = 0; col < matrix[0].length; col++) {

            double temp = matrix[rowX][col];
            matrix[rowX][col] = matrix[rowY][col];

            matrix[rowY][col] = temp;
        }

    }

    public static void rowEchelonForm() {

        rearrangeRows();

        System.out.println("matrix after rearange");
        printMatrix();

        for (int row = 0; row < matrix.length; row++) {

            int colIndexOfFNE = 0; // FNE = first nonzero entry

            double firstNonzeroEntry = 0;
            boolean foundFirstNonzeroEntry = false;

            for (int col = 0; col < matrix[row].length; col++) {

                if (foundFirstNonzeroEntry == false && matrix[row][col] != 0 && col < (matrix[row].length - 1)) {
// why the condition && col<(matrix[row].length-1) ?? because the last column is for augmented column 
// remeber: when you face a row in the form: [0 0 0 .... | 2]  then you cannot consider the 2 as a the firstNonzeroEntry
                    firstNonzeroEntry = matrix[row][col];
                    colIndexOfFNE = col;
                    foundFirstNonzeroEntry = true;
                }

                if (foundFirstNonzeroEntry) {
                    matrix[row][col] /= firstNonzeroEntry;
                }

            }// now the first nonzero entry in the row is 1

            //see the first nonzero entry in row #row? all entries below its column must become zero, but how?
            if (firstNonzeroEntry != 0) {
                for (int i = row + 1; i < matrix.length; i++) {

                    double pivot = matrix[i][colIndexOfFNE];  // the first nonzero entry in the ith row

                    for (int j = colIndexOfFNE; j < matrix[i].length; j++) {

                        matrix[i][j] = matrix[i][j] - (pivot * matrix[row][j]);
                        // matrix[row][j] in row #row is the corresponding entry to matrix[i][j] in row #i 

                    }
                }

            }// end if

            System.out.println("matrix directly after performing row-echelon");
            printMatrix();

            rearrangeRows();

            System.out.println("matrix after rearranging the row-echelon");
            printMatrix();

        }

    }// end method

    public static void reducedRowEchelonForm() {
        //Gaussian Elimination

        // before calling reducedRowEchelonForm, make sure you have called rowEchelonForm
        for (int row = matrix.length - 1; row > 0; row--) {

            System.out.println("reducedRowEchelon");
            printMatrix();

            int colIndexOfFNE = 0; // FNE: first nonzero entry

            double firstNonzeroEntry = 0; // this nonzero entry is sure to be 1 because I made it become 1 
            //previously in rowEchelon function
            //boolean foundFirstNonzeroEntry = false;

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] != 0 && col < (matrix[row].length - 1)) { // or if(matrix[row][col]==1

// why the condition && col<(matrix[row].length-1) ?? because the last column is for augmented column 
// remeber: when you face a row in the form: [0 0 0 .... | 2]  then you cannot consider the 2 as a the firstNonzeroEntry
                    firstNonzeroEntry = matrix[row][col]; // here of course it will be 1 (leading one)
                    colIndexOfFNE = col; // FNE: first nonzero entry
                    //foundFirstNonzeroEntry = true;
                    break;
                }

            }// here already the first nonzero entry in the row is 1, but I need this above loop to detect the ColumnIndex
            // of this leading 1

            if (firstNonzeroEntry != 0) {
                for (int i = row - 1; i >= 0; i--) {

                    double pivot = matrix[i][colIndexOfFNE];

                    for (int j = colIndexOfFNE; j < matrix[i].length; j++) {

                        matrix[i][j] = matrix[i][j] - (pivot * matrix[row][j]);
                    }

                }

            }// end if

        }// end of outer for

        System.out.println("After Reduced Row Echelon");
        printMatrix();

    }// end method

    public static void solveSystemOfEqns() {

        rowEchelonForm();
        reducedRowEchelonForm();

        if (detectInconsistency() == true) {

            System.out.println("The System is Inconsistent!!  (Has No Solution!) ");
        } else {

            //--------------------------------------------In Case OF Free Variables---------------------------------------------------
            boolean[] leadingVariables = detectFreeVariables();
            boolean thereAreFreeVariables = false;

            for (int i = 0; i < leadingVariables.length; i++) {
                if (leadingVariables[i] == false) {
                    System.out.println("X" + (i + 1) + " is Free");

                    thereAreFreeVariables = true;
                }
            }

            if (thereAreFreeVariables) {

                for (int row = 0; row < matrix.length; row++) {

                    boolean foundLeadingOne = false;

                    for (int col = 0; col < matrix[row].length - 1; col++) {

                        if (!foundLeadingOne && matrix[row][col] == 1) {

                            if (isInteger(matrix[row][matrix[row].length - 1])) {
                                System.out.print("X" + (col + 1) + " = " + matrix[row][matrix[row].length - 1].intValue());
                            } else {
                                System.out.print("X" + (col + 1) + " = " + matrix[row][matrix[row].length - 1]);
                            }
                            foundLeadingOne = true;
                        } else if (foundLeadingOne && matrix[row][col] != 0) {

                            if (matrix[row][col] < 0) {

                                if (isInteger(matrix[row][col])) {
                                    int temp = matrix[row][col].intValue();
                                    System.out.print(" + " + -temp + "X" + (col + 1));

                                } else {
                                    System.out.print(" + " + -matrix[row][col] + "X" + (col + 1));
                                }

                            } else {

                                if (isInteger(matrix[row][col])) {

                                    int temp = matrix[row][col].intValue();
                                    System.out.print(" - " + temp + "X" + (col + 1));

                                } else {
                                    System.out.print(" - " + matrix[row][col] + "X" + (col + 1));
                                }

                            }
                        }
                    }// end for inner

                    System.out.println();
                }

            }// end free variables
            //--------------------------------------------End The Case OF Free Variables-------------------------------------------
            else {
                // the program reaches here if the sys. is consistent and there are no free variables 

                //----------------------------In Case Of Unique Solution------------------------------------------------
                Double[] X = new Double[matrix[0].length - 1];// because the last column is not for variables. It's for constants

                for (int row = 0; row < matrix.length; row++) {

                    for (int col = 0; col < matrix[row].length - 1; col++) {

                        if (matrix[row][col] == 1) {
                            X[col] = matrix[row][matrix[row].length - 1];
                            break;
                        }
                    }
                }

                //System.out.println("Solutions: "+Arrays.toString(X));
                for (int i = 0; i < X.length; i++) {

                    System.out.print("X" + (i + 1) + " = ");

                    if (isInteger(X[i])) {
                        System.out.println(X[i].intValue());
                    } else {
                        System.out.printf("%.2f\n", X[i]);
                    }
                }
            }// end else which is for unique solution case

            //--------------------------------------------------------------------------------------------------------
        }// end else which is for Consistent System

        determineSystemType();// this will not help in solving the matrix, just giving information of the system type

    }// end method

    public static void determineSystemType() {

        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length - 1; // why -1 ? because the last column is for constants (augmented matrix)

        if (numOfRows > numOfColumns) {
            System.out.println("Over-determined System: number of rows (equations) > number of columns (variables)");
        } else if (numOfRows < numOfColumns) {
            System.out.println("Under-determined System: number of rows (equations) < number of columns (variables)");
        } else {
            System.out.println("Square System: number of rows (equations) = number of columns (variables)");

        }
    }//end method

    public static boolean[] detectFreeVariables() {

        // this method MUST be called only after calling reducedRowEchelon() method
        boolean[] leadingVariables = new boolean[matrix[0].length - 1]; // because the last column is for constants not variables

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 1) {
                    leadingVariables[col] = true;
                    break;
                }
            }
        }

        return leadingVariables;

    }// end method

    public static boolean detectInconsistency() {

        // this method MUST be called only after calling reducedRowEchelon() method
        // this method detects if there's NO SOLUTION for the system
        // the system has no solution when there exists a row with all zero entries except the entry in the last column
        // is not zero.  Ex:  [ 0,0,0,.... | 3 ]
        for (int row = 0; row < matrix.length; row++) {

            boolean rowWithAllZerosDetected = true;

            // detect a row with all entries are zero except the entry in last column
            for (int col = 0; col < matrix[row].length - 1; col++) {

                if (matrix[row][col] != 0) {
                    rowWithAllZerosDetected = false;
                    break;
                }

            }// end inner for

            if (rowWithAllZerosDetected) {

                // now check the entry in the last column (the constant)
                if (matrix[row][matrix[row].length - 1] != 0) {
                    System.out.println("Inconsistent System");
                    return true; // then the system is inconsistent (has no solutuon)
                }
            }

        }// end outer for

        return false;

    }//end method

    public static void determinant() {

        sign = 1;

        if (matrix.length != matrix[0].length) {
            JOptionPane.showMessageDialog(null, "determinant is undefined for a non-square matrix !!");
        } else {

            rearrangeRows();

            System.out.println("matrix after rearange");
            printMatrix();
            System.out.println("sign = " + sign);

            for (int row = 0; row < matrix.length; row++) {

                int colIndexOfFNE = 0;

                for (int col = 0; col < matrix[row].length; col++) {

                    if (matrix[row][col] != 0) {
                        colIndexOfFNE = col; // FirstNonzeroEntry
                        break;
                    }

                }

                for (int i = row + 1; i < matrix.length; i++) {

                    double pivot = matrix[i][colIndexOfFNE];  // the first nonzero entry in the ith row

                    for (int j = colIndexOfFNE; j < matrix[i].length; j++) {

                        matrix[i][j] = matrix[i][j] - ((pivot / matrix[row][colIndexOfFNE]) * matrix[row][j]);
                        // matrix[row][j] in row #row is the corresponding entry to matrix[i][j] in row #i 

                    }
                }

                System.out.println("matrix directly after working on determinant");
                printMatrix();

                rearrangeRows();

                System.out.println("matrix after rearranging the determinant");
                printMatrix();
                System.out.println("sign = " + sign);

            }// end outer for

            // now the matrix is strict triangular (upper triangular)
            Double productOfMainDiagonalEntries = multiplyDiagonalEntries();
            // productOfMainDiagonalEntries *= sign;

            System.out.printf("Δ = %.2f\n", productOfMainDiagonalEntries);

        }// end else

    }// end method

    public static Double multiplyDiagonalEntries() {

        // this method is made to be called inside determinant() method after converting the matrix to 
        // upper strict triangular
        Double product = 1d;

        for (int i = 0; i < matrix.length; i++) {

            product *= matrix[i][i];
        }

        return product;

    }// end method

    public static void main(String[] args) {

        //0 0 4 0 0 0 1 3 5 0 2 1
        //1 3 5 0 2 1 0 3 4 0 6 0
        //fillMatrix();
        //------------------------------------ Inconsistent System (NO SOLUTION!) ----------------------------------------
        //TheBest Example
        //matrix = new Double[][]{{1.0, 1.0, 1.0}, {1.0, -1.0, 3.0}, {-1.0, 2.0, -2.0}};// Inconsistent System
        //matrix = new Double[][]{{1.0, 1.0, 1.0}, {2.0, 2.0, 1.0}};
        //------------------------------------ End -----------------------------------------------------
        //------------------------------------ Free Variables (infinite solutions) ----------------------------------------
        // matrix = new Double[][]{{1.0, 2.0, 3.0, 5.0}, {3.0, 4.0, 5.0, 1.0}}; ////one Free Variable
        // two free variables
        // matrix = new Double[][]{{1.0, 1.0, 1.0, 1.0, 1.0, 2.0}, {1.0, 1.0, 1.0, 2.0, 2.0, 3.0}, {1.0, 1.0, 1.0, 2.0, 3.0, 2.0}};
        //matrix = new Double[][]{{2.0, 3.0, -2.0, 5.0}, {5.0, -4.0, 2.0, 6.0}};
        //------------------------------------ End -----------------------------------------------------
        //------------------------------------ Unique Solution -----------------------------------------------------
        //matrix = new Double[][]{{1.0, 2.0, 1.0, 1.0}, {2.0, -1.0, 1.0, 2.0}, {4.0, 3.0, 3.0, 4.0}, {2.0, -1.0, 3.0, 5.0}};
        //matrix = new Double[][]{{3.0, 6.0, 3.0, 9.0}, {3.0, -1.0, -3.0, -1.0}, {2.0, 3.0, 1.0, 4.0}};
        //matrix = new Double[][]{{1.0, 2.0, 3.0, 5.0}, {6.0, 7.0, 12.0, 0.0}, {3.0, 0.0, 5.0, 11.0}};
        // matrix = new Double[][]{{2.0, 1.0, 2.0,1.0}, {3.0, 2.0, 2.0,2.0}, {1.0, 2.0, 3.0,1.0}};
         matrix = new Double[][]{{3.0, 6.0, 5.0,9.0}, {3.0, -1.0, 2.0,-1.0}, {2.0, 3.0, 5.0,1.0}};
        solveSystemOfEqns();
        // solveSystemOfEqns();
        //------------------------------------ End -----------------------------------------------------
        //System.out.println("Original matrix");
        //printMatrix();
        // solveSystemOfEqns();
        //=============================Now For Determinant=========================================
        // matrix = new Double[][]{{1.0, 2.0, 3.0}, {6.0, 7.0, 12.0}, {3.0, 0.0, 5.0}};
        // matrix = new Double[][]{{1.0, 2.0, 3.0, 4.0}, {3.0, 2.0, 4.0, 1.0}, {6.0, 1.0, 2.0, 1.0}, {1.0, 3.0, 1.0, 4.0}};
        // matrix = new Double[][]{{5.0, 2.0, 4.0}, {1.0, 3.0, 2.0}, {4.0, 5.0, 6.0}};
        //matrix = new Double[][]{{5.0, 3.0, 2.0}, {0.0, 7.0, 8.0}, {1.0, 4.0, 9.0}};
        //matrix = new Double[][]{{2.0, 1.0, 3.0}, {4.0, 2.0, 1.0}, {6.0, -3.0, 4.0}};
        //matrix = new Double[][]{{0.0, 0.0, 0.0, 1.0}, {1.0, 0.0, 0.0, 0.0}, {0.0, 1.0, 0.0, 0.0}, {0.0, 0.0, 1.0, 0.0}};
        //matrix = new Double[][]{{2.0, 1.0, 2.0}, {3.0, 2.0, 2.0}, {1.0, 2.0, 3.0}};
        //matrix = new Double[][]{{1.0, 2.0, 3.0, 4.0}, {3.0, 2.0, 4.0, 1.0}, {6.0, 1.0, 2.0, 1.0}, {1.0, 3.0, 1.0, 4.0}};
        matrix = new Double[][]{{2.0, 33.0, 4.0}, {6.0, 7.0, 5.0}, {8.0, 9.0, 12.0}};
        matrix = new Double[][]{{7.0, 11.0, 2.0}, {4.0, 8.0, 8.0}, {5.0, 7.0, 9.0}};
        matrix = new Double[][]{{2.0, 3.0}, {4.0, 5.0}};
        matrix = new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
       
        //System.out.println();

        //determinant();
        // ============================================================================================
        //detectFreeVariables();
        //rowEchelonForm();
        //reducedRowEchelonForm();
//        System.out.println("Original: ");
//        printMatrix();
//
//        rowEchelon();
    }// end main

}// end class
