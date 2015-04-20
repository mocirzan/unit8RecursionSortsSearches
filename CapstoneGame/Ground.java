import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Ground
{
    public void draw(Graphics2D g2){
        Rectangle cliff = new Rectangle(300, 500, 600, 150);
        g2.draw(cliff);
        g2.setColor(Color.BLACK);
        g2.fill(cliff);
    }
}
