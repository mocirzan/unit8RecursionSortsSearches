import javax.swing.*;
public class TreeViewer
{
    public static void main ( String [] args ){
        JPanel panel = new JPanel();
        TreePanel tree = new TreePanel();
        panel.add(tree);
        
        JFrame frame = new JFrame();
        frame.setTitle("Tree");
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}