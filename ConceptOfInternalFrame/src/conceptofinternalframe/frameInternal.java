/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptofinternalframe;

import static conceptofinternalframe.KingFrame.isInteger;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fares Abu Ali
 */
public class frameInternal extends javax.swing.JInternalFrame {

    //public static DefaultListModel dm = new DefaultListModel();
    /**
     * Creates new form frameInternal
     */
    // static JTextField[][] matrixOfTextFields;
    // static JLabel[] arrayOfLabels;
    //Double[][] matrixOfValues;
    public frameInternal() {
        initComponents();

        if (KingFrame.rows == KingFrame.cols) {
            btnDeterminant.setEnabled(true);
            btnAdjoint.setEnabled(true);
            btnInverse.setEnabled(true);

        }
        createTextFields();
    }

    public void createTextFields() {

        int initial_Y = 30;
        int initial_X = 50;

        int rows = KingFrame.rows;
        int cols = KingFrame.cols;

        KingFrame.matrixOfValues = new Double[rows][cols];

        for (int i = 0; i < KingFrame.matrixOfValues.length; i++) {
            KingFrame.matrixOfValues[i] = new Double[cols];
        }

        KingFrame.matrixOfTextFields = new JTextField[rows][cols];

        for (int i = 0; i < KingFrame.matrixOfTextFields.length; i++) {
            KingFrame.matrixOfTextFields[i] = new JTextField[cols];
        }

        KingFrame.arrayOfLabels = new JLabel[cols];
        for (int i = 0; i < KingFrame.arrayOfLabels.length; i++) {
            KingFrame.arrayOfLabels[i] = new JLabel("X" + (i + 1));
            KingFrame.arrayOfLabels[i].setBounds(initial_X, initial_Y, 60, 30);
            KingFrame.arrayOfLabels[i].setFont(new Font("Thoma", 0, 16));
            KingFrame.arrayOfLabels[i].setForeground(Color.WHITE);

            pnlMain.add(KingFrame.arrayOfLabels[i]);
            KingFrame.arrayOfLabels[i].setVisible(true);

            initial_X += 65;
        }

        initial_Y += 35;

        KingFrame.arrayOfLabels[KingFrame.arrayOfLabels.length - 1].setText("b");

        initial_X = 30;

        String str = null;

        //-------------------------------
        for (int i = 0; i < KingFrame.matrixOfTextFields.length; i++) {

            for (int j = 0; j < KingFrame.matrixOfTextFields[0].length; j++) {

                //when the layout is absolute, we use this:
                //jDesktopPane1.add(m[i][j], new AbsoluteConstraints(initial_X, initial_Y, 60, 30));// x,y,width,height
                KingFrame.matrixOfTextFields[i][j] = new JTextField();
                KingFrame.matrixOfTextFields[i][j].setHorizontalAlignment((int) CENTER_ALIGNMENT);             
                KingFrame.matrixOfTextFields[i][j].setFont(new Font("Thoma", 0, 16));
                KingFrame.matrixOfTextFields[i][j].addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent evt) {

                        char c = evt.getKeyChar();

                        if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE)
                                && c != '.' && c != '-' && !Character.isDigit(c)) {
                            getToolkit().beep();
                            evt.consume();
                            JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digits, '-' and '.' only!");
                        }

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                KingFrame.matrixOfTextFields[i][j].setBounds(initial_X, initial_Y, 60, 30);
                pnlMain.add(KingFrame.matrixOfTextFields[i][j]);
                KingFrame.matrixOfTextFields[i][j].setVisible(true);

                initial_X += 65;
            }

