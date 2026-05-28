import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener
{
    private Timer tmr;
    private final int DELAY = 50;
    private int spawnCounter = 0;
    private Image bgImage;
    private Image peashooterImg;
    private Image zombieImg;
    private Image bulletImg;

    public GamePanel()
    {
        tmr = new Timer(DELAY, this);
        tmr.start();

        bgImage = new ImageIcon("assets/background.jpg").getImage();
        peashooterImg = new ImageIcon("assets/peashooter.png").getImage();
        zombieImg = new ImageIcon("assets/zombie.png").getImage();
        bulletImg = new ImageIcon("assets/bullet.png").getImage();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                int col = clickX / (800 / 9);
                int row = clickY / (600 / 5);
                int plantX = col * (800 / 9);
                int plantY = row * (600 / 5);
                Peashooter p = new Peashooter(plantX, plantY);
                GameManager.getInstance().addPlant(p);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //update game state
        spawnCounter++;
        if (spawnCounter >= 100) { //spawn a zombie every 5 seconds
            int randomY = (int)(Math.random() * 5) * 100;
            BasicZombie z = new BasicZombie(800, randomY);
            GameManager.getInstance().addZombie(z);
            spawnCounter = 0;
        }

        for (Plant p : GameManager.getInstance().getPlants()) {
            p.update();
        }

        for(Zombie z : GameManager.getInstance().getZombies())
        {
            z.update();
        }
        for (Bullet b : GameManager.getInstance().getBullets()) {
            b.update();
        }
        for (Bullet b : GameManager.getInstance().getBullets()) {
            b.update();
        }
        
        checkCollisions();
        repaint();
    }
    public void checkCollisions() {
    ArrayList<Bullet> bullets = GameManager.getInstance().getBullets();
    ArrayList<Zombie> zombies = GameManager.getInstance().getZombies();

    for (int i = bullets.size() - 1; i >= 0; i--) {
        Bullet b = bullets.get(i);
        
        for (int j = zombies.size() - 1; j >= 0; j--) {
            Zombie z = zombies.get(j);
            if (b.getX() >= z.getX() && b.getX() <= z.getX() + 50) {
                z.takeDmg(b.getDamage());
                bullets.remove(i);
                if (z.isDead()) {
                    zombies.remove(j);
                }
                break;
            }
        }
    }
}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, 800, 600, null);
        } else {
            g.setColor(new Color(34, 139, 34));
            g.fillRect(0, 0, 800, 600);
            System.out.println("Eror: Can not load background.png");
        }
        for (Plant p : GameManager.getInstance().getPlants()) {
            g.drawImage(peashooterImg, p.getX(), p.getY(), 50, 50, null); 
        } 
        for (Zombie z : GameManager.getInstance().getZombies()) {
            g.drawImage(zombieImg, z.getX(), z.getY(), 50, 70, null);
        }
        for (Bullet b : GameManager.getInstance().getBullets()) {
            g.drawImage(bulletImg, b.getX(), b.getY(), 15, 15, null);
        }
    }
}
