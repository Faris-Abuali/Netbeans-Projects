/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarea;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class Main 
{
        JTextArea area;
        JFrame frame;
        
    Main()
    {
        area = new JTextArea("PLease write your answer in this box:\n",500,500); // (rows,columns)

        frame = new JFrame();

        area.setBounds(15,50,400,400); //(x,y,width,height)
        area.setBackground(Color.DARK_GRAY);
        area.setForeground(Color.white);

       Font font = new Font("Handlee",Font.BOLD,16);
        area.setFont(font);  // object 
        
        frame.add(area);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new Main();

        
    }
}
