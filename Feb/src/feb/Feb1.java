package feb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Feb1 implements ActionListener{

    private JFrame f;
    private JButton b;
    
     public Feb1(){
        f = new JFrame("My Form");
        b = new JButton("Click");
        f.setSize(400,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);     
        f.add(b);
        
        b.addActionListener(this);

     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "OK");
    }
    
    
    public static void main(String[] args) {
        Feb1 obj = new Feb1();
        
        
    }
    
    
}// end class
