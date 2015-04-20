import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.net.URL;
import java.awt.Image;
import java.awt.Toolkit;

public class Character
{
    private int x = 0;
    private int y = 0;
    private Rectangle cha = new Rectangle(this.x, this.y, 20, 20);
    private Image guy = null;
    private GameRunner gr = new GameRunner();
    
    
    
    
    public void draw(Graphics2D g2)
    {
        if (guy == null)
        {
            guy = getImage("guy.png");
            
        }
        g2.drawImage(guy, this.x, this.y, 50, 50, gr);
        g2.draw(cha);
        g2.setColor(Color.BLACK);
        g2.fill(cha);
    }
    
    public Image getImage(String path)
    {
        Image tempImage = null;
        try
        {
            URL imageURL = Character.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            
        }
        catch (Exception e)
        {
            System.out.println("An error occured - " + e.getMessage());
            
        }
        return tempImage;
        
    }
    
    public void moveRight()
    {
        this.x += 100;
        
        
    }
    
    public void moveLeft()
    {
        this.x -= 100;
        
    }
}
