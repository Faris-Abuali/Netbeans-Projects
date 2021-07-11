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
//matrix = new Double[][]{{1.0, 2.0, 3.0, 5.0}, {6.0, 7.0, 12.0, 0.0}, {3.0, 0.0, 5.0, 11.0}}
package Scientific_Calculate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Fares Abu Ali
 */
public class KingFrame extends javax.swing.JFrame {

    /**
     * Creates new form KingFrame
     */
    static JTextField[][] matrixOfTextFields;
    public static JLabel[] arrayOfLabels;
    public static Double[][] matrixOfValues;
    static int rows = 0;
    static int cols = 0;

    static int sign = 1; // I made this for determinant() method, becasue when two rows are swapped, this affects the 

    public KingFrame() {
        initComponents();

        setResizable(false);

        setTitle("System of Linear Equations Calculator. Developed By: Fares H. AbuAli [11 Jan 2020]");
        //createTextFields();
    }

//    public void createTextFields() {
//
//        int initial_Y = 30;
//        int initial_X = 50;
//
//        matrixOfValues = new Double[rows][cols];
//
//        for (int i = 0; i < matrixOfValues.length; i++) {
//            matrixOfValues[i] = new Double[cols];
//        }
//
//        matrixOfTextFields = new JTextField[rows][cols];
//
//        for (int i = 0; i < matrixOfTextFields.length; i++) {
//            matrixOfTextFields[i] = new JTextField[cols];
//        }
//
//        arrayOfLabels = new JLabel[cols];
//        for (int i = 0; i < arrayOfLabels.length; i++) {
//            arrayOfLabels[i] = new JLabel("X" + (i + 1));
//            arrayOfLabels[i].setBounds(initial_X, initial_Y, 60, 30);
//            arrayOfLabels[i].setFont(new Font("Thoma", 0, 16));
//            arrayOfLabels[i].setForeground(Color.WHITE);
//
//            jDesktopPane1.add(arrayOfLabels[i]);
//            arrayOfLabels[i].setVisible(true);
//
//            initial_X += 65;
//        }
//
//        initial_Y += 35;
//
//        arrayOfLabels[arrayOfLabels.length - 1].setText("b");
//
//        initial_X = 30;
//
//        //-------------------------------
//        for (int i = 0; i < matrixOfTextFields.length; i++) {
//
//            for (int j = 0; j < matrixOfTextFields[0].length; j++) {
//
//                //when the layout is absolute, we use this:
//                //jDesktopPane1.add(m[i][j], new AbsoluteConstraints(initial_X, initial_Y, 60, 30));// x,y,width,height
//                matrixOfTextFields[i][j] = new JTextField();
//                KingFrame.matrixOfTextFields[i][j].addKeyListener(new KeyListener() {
//                    @Override
//                  public void keyTyped(KeyEvent evt) {
//
//                        char c = evt.getKeyChar();
//
//                            if ((c!= KeyEvent.VK_BACK_SPACE) && (c!= KeyEvent.VK_DELETE) &&
//                                    c!='.' && c!='-' && !Character.isDigit(c)) {
//                                getToolkit().beep();
//                                evt.consume();
//                                JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digits, '-' and '.' only!");
//                            }
//                        
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });
//                matrixOfTextFields[i][j].setBounds(initial_X, initial_Y, 60, 30);
//                jDesktopPane1.add(matrixOfTextFields[i][j]);
//                matrixOfTextFields[i][j].setVisible(true);
//
//                initial_X += 65;
//            }
//
//            initial_X = 30;
//            initial_Y += 35;
//        }
//
//    }// end method
    public void fillMatrixWithValuesFromTextFields() {

        for (int i = 0; i < matrixOfTextFields.length; i++) {

            for (int j = 0; j < matrixOfTextFields[0].length; j++) {

                String str = matrixOfTextFields[i][j].getText();
                if (str.length() > 0) {
                    matrixOfValues[i][j] = Double.parseDouble(str);
                }
            }
        }

        printMatrix(matrixOfValues, false);
    }// end method

    public static void printMatrix(Double[][] matrix, boolean augmented) {

        DecimalFormat df = new DecimalFormat("###.###");

        System.out.println("---------------------------------");
        txtAreaShowSolutionSteps.append("---------------------------------\n");

        for (int j = 0; j < matrix.length; j++) {
            int ctr = 0;
            for (int i = 0; i < matrix[0].length; i++) {

                if (matrix[j][i] != null) {

                    if (i < 0) {
                        System.out.printf("%.2f ", matrix[j][i]);
                        txtAreaShowSolutionSteps.append(df.format(matrix[j][i]) + " ");

                    } else {
                        System.out.printf(" %.2f ", matrix[j][i]);
                        txtAreaShowSolutionSteps.append(" " + df.format(matrix[j][i]) + " ");

                    }

                    ctr++;

                    if (augmented && ctr == matrix[j].length - 1) {
                        System.out.print(" | ");
                        txtAreaShowSolutionSteps.append(" | ");

                    }

                }
            }// end innerFor

            System.out.println();
            txtAreaShowSolutionSteps.append("\n");

        }// end outerFor
        System.out.println("---------------------------------");
        txtAreaShowSolutionSteps.append("---------------------------------\n");

    }// end method

