/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main 
{
   JFrame frame;
   
    
    Main()
    {
        frame =new JFrame("Combo Box");
        
       
        String []majors={"Computer","Mechanical","Electrical","Sustainable Energy","Mechatronics","Construction"};
        
        JComboBox jcb = new JComboBox(majors);  //JComboBox(array)
        
        jcb.setBounds(60, 60, 200 , 30);
        
        frame.add(jcb);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new Main();
        
    }
}
