package fares4th;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Fares Abu Ali
 */
public class Fares4th extends JFrame {

    JPanel pnlMain;
    final JButton[] btnArray = new JButton[9];
    int alter = 0;

    public Fares4th() {

        intitialize();

        for (int i = 0; i < 9; i++) {

            btnArray[i] = new JButton();
            pnlMain.add(btnArray[i]);

            btnArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton btnTemp = (JButton) e.getSource();

                    if (btnTemp.getText().length() > 0) {
                        if (btnTemp.getText().equals("O")) {
                            btnTemp.setText("X");
                            btnTemp.setBackground(Color.red);
                            btnTemp.setForeground(Color.white);

                            if (alter == 1) {
                                alter = 0;
                            } else {
                                alter = 1;
                            }
                        } else {
                            btnTemp.setText("O");
                            btnTemp.setBackground(Color.blue);
                            btnTemp.setForeground(Color.white);

                            if (alter == 1) {
                                alter = 0;
                            } else {
                                alter = 1;
                            }
                        }
                    } else {

                        if (alter == 0) {
                            btnTemp.setText("X");
                            alter = 1;
                            btnTemp.setBackground(Color.red);
                            btnTemp.setForeground(Color.white);
                        } else {

                            btnTemp.setText("O");
                            btnTemp.setBackground(Color.blue);
                            btnTemp.setForeground(Color.white);
                            btnTemp.setFont(new Font("Thoma", 16, 16){
                            });
                            alter = 0;

                        }

                    }

                }
            });

        }

        add(pnlMain);

    }

    private void intitialize() {
        setTitle("TicTacToe-Fares H.AbuAli 29-Sept-2019");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFont(new Font("Hacker", 12, 12));

        pnlMain = new JPanel(new GridLayout(3, 3));
        setSize(300, 450);
        //btnArray = new JButton[9];

    }

    public static void main(String[] args) {

        new Fares4th().setVisible(true);
    }

}
