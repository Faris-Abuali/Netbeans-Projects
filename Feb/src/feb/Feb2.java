package feb;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fares Abu Ali
 */
public class Feb2 {

    private JFrame f;
    private JButton b;
    private JTextField txt;


    class CancelActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == b){
                System.out.println("The button b was clicked");
            }
            
            if(e.getSource() == txt){
                System.out.println("The textField txt was clicked");
                System.out.println(txt.getText());
            }
            
            
            //JOptionPane.showConfirmDialog(null, "Fares");
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }// end inner class CancelActionListener

    public Feb2() {

        f = new JFrame("My Form");
        b = new JButton("Click");
        txt = new JTextField("Enter .....");
        
        f.setLayout(new FlowLayout());
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.add(b);
        f.add(txt);

        b.addActionListener(new CancelActionListener());
        txt.addActionListener(new CancelActionListener());

    }// end constructor

    public static void main(String[] args) {

        Feb2 obj = new Feb2();

    }// end main

}// end class
