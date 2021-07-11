package feb;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Feb extends JFrame {

    public static void main(String[] args) {
        JFrame f = new JFrame("First Frame");
        f.setVisible(true);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //===============================================================
        
//        p.setBackground(Color.red);
//        f.add(p); // add the panel into the frame
//
//        JLabel label = new JLabel();
//        label.setText("Result: ");
//        p.add(label);
//
//        JButton button = new JButton("Click");
//        p.add(button);


// 3 types of Layouts: 1.Border,  2.Flow, 3.Grid

//=======BorderLayout==============================
//    JPanel p = new JPanel();
//    p.setLayout(new BorderLayout());
//    JButton b1 = new JButton("North");
//    JButton b2 = new JButton("South");
//    JButton b3 = new JButton("East");
//    JButton b4 = new JButton("West");
//    JButton b5 = new JButton("Center");
//
//    
//    p.add(b1,BorderLayout.NORTH);
//    p.add(b2,BorderLayout.SOUTH);
//    p.add(b3,BorderLayout.EAST);
//    p.add(b4,BorderLayout.WEST);
//    p.add(b5,BorderLayout.CENTER);
//    f.add(p);
//-============================================================

//=======FlowLayout==============================
//    JPanel p = new JPanel();
//    p.setLayout(new FlowLayout());
//    JButton b1 = new JButton("One");
//    JButton b2 = new JButton("Two");
//    JButton b3 = new JButton("Three");
//    JButton b4 = new JButton("Four");
//    JButton b5 = new JButton("Five");
//    JButton b6 = new JButton("Six");
//    
//    p.add(b1);
//    p.add(b2);
//    p.add(b3);
//    p.add(b4);
//    p.add(b5);
//    f.add(p);
//-============================================================

//=======GridLayout==============================
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(2,3));  // 2 rows and 3 columns
    
    JButton b1 = new JButton("One");
    JButton b2 = new JButton("Two");
    JButton b3 = new JButton("Three");
    JButton b4 = new JButton("Four");
    JButton b5 = new JButton("Five");
    JButton b6 = new JButton("Six");
    
    p.add(b1);
    p.add(b2);
    p.add(b3);
    p.add(b4);
    p.add(b5);
    f.add(p);
//-============================================================






    

    }// end main

}// end class
