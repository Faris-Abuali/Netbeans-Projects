package VisualRepresent;


import ArrayList_based.MyArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class ARListScroll extends javax.swing.JFrame {

    MyArrayList<Object> al;
    JLabel[] lbls;
    int arrayOfLabelsSize;

    public ARListScroll() {

        setLocation(200, 100);
        setTitle("Fares H.Abu Ali");

        al = new MyArrayList<>();

        initComponents();

        pnlMainInside.setPreferredSize(new Dimension(750, 430));
        pnlMenue.setVisible(false);
        lblInfo.setVisible(false);

        // createArrayListShape();
    }

    public void createArrayListShape() {

        int X_Cordinate = 40;
        int Y_Cordinate = 50;

        for (int i = 0; i < arrayOfLabelsSize; i++) {

            lbls[i] = new JLabel();
            pnlMainInside.add(lbls[i], new AbsoluteConstraints(X_Cordinate, Y_Cordinate, 59, 40));// x,y,width,height
            lbls[i].setHorizontalAlignment(0);
            //lbls[i].setText(i + "");
            lbls[i].setVisible(false);
            lbls[i].setBorder(new LineBorder(Color.black, 1));

            X_Cordinate += 60;

        }

        lbls[0].setVisible(true);
        lbls[1].setVisible(true);
        lbls[2].setVisible(true);

    }

    public void fillLabels() {

        if (al.getSize() == al.getCapacity() / 2 + 1) {

            for (int i = al.getSize() - 1; (i < al.getCapacity() && i < arrayOfLabelsSize); i++) {
                lbls[i].setVisible(true);

            }

        }

        clearLabelsTexts();
        for (int i = 0; (i < al.getSize() && i < arrayOfLabelsSize); i++) {
            lbls[i].setFont(new Font("Tahoma", 1, 14));
            lbls[i].setHorizontalAlignment(SwingConstants.CENTER);
            lbls[i].setText(al.get(i) + "");

        }

    }

    public void clearLabelsTexts() {

        for (int i = 0; i < arrayOfLabelsSize; i++) {
            lbls[i].setText("");
        }
    }

    public void clearArrayList() {

        txtValue.setText("");

        if (lbls != null) {
            for (int i = 0; i < arrayOfLabelsSize; i++) {
                lbls[i].setVisible(false);
            }
        }

        al.clear();

        pnlMenue.setVisible(false);

        lblInfo.setText("ArrayList is empty. Size=0 and Capacity is 3");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScroll = new javax.swing.JScrollPane();
        pnlMainInside = new javax.swing.JPanel();
        cmboDataType = new javax.swing.JComboBox<>();
        lblInfo2 = new javax.swing.JLabel();
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
        btnGet = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        rdbtn1 = new javax.swing.JRadioButton();
        rdbtn2 = new javax.swing.JRadioButton();
        rdbtn3 = new javax.swing.JRadioButton();
        rdbtn5 = new javax.swing.JRadioButton();
        rdbtn4 = new javax.swing.JRadioButton();
        lblInfo1 = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        cmboDataType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmboDataType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Integer", "Character", "String", "Double/Float" }));
        cmboDataType.setSelectedIndex(-1);
        cmboDataType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboDataTypeActionPerformed(evt);
            }
        });

        lblInfo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo2.setText("Choose Data Type:");
        lblInfo2.setToolTipText("");

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

        btnSet.setBackground(new java.awt.Color(0, 204, 153));
        btnSet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSet.setText("Set(index,value)");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });
        pnlMenue.add(btnSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 40));

        btnGet.setBackground(new java.awt.Color(0, 204, 153));
        btnGet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGet.setText("get(index)");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });
        pnlMenue.add(btnGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 40));

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo.setText("ArrayList is empty. Size=0 and Capacity is 3");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Visualization of The ArrayList Class");

        rdbtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn1.setText("10");
        rdbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn1ActionPerformed(evt);
            }
        });

        rdbtn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn2.setText("50");
        rdbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn2ActionPerformed(evt);
            }
        });

        rdbtn3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn3.setText("100");
        rdbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn3ActionPerformed(evt);
            }
        });

        rdbtn5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn5.setText("1000");
        rdbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn5ActionPerformed(evt);
            }
        });

        rdbtn4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbtn4.setText("500");
        rdbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn4ActionPerformed(evt);
            }
        });

        lblInfo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInfo1.setText("Choose Approximate Size of ArrayList:");
        lblInfo1.setToolTipText("");

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

        javax.swing.GroupLayout pnlMainInsideLayout = new javax.swing.GroupLayout(pnlMainInside);
        pnlMainInside.setLayout(pnlMainInsideLayout);
        pnlMainInsideLayout.setHorizontalGroup(
            pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainInsideLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlMainInsideLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlMainInsideLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlMenue, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cmboDataType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rdbtn1)
                        .addGap(13, 13, 13)
                        .addComponent(rdbtn2)
                        .addGap(13, 13, 13)
                        .addComponent(rdbtn3))
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(rdbtn4)
                        .addGap(16, 16, 16)
                        .addComponent(rdbtn5))
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlMainInsideLayout.setVerticalGroup(
            pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainInsideLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(171, 171, 171)
                .addComponent(lblInfo)
                .addGap(3, 3, 3)
                .addGroup(pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlMenue, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainInsideLayout.createSequentialGroup()
                        .addComponent(lblInfo2)
                        .addGap(13, 13, 13)
                        .addComponent(cmboDataType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblInfo1)
                        .addGap(5, 5, 5)
                        .addGroup(pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbtn1)
                            .addComponent(rdbtn2)
                            .addComponent(rdbtn3))
                        .addGap(12, 12, 12)
                        .addGroup(pnlMainInsideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbtn4)
                            .addComponent(rdbtn5))
                        .addGap(22, 22, 22)
                        .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pnlScroll.setViewportView(pnlMainInside);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmboDataTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboDataTypeActionPerformed

        System.out.println(cmboDataType.getSelectedIndex());

    }//GEN-LAST:event_cmboDataTypeActionPerformed

    private void btnAddFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFirstActionPerformed

        String value = txtValue.getText();

        if (value.length() > 0) {

            al.addFirst(value);
            //System.out.println(al);

            fillLabels();

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added in the first");
        }

        //System.out.println(al);
        lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());

        // txtArea.append(al.toString());
    }//GEN-LAST:event_btnAddFirstActionPerformed

    private void btnAddLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLastActionPerformed

        String value = txtValue.getText();

        if (value.length() > 0) {

            al.add(value);
            //System.out.println(al);
            fillLabels();

        } else {

            JOptionPane.showMessageDialog(rootPane, "Please enter the value which will be added");
        }

        // txtArea.append(al.toString());
        lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());
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

                al.add(index, value);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + al.getSize()
                            + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            fillLabels();
            lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());

        }

    }//GEN-LAST:event_btnAddByIndexActionPerformed

    private void btnRemoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFirstActionPerformed

        al.removeFirst();

        // System.out.println(al);
        fillLabels();
        lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());

    }//GEN-LAST:event_btnRemoveFirstActionPerformed

    private void btnRemoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLastActionPerformed
        al.remove();

        fillLabels();

        lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());
    }//GEN-LAST:event_btnRemoveLastActionPerformed

    private void btnRemoveByIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveByIndexActionPerformed

        String indexStr = txtIndex.getText();

        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        } else {

            int index = 0;

            try {
                index = Integer.parseInt(indexStr);

                al.remove(index);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + al.getSize()
                            + ". Index must be less than the size");
                }

            }

            fillLabels();
            lblInfo.setText("Array List is not empty  Size = " + al.getSize() + " and Capacity is " + al.getCapacity());

        }

    }//GEN-LAST:event_btnRemoveByIndexActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String value = txtValue.getText();

        int loc = -1;

        if (value.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the value you want to search for");
        } else {

            loc = al.firstOccurenceOf(value);

            if (loc == -1) {
                JOptionPane.showMessageDialog(rootPane, "The value " + value + " was not found in the list");

            } else {
                JOptionPane.showMessageDialog(rootPane, "The value " + value + " is at index " + loc + " in the list");

            }

        }

    }//GEN-LAST:event_btnSearchActionPerformed

    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        al.clear();
        clearLabelsTexts();

        //clearLabelsTexts();
    }//GEN-LAST:event_btnClearActionPerformed

    private void rdbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn1ActionPerformed
        lblInfo.setVisible(true);
        pnlMenue.setVisible(true);

        clearArrayList();
        al = new MyArrayList<>();
        System.out.println(al.getSize());
        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = Integer.parseInt(rdbtn1.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 70, 1000));

        // System.out.println(arrayOfLabelsSize);
        createArrayListShape();

        pnlMenue.setVisible(true);
    }//GEN-LAST:event_rdbtn1ActionPerformed

    private void rdbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn2ActionPerformed
        lblInfo.setVisible(true);
        pnlMenue.setVisible(true);

        clearArrayList();
        al = new MyArrayList<>();

        rdbtn1.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = Integer.parseInt(rdbtn2.getText());

        lbls = new JLabel[arrayOfLabelsSize];
        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 65, 1000));

        createArrayListShape();

        // System.out.println(arrayOfLabelsSize);
        pnlMenue.setVisible(true);

    }//GEN-LAST:event_rdbtn2ActionPerformed

    private void rdbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn3ActionPerformed
        lblInfo.setVisible(true);
        pnlMenue.setVisible(true);

        clearArrayList();
        al = new MyArrayList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn4.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = Integer.parseInt(rdbtn3.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 65, 1000));

        createArrayListShape();

        // System.out.println(arrayOfLabelsSize);
        pnlMenue.setVisible(true);

    }//GEN-LAST:event_rdbtn3ActionPerformed

    private void rdbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn5ActionPerformed

        lblInfo.setVisible(true);
        pnlMenue.setVisible(true);

        clearArrayList();
        al = new MyArrayList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn4.setSelected(false);

        arrayOfLabelsSize = Integer.parseInt(rdbtn5.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 67, 1000));

        //createQueueShape();
        //System.out.println(arrayOfLabelsSize);
        createArrayListShape();
        pnlMenue.setVisible(true);


    }//GEN-LAST:event_rdbtn5ActionPerformed

    private void rdbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn4ActionPerformed

        lblInfo.setVisible(true);
        pnlMenue.setVisible(true);

        clearArrayList();
        al = new MyArrayList<>();

        rdbtn1.setSelected(false);
        rdbtn2.setSelected(false);
        rdbtn3.setSelected(false);
        rdbtn5.setSelected(false);

        arrayOfLabelsSize = Integer.parseInt(rdbtn4.getText());
        lbls = new JLabel[arrayOfLabelsSize];

        pnlMainInside.setPreferredSize(new Dimension(arrayOfLabelsSize * 62, 1000));

        // createQueueShape();
        //System.out.println(arrayOfLabelsSize);
        createArrayListShape();

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

                al.set(index,value);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + al.getSize()
                        + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            fillLabels();

            System.out.println(al);

        }
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed

        String indexStr = txtIndex.getText();
        if (indexStr.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the index");
        }
        else {

            int index = 0;

            boolean isValidIndex = true;

            try {
                index = Integer.parseInt(indexStr);

                JOptionPane.showMessageDialog(rootPane, "the value at index "+index+" is: "+ al.get(index));

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                // isValidIndex=false;
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter a valid index, a positive integer only");
                }

                if (ex instanceof ArrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(rootPane, "Index= " + index + ", size= " + al.getSize()
                        + ". Index cannot be bigger than the size");
                }

            }

            // System.out.println(al);
            //txtArea.append(al.toString());
            fillLabels();

            System.out.println(al);

        }

    }//GEN-LAST:event_btnGetActionPerformed

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
            java.util.logging.Logger.getLogger(ARListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ARListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ARListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ARListScroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ARListScroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddByIndex;
    private javax.swing.JButton btnAddFirst;
    private javax.swing.JButton btnAddLast;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnRemoveByIndex;
    private javax.swing.JButton btnRemoveFirst;
    private javax.swing.JButton btnRemoveLast;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSet;
    private javax.swing.JComboBox<String> cmboDataType;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfo2;
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
