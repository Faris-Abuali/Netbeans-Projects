
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fares Abu Ali
 */
public class LinkedListScroll extends javax.swing.JFrame {

    JLabel[] lbls;
    int arrayOfLabelsSize;
    MySinglyLinkedList<Object> msl;

    public LinkedListScroll() {
        setLocation(200, 100);
        setTitle("Fares H.Abu Ali");

        initComponents();

        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(750, 430));
        pnlMenue.setVisible(false);

        //createLinkedListShape();
    }

    public void createLinkedListShape() {

        int X_Cordinate = 40;
        int Y_Cordinate = 90;

        for (int i = 0; i < arrayOfLabelsSize ; i++) {

            if (i % 2 == 1) {
                lbls[i] = new JLabel();
                pnlMainInside.add(lbls[i], new AbsoluteConstraints(X_Cordinate, Y_Cordinate, 59, 40));// x,y,width,height
                lbls[i].setHorizontalAlignment(0);
                lbls[i].setText("===>");
                lbls[i].setVisible(false);
            } else {
                lbls[i] = new JLabel();
                pnlMainInside.add(lbls[i], new AbsoluteConstraints(X_Cordinate, Y_Cordinate, 59, 40));// x,y,width,height
                lbls[i].setHorizontalAlignment(0);
                //lbls[i].setText(i + "");
                lbls[i].setVisible(false);
                lbls[i].setBorder(new LineBorder(Color.black, 2));
            }

            X_Cordinate += 45;

        }

    }

    public void fillLabels() {

        clearLabelsTexts();

        int j = 0;
        for (int i = 0; (j < msl.size() && j < 2 * arrayOfLabelsSize); i += 2) {

            
            lbls[i].setText(msl.get(j) + "");
            lbls[i].setFont(new Font("Tahoma", 1, 14));

            lbls[i].setVisible(true);

            if (i != 0) {
                lbls[i - 1].setVisible(true);
            }

            j++;
        }

    }

    public void clearLabelsTexts() {

        int j = 0;
        for (int i = 0; j < arrayOfLabelsSize; i += 2) {

            lbls[j].setVisible(false);

            j++;
        }

    }

    public void clearLinkedList() {

        txtValue.setText("");

        if (lbls != null) {
            for (int i = 0; i < arrayOfLabelsSize; i++) {
                lbls[i].setVisible(false);
            }
        }

        if (msl != null) {
            msl.clear();
        }

        pnlMenue.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScroll = new javax.swing.JScrollPane();
        pnlMainInside = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblInfo3 = new javax.swing.JLabel();
        cmboDataType = new javax.swing.JComboBox<>();
        lblInfo1 = new javax.swing.JLabel();
        rdbtn1 = new javax.swing.JRadioButton();
        rdbtn2 = new javax.swing.JRadioButton();
        rdbtn3 = new javax.swing.JRadioButton();
        rdbtn5 = new javax.swing.JRadioButton();
        rdbtn4 = new javax.swing.JRadioButton();
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
        btnMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlScroll.setBackground(new java.awt.Color(255, 255, 255));
        pnlScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlScroll.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlScroll.setAutoscrolls(true);
        pnlScroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlScroll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlScroll.setMaximumSize(new java.awt.Dimension(100000, 100000));
        pnlScroll.setName(""); // NOI18N
        pnlScroll.setPreferredSize(new java.awt.Dimension(1000, 100));

        pnlMainInside.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainInside.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlMainInside.setMaximumSize(new java.awt.Dimension(100000, 100000));
        pnlMainInside.setPreferredSize(new java.awt.Dimension(5000, 1000));
        pnlMainInside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Visualization of The LinkedList Class");
        pnlMainInside.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, -1));

        lblInfo3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo3.setText("Choose Data Type:");
        lblInfo3.setToolTipText("");
        pnlMainInside.add(lblInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 130, -1));

        cmboDataType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmboDataType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Integer", "Character", "String", "Double/Float" }));
        cmboDataType.setSelectedIndex(-1);
        cmboDataType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboDataTypeActionPerformed(evt);
            }
        });
        pnlMainInside.add(cmboDataType, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 170, -1));

        lblInfo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInfo1.setText("Choose Approximate Size of ArrayList:");
        lblInfo1.setToolTipText("");
        pnlMainInside.add(lblInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 230, -1));

        rdbtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn1.setText("10");
        rdbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn1ActionPerformed(evt);
            }
        });
        pnlMainInside.add(rdbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        rdbtn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn2.setText("50");
        rdbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn2ActionPerformed(evt);
            }
        });
        pnlMainInside.add(rdbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        rdbtn3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn3.setText("100");
        rdbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn3ActionPerformed(evt);
            }
        });
        pnlMainInside.add(rdbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        rdbtn5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn5.setText("1000");
        rdbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn5ActionPerformed(evt);
            }
        });
        pnlMainInside.add(rdbtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        rdbtn4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn4.setText("500");
        rdbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn4ActionPerformed(evt);
            }
        });
        pnlMainInside.add(rdbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, -1, -1));

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

        pnlMainInside.add(pnlMenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 500, 240));

        btnMainMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exitAccount.png"))); // NOI18N
        btnMainMenu.setBorder(null);
        btnMainMenu.setContentAreaFilled(false);
        btnMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMainMenuMouseReleased(evt);
            }
        });
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });
        pnlMainInside.add(btnMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 70, 70));

        pnlScroll.setViewportView(pnlMainInside);

        getContentPane().add(pnlScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmboDataTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboDataTypeActionPerformed

        System.out.println(cmboDataType.getSelectedIndex());
    }//GEN-LAST:event_cmboDataTypeActionPerformed

    private void rdbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn1ActionPerformed

        pnlMenue.setVisible(true);

        clearLinkedList();
        msl = new MySinglyLinkedList<>();

        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = 2 * Integer.parseInt(rdbtn1.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 70, 1000));

        // System.out.println(arrayOfLabelsSize);
        createLinkedListShape();

        pnlMenue.setVisible(true);
    }//GEN-LAST:event_rdbtn1ActionPerformed

    private void rdbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn2ActionPerformed

        pnlMenue.setVisible(true);

        clearLinkedList();
        msl = new MySinglyLinkedList<>();

        rdbtn1.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = 2 * Integer.parseInt(rdbtn2.getText());

        lbls = new JLabel[arrayOfLabelsSize];
        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 65, 1000));

        createLinkedListShape();

        // System.out.println(arrayOfLabelsSize);
        pnlMenue.setVisible(true);
    }//GEN-LAST:event_rdbtn2ActionPerformed

    private void rdbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn3ActionPerformed

        pnlMenue.setVisible(true);

        clearLinkedList();
        msl = new MySinglyLinkedList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = 2 * Integer.parseInt(rdbtn2.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 65, 1000));

        createLinkedListShape();

        // System.out.println(arrayOfLabelsSize);
        pnlMenue.setVisible(true);
    }//GEN-LAST:event_rdbtn3ActionPerformed

    private void rdbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn5ActionPerformed

        pnlMenue.setVisible(true);

        clearLinkedList();
        msl = new MySinglyLinkedList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);

        arrayOfLabelsSize = 2 * Integer.parseInt(rdbtn2.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 67, 1000));

        //createQueueShape();
        //System.out.println(arrayOfLabelsSize);
        createLinkedListShape();
        pnlMenue.setVisible(true);

    }//GEN-LAST:event_rdbtn5ActionPerformed

    private void rdbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn4ActionPerformed

        pnlMenue.setVisible(true);

        clearLinkedList();
        msl = new MySinglyLinkedList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = 2 * Integer.parseInt(rdbtn2.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 62, 1000));

        // createQueueShape();
        //System.out.println(arrayOfLabelsSize);
        createLinkedListShape();

        pnlMenue.setVisible(true);
    }//GEN-LAST:event_rdbtn4ActionPerformed

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

            fillLabels();

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added in the first");
        }

        System.out.println(msl);
        // txtArea.append(al.toString());
    }//GEN-LAST:event_btnAddFirstActionPerformed

    private void btnAddLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLastActionPerformed

        String value = txtValue.getText();

        if (value.length() > 0) {

            msl.addLast(value);
            //System.out.println(al);
            fillLabels();

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
            fillLabels();

            System.out.println(msl);

        }
    }//GEN-LAST:event_btnAddByIndexActionPerformed

    private void btnRemoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFirstActionPerformed

        msl.removeFirst();

        // System.out.println(al);
        fillLabels();

        System.out.println(msl);

    }//GEN-LAST:event_btnRemoveFirstActionPerformed

    private void btnRemoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLastActionPerformed
        msl.removeLast();
        fillLabels();

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

            fillLabels();

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
        clearLabelsTexts();

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
        }
            else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                msl.set(index,value);

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
            fillLabels();

            System.out.println(msl);

        }

    }//GEN-LAST:event_btnSetActionPerformed

    private void btnSet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSet1ActionPerformed
      
          String indexStr = txtIndex.getText();
        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        }
            else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                JOptionPane.showMessageDialog(rootPane, "the value at index "+index+" is: "+ msl.get(index));


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
            fillLabels();

            System.out.println(msl);

        }
        
        
        
    }//GEN-LAST:event_btnSet1ActionPerformed

    private void btnMainMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMainMenuMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMainMenuMouseReleased

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed

        MainFrame obj = new MainFrame();
        obj.setVisible(rootPaneCheckingEnabled);

        dispose();
    }//GEN-LAST:event_btnMainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(LinkedListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LinkedListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LinkedListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LinkedListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkedListScroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddByIndex;
    private javax.swing.JButton btnAddFirst;
    private javax.swing.JButton btnAddLast;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnRemoveByIndex;
    private javax.swing.JButton btnRemoveFirst;
    private javax.swing.JButton btnRemoveLast;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnSet1;
    private javax.swing.JComboBox<String> cmboDataType;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfo3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValue;
    private javax.swing.JPanel pnlMainInside;
    private javax.swing.JPanel pnlMenue;
    private javax.swing.JScrollPane pnlScroll;
    private javax.swing.JRadioButton rdbtn1;
    private javax.swing.JRadioButton rdbtn2;
    private javax.swing.JRadioButton rdbtn3;
    private javax.swing.JRadioButton rdbtn4;
    private javax.swing.JRadioButton rdbtn5;
    private javax.swing.JTextField txtIndex;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
