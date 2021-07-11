package numberconverter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Fares Abu Ali
 */
public class ConverterVisual extends javax.swing.JFrame {

    JTextField[] txtFieldArray = new JTextField[4];

    int X = 140;
    int Y = 80;
    int height = 34;
    int width = 300;
    int btnHeight = 34;
    int btnWidth = 111;

    static final int DECIMAL = 0;
    static final int BINARY = 1;
    static final int OCTAL = 2;
    static final int HEX = 3;

    JLabel[] lblArray = new JLabel[4];

    JButton[] btnConvertArray = new JButton[4];

    public ConverterVisual() {
        initComponents();

        setSize(762, 394);
        pnlMain.setSize(762, 394);
        pnlTwo.setSize(762, 394);

        setTitle("Number System Converter");

        showTextFields();
        showButtons();
        showLabels();

        pnlMain.setVisible(true);
        pnlTwo.setVisible(false);

    }// end constructor

    public void showTextFields() {

        int x = X;
        int y = Y;

        for (int i = 0; i < txtFieldArray.length; i++) {
            txtFieldArray[i] = new JTextField();
            txtFieldArray[i].setBounds(x, y, width, height);// x,y,width,height
            txtFieldArray[i].setFont(new Font("Thoma", 1, 16));

            final int index = i;
            //========================================================================
            txtFieldArray[i].addKeyListener(new KeyAdapter() {

                public void keyTyped(KeyEvent evt) {

                    char c = evt.getKeyChar();

                    switch (index) {

                        case DECIMAL:
                            if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE)
                                    && c != '.' && c != '-' && !Character.isDigit(c)) {
                                evt.consume();
                            }

                            break;

                        case BINARY:
                            if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE)
                                    && c != '.' && c != '-' && c != '0' && c != '1') {
                                evt.consume();
                            }

                            break;

                        case OCTAL:
                            if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE)
                                    && c != '.' && c != '-' && (c < '0' || c > '7')) {
                                evt.consume();
                            }

                            break;

                        case HEX:

                            c = Character.toUpperCase(c);

                            if ((c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_DELETE)
                                    && c != '.' && c != '-' && (c < 'A' || c > 'F') && !Character.isDigit(c)) {
                                evt.consume();
                            }

                            break;
                    }

