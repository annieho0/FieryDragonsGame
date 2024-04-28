import javax.swing.JFrame;


public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Fiery Dragons");

        GameUI gameUI = new GameUI();
        gameUI.PictureAnimationTitle();
        window.add(gameUI);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
 }