//       public static void printMatrix() {
//
//        System.out.println("---------------------------------");
//        for (Double[] ar : matrix) {
//            int ctr = 0;
//            for (double i : ar) {
//
//                if (isInteger(i)) {
//
//                    if (i < 0) {
//                        System.out.print((int) i + " ");
//                    } else {
//                        System.out.print(" " + (int) i + " ");
//                    }
//
//                } else {
//                    if (i < 0) {
//                        System.out.printf("%.2f ", i);
//
//                    } else {
//                        System.out.printf(" %.2f ", i);
//
//                    }
//
//                }
//
//                ctr++;
//
//                if (ctr == ar.length - 1) {
//                    System.out.print("|");
//                }
//            }// end innerFor
//
//            System.out.println();
//        }// end outerFor
//        System.out.println("---------------------------------");
//
//    }
    public static boolean isInteger(double n) {

        int i = (int) n;
        return i == n;
    }

    public static void solveSystemOfEqns() {

        rowEchelonForm();
        reducedRowEchelonForm();

        if (detectInconsistency() == true) {

            System.out.println("The System is Inconsistent!!  (Has No Solution!) ");
            txtAreaShowSolutionSteps.append("The System is Inconsistent!!  (Has No Solution!) \n");
            //frameInternal.dm.addElement("The System is Inconsistent!!  (Has No Solution!)");
        } else {

            //--------------------------------------------In Case OF Free Variables---------------------------------------------------
            boolean[] leadingVariables = detectFreeVariables();
            boolean thereAreFreeVariables = false;

            for (int i = 0; i < leadingVariables.length; i++) {
                if (leadingVariables[i] == false) {
                    System.out.println("X" + (i + 1) + " is Free");
                    txtAreaShowSolutionSteps.append("X" + (i + 1) + " is Free\n");
                    //frameInternal.dm.addElement("X" + (i + 1) + " is Free");

                    thereAreFreeVariables = true;
                }
            }

            if (thereAreFreeVariables) {

                for (int row = 0; row < matrixOfValues.length; row++) {

                    boolean foundLeadingOne = false;

                    for (int col = 0; col < matrixOfValues[row].length - 1; col++) {

                        if (!foundLeadingOne && matrixOfValues[row][col] == 1) {

                            if (isInteger(matrixOfValues[row][matrixOfValues[row].length - 1])) {
                                System.out.print("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1].intValue());
                                txtAreaShowSolutionSteps.append("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1].intValue());
                                //frameInternal.dm.addElement("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1].intValue());

                            } else {
                                System.out.print("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1]);
                                txtAreaShowSolutionSteps.append("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1]);
                                //frameInternal.dm.addElement("X" + (col + 1) + " = " + matrixOfValues[row][matrixOfValues[row].length - 1]);

                            }
                            foundLeadingOne = true;
                        } else if (foundLeadingOne && matrixOfValues[row][col] != 0) {

                            if (matrixOfValues[row][col] < 0) {

                                if (isInteger(matrixOfValues[row][col])) {
                                    int temp = matrixOfValues[row][col].intValue();
                                    System.out.print(" + " + -temp + "X" + (col + 1));
                                    txtAreaShowSolutionSteps.append(" + " + -temp + "X" + (col + 1));
                                    //frameInternal.dm.addElement(" + " + -temp + "X" + (col + 1));

                                } else {
                                    System.out.print(" + " + -matrixOfValues[row][col] + "X" + (col + 1));
                                    txtAreaShowSolutionSteps.append(" + " + -matrixOfValues[row][col] + "X" + (col + 1));
                                    //frameInternal.dm.addElement(" + " + -matrixOfValues[row][col] + "X" + (col + 1));

                                }

                            } else {

                                if (isInteger(matrixOfValues[row][col])) {

                                    int temp = matrixOfValues[row][col].intValue();
                                    System.out.print(" - " + temp + "X" + (col + 1));
                                    txtAreaShowSolutionSteps.append(" - " + temp + "X" + (col + 1));
                                    //frameInternal.dm.addElement(" - " + temp + "X" + (col + 1));

                                } else {
                                    System.out.print(" - " + matrixOfValues[row][col] + "X" + (col + 1));
                                    txtAreaShowSolutionSteps.append(" - " + matrixOfValues[row][col] + "X" + (col + 1));
                                    //frameInternal.dm.addElement(" - " + matrixOfValues[row][col] + "X" + (col + 1));

                                }

                            }
                        }
                    }// end for inner

                    System.out.println();
                    txtAreaShowSolutionSteps.append("\n");

                }

            }// end free variables
            //--------------------------------------------End The Case OF Free Variables-------------------------------------------
            else {
                // the program reaches here if the sys. is consistent and there are no free variables 

                //----------------------------In Case Of Unique Solution------------------------------------------------
                Double[] X = new Double[matrixOfValues[0].length - 1];// because the last column is not for variables. It's for constants

                for (int row = 0; row < matrixOfValues.length; row++) {

                    for (int col = 0; col < matrixOfValues[row].length - 1; col++) {

                        if (matrixOfValues[row][col] == 1) {
                            X[col] = matrixOfValues[row][matrixOfValues[row].length - 1];
                            break;
                        }
                    }
                }

                //System.out.println("Solutions: "+Arrays.toString(X));
                for (int i = 0; i < X.length; i++) {

                    System.out.print("X" + (i + 1) + " = ");
                    txtAreaShowSolutionSteps.append("X" + (i + 1) + " = ");

                    System.out.printf("%.2f\n", X[i]);
                    DecimalFormat df = new DecimalFormat("#.#");
                    txtAreaShowSolutionSteps.append(df.format(X[i]) + "\n");
                    //frameInternal.dm.addElement("X" + (i + 1) + " = " + df.format(X[i]));

                }
            }// end else which is for unique solution case

            //--------------------------------------------------------------------------------------------------------
        }// end else which is for Consistent System

        determineSystemType();// this will not help in solving the matrix, just giving information of the system type

    }// end method

    public static void rowEchelonForm() {

        rearrangeRows();

        System.out.println("matrix after rearange");
        txtAreaShowSolutionSteps.append("matrix after rearange\n");

        printMatrix(matrixOfValues, true);

        for (int row = 0; row < matrixOfValues.length; row++) {

            int colIndexOfFNE = 0; // FNE = first nonzero entry

            double firstNonzeroEntry = 0;
            boolean foundFirstNonzeroEntry = false;

            for (int col = 0; col < matrixOfValues[row].length; col++) {

                if (foundFirstNonzeroEntry == false && matrixOfValues[row][col] != 0 && col < (matrixOfValues[row].length - 1)) {
// why the condition && col<(matrix[row].length-1) ?? because the last column is for augmented column 
// remeber: when you face a row in the form: [0 0 0 .... | 2]  then you cannot consider the 2 as a the firstNonzeroEntry
                    firstNonzeroEntry = matrixOfValues[row][col];
                    colIndexOfFNE = col;
                    foundFirstNonzeroEntry = true;
                }

                if (foundFirstNonzeroEntry) {
                    matrixOfValues[row][col] /= firstNonzeroEntry;
                }

            }// now the first nonzero entry in the row is 1

            //see the first nonzero entry in row #row? all entries below its column must become zero, but how?
            if (firstNonzeroEntry != 0) {
                for (int i = row + 1; i < matrixOfValues.length; i++) {

                    double pivot = matrixOfValues[i][colIndexOfFNE];  // the first nonzero entry in the ith row

                    for (int j = colIndexOfFNE; j < matrixOfValues[i].length; j++) {

                        matrixOfValues[i][j] = matrixOfValues[i][j] - (pivot * matrixOfValues[row][j]);
                        // matrix[row][j] in row #row is the corresponding entry to matrix[i][j] in row #i 

                    }
                }

            }// end if

            System.out.println("matrix directly after performing row-echelon");
            txtAreaShowSolutionSteps.append("matrix directly after performing row-echelon\n");

            printMatrix(matrixOfValues, true);

            rearrangeRows();

            System.out.println("matrix after rearranging the row-echelon");
            txtAreaShowSolutionSteps.append("matrix after rearranging the row-echelon\n");

            printMatrix(matrixOfValues, true);

        }

    }// end method

    public static void reducedRowEchelonForm() {
        //Gaussian Elimination

        // before calling reducedRowEchelonForm, make sure you have called rowEchelonForm
        for (int row = matrixOfValues.length - 1; row > 0; row--) {

            System.out.println("reducedRowEchelon");
            txtAreaShowSolutionSteps.append("reducedRowEchelon\n");

            printMatrix(matrixOfValues, true);

            int colIndexOfFNE = 0; // FNE: first nonzero entry

            double firstNonzeroEntry = 0; // this nonzero entry is sure to be 1 because I made it become 1 
            //previously in rowEchelon function
            //boolean foundFirstNonzeroEntry = false;

            for (int col = 0; col < matrixOfValues[row].length; col++) {

                if (matrixOfValues[row][col] != 0 && col < (matrixOfValues[row].length - 1)) { // or if(matrix[row][col]==1

// why the condition && col<(matrix[row].length-1) ?? because the last column is for augmented column 
// remeber: when you face a row in the form: [0 0 0 .... | 2]  then you cannot consider the 2 as a the firstNonzeroEntry
                    firstNonzeroEntry = matrixOfValues[row][col]; // here of course it will be 1 (leading one)
                    colIndexOfFNE = col; // FNE: first nonzero entry
                    //foundFirstNonzeroEntry = true;
                    break;
                }

            }// here already the first nonzero entry in the row is 1, but I need this above loop to detect the ColumnIndex
            // of this leading 1

            if (firstNonzeroEntry != 0) {
                for (int i = row - 1; i >= 0; i--) {

                    double pivot = matrixOfValues[i][colIndexOfFNE];

                    for (int j = colIndexOfFNE; j < matrixOfValues[i].length; j++) {

                        matrixOfValues[i][j] = matrixOfValues[i][j] - (pivot * matrixOfValues[row][j]);
                    }

                }

            }// end if

        }// end of outer for

        System.out.println("After Reduced Row Echelon");
        txtAreaShowSolutionSteps.append("After Reduced Row Echelon\n");
        printMatrix(matrixOfValues, true);

    }// end method

    public static void rearrangeRows() {

        // this method achieves the principle: the number of leading zeros in row k is less than or equal to 
        // the number of leading zeros in row (k+1)
        for (int i = 0; i < matrixOfValues.length - 1; i++) {

            int maxNumOfLeadingZeros = 0;
            int numOfLeadingZeros = 0;
            int rowIndex = i;

            for (int row = 0; row < matrixOfValues.length - i; row++) {

                numOfLeadingZeros = 0;

                for (int col = 0; col < matrixOfValues[row].length; col++) {

                    if (matrixOfValues[row][col] != 0) {
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
                swapRows(rowIndex, matrixOfValues.length - 1 - i);
            }
            //printMatrix();

        }// end forOuter

    }// end method

    public static void swapRows(int rowX, int rowY) {

        for (int col = 0; col < matrixOfValues[0].length; col++) {

            double temp = matrixOfValues[rowX][col];
            matrixOfValues[rowX][col] = matrixOfValues[rowY][col];

            matrixOfValues[rowY][col] = temp;
        }

    }

    public static boolean detectInconsistency() {

        // this method MUST be called only after calling reducedRowEchelon() method
        // this method detects if there's NO SOLUTION for the system
        // the system has no solution when there exists a row with all zero entries except the entry in the last column
        // is not zero.  Ex:  [ 0,0,0,.... | 3 ]
        for (int row = 0; row < matrixOfValues.length; row++) {

            boolean rowWithAllZerosDetected = true;

            // detect a row with all entries are zero except the entry in last column
            for (int col = 0; col < matrixOfValues[row].length - 1; col++) {

                if (matrixOfValues[row][col] != 0) {
                    rowWithAllZerosDetected = false;
                    break;
                }

            }// end inner for

            if (rowWithAllZerosDetected) {

                // now check the entry in the last column (the constant)
                if (matrixOfValues[row][matrixOfValues[row].length - 1] != 0) {
                    System.out.println("Inconsistent System");
                    return true; // then the system is inconsistent (has no solutuon)
                }
            }

        }// end outer for

        return false;

    }//end method

    public static void determineSystemType() {

        int numOfRows = matrixOfValues.length;
        int numOfColumns = matrixOfValues[0].length - 1; // why -1 ? because the last column is for constants (augmented matrix)

        if (numOfRows > numOfColumns) {
            System.out.println("Over-determined System: number of rows (equations) > number of columns (variables)");
            txtAreaShowSolutionSteps.append("Over-determined System: number of rows (equations) > number of columns (variables)\n");

        } else if (numOfRows < numOfColumns) {
            System.out.println("Under-determined System: number of rows (equations) < number of columns (variables)");
            txtAreaShowSolutionSteps.append("Under-determined System: number of rows (equations) < number of columns (variables)\n");

        } else {
            System.out.println("Square System: number of rows (equations) = number of columns (variables)");
            txtAreaShowSolutionSteps.append("Square System: number of rows (equations) = number of columns (variables)\n");

        }
    }//end method

    public static boolean[] detectFreeVariables() {

        // this method MUST be called only after calling reducedRowEchelon() method
        boolean[] leadingVariables = new boolean[matrixOfValues[0].length - 1]; // because the last column is for constants not variables

        for (int row = 0; row < matrixOfValues.length; row++) {

            for (int col = 0; col < matrixOfValues[row].length; col++) {

                if (matrixOfValues[row][col] == 1) {
                    leadingVariables[col] = true;
                    break;
                }
            }
        }

        return leadingVariables;

    }// end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCross2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        cmboBoxRows = new javax.swing.JComboBox<>();
        cmboBoxColumns = new javax.swing.JComboBox<>();
        lblCross = new javax.swing.JLabel();
        lblCross1 = new javax.swing.JLabel();
        btnSetMatrix = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaShowSolutionSteps = new javax.swing.JTextArea();
        lblCross4 = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        btnSetMatrix1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        lblCross2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCross2.setForeground(new java.awt.Color(255, 255, 255));
        lblCross2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCross2.setText("Matrix Dimension: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(766, 481));
        setPreferredSize(new java.awt.Dimension(766, 481));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(760, 550));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(760, 750));
        jScrollPane1.setRequestFocusEnabled(false);

        jDesktopPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(867, 781));

        cmboBoxRows.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmboBoxRows.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmboBoxRows.setSelectedIndex(-1);

        cmboBoxColumns.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmboBoxColumns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cmboBoxColumns.setSelectedIndex(-1);

        lblCross.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCross.setForeground(new java.awt.Color(255, 255, 255));
        lblCross.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCross.setText("X");

        lblCross1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCross1.setForeground(new java.awt.Color(255, 255, 255));
        lblCross1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCross1.setText("Detailed Solution:");

        btnSetMatrix.setBackground(new java.awt.Color(255, 255, 255));
        btnSetMatrix.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSetMatrix.setText("Set Matrix");
        btnSetMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetMatrixActionPerformed(evt);
            }
        });

        txtAreaShowSolutionSteps.setColumns(20);
        txtAreaShowSolutionSteps.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaShowSolutionSteps.setRows(5);
        txtAreaShowSolutionSteps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtAreaShowSolutionSteps);

        lblCross4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCross4.setForeground(new java.awt.Color(255, 255, 255));
        lblCross4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCross4.setText("Matrix Dimension: ");

        lblTitle1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle1.setText("Here You Can Solve Systems of Linear Equations Using Gauss-Jordan Elimination Algorithm.\n ");
        lblTitle1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnSetMatrix1.setBackground(new java.awt.Color(255, 255, 255));
        btnSetMatrix1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSetMatrix1.setText("Clear");
        btnSetMatrix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetMatrix1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(cmboBoxRows, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cmboBoxColumns, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblCross, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblCross1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSetMatrix, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblCross4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblTitle1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSetMatrix1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSetMatrix1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblCross4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmboBoxRows, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCross, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmboBoxColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSetMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCross1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(147, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmboBoxRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmboBoxColumns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCross, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSetMatrix)
                            .addComponent(lblCross4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(lblCross1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSetMatrix1))
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jDesktopPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 420));

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