//                    JTextField txtf = (JTextField) (evt.getSource());
//                    String str = txtf.getText();
//
//                    if (index == DECIMAL) {
//
//                        txtFieldArray[BINARY].setText(IntegerRepresentation.fromDecimalToBinary(str));
//                        txtFieldArray[OCTAL].setText(IntegerRepresentation.fromDecimalToOctal(str));
//                        txtFieldArray[HEX].setText(IntegerRepresentation.fromDecimalToHexa(str));
//
//                    }
                    //System.out.println(str);
                }// end method keyListener

            });
            //========================================================================

            pnlMain.add(txtFieldArray[i]);

            y += height + 10;
        }

    }

    public void showLabels() {
        int x = X - 120;
        int y = Y;

        //--------------------- Now show the labels -----------------------
        for (int i = 0; i < lblArray.length; i++) {

            lblArray[i] = new JLabel("Decimal(10) ");
            lblArray[i].setFont(new Font("Hack", 0, 14));
            lblArray[i].setBounds(x, y, width, height);// x,y,width,height
            pnlMain.add(lblArray[i]);

            y += height + 10;

        }

        lblArray[0].setText("Decimal (10)");
        lblArray[1].setText("  Binary (2)");
        lblArray[2].setText("   Octal (8)");
        lblArray[3].setText("    Hex (16)");

    }

    public void showButtons() {

        int x = X + width;
        int y = Y;

        for (int i = 0; i < btnConvertArray.length; i++) {

            btnConvertArray[i] = new JButton("CONVERT");
            btnConvertArray[i].setBounds(x, y, width, height);// x,y,width,height
            btnConvertArray[i].setFont(new Font("Gill Sans MT", 0, 16));
            btnConvertArray[i].setBounds(x, y, btnWidth, height);
            btnConvertArray[i].setBackground(Color.black);
            btnConvertArray[i].setForeground(Color.white);
            pnlMain.add(btnConvertArray[i]);
            btnConvertArray[i].setVisible(true);

            final int index = i;

            btnConvertArray[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String str = txtFieldArray[index].getText();

                    if (index == DECIMAL) {
                        txtFieldArray[BINARY].setText(IntegerRepresentation.fromDecimalToBinary(str));
                        txtFieldArray[OCTAL].setText(IntegerRepresentation.fromDecimalToOctal(str));
                        txtFieldArray[HEX].setText(IntegerRepresentation.fromDecimalToHexa(str));

                    } else if (index == BINARY) {

                        txtFieldArray[DECIMAL].setText(IntegerRepresentation.fromBinaryToDecimal(str));
                        txtFieldArray[OCTAL].setText(IntegerRepresentation.fromBinaryToOctal(str));
                        txtFieldArray[HEX].setText(IntegerRepresentation.fromBinaryToHexa(str));
                    } else if (index == OCTAL) {

                        txtFieldArray[DECIMAL].setText(IntegerRepresentation.fromOctalToDecimal(str));
                        txtFieldArray[BINARY].setText(IntegerRepresentation.fromOctalToBinary(str));
                        txtFieldArray[HEX].setText(IntegerRepresentation.fromOctalToHexa(str));
                    } else if (index == HEX) {

                        txtFieldArray[DECIMAL].setText(IntegerRepresentation.fromHexaToDecimal(str));
                        txtFieldArray[BINARY].setText(IntegerRepresentation.fromHexaToBinary(str));
                        txtFieldArray[OCTAL].setText(IntegerRepresentation.fromHexaToOctal(str));
                    }

                }
            });

            y += height + 10;
        }

    }// end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTwo = new javax.swing.JPanel();
        btnChangePnlTwo = new javax.swing.JButton();
        btnClearTwo = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnChangePnl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pnlTwo.setBackground(new java.awt.Color(255, 204, 204));
        pnlTwo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        btnChangePnlTwo.setBackground(new java.awt.Color(0, 0, 0));
        btnChangePnlTwo.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnChangePnlTwo.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePnlTwo.setText("page 1");
        btnChangePnlTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePnlTwoActionPerformed(evt);
            }
        });

        btnClearTwo.setBackground(new java.awt.Color(0, 0, 0));
        btnClearTwo.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnClearTwo.setForeground(new java.awt.Color(255, 255, 255));
        btnClearTwo.setText("CLEAR");
        btnClearTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTwoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTwoLayout = new javax.swing.GroupLayout(pnlTwo);
        pnlTwo.setLayout(pnlTwoLayout);
        pnlTwoLayout.setHorizontalGroup(
            pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTwoLayout.createSequentialGroup()
                .addContainerGap(651, Short.MAX_VALUE)
                .addGroup(pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChangePnlTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTwoLayout.setVerticalGroup(
            pnlTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTwoLayout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(btnChangePnlTwo)
                .addGap(35, 35, 35)
                .addComponent(btnClearTwo)
                .addContainerGap())
        );

        getContentPane().add(pnlTwo, "card3");

        pnlMain.setBackground(new java.awt.Color(204, 204, 255));
        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnChangePnl.setBackground(new java.awt.Color(0, 0, 0));
        btnChangePnl.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnChangePnl.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePnl.setText("page 2");
        btnChangePnl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePnlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap(698, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangePnl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(btnChangePnl)
                .addGap(68, 68, 68)
                .addComponent(btnClear)
                .addContainerGap())
        );

        getContentPane().add(pnlMain, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        for (int i = 0; i < txtFieldArray.length; i++) {
            txtFieldArray[i].setText("");
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnChangePnlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePnlActionPerformed

        if (pnlTwo.isVisible() == false) {
            pnlMain.setVisible(false);
            pnlTwo.setVisible(true);
        } else {
            pnlTwo.setVisible(false);
            pnlMain.setVisible(true);
        }

    }//GEN-LAST:event_btnChangePnlActionPerformed

    private void btnChangePnlTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePnlTwoActionPerformed

        if (pnlTwo.isVisible() == false) {
            pnlMain.setVisible(false);
            pnlTwo.setVisible(true);
        }
        else {
            pnlTwo.setVisible(false);
            pnlMain.setVisible(true);
        }
    }//GEN-LAST:event_btnChangePnlTwoActionPerformed

    private void btnClearTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearTwoActionPerformed

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
            java.util.logging.Logger.getLogger(ConverterVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConverterVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConverterVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConverterVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConverterVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePnl;
    private javax.swing.JButton btnChangePnlTwo;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearTwo;
    public javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTwo;
    // End of variables declaration//GEN-END:variables
}
