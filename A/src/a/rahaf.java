
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class rahaf extends JFrame implements ActionListener {

    private JLabel l;
    private JButton b;
    private JTextField t;
    private JPanel p1, p2, p3;
    boolean temp;
    int tp;
    int firstTrial;
    Random r;
    int previousNumber = 0;

    public rahaf() {

        super("Guess The Number");

        t = new JTextField(20);
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldActionPerformed(evt);
            }
        });

        l = new JLabel("I have a number between 1 and 100. Can you guess it?");
        b = new JButton("Play Again");

        b.setText("Play Again");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }

        });

        p1 = new JPanel();
        p1.add(t);

        p2 = new JPanel();
        p2.add(l);

        p3 = new JPanel();
        p3.add(b);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        setResizable(false);
        temp = true;
        Random r = new Random();
        tp = r.nextInt(100);

    }
//========================================================================

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtFieldActionPerformed(evt);
    }

    public void jButtonActionPerformed(ActionEvent evt) {
        Random r = new Random();
        tp = r.nextInt(100);
        t.setEditable(true);
        l.setText("");
    }

    private void txtFieldActionPerformed(java.awt.event.ActionEvent evt) {

        String s = t.getText();
        int tt = Integer.parseInt(s);

        if (tt < tp) {
            p2.setBackground(Color.blue);

            l.setText("Too low");

        } else if (tt > tp) {
            p2.setBackground(Color.red);

            l.setText("Too High");
        } else {
            p2.setBackground(Color.green);
            l.setText("Correct");
            t.setEditable(false);

        }

//        if (Math.abs(tp - previousNumber) < Math.abs(tp - t)) {
//            p2.setBackground(Color.blue);
//        } else {
//            p2.setBackground(Color.red);
//        }
        previousNumber = tt;

    }// end method
    //========================================================================
//    public void actionPerformed(ActionEvent e) {
//
//        if (temp == false) {
//            t.setEditable(true);
//            l.setFont(new Font("Serif", Font.BOLD, 15));
//            l.setText("I have num from 1 to 100 guess me");
//            l.setBackground(Color.WHITE);
//            temp = true;
//            tp = r.nextInt(100);
//            return;
//        }
//        
//        if (Integer.parseInt(t.getText()) == tp) {
//       
//            t.setEditable(false);
//            l.setFont(new Font("Serif", Font.BOLD, 15));
//            l.setText("Correct!");
//            l.setBackground(Color.GREEN);
//            temp = false;
//        } else if (Math.abs((Integer.parseInt(t.getText()) - tp)) < Math.abs((Integer.parseInt(t.getText()) - firstTrial))) {
//            l.setFont(new Font("Serif", Font.BOLD, 15));
//            if (Integer.parseInt(t.getText()) < tp) {
//                l.setText("Too Low!");
//            } else {
//                l.setText("Too High!");
//            }
//            l.setBackground(Color.BLUE);
//            temp = true;
//            firstTrial = Integer.parseInt(t.getText());
//        } else if (Math.abs((Integer.parseInt(t.getText()) - tp)) > Math.abs((Integer.parseInt(t.getText()) - firstTrial))) {
//
//            l.setFont(new Font("Serif", Font.BOLD, 15));
//            if (Integer.parseInt(t.getText()) < tp) {
//                l.setText("Too Low!");
//                p2.setBackground(Color.red);
//
//            } else {
//                l.setText("Too High!");
//                p2.setBackground(Color.blue);
//
//            }
//            l.setBackground(Color.RED);
//            firstTrial = Integer.parseInt(t.getText());
//            temp = true;
//        }
//
//    }// end method

    public static void main(String[] args) {
        rahaf r = new rahaf();

        r.setSize(350, 300);

        r.setVisible(true);
    }
}
