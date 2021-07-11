package firstappgraph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JOptionPane;

public class LinkedListGraph extends javax.swing.JFrame {

    int x_CorRect;
    int y_CorRect;
    int widthForRect;
    int heightForRect;
    int arrowLength;
    int largestNumOfDigits;

    MySinglyLinkedList<Object> msl;

    public LinkedListGraph() {
        initComponents();

        x_CorRect = 20;
        y_CorRect = 60;
        widthForRect = 80;
        heightForRect = 50;
        arrowLength = 50;
        largestNumOfDigits = 1;

        msl = new MySinglyLinkedList<>();

    }

    public void resetAllCoordinates() {
        x_CorRect = 20;
        y_CorRect = 60;
        
        if(largestNumOfDigits==1)
            widthForRect=40;
        else
        widthForRect = largestNumOfDigits * 18;
        
        
        heightForRect = 50;
        arrowLength = 50;
    }

    public void setLargesNumberOfDigits(String str) {

        if (str.length() > largestNumOfDigits) {
            largestNumOfDigits = str.length();
            widthForRect = largestNumOfDigits * 18;
        }

    }

    @Override
    public void paint(Graphics gr) {

        resetAllCoordinates();
        super.paint(gr);

        for (int i = 0; i < msl.size(); i++) {

            gr.setFont(new Font("Times New Roman", 1, 20));

            //the first rectangle for the element
            gr.drawRect(x_CorRect, y_CorRect, widthForRect, heightForRect);// x , y ,width,height    

            //the second rectangle for the (Node next)
            gr.drawRect((int) (x_CorRect + (3 / 4.0) * widthForRect), y_CorRect, widthForRect / 4, heightForRect);// x , y ,width,height    
            gr.drawString(msl.get(i).toString(), x_CorRect + 5 , y_CorRect + (int) (0.5 * heightForRect));
            gr.setColor(new Color(0, 114, 187));// RGB
            gr.fillRect((int) (x_CorRect + (3 / 4.0) * widthForRect), y_CorRect, widthForRect / 4, heightForRect);

            //----------------------------------------------------
            gr.setColor(Color.black);

            //draw the body of the arrow
            gr.drawLine(x_CorRect + widthForRect, (int) (y_CorRect + (1 / 2.0) * heightForRect), x_CorRect + widthForRect + arrowLength, (int) (y_CorRect + (1 / 2.0) * heightForRect));  // x1,y1,x2,y2

            // draw the upper inclined part
            gr.drawLine((int) (x_CorRect + widthForRect + (3 / 5.0) * arrowLength), (int) (y_CorRect + 0.3 * heightForRect), x_CorRect + widthForRect + arrowLength, (int) (y_CorRect + (1 / 2.0) * heightForRect));  // x1,y1,x2,y2

            // draw the lowe inclined part
            gr.drawLine((int) (x_CorRect + widthForRect + (3 / 5.0) * arrowLength), (int) (y_CorRect + 0.7 * heightForRect), x_CorRect + widthForRect + arrowLength, (int) (y_CorRect + (1 / 2.0) * heightForRect));  // x1,y1,x2,y2

            x_CorRect += (widthForRect + arrowLength);

        }

        gr.setFont(new Font("Times New Roman", 0, 14));

        gr.drawString("null", x_CorRect + 5, y_CorRect + (int) (0.5 * heightForRect) + 5);

        System.out.println(msl);

        //gr.drawLine(20 + 80 - 15, 60 + 25 - 15, 20+80+50 ,60 + 25);  // x1,y1,x2,y2
        //gr.drawLine(210, 215, 220, 205);
        // gr.clearRect(100, 170, 80, 70);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlMenue = new javax.swing.JPanel();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        lblIndex = new javax.swing.JLabel();
        txtIndex = new javax.swing.JTextField();
        btnAddFirst = new javax.swing.JButton();
        btnAddLast = new javax.swing.JButton();
        btnAddByIndex = new javax.swing.JButton();
        btnRemoveFirst = new javax.swing.JButton();
        btnRemoveLast = new javax.swing.JButton();
        btnRemoveByIndex = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSet = new javax.swing.JButton();
        btnSet1 = new javax.swing.JButton();
        lblInfo3 = new javax.swing.JLabel();
        cmboDataType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMainMouseClicked(evt);
            }
        });
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        pnlMenue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValue.setText("Enter a value:");
        pnlMenue.add(lblValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        txtValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValueKeyTyped(evt);
            }
        });
        pnlMenue.add(txtValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, 30));

        lblIndex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIndex.setText("Enter an Index:");
        pnlMenue.add(lblIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        txtIndex.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIndex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndexKeyTyped(evt);
            }
        });
        pnlMenue.add(txtIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 90, 30));

        btnAddFirst.setBackground(new java.awt.Color(255, 51, 51));
        btnAddFirst.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnAddFirst.setText("AddFirst");
        btnAddFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFirstActionPerformed(evt);
            }
        });
        pnlMenue.add(btnAddFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 108, 40));

        btnAddLast.setBackground(new java.awt.Color(255, 51, 51));
        btnAddLast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddLast.setForeground(new java.awt.Color(255, 255, 255));
        btnAddLast.setText("Add Last");
        btnAddLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLastActionPerformed(evt);
            }
        });
        pnlMenue.add(btnAddLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 110, 40));

        btnAddByIndex.setBackground(new java.awt.Color(255, 51, 51));
        btnAddByIndex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddByIndex.setForeground(new java.awt.Color(255, 255, 255));
        btnAddByIndex.setText("Add by Index");
        btnAddByIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddByIndexActionPerformed(evt);
            }
        });
        pnlMenue.add(btnAddByIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 140, 40));

        btnRemoveFirst.setBackground(new java.awt.Color(0, 255, 255));
        btnRemoveFirst.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoveFirst.setText("Remove First");
        btnRemoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFirstActionPerformed(evt);
            }
        });
        pnlMenue.add(btnRemoveFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 40));

        btnRemoveLast.setBackground(new java.awt.Color(0, 255, 255));
        btnRemoveLast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoveLast.setText("Remove Last");
        btnRemoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveLastActionPerformed(evt);
            }
        });
        pnlMenue.add(btnRemoveLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, 40));

        btnRemoveByIndex.setBackground(new java.awt.Color(0, 255, 255));
        btnRemoveByIndex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoveByIndex.setText("Remove by Index");
        btnRemoveByIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveByIndexActionPerformed(evt);
            }
        });
        pnlMenue.add(btnRemoveByIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 140, 40));

        btnSearch.setBackground(new java.awt.Color(0, 204, 153));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlMenue.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 40));

        btnClear.setBackground(new java.awt.Color(0, 204, 153));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        pnlMenue.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 80, 40));

        btnSet.setBackground(new java.awt.Color(255, 51, 51));
        btnSet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSet.setForeground(new java.awt.Color(255, 255, 255));
        btnSet.setText("Set(index,value)");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });
        pnlMenue.add(btnSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 40));

        btnSet1.setBackground(new java.awt.Color(255, 51, 51));
        btnSet1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSet1.setForeground(new java.awt.Color(255, 255, 255));
        btnSet1.setText("get(index)");
        btnSet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSet1ActionPerformed(evt);
            }
        });
        pnlMenue.add(btnSet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 40));

        lblInfo3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo3.setText("Choose Data Type:");
        lblInfo3.setToolTipText("");
        pnlMenue.add(lblInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 130, -1));

        cmboDataType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmboDataType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Integer", "Character", "String", "Double/Float" }));
        cmboDataType.setSelectedIndex(-1);
        cmboDataType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboDataTypeActionPerformed(evt);
            }
        });
        pnlMenue.add(cmboDataType, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 170, -1));

        pnlMain.add(pnlMenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 500, 240));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked

        int x = evt.getX();
        int y = evt.getY();

        System.out.println(x + "    " + y);

    }//GEN-LAST:event_pnlMainMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        int x = evt.getX();
        int y = evt.getY();

        System.out.println(x + "    " + y);
    }//GEN-LAST:event_formMouseClicked

    private void txtValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyTyped

        char c = evt.getKeyChar();

        if (cmboDataType.getSelectedIndex() == 0) {// integer

            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                    || (c == KeyEvent.VK_DELETE))) {

                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digit only!");

            }

        } else if (cmboDataType.getSelectedIndex() == 1) {// char

            String value = txtValue.getText();

            if (value.length() > 0) {

                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(rootPane, "You are allowed to enter Characters (1 Byte) only!");
            }

        } else if (cmboDataType.getSelectedIndex() == 3) {//Double/Float

            if (c != '.' && !(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                    || (c == KeyEvent.VK_DELETE))) {

                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digits or decimal points only!");
            }

        }
    }//GEN-LAST:event_txtValueKeyTyped

    private void txtIndexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndexKeyTyped

        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "You are allowed to enter digit only!");

        }
    }//GEN-LAST:event_txtIndexKeyTyped

    private void btnAddFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFirstActionPerformed

        String value = txtValue.getText();

        if (value.length() > 0) {

            msl.addFirst(value);
            //System.out.println(al);

            setLargesNumberOfDigits(value);

            repaint();

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added in the first");
        }

        System.out.println(msl);
        // txtArea.append(al.toString());

        setLargesNumberOfDigits(value);
    }//GEN-LAST:event_btnAddFirstActionPerformed

    private void btnAddLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLastActionPerformed

        String value = txtValue.getText();

        if (value.length() > 0) {

            msl.addLast(value);
            //System.out.println(al);

            setLargesNumberOfDigits(value);

            repaint();

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added");
        }

        // txtArea.append(al.toString());
        System.out.println(msl);


    }//GEN-LAST:event_btnAddLastActionPerformed

    private void btnAddByIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddByIndexActionPerformed

        String value = txtValue.getText();

        if (value.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added");
        }

        String indexStr = txtIndex.getText();
        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        } else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                msl.add(index, value);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + msl.size()
                            + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            setLargesNumberOfDigits(value);

            repaint();

            System.out.println(msl);

            setLargesNumberOfDigits(value);

        }
    }//GEN-LAST:event_btnAddByIndexActionPerformed

    private void btnRemoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFirstActionPerformed

        msl.removeFirst();

        // System.out.println(al);
        repaint();

        System.out.println(msl);
    }//GEN-LAST:event_btnRemoveFirstActionPerformed

    private void btnRemoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLastActionPerformed
        msl.removeLast();
        repaint();

        System.out.println(msl);
    }//GEN-LAST:event_btnRemoveLastActionPerformed

    private void btnRemoveByIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveByIndexActionPerformed

        String indexStr = txtIndex.getText();

        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        } else {

            int index = 0;

            try {
                index = Integer.parseInt(indexStr);

                msl.remove(index);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + msl.size()
                            + ". Index must be less than the size");
                }

            }

            repaint();

            System.out.println(msl);

        }
    }//GEN-LAST:event_btnRemoveByIndexActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String value = txtValue.getText();

        int loc = -1;

        if (value.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the value you want to search for");
        } else {

            loc = msl.indexOf(value);

            if (loc == -1) {
                JOptionPane.showMessageDialog(rootPane, "The value " + value + " was not found in the list");

            } else {
                JOptionPane.showMessageDialog(rootPane, "The value " + value + " is at index " + loc + " in the list");

            }

        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        msl.clear();
        repaint();

        //clearLabelsTexts();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed

        String value = txtValue.getText();

        if (value.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added");
        }

        String indexStr = txtIndex.getText();
        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        } else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                msl.set(index, value);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + msl.size()
                            + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            repaint();

            System.out.println(msl);

        }
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnSet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSet1ActionPerformed

        String indexStr = txtIndex.getText();
        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        } else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                JOptionPane.showMessageDialog(rootPane, "the value at index " + index + " is: " + msl.get(index));

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + msl.size()
                            + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            repaint();

            System.out.println(msl);

        }

    }//GEN-LAST:event_btnSet1ActionPerformed

    private void cmboDataTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboDataTypeActionPerformed

        System.out.println(cmboDataType.getSelectedIndex());
    }//GEN-LAST:event_cmboDataTypeActionPerformed

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
            java.util.logging.Logger.getLogger(LinkedListGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LinkedListGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LinkedListGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LinkedListGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkedListGraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddByIndex;
    private javax.swing.JButton btnAddFirst;
    private javax.swing.JButton btnAddLast;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemoveByIndex;
    private javax.swing.JButton btnRemoveFirst;
    private javax.swing.JButton btnRemoveLast;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnSet1;
    private javax.swing.JComboBox<String> cmboDataType;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblInfo3;
    private javax.swing.JLabel lblValue;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenue;
    private javax.swing.JTextField txtIndex;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
