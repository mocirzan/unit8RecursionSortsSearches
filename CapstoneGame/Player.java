import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Player
{
    private int x = 10;
    private int y = 10;
    private Rectangle player = new Rectangle(this.x, this.y, 30, 30);
    public void draw(Graphics2D g2){
        g2.draw(player);
        g2.setColor(Color.BLUE);
        g2.fill(player);
    }
    
    public void moveRight()
    {
        this.x += 10;
        
    }
    
    public void moveLeft()
    {
        this.y -= 10;
    }
}

