package linearalgebra;

import java.util.Arrays;
import javax.swing.JOptionPane;
import static linearalgebra.LinearAlgebra.matrix;

/**
 *
 * @author Fares Abu Ali
 */
public class Adjoint {
    
    public static int rearrangeRows(Double[][] matrix, int sign) {

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
                swapRows(rowIndex, matrix.length - 1 - i, matrix);
            }
            //printMatrix();

        }// end forOuter

        return sign;
    }// end method

    public static void swapRows(int rowX, int rowY, Double[][] matrix) {
        
        for (int col = 0; col < matrix[0].length; col++) {
            
            double temp = matrix[rowX][col];
            matrix[rowX][col] = matrix[rowY][col];
            
            matrix[rowY][col] = temp;
        }
        
    }
    
    public static Double determinant(Double[][] m) {
        
        int sign = 1; // I made this for determinant() method, becasue when two rows are swapped, this affects the 

        //---------------------Creates a new matrix and copy all the data from the matrix m ---------------
        Double[][] matrix = new Double[m.length][m.length];
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.copyOf(m[i], m[i].length);
        }

        //-----------------------------------------------------------
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("determinant is undefined for a non-square matrix !!");
        } else {
            
            sign = rearrangeRows(matrix, sign);

            //System.out.println("matrix after rearange");
            //printMatrix(matrix);
            //System.out.println("sign = " + sign);
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

                // System.out.println("matrix directly after working on determinant");
                // printMatrix(matrix);
                sign = rearrangeRows(matrix, sign);

                //System.out.println("matrix after rearranging the determinant");
                //printMatrix(matrix);
                // System.out.println("sign = " + sign);
            }// end outer for

            // now the matrix is strict triangular (upper triangular)
            Double productOfMainDiagonalEntries = multiplyDiagonalEntries(matrix);
            productOfMainDiagonalEntries *= sign;
            return productOfMainDiagonalEntries;

            //System.out.printf("Δ = %.2f\n", productOfMainDiagonalEntries);
        }// end else

    }// end method

    public static Double multiplyDiagonalEntries(Double[][] matrix) {

        // this method is made to be called inside determinant() method after converting the matrix to 
        // upper strict triangular
        Double product = 1d;
        
        for (int i = 0; i < matrix.length; i++) {
            
            product *= matrix[i][i];
        }
        
        return product;
        
    }// end method

    public static boolean isInteger(double n) {
        
        int i = (int) n;
        return i == n;
    }
    
    public static void printMatrix(Double[][] matrix, boolean augmented) {
        
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
                        System.out.printf("%.1f ", i);
                        
                    } else {
                        System.out.printf(" %.1f ", i);
                        
                    }
                    
                }
                
                ctr++;
                
                if (augmented && ctr == ar.length - 1) {
                    System.out.print(" | ");
                }
            }// end innerFor

            System.out.println();
        }// end outerFor
        System.out.println("---------------------------------");
        
    }
    
    public static Double[][] adjointMatrix(Double[][] m) {

        //---------------------Creates a new matrix and copy all the data from the matrix m ---------------
        Double[][] matrix = new Double[m.length][m.length];
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.copyOf(m[i], m[i].length);
        }

        //-----------------------------------------------------------
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("adjoint is undefined for a non-square matrix !!");
        } else {
            
            Double[][] adjOfMatrix = new Double[matrix.length][matrix.length];
            
            for (int i = 0; i < matrix.length; i++) {
                
                for (int j = 0; j < matrix.length; j++) {
                    
                    int sign = (int) Math.pow(-1, (i + j));
                    
                    Double[][] MinorMatrix = new Double[matrix.length - 1][matrix.length - 1];
                    int rowIndex = 0;
                    int colIndex = 0;

                    //-------------------------------------------------------------       
                    for (int row = 0; (row < matrix.length); row++) {
                        
                        colIndex = 0;  // we have started a new line so reset the colIndex to 0

                        if (row != i) {
                            
                            for (int col = 0; (col < matrix.length); col++) {
                                
                                if (col != j) {
                                    //System.out.print(matrix[row][col] + " ");
                                    MinorMatrix[rowIndex][colIndex] = matrix[row][col];
                                    colIndex++;
                                }
                                
                            }

                            //System.out.println();
                            rowIndex++;
                        }// end if
                    }

                    //System.out.println();
                    //-------------------------------------------------------------
                    double det = determinant(MinorMatrix); // the function determinant() will not edit on the MinorMatrix 
                    // it will make a separate copy of it and work on the copy instead.
                    double Aij = sign * det;
                    adjOfMatrix[i][j] = Aij;
                    //System.out.println(Aij);
                    //printMatrix(MinorMatrix);

                }// end j : which means we have finished finding the Aij for one entry in a row

                //System.out.println("--------------End a whole row------------------");
            }

            // the last step is to get the transpose of the matrix
            adjOfMatrix = transposeOf(adjOfMatrix);
            
            return adjOfMatrix;
        }// end else
    }// end method

    public static Double[][] transposeOf(Double[][] m) {
        
        Double[][] t = new Double[m[0].length][m.length]; // if a matrix has n rows and m columns
        // then its transpose will have m rows and n columns

        for (int row = 0; row < m[0].length; row++) {
            
            for (int col = 0; col < m.length; col++) {
                t[row][col] = m[col][row];
                
            }
        }
        
        return t;
    }// end method

    public static Double[][] inverseOf(Double[][] m) {

        //---------------------Creates a new matrix and copy all the data from the matrix m ---------------
        Double[][] matrix = new Double[m.length][m.length];
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.copyOf(m[i], m[i].length);
        }

        //-----------------------------------------------------------
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("inverse is undefined for a non-square matrix !!");
        } else if (isSingular(matrix)) {
            throw new RuntimeException("inverse is undefined for a SINGULAR matrix !!");
        } else {
            
            double det = determinant(matrix);
            
            matrix = adjointMatrix(matrix); // I will get rid of the copy (matrix) and get the adjoint of it

            // inverse(matrix) = ( 1/det(matrix) ) * adjoint(matrix)
            for (int row = 0; row < matrix.length; row++) {
                
                for (int col = 0; col < matrix.length; col++) {
                    
                    matrix[row][col] /= det;
                }
            }
            
            return matrix;
        }// end else
    }//end method

    public static boolean isSingular(Double[][] matrix) {
        
        int det = determinant(matrix).intValue();
        
        return (det == 0);
        
    }// end method

    public static Double[][] productOfTwoMatrices(Double[][] a, Double[][] b) {
        
        if (a[0].length != b.length) {
            
            throw new RuntimeException("The number of the columns of the first matrix must equall the number of the rows of the"
                    + "second matrix!");
        } else {
            
            Double[][] P = new Double[a.length][b[0].length];
            
            for (int row = 0; row < a.length; row++) {
                // this 1st loop is for visiting all rows of the matrix a

                for (int col = 0; col < b[0].length; col++) {
                    // this 2nd loop is for visiting all columns of the matrix b

                    double sum = 0;
                    
                    for (int i = 0; i < a[0].length; i++) { // or i<b.length  
                        // this 3rd loop is for visiting all elements inside the SAME COLUMN of the matrix b

                        sum += a[row][i] * b[i][col];
                        
                    }// end 3rd loop for visiting all elements inside the SAME COLUMN of the matrix b

                    P[row][col] = sum;
                    
                }//end 2nd loop is for visiting all columns of the matrix b

            }// end 1st loop is for visiting all rows of the matrix a

            return P;
            
        }// end else

    }// end method

    public static Double[] solveSysOfEqnsUsingInverse(Double[][] A, Double[][] b) {

        // A X = b    A=coefficients matrix, X= variables vector, b= constants vector
        // A: nxn
        // X: nx1
        // b: nX1
        Double[][] X = new Double[b.length][1]; // to make a vector nx1 , I have to create a matrix ( array of n arrays)
        // and each array contains only one element

        Double[][] Ainverse = inverseOf(A);
        
        X = productOfTwoMatrices(Ainverse, b);
        
        Double[] xVector = new Double[A.length];
        
        for (int col = 0; col < A.length; col++) {
            xVector[col] = X[col][0];
        }

        //System.out.println(Arrays.toString(xVector));
        for (int i = 0; i < xVector.length; i++) {
            System.out.printf("X" + (i + 1) + " = %.1f\n", xVector[i]);
        }
        
        return xVector;
        
    }// end method

    public static void main(String[] args) {

        //Double[][] matrix = new Double[][]{{2.0, 1.0, 2.0}, {3.0, 2.0, 2.0}, {1.0, 2.0, 3.0}};
        //printMatrix(inverseOf(matrix), false);
        //solveSysOfEqnsUsingInverse(matrix, new Double[][]{{1.0}, {2.0}, {1.0}});
        //Double[][] matrix = new Double[][]{{1.0, 2.0, 3.0, 4.0}, {3.0, 2.0, 4.0, 1.0}, {6.0, 1.0, 2.0, 1.0}, {1.0, 3.0, 1.0, 4.0}};
        
       // System.out.println(determinant(matrix));
        
        matrix = new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        System.out.println(determinant(matrix));
        System.out.println(isSingular(matrix));
//       Double[][] x = new Double[][]{{1.0},{2.0},{1.0}};
//       
//        System.out.println(x.length);
//        System.out.println(x[0].length);
//        
//
//        System.out.println("Original Matrix: ");
//        printMatrix();
//
        // printMatrix(adjointMatrix(matrix));
        //printMatrix(matrix, false);
        //Double[][] inv = inverseOf(matrix);
        //printMatrix(inv, false);
//        Double[][] a = new Double[][]{{1.0, 2.0, 3.0}, {0.0, 4.0, 5.0}};
//        Double[][] b = new Double[][]{{1.0, 1.0, 5.0,1.0}, {3.0, 4.0, 2.0,3.0}, {3.0, 5.0, 2.0,5.0}};
//        
//        printMatrix(productOfTwoMatrices(a, b),false);
        // System.out.println(determinant(matrix));
    }// end main

}// end class
