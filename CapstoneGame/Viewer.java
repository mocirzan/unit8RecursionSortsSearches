import javax.swing.JFrame;

public class Viewer extends Component
{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        
        frame.setSize(800, 600);
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Component comp = new Component();
        frame.add(comp); 
        
        frame.setVisible(true);
    }
    
}
