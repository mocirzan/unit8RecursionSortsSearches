import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.*;

public class Viewer 
{
    // Creates instance of component
    private Component component;
    
    // Extra step in order to set the focus to the frame
    class FrameWindowListener extends WindowAdapter
    {
        public void windowOpened(WindowEvent event)
        {
            component.requestFocusInWindow();
        }
    }
    public Viewer(){
        // Creates new jFrame
        JFrame frame = new JFrame();
        
        // Creates frame that is 640 pixels by 480 pixels with title of "Game" 
        // and adds the listener to the frame
        frame.setSize(640 , 480);
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new FrameWindowListener());
        
        // Sets instance of Component equal to a new Component object and adds it to the frame
        component = new Component();
        frame.add(component);

        frame.setVisible(true);

    }

    public static void main(String [] args)
    {
        Viewer myViewer = new Viewer();

    }
}
