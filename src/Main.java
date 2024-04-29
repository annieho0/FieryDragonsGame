import javax.swing.JFrame;


public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Fiery Dragons");

        GameBoardUI gameBoardUI= new GameBoardUI();
        window.add(gameBoardUI);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

