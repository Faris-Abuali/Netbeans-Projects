package feb;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Fares Abu Ali
 */
public class Feb3 extends JFrame{
    
    private JButton b;
    
    public Feb3(){
        
        b = new JButton("Click");
        add(b);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fares");
            }
        });
        
        
        
        
    }// end constructor
    
    
    public static void main(String[] args) {
        Feb3 gui = new Feb3(); // Feb3 extends JFrame
        
        gui.setVisible(true);
        gui.setLayout(new FlowLayout());
        // remember that the default Layout is the BorderLayout()
        gui.setSize(400,300);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);   
    }
    
    
}// end class
