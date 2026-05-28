public class Peashooter extends Plant
{
    public Peashooter(int x, int y)
    {
        super(x, y, 100, 100);
    }
    private int shootTimer = 0;

    @Override
    public void update()
    {
        shootTimer++;
        if (shootTimer >= 40) { 
            Bullet b = new Bullet(this.x + 40, this.y + 10, 20);
            GameManager.getInstance().addBullet(b);
            
            shootTimer = 0;
        }
    }
}
