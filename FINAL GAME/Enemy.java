import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class Enemy
{
    // Positions to keep track of x and y coordinates
    private int xpos = 0;
    private int ypos = 0;
    
    // Sets the speed of the enemy to 0
    private int velocity = 0;
    
    // Creates a random number between 0 and 3 in order to set random direction
    private Random gen = new Random();
    int rand = gen.nextInt(4);
    
    // Buffered image to be assigned later
    private BufferedImage img = null;

    
    public Enemy(int x, int y, int vel)
    {
        // Sets instance variables
        this.velocity = vel;
        this.xpos = x;
        this.ypos = y;
        
        // Imports enemy image
        try {
            img = ImageIO.read(new File("enemy.png"));
        } catch (IOException e) {
        }
    }
    
    public void draw(Graphics2D g2)
    {
        // Draws enemy image along with 
        Rectangle enemy = new Rectangle(this.xpos, this.ypos, 50, 50);
        g2.setColor(Color.red);
        g2.drawImage(img,this.xpos, this.ypos, null);
        g2.draw(enemy);
        
    }
    
    public void move()
    {
        
        // Assigns initial direction based upon random number between 0 - 3
        if (rand == 0)
        {
            this.xpos += this.velocity;
            this.ypos += this.velocity;
        }
        if (rand == 1)
        {
            this.xpos += this.velocity;
            this.ypos -= this.velocity;
        }
        if (rand == 2)
        {
            this.xpos -= this.velocity;
            this.ypos += this.velocity;
        }
        if (rand == 3)
        {
            this.xpos -= this.velocity;
            this.ypos -= this.velocity;
        }

        // Wraps the enemy if it goes off screen
        if (this.xpos > 650)
        {
            this.xpos = 0;
        }
        else if (this.xpos < 0)
        {
            this.xpos = 650;
        }
         if (this.ypos > 490)
        {
            this.ypos = 0;
        }
        else if (this.ypos < 0)
        {
            this.ypos = 490;
        }
    
    

    }
    
    public int getX()
    {
        return this.xpos;
    }
    
    public int getY()
    {
        return this.ypos;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(this.xpos, this.ypos, 50, 50);
    }
}
    