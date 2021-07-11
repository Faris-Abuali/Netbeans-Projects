
import ArrayList_based.MyArrayList;
import java.awt.Color;
import java.awt.Font;
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
public class QueueVisualization extends javax.swing.JFrame {

    int xHead, yHead;
    int xTail, yTail;

    MyQueue<Object> q;
    JLabel[] lbls;

    public QueueVisualization() {

        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Fares H.Abu Ali");

        xHead = 45;
        yHead = 40;

        xTail = 45;
        yTail = 60;

        setLocationRelativeTo(null);

        q = new MyQueue<>();
        lbls = new JLabel[24];

        initComponents();

        createQueueShape();
    }

    public void createQueueShape() {

        lblHead.setVisible(false);
        lblTail.setVisible(false);

        int X_Cordinate = 40;
        int Y_Cordinate = 90;

        for (int i = 0; i < 24; i++) {

            if (i == 12) {
                X_Cordinate = 40;
                Y_Cordinate = 130;

            }

            lbls[i] = new JLabel();
            pnlMain.add(lbls[i], new AbsoluteConstraints(X_Cordinate, Y_Cordinate, 59, 40));// x,y,width,height
            lbls[i].setHorizontalAlignment(0);
            lbls[i].setVisible(false);
            lbls[i].setBorder(new LineBorder(Color.black, 1));

            X_Cordinate += 60;

        }

    }

    public void fillLabels() {

        lblHead.setVisible(true);
        lblTail.setVisible(true);

        for (int i = 0; (i < q.getSize() && i < 24); i++) {
            lbls[i].setFont(new Font("Tahoma", 1, 14));
            lbls[i].setHorizontalAlignment(SwingConstants.CENTER);
            lbls[i].setText(q.get(i) + "");
            lbls[i].setVisible(true);
        }

        if (q.getSize() != 1) {
            pnlMain.add(lblHead, new AbsoluteConstraints(xHead, 60, 59, 40));// x,y,width,height
        } else {
            pnlMain.add(lblHead, new AbsoluteConstraints(xHead, 40, 59, 40));// x,y,width,height

        }

        if (q.getSize() < 13) {
            yTail = 60;
            xTail = 45 + 60 * (q.getSize() - 1);
        } else if (q.getSize() == 13) {
            xTail = 45;
            yTail = 160;
        } else if (q.getSize() > 13) {
            xTail = 45 + 60 * (q.getSize() - 13);
        }
        lblTail.setVisible(true);
        pnlMain.add(lblTail, new AbsoluteConstraints(xTail, yTail, 59, 40));// x,y,width,height

        if (q.getSize() == 0) {
            lblTail.setVisible(false);
            lblHead.setVisible(false);
        }

        for (int i = q.getSize(); i < 24; i++) {
            lbls[i].setVisible(false);
        }

    }

    public void clearQueue() {

        lblHead.setVisible(false);
        lblTail.setVisible(false);

        for (int i = 0; i < 24; i++) {
            lbls[i].setVisible(false);
        }

        q.clear();

        lblInfo.setText("Queue is empty  Size = " + q.getSize());

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
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        btnEnqueue = new javax.swing.JButton();
        btnDequeue = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        lblHead = new javax.swing.JLabel();
        lblTail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(800, 400));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Visualization of The Queue Class");
        pnlMain.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, -1));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValue.setText("Enter a value:");
        jPanel2.add(lblValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        txtValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txtValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 90, 30));

        btnEnqueue.setBackground(new java.awt.Color(255, 51, 51));
        btnEnqueue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEnqueue.setForeground(new java.awt.Color(255, 255, 255));
        btnEnqueue.setText("enqueue");
        btnEnqueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnqueueActionPerformed(evt);
            }
        });
        jPanel2.add(btnEnqueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 40));

        btnDequeue.setBackground(new java.awt.Color(0, 255, 255));
        btnDequeue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDequeue.setText("dequeue");
        btnDequeue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDequeueActionPerformed(evt);
            }
        });
        jPanel2.add(btnDequeue, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, 40));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 90, 40));

        pnlMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 120));

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInfo.setText("Queue is empty");
        pnlMain.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 440, -1));

        lblHead.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHead.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHead.setText("Head");
        pnlMain.add(lblHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, 30));

        lblTail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTail.setText("Tail");
        pnlMain.add(lblTail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 30, 30));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnqueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnqueueActionPerformed

        String value = txtValue.getText();

        if (q.getSize() < 24) {
            if (value.length() > 0) {

                q.enqueue(value);
                fillLabels();
            } else {

                JOptionPane.showMessageDialog(pnlMain, "Please enter the value which will be enqueued");
            }

            if (q.getSize() > 0) {
                lblInfo.setText("Queue is not empty  Size = " + q.getSize());
            }

            System.out.println(q);
        } else {
            JOptionPane.showMessageDialog(pnlMain, "Queue is Full!");

        }
    }//GEN-LAST:event_btnEnqueueActionPerformed

    private void btnDequeueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDequeueActionPerformed

        if (q.getSize() == 0) {
            JOptionPane.showMessageDialog(pnlMain, "Queue is empty");
        } else {
            q.dequeue();
            fillLabels();

            if (q.getSize() > 0) {
                lblInfo.setText("Queue is not empty.  Size = " + q.getSize());
            }

        }
        //System.out.println(q);


    }//GEN-LAST:event_btnDequeueActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        clearQueue();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(QueueVisualization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueueVisualization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueueVisualization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueueVisualization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueueVisualization().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDequeue;
    private javax.swing.JButton btnEnqueue;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTail;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValue;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
