/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scientific_Calculate;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fares Abu Ali
 */
public class frameInternalTwo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frameInternalTwo
     */
    static JTextField[][] matrixOfTextFields;

    public frameInternalTwo() {
        initComponents();

    }

    public frameInternalTwo(Double[][] matrixToBeDisplayed, String title) {
        this();

        createTextFields(matrixToBeDisplayed);

        this.setTitle(title);

    }

    public void createTextFields(Double[][] matrixToBeDisplayed) {

        DecimalFormat df = new DecimalFormat("#.###");

        int initial_Y = 30;
        int initial_X = 30;

        matrixOfTextFields = new JTextField[matrixToBeDisplayed.length][matrixToBeDisplayed[0].length];

        for (int i = 0; i < matrixOfTextFields.length; i++) {
            matrixOfTextFields[i] = new JTextField[matrixOfTextFields[i].length];
        }

        //-------------------------------
        for (int i = 0; i < matrixOfTextFields.length; i++) {

            for (int j = 0; j < matrixOfTextFields[0].length; j++) {

                //when the layout is absolute, we use this:
                //jDesktopPane1.add(m[i][j], new AbsoluteConstraints(initial_X, initial_Y, 60, 30));// x,y,width,height
                matrixOfTextFields[i][j] = new JTextField();
                matrixOfTextFields[i][j].setAlignmentX(CENTER_ALIGNMENT);
                matrixOfTextFields[i][j].setFont(new Font("Thoma", 0, 16));
                matrixOfTextFields[i][j].setBounds(initial_X, initial_Y, 60, 30);

                // I don't want to allow the user to enter anything here!!!
                // I know that I could have made the fields setEnabled(false) but their look would be ugly :(
                matrixOfTextFields[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent evt) {

                        char c = evt.getKeyChar();
                        //if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE){
                            //    & c != '.' && c != '-' && !Character.isDigit(c)) 
                            //getToolkit().beep();
                            evt.consume();
                            //JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digits, '-' and '.' only!");
                        //}

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

                matrixOfTextFields[i][j].setText(df.format(matrixToBeDisplayed[i][j]) + "");
                //matrixOfTextFields[i][j].setEnabled(false);
                pnlMain.add(matrixOfTextFields[i][j]);
                matrixOfTextFields[i][j].setVisible(true);

                initial_X += 65;
            }

            initial_X = 30;
            initial_Y += 35;
        }

    }// end method

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
            //productOfMainDiagonalEntries *= sign;
            return productOfMainDiagonalEntries;

            //System.out.printf("Δ = %.2f\n", productOfMainDiagonalEntries);
        }// end else

    }// end method

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

    public static boolean isSingular(Double[][] matrix) {

        int det = determinant(matrix).intValue();

        return (det == 0);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Result");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlMain.setBackground(new java.awt.Color(255, 204, 102));
        pnlMain.setPreferredSize(new java.awt.Dimension(375, 221));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
