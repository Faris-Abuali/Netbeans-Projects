
package feb;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Example extends JFrame{
    
    JLabel l1;
    JLabel l2;
    JLabel lresult;
    JTextField txtFirstName;
    JTextField txtLastName;
    
    JButton b;
    
    public Example(){
        
         l1 = new JLabel("First Name: ");
         l2 = new JLabel("Last Name: ");
         lresult = new JLabel("");
         
         txtFirstName = new JTextField(25);
         txtLastName = new JTextField(30);
         
         b = new JButton("click");
         
         add(l1); add(txtFirstName);
         add(l2); add(txtLastName);  
         add(b); add(lresult);  
        
         b.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 lresult.setText(txtFirstName.getText() + " " + txtLastName.getText());
             }
         });
    }// end constructor
    
    
    
    public static void main(String[] args) {
           
        Example gui = new Example();
        gui.setLayout(new FlowLayout());
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setSize(400,400);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
    }// end main
    
    
    
}// end class
