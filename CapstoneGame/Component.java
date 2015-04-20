import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Component extends JComponent
{    
    private Background bkg = new Background();
    private Ground ground = new Ground();
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        bkg.draw(g2);
        ground.draw(g2);
        
   
    }

}
