public abstract class GameObject
{
    protected int x;
    protected int y;
    protected int health;

    public GameObject(int x, int y, int health)
    {
        this.x = x;
        this.y = y;
        this.health = health;
    }
    public int getX(){ return x;}
    public void setX(int x) { this.x = x;}
    public int getY(){ return y;}
    public void setY(int y) { this.y = y;}
    public abstract void update();
    public void takeDmg(int dmg)
    {
        this.health -= dmg;
    }
    public boolean isDead()
    {
        return this.health <= 0;
    }
}