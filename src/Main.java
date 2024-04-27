import javax.swing.JFrame;


public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Fiery Dragons");

        GamePanel gamePanel = new GamePanel();
        gamePanel.PictureAnimation();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}