            initial_X = 30;
            initial_Y += 35;
        }

    }// end method

    public boolean fillMatrixWithValuesFromTextFields() {

        for (int i = 0; i < KingFrame.matrixOfTextFields.length; i++) {

            for (int j = 0; j < KingFrame.matrixOfTextFields[0].length; j++) {

                String str = KingFrame.matrixOfTextFields[i][j].getText();
                if (str.length() > 0) {
                    KingFrame.matrixOfValues[i][j] = Double.parseDouble(str);
                } else {
                    return false;
                }
            }
        }

        printMatrix(KingFrame.matrixOfValues, false);

        return true;
    }// end method

    public static void printMatrix(Double[][] matrix, boolean augmented) {

        System.out.println("---------------------------------");
        for (int j = 0; j < matrix.length; j++) {
            int ctr = 0;
            for (int i = 0; i < matrix[0].length; i++) {

                if (matrix[j][i] != null) {

                    if (isInteger(i)) {

                        if (i < 0) {
                            System.out.print(matrix[j][i].intValue() + " ");
                        } else {
                            System.out.print(" " + matrix[j][i].intValue() + " ");
                        }

                    } else {
                        if (i < 0) {
                            System.out.printf("%.1f ", matrix[j][i].intValue());

                        } else {
                            System.out.printf(" %.1f ", matrix[j][i].intValue());

                        }

                    }

                    ctr++;

                    if (augmented && ctr == matrix[j].length - 1) {
                        System.out.print(" | ");
                    }

                }
            }// end innerFor

            System.out.println();
        }// end outerFor
        System.out.println("---------------------------------");

    }// end method

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
        btnSolve = new javax.swing.JButton();
        btnDeterminant = new javax.swing.JButton();
        btnInverse = new javax.swing.JButton();
        btnAdjoint = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Matrix Input");
        setMinimumSize(new java.awt.Dimension(400, 400));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        pnlMain.setBackground(new java.awt.Color(102, 102, 102));
        pnlMain.setMinimumSize(new java.awt.Dimension(1000, 1000));

        btnSolve.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSolve.setText("Solve");
        btnSolve.setActionCommand("Set Matrix");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        btnDeterminant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDeterminant.setText("Determinant");
        btnDeterminant.setToolTipText("");
        btnDeterminant.setActionCommand("Set Matrix");
        btnDeterminant.setEnabled(false);
        btnDeterminant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeterminantActionPerformed(evt);
            }
        });

        btnInverse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInverse.setText("Inverse");
        btnInverse.setActionCommand("Set Matrix");
        btnInverse.setEnabled(false);
        btnInverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInverseActionPerformed(evt);
            }
        });

        btnAdjoint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdjoint.setText("adjoint");
        btnAdjoint.setActionCommand("Set Matrix");
        btnAdjoint.setEnabled(false);
        btnAdjoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjointActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeterminant, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdjoint, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInverse, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1027, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolve)
                    .addComponent(btnDeterminant)
                    .addComponent(btnAdjoint)
                    .addComponent(btnInverse))
                .addGap(0, 971, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
        boolean ok = fillMatrixWithValuesFromTextFields();

        //KingFrame.listShowSolution.setModel(dm);
        if (ok) {
            KingFrame.solveSystemOfEqns();
           // this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please fill all the entries of the matrix!");
        }
    }//GEN-LAST:event_btnSolveActionPerformed

    private void btnDeterminantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeterminantActionPerformed
        DecimalFormat df = new DecimalFormat("#.###");

        boolean ok = fillMatrixWithValuesFromTextFields();

        //KingFrame.listShowSolution.setModel(dm);
        if (ok) {
            double det = frameInternalTwo.determinant(KingFrame.matrixOfValues);

            JOptionPane.showMessageDialog(rootPane, "Determinant = " + df.format(det));
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please fill all the entries of the matrix!");
        }


    }//GEN-LAST:event_btnDeterminantActionPerformed

    private void btnInverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInverseActionPerformed

        boolean ok = fillMatrixWithValuesFromTextFields();

        //KingFrame.listShowSolution.setModel(dm);
        if (ok) {

            if (frameInternalTwo.isSingular(KingFrame.matrixOfValues)) {
                JOptionPane.showMessageDialog(rootPane, "This Matrix Is Singular (its determinant = 0), so it's not invertible");
            } 
            else {

                Double[][] matrixToBeDisplayed = frameInternalTwo.inverseOf(KingFrame.matrixOfValues);

                frameInternalTwo f2 = new frameInternalTwo(matrixToBeDisplayed, "Inverse");
                KingFrame.jDesktopPane1.add(f2);
                f2.show();

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please fill all the entries of the matrix!");
        }
    }//GEN-LAST:event_btnInverseActionPerformed

    private void btnAdjointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjointActionPerformed

        boolean ok = fillMatrixWithValuesFromTextFields();

        //KingFrame.listShowSolution.setModel(dm);
        if (ok) {
            Double[][] matrixToBeDisplayed = frameInternalTwo.adjointMatrix(KingFrame.matrixOfValues);

            frameInternalTwo f2 = new frameInternalTwo(matrixToBeDisplayed, "Adjoint");
            KingFrame.jDesktopPane1.add(f2);
            f2.show();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please fill all the entries of the matrix!");
        }
    }//GEN-LAST:event_btnAdjointActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjoint;
    private javax.swing.JButton btnDeterminant;
    private javax.swing.JButton btnInverse;
    private javax.swing.JButton btnSolve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
