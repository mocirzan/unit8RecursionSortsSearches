import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
public class Character
{
    // x and y position
    private int xpos = 0;
    private int ypos = 0;
    
    // Creates new rectangle called character
    private Rectangle character;
    
    // Creates buffered image to be assigned in construcor
    private BufferedImage img = null;

    
    public Character()
    {
        try {
            img = ImageIO.read(new File("jonah.png"));
        } catch (IOException e) {
        }
        
    }
    
     public void draw(Graphics2D g2)
    {
        
        // Draws rectangle and image with same coordinates 
        character = new Rectangle(this.xpos, this.ypos, 35, 35);
        g2.setColor(Color.black);
        g2.drawImage(img,this.xpos, this.ypos, null);
        g2.draw(character);
      
        
    }
    
    
    // increases and decreases the x and y values based on direction
    public void moveRight()
    {
        this.xpos += 3;
        
        
    }
    
    public void moveLeft()
    {
        this.xpos -= 3;
        
        
    }
    
    public void moveUp()
    {
        this.ypos -=3;
        
        
    }
    
    public void moveDown()
    {
        this.ypos += 3;
        
        
    }
    
    // Returns x and y coordinates
    public int getX()
    {
        return this.xpos;
    }

    public int getY()
    {
        return this.ypos;
    }
    
    // Returns new rectangle object with the characters size and position
    public Rectangle getBounds()
    {
        return new Rectangle(this.xpos, this.ypos, 35, 35);
    }
    
   
    
    
    
   
    
    
    
}
