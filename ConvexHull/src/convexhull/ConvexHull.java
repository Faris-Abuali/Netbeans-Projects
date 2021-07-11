/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.*;

/*
Convex Polygon: is a polygon where all interior angles are less than 180 degrees

Convex Hull: is the SMALLEST convex polygon containing a given set of points
 */
public class ConvexHull extends javax.swing.JFrame {

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    ArrayList<Point> arlist = new ArrayList<>();

    ArrayList<Point> H = new ArrayList<>();//H is initially empty. H will hold all points in the convex hull after the algorithm is finished

  

    /**
     * Creates new form ConvexHull
     */
    public ConvexHull() {
        initComponents();
        setTitle("Find Convex Hull Using Gift-Wrapping Algorithm");
        
        setSize(1600, 900);
       
    }

    public void paint(Graphics gr) {
//
//        for(Integer key :map.keySet()){
//            gr.drawOval(key, map.get(key), 4, 4);
//            gr.fillOval(key, map.get(key), 4, 4);
// 
//        }

        for (int i = 0; i < arlist.size(); i++) {
            int x = arlist.get(i).x;
            int y = arlist.get(i).y;
            gr.drawOval(x, y, 4, 4);  // x,y,width,height
            gr.fillOval(x, y, 4, 4);
            String s = "X" + (i + 1) + "(" + x + ", " + y + ")";
            char[] c = s.toCharArray();
            gr.drawChars(c, 0, c.length, x, y - 15);  // data,offset,length,x,y
        }

//        for (i = 0; i < arlist.size() - 1; i++) {
//            gr.drawLine(arlist.get(i).x, arlist.get(i).y, arlist.get(i + 1).x, arlist.get(i + 1).y);  // x1,y1,x2,y2
//        }
        //--------------------------------------------------------------------------
    

        if (H.size() > 0) {
            for (int i = 0; i < H.size() - 1; i++) {
                gr.drawLine(H.get(i).x, H.get(i).y, H.get(i + 1).x, H.get(i + 1).y);  // x1,y1,x2,y2
            }

            gr.drawLine(H.get(0).x, H.get(0).y, H.get(H.size() - 1).x, H.get(H.size() - 1).y);  // x1,y1,x2,y2

            lblH.setText("The convex hull consists of these points: " + printListOfPoints(H));
        }

    }// end method

//    public void leftOrRight() {
//
//        Vectorr v1, v2;
//
//        v1 = new Vectorr(arlist.get(1), arlist.get(0));
//
//        for (int i = 0; i < arlist.size(); i++) {
//            v2 = new Vectorr(arlist.get(0), arlist.get(i));
//
//            if (Vectorr.crossProduct(v1, v2) > 0) {
//                leftPoints.add(arlist.get(i));
//            } else if (Vectorr.crossProduct(v1, v2) < 0) {
//                rightPoints.add(arlist.get(i));
//            }
//        }
//
//        repaint();
//
//    }// end method

    public String printListOfPoints(ArrayList<Point> arlist) {

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < arlist.size(); i++) {

            Point currPoint = arlist.get(i);

            builder.append("(" + currPoint.x + "," + currPoint.y + "), ");
        }

        String res = builder.toString();

        if (builder.length() > 2) {
            res = builder.substring(0, builder.length() - 2);
        }

        res += "]";

