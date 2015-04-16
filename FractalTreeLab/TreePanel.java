import java.util.Random;
import java.lang.Math;
import java.awt.*;
import javax.swing.JPanel;



public class TreePanel extends JPanel 
{

    private int height = 600, width = 600;
    private int bx = 500;
    private int by = 800;;
    private int length = 175;
    private double angle = Math.PI/6.7;
    private double size = .75;
    private int amount = 17;
    
    /**
     * Default constructor for objects of class TreePanel
     */
    public TreePanel() 
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(1000,800));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawLine(bx, by, bx, by-length);
        drawTreeRight(g, amount, bx, by, bx, by-length,angle);
        drawTreeLeft(g, amount, bx, by, bx,by-length,0-angle);

    }

    public void drawTreeRight(Graphics g, int current, int x1, int y1, int x2, int y2, double curAngle) 
    {
        if (current == 1)
        {
            g.drawLine(x1,y1,x2,y2);
        }
        else
        {
            double cos = Math.cos(curAngle);
            double sin = Math.sin(curAngle);

            double length = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
            double lenX = sin*length*size;
            double lenY = cos*length*size;

            int dx = x2-(int)(lenX);
            int dy = y2-(int)(lenY);

            g.setColor(Color.black);
            g.drawLine(x2,y2,dx,dy);
            drawTreeRight(g, current-1, x2, y2, dx,dy, curAngle+angle);
            drawTreeLeft(g, current-1, x2, y2, dx,dy, curAngle-angle);

        }
    }

    public void drawTreeLeft(Graphics g, int current, int x1, int y1, int x2, int y2, double curAngle)
    {
        if (current == 1)
        {
            g.drawLine(x1,y1,x2,y2);
        }
        else
        {
            double cos = Math.cos(curAngle);
            double sin = Math.sin(curAngle);

            double length = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
            double lenX = sin*length*size;
            double lenY = cos*length*size;

            int dx = x2-(int)(lenX);
            int dy = y2-(int)(lenY);

            g.setColor(Color.black);
            g.drawLine(x2,y2,dx,dy);
            drawTreeLeft(g, current-1, x2, y2, dx,dy, curAngle-angle);
            drawTreeRight(g, current-1, x2, y2, dx,dy, curAngle+angle);

        }
    }
}