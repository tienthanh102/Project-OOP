public class Zombie extends GameObject
{
    protected int speed;
    protected int attackDmg;
    public Zombie(int x, int y, int health, int speed, int attackDamage)
    {
        super(x, y, health);
        this.speed = speed;
        this.attackDmg = attackDamage;
    }
    @Override
    public void update()
    {
        this.x -= speed;
    }
}
