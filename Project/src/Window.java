import javax.swing.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame{
    private BufferStrategy bs;
    public Window() {
        setTitle("Fiery Dragons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();


    }
}
