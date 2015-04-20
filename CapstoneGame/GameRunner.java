import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRunner extends Applet implements KeyListener
{
    private Character character;
    
    public void init()
    {
        this.addKeyListener(this);
        character = new Character();
    }
    
    public void paint(Graphics g)
    {
       setSize(500, 500);
       Graphics2D g2 = (Graphics2D)g;
       character.draw(g2);
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            character.moveRight();
        }
        
         if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            character.moveLeft();
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
