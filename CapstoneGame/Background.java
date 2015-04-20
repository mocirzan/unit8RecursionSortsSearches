import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background
{
    public void draw(Graphics2D g2){
        Rectangle bkg = new Rectangle(0, 0, 800, 600);
        g2.draw(bkg);
        g2.setColor(Color.GRAY);
        g2.fill(bkg);
    }
}


