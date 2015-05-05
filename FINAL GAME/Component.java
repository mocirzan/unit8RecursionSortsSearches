import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Component extends JComponent implements ActionListener{
    // Instance of character
    private Character character = new Character();
    
    // Random object
    private Random gen = new Random();
    
    // Key listnener to implement keyboard
    private MyKeyListener mkl;
    
    // Timer that updates objects on screen
    private Timer update = new Timer(15, this);
    
    // Timer used to update the score every second
    private Timer score = new Timer(1000, this);
    
    // Directional variables used to update the players position on screen
    private boolean up = false;
    private boolean right = false;
    private boolean left = false;
    private boolean down = false;
    
    // Image object for background
    private BufferedImage bkg = null;
    
    // Variable to keep track of score
    private int points = 0;
    
    // Variable that keeps the game running, stops when false
    private boolean running = true;
    
    // List of enemies to be created later on
    ArrayList<Enemy> enemies;
    
    
    public Component()
    {
        // Loads the background image
        try {
           bkg = ImageIO.read(new File("bkg.png"));
        } catch (IOException e) {
        }
        
        // Instanciates enemy list and creates 20 enemy objects with random x and y coordinates other
        // than the players current position
        enemies = new ArrayList<Enemy>();
        for (int i = 0; i < 21; i ++)
        {
            int rand = gen.nextInt(641);
            int rand2 = gen.nextInt(481);
            int charX = character.getX();
            int charY = character.getY();
            if (rand == charX || rand2 == charY)
            {
                rand = gen.nextInt(641);
                rand2 = gen.nextInt(481);
                
            }
            int vel = gen.nextInt(1)+1;
            Enemy enemy = new Enemy(rand, rand2, vel);
            enemies.add(enemy);
            
        }
        
        // Sets up key listener and starts timers 
        mkl = new MyKeyListener();
        this.addKeyListener(mkl);
        this.setFocusable(true);
        this.update.start();
        this.score.start();
        
    }
    
    
    public void paint(Graphics g)
    {
           // Casts graphics object and creates string version of score
           Graphics2D g2 = (Graphics2D) g;
           String pointsString = Integer.toString(this.points);
           
           // Checks to make sure game is running
            if (running == true)
            {
                // Draws background, character, and score
                g2.drawImage(bkg, 0, 0, null);
                character.draw(g2);
                g2.drawString(pointsString, 320, 10);
                
                // Iterates through the enemy list, draws, and instanciates movement
                for (Enemy enemy : enemies)
                {
                    enemy.draw(g2);
                    enemy.move();
                }
           }
           else
           {
               // Stops timer and creates a YOU LOSE screen displaying user's score
               this.update.stop();
               Rectangle back = new Rectangle(0, 0, 640, 480);
               g2.setColor(Color.white);
               g2.draw(back);
               g2.drawString(pointsString, 320, 240);
               System.out.println("YOU LOSE! Score: " + pointsString );
               
               
           }
    }

    
    

    public void actionPerformed(ActionEvent e){
        
            if (e.getSource() == update)
            {
                
            // Checks variables for movement and updates the characters position accordingly
            if (this.up){
                character.moveUp();
            }
            if (this.right){
                character.moveRight();
            } 
            if (this.left){
                character.moveLeft();
            }
            if (this.down){
                character.moveDown();
            }
            
            // Runs through the list of enemies and make sure there are no collisions 
            for (Enemy enemy : enemies)
            {
                if (enemy.getBounds().intersects(character.getBounds()))
                {
                    // Ends game if collision is present
                    this.running = false;
                    this.score.stop();
                }
            }

            repaint();
        }
        
        else if (e.getSource() == score)
        {
            // Updates score 
            this.points += 1;
            
        }
    }

    public class MyKeyListener implements KeyListener{
        public void keyTyped(KeyEvent e){
        }

        public void keyPressed(KeyEvent e){
           
            // Chekcs for key presses and updates directional variables
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                up = true;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                right = true;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                left = true;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                down = true;
                repaint();
            }
        }

        public void keyReleased(KeyEvent e){

            // Checks for key releases and updates directional variables
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                up = false;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                right = false;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                left = false;
                repaint();
            } 
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                down = false;
                repaint();
            }
        }
    }

}