        return res;

    }// end method

    public void sortByX() {
        Collections.sort(arlist, new XSorter());

        System.out.println(arlist);

        int lowestY = Integer.MIN_VALUE;
        Point rightmostLowestPoint = arlist.get(arlist.size() - 1);

        //NOW the list of points is sorted by x ascending
        //===========================================RightmostLowest==========================================
//        for (int i = 0; i < arlist.size(); i++) {
//
//            int currY = arlist.get(i).y;
//
//            if (currY > lowestY) {
//                lowestY = currY;
//                rightmostLowestPoint = arlist.get(i);
//            }
//        }
        System.out.println("RightmostLowestPoint is: " + rightmostLowestPoint.getLocation());

        //===========================================LeftmostHighest==========================================
        int highestY = Integer.MAX_VALUE;
        Point leftmostHighestPoint = arlist.get(0);
//
//        for (int i = arlist.size() -1 ; i>=0 ; i--) {
//
//            int currY = arlist.get(i).y;
//
//            if (currY < highestY) {
//                highestY = currY;
//                leftmostHighestPoint = arlist.get(i);
//            }
//        }

        System.out.println("leftmostHighestPoint is: " + leftmostHighestPoint.getLocation());

    }// end method

    public Point getLeftmostPoint() {

        //sortByX();
        //Point leftmostHighestPoint = arlist.get(0);
        // O(n)
        int minX = Integer.MAX_VALUE;
        Point leftmostPoint = null;

        for (int i = 0; i < arlist.size(); i++) {

            if (arlist.get(i).x < minX) {
                minX = arlist.get(i).x;
                leftmostPoint = arlist.get(i);
            }
        }

        return leftmostPoint;

    }// end method

