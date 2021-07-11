
import java.awt.Color;
import java.awt.Rectangle;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fares Abu Ali
 */
public class Areas extends javax.swing.JFrame {

    public Areas() {

        setTitle("Fares H. AbuAli");
        //setResizable(false);
        initComponents();

        setLocationRelativeTo(null);

        pnlRect.setVisible(false);
        pnlCircle.setVisible(false);
        pnlTriangle.setVisible(false);
        pnlSquare.setVisible(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        comboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        pnlCircle = new javax.swing.JPanel();
        txtFieldCircleRadius = new javax.swing.JTextField();
        pnl2 = new javax.swing.JLabel();
        pnlTriangle = new javax.swing.JPanel();
        txtFieldBaseTriangle = new javax.swing.JTextField();
        txtFieldHeightTriangle = new javax.swing.JTextField();
        pnl3 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlSquare = new javax.swing.JPanel();
        txtFieldSquare = new javax.swing.JTextField();
        pnl4 = new javax.swing.JLabel();
        pnlRect = new javax.swing.JPanel();
        txtFieldHeightRect = new javax.swing.JTextField();
        txtFieldWidthRect = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Area Calculator For Different Shapes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboBox.setBackground(new java.awt.Color(255, 51, 51));
        comboBox.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Circle", "Rectangle", "Triangle", "Square" }));
        comboBox.setSelectedIndex(-1);
        comboBox.setToolTipText("");
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        pnlMain.add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 139, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calculate Area");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlMain.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 39));

        pnlCircle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Circle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hack", 1, 10))); // NOI18N

        txtFieldCircleRadius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCircleRadiusActionPerformed(evt);
            }
        });

        pnl2.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        pnl2.setText("Enter Radius:");

        javax.swing.GroupLayout pnlCircleLayout = new javax.swing.GroupLayout(pnlCircle);
        pnlCircle.setLayout(pnlCircleLayout);
        pnlCircleLayout.setHorizontalGroup(
            pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCircleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldCircleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCircleLayout.setVerticalGroup(
            pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCircleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldCircleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 80));

        pnlTriangle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Triangle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 10))); // NOI18N

        txtFieldBaseTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldBaseTriangleActionPerformed(evt);
            }
        });

        txtFieldHeightTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldHeightTriangleActionPerformed(evt);
            }
        });

        pnl3.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        pnl3.setText("Enter Base:");

        lbl5.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        lbl5.setText("Enter Height:");
        lbl5.setToolTipText("");

        javax.swing.GroupLayout pnlTriangleLayout = new javax.swing.GroupLayout(pnlTriangle);
        pnlTriangle.setLayout(pnlTriangleLayout);
        pnlTriangleLayout.setHorizontalGroup(
            pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTriangleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldBaseTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldHeightTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlTriangleLayout.setVerticalGroup(
            pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTriangleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldBaseTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldHeightTriangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlMain.add(pnlTriangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lblResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlMain.add(lblResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 70, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select a shape:");
        pnlMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 20));

        pnlSquare.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Square", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hack", 1, 10))); // NOI18N
        pnlSquare.setPreferredSize(new java.awt.Dimension(262, 143));

        txtFieldSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldSquareActionPerformed(evt);
            }
        });

        pnl4.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        pnl4.setText("Enter side length:");

        javax.swing.GroupLayout pnlSquareLayout = new javax.swing.GroupLayout(pnlSquare);
        pnlSquare.setLayout(pnlSquareLayout);
        pnlSquareLayout.setHorizontalGroup(
            pnlSquareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSquareLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnl4)
                .addGap(6, 6, 6)
                .addComponent(txtFieldSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSquareLayout.setVerticalGroup(
            pnlSquareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSquareLayout.createSequentialGroup()
                .addGroup(pnlSquareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSquareLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSquareLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtFieldSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl4.getAccessibleContext().setAccessibleName("");

        pnlMain.add(pnlSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 292, 105));

        pnlRect.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rectangle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Hack", 1, 10))); // NOI18N
        pnlRect.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        pnlRect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFieldHeightRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldHeightRectActionPerformed(evt);
            }
        });
        pnlRect.add(txtFieldHeightRect, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 31, 96, 37));

        txtFieldWidthRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldWidthRectActionPerformed(evt);
            }
        });
        pnlRect.add(txtFieldWidthRect, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 86, 96, 37));

        lbl3.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        lbl3.setText("Enter Height");
        pnlRect.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 120, 28));

        lbl4.setFont(new java.awt.Font("Hack", 1, 14)); // NOI18N
        lbl4.setText("Enter Width");
        lbl4.setToolTipText("");
        pnlRect.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 91, -1, 27));

        pnlMain.add(pnlRect, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 266, 135));
        pnlRect.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed

        JComboBox temp = ((JComboBox) evt.getSource());

        pnlTriangle.setVisible(false);
        pnlRect.setVisible(false);
        pnlCircle.setVisible(false);
        pnlSquare.setVisible(false);

        txtFieldBaseTriangle.setText("");
        txtFieldHeightTriangle.setText("");
        txtFieldCircleRadius.setText("");
        txtFieldWidthRect.setText("");
        txtFieldHeightRect.setText("");
        txtFieldSquare.setText("");

        lblResult.setText("");

        if (comboBox.getSelectedIndex() == 0) { // circle

            pnlCircle.setBounds(30, 80, 240, 88);
            pnlCircle.setVisible(true);

        } else if (comboBox.getSelectedIndex() == 1) {

            // x=30, y=80
                    pnlRect.setBounds(0,0,262, 143);

          //  pnlRect.setBounds(30, 80, 262, 143);
            pnlRect.setVisible(true);

        } else if (comboBox.getSelectedIndex() == 2) {

            pnlTriangle.setBounds(new Rectangle(30, 80, 262, 143));
            pnlTriangle.setVisible(true);

        } else if (comboBox.getSelectedIndex() == 3) {

            pnlSquare.setBounds(new Rectangle(30, 80, 260, 88));
            pnlSquare.setVisible(true);
        }


    }//GEN-LAST:event_comboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        double result = 0, width = 0, height = 0, radius = 0, base = 0;

        if (comboBox.getSelectedIndex() == 0) {

            try {
                radius = Double.parseDouble(txtFieldCircleRadius.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild radius");
            }

            result = 3.14159 * radius * radius;

            lblResult.setText(String.format("%.2f", result));

        } else if (comboBox.getSelectedIndex() == 1) {

            try {
                height = Double.parseDouble(txtFieldHeightRect.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild height");
            }
            try {
                width = Double.parseDouble(txtFieldWidthRect.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild width");
            }

            result = height * width;

            lblResult.setText(String.format("%.2f", result));

        } else if (comboBox.getSelectedIndex() == 2) {

            try {
                height = Double.parseDouble(txtFieldHeightTriangle.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild height");
            }

            try {
                base = Double.parseDouble(txtFieldBaseTriangle.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild base");
            }

            result = 0.5 * height * base;

            lblResult.setText(String.format("%.2f", result));
        } else if (comboBox.getSelectedIndex() == 3) {

            try {
                base = Double.parseDouble(txtFieldSquare.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pnlMain, "Please enter a vaild side length");
            }

            result = base * base;
            lblResult.setText(String.format("%.2f", result));

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFieldCircleRadiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCircleRadiusActionPerformed


    }//GEN-LAST:event_txtFieldCircleRadiusActionPerformed

    private void txtFieldHeightRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldHeightRectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldHeightRectActionPerformed

    private void txtFieldWidthRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldWidthRectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldWidthRectActionPerformed

    private void txtFieldBaseTriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldBaseTriangleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldBaseTriangleActionPerformed

    private void txtFieldHeightTriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldHeightTriangleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldHeightTriangleActionPerformed

    private void txtFieldSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldSquareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldSquareActionPerformed

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
            java.util.logging.Logger.getLogger(Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Areas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Areas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel pnl2;
    private javax.swing.JLabel pnl3;
    private javax.swing.JLabel pnl4;
    private javax.swing.JPanel pnlCircle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRect;
    private javax.swing.JPanel pnlSquare;
    private javax.swing.JPanel pnlTriangle;
    private javax.swing.JTextField txtFieldBaseTriangle;
    private javax.swing.JTextField txtFieldCircleRadius;
    private javax.swing.JTextField txtFieldHeightRect;
    private javax.swing.JTextField txtFieldHeightTriangle;
    private javax.swing.JTextField txtFieldSquare;
    private javax.swing.JTextField txtFieldWidthRect;
    // End of variables declaration//GEN-END:variables
}