import javax.swing.*;

public class GameWindow extends JFrame
{
    public GameWindow()
    {
        setTitle("Plant vs Zombies");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow();
            window.setVisible(true);
        });
    }
}
