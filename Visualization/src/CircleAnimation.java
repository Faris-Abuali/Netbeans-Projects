
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author Fares Abu Ali
 */
public class CircleAnimation extends JPanel {
    
    
    private int x,y;
    private int velocityX;
    private Timer t;
    
    public CircleAnimation(){
        t = new Timer(1000, new MoveListener());
        x=0;
        y=100;
        velocityX=1;
    }
    
    
    public void paintComponenet(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 20, 20); // x,y,widht,height
        
        g2.setColor(Color.magenta);
        g2.draw(circle);
        g2.fill(circle);
        
        t.restart();
        
        
        
        
    }
    
    
    private class MoveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            x+=velocityX;
        }
        
        
    }
}
