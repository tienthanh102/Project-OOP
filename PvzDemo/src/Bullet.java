public class Bullet extends GameObject
{
    private int dmg;
    private int speed;
    public Bullet(int x, int y, int dmg)
    {
        super(x, y, 1);
        this.dmg = dmg;
        this.speed = 5; //Basic speed
    }

    public int getDamage(){ return dmg;}
    public int getSpeed(){ return speed;}

    @Override
    public void update()
    {
        this.x += speed;
    }
}

