import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Component extends JComponent 

{    
    private Background bkg = new Background();
    private Ground ground = new Ground();
    private Player player = new Player();
    private MyKeyListener listener = new MyKeyListener();
    public void Component()
    {
        addKeyListener(listener);
        setFocusable(true);
    }
    
    public void paint(Graphics g)
    {
        
        Graphics2D g2 = (Graphics2D) g;
        bkg.draw(g2);
        ground.draw(g2);
        player.draw(g2);

    }
    
    class MyKeyListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.moveRight();
            System.out.println("RIGHT");
        }
        
         if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.moveLeft();
            System.out.println("LEFT");
        }
        
        repaint();
        
    }
    
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }

    }
    
    
}