//        //this.jDesktopPane1.removeAll();
//        //this.jDesktopPane1.repaint();
//        frameInternal persona = new frameInternal(); // make an object from the internal frame (frameInternal) class
//
//        this.jDesktopPane1.add(persona); // add that object to the jDesktopPane1 which is in the regular frame
//        persona.show();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        this.jDesktopPane1.removeAll();
//        this.jDesktopPane1.repaint();
//        
//        frameInternalTwo persona2 = new frameInternalTwo(); // make an object from the internal frame (frameInternal) class
//
//        this.jDesktopPane1.add(persona2); // add that object to the jDesktopPane1 which is in the regular frame
//        persona2.show();
//        

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnSetMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetMatrixActionPerformed
        //this.jDesktopPane1.removeAll();
        //this.jDesktopPane1.repaint();

        if (cmboBoxRows.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter The Number Of Rows!");
        } else if (cmboBoxColumns.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter The Number Of Columns!");

        } else {

            String rowsNumberStr = (String) cmboBoxRows.getSelectedItem();
            if (rowsNumberStr != null) {
                rows = Integer.parseInt(rowsNumberStr);
            }

            String colsNumberStr = (String) cmboBoxColumns.getSelectedItem();
            if (colsNumberStr != null) {
                cols = Integer.parseInt(colsNumberStr);
            }

            frameInternal persona = new frameInternal(); // make an object from the internal frame (frameInternal) class

            this.jDesktopPane1.add(persona); // add that object to the jDesktopPane1 which is in the regular frame
            persona.show();

        }

    }//GEN-LAST:event_btnSetMatrixActionPerformed

    private void btnSetMatrix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetMatrix1ActionPerformed

        txtAreaShowSolutionSteps.removeAll();
    }//GEN-LAST:event_btnSetMatrix1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetMatrix;
    private javax.swing.JButton btnSetMatrix1;
    private javax.swing.JComboBox<String> cmboBoxColumns;
    private javax.swing.JComboBox<String> cmboBoxRows;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCross;
    private javax.swing.JLabel lblCross1;
    private javax.swing.JLabel lblCross2;
    private javax.swing.JLabel lblCross4;
    private javax.swing.JLabel lblTitle1;
    public static javax.swing.JTextArea txtAreaShowSolutionSteps;
    // End of variables declaration//GEN-END:variables
}