//    public void giftWrappingAlgo() {
//
//        arlist.add(new Point(168, 220));//x1
//        arlist.add(new Point(388, 263));//x2
//        arlist.add(new Point(470, 182));//x3
//        arlist.add(new Point(550, 95));//x4
//        arlist.add(new Point(634, 207));//x5
//        arlist.add(new Point(567, 329));//x6
//        arlist.add(new Point(296, 352));//x7
////        
//        repaint();
////
////        Vectorr temporaryVector = new Vectorr(arlist.get(0), arlist.get(3));// dashed line
////        for (int i = 0; i < arlist.size(); i++) {
////            int crossProduct = Vectorr.crossProduct(temporaryVector, new Vectorr(arlist.get(0), arlist.get(i)));
////            System.out.println("X"+(i+1)+"="+crossProduct);
////        }
//
//        Point leftmostPoint = getLeftmostPoint();
//
//        Point testingPoint = leftmostPoint;
//        H.add(testingPoint); // Of course the leftmost point will be a member of the convex hull, so add it to the set H
//        // somehow we managed to find the leftmost point. Let's call it p1, now we want to know
//        // which point is the leftmost point FROM P1'S PERSPECTIVE  
//        // so what we are going to do is to randomly pic a point and test if it is the leftmost point FROM P1'S PERSPECTIVE (O(n))
//        int i = 0;
//
//        while (i == 0 || (!testingPoint.equals(leftmostPoint) && i < arlist.size())) {
//
//            // when the testingPoint.equals(leftmostPoint) is true, this means that we have returned to the point 
//            // from which we started, so the convex hull is completed
//            Point potentialPoint = arlist.get(i);
//            boolean passedTheTest = true;
//
//            //if (!potentialPoint.equals(testingPoint)) {
//            Vectorr temporaryVector = new Vectorr(testingPoint, potentialPoint);// dashed line
//            // the temporaryVector passes the test when there're no points on left of it
//
//            for (int j = 0; j < arlist.size(); j++) {
//
//                //if (!arlist.get(j).equals(potentialPoint)) { // don't compare the endPoint of the temporaryVector with itself
//                int crossProduct = Vectorr.crossProduct(temporaryVector, new Vectorr(testingPoint, arlist.get(j)));
//
//                if (crossProduct < 0) {// then there's a point on the left of this temporaryVector  
//                    passedTheTest = false;
//                    break;
//                }
//                //}
//            }
//
//            if (passedTheTest) {
//                H.add(potentialPoint); // congrats! we have found a line that will be permanent (the convex hull will contain this border)
//                System.out.println("the point " + potentialPoint + " has been added to the H");
//                testingPoint = potentialPoint;  // now move on to the endPoint of the permanent vector 
//                i = 0;
//            }
//
//            i++;
//        }//end while
//        System.out.println("H = " + H);
//
//    }// end method
    public void giftWrappingAlgo() { // also called Jarvis-Marshall

        //--------The Best Example---------------
//        arlist.add(new Point(168, 220));//x1
//        arlist.add(new Point(388, 263));//x2
//        arlist.add(new Point(470, 182));//x3
//        arlist.add(new Point(550, 95));//x4
//        arlist.add(new Point(634, 207));//x5
//        arlist.add(new Point(567, 329));//x6
//        arlist.add(new Point(296, 352));//x7
        //------------------------------------------
        repaint();

        Point candidateP;
        Point leftmost = getLeftmostPoint();
        Point startFromP = leftmost;
        H.add(leftmost);
        boolean firstTime = true;

        for (int i = 0; i < arlist.size(); i++) {

//            if (startFromP.equals(leftmost) == true) {
//                break;
//            }
            candidateP = arlist.get(i);

            firstTime = false;

            if (startFromP.equals(candidateP)) {
                continue;
            }

            Vectorr dashedLine = new Vectorr(startFromP, candidateP);// dashed line
            boolean passedTheTest = true;

            //-------------------------------------------------------------
            int j = 0;
            while (j < arlist.size()) {

                Point currentP = arlist.get(j);

                if (startFromP.equals(currentP)) {
                    j++;
                    continue;
                }

                passedTheTest = true;

                int crossProduct = Vectorr.crossProduct(dashedLine, new Vectorr(startFromP, currentP));

                if (crossProduct < 0) {
                    passedTheTest = false;
                    break;
                }

                j++;
            }// end for
            //-------------------------------------------------------------

            if (passedTheTest) {
                System.out.println(candidateP + "passed the test");
                startFromP = candidateP;
                H.add(candidateP);
                i = 0;
            } else {
                System.out.println(candidateP + "did not pass the test");
            }

        }// end for

        System.out.println("H = " + printListOfPoints(H));

        repaint();

    }// end method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConvexHull = new javax.swing.JButton();
        lblH = new javax.swing.JLabel();
        btnConvexHull1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        btnConvexHull.setBackground(new java.awt.Color(255, 51, 51));
        btnConvexHull.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConvexHull.setForeground(new java.awt.Color(255, 255, 255));
        btnConvexHull.setText("Find Convex Hull");
        btnConvexHull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvexHullActionPerformed(evt);
            }
        });

        lblH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblH.setText("jLabel1");

        btnConvexHull1.setBackground(new java.awt.Color(255, 51, 51));
        btnConvexHull1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConvexHull1.setForeground(new java.awt.Color(255, 255, 255));
        btnConvexHull1.setText("Clear");
        btnConvexHull1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvexHull1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(646, Short.MAX_VALUE)
                        .addComponent(btnConvexHull))
                    .addComponent(lblH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConvexHull1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConvexHull)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConvexHull1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(lblH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        

        
      arlist.add(new Point(evt.getX(), evt.getY()));
        
      
        //printListOfPoints(arlist);
        // System.out.println(evt.getX()+", "+evt.getY());
        // map.put(evt.getX(), evt.getY());
        // System.out.println(map.entrySet());

        repaint();

    }//GEN-LAST:event_formMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

        char c = evt.getKeyChar();

        System.out.println((int) c);
//        if (c == KeyEvent.VK_SPACE) {
//            System.out.println("FA");
//            map.clear();
//            repaint();
//        }
    }//GEN-LAST:event_formKeyTyped

    private void btnConvexHullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvexHullActionPerformed
        //sortByX();

        //leftOrRight();
        //System.out.println(getLeftmostPoint().toString());
        //giftWrappingAlgo();
        giftWrappingAlgo();
    }//GEN-LAST:event_btnConvexHullActionPerformed

    private void btnConvexHull1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvexHull1ActionPerformed
        arlist.clear();
        repaint();
    }//GEN-LAST:event_btnConvexHull1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConvexHull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvexHull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvexHull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvexHull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvexHull().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvexHull;
    private javax.swing.JButton btnConvexHull1;
    private javax.swing.JLabel lblH;
    // End of variables declaration//GEN-END:variables
}
