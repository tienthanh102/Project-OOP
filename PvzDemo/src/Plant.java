public abstract class Plant extends GameObject
{
    protected int cost;
    public Plant(int x, int y, int health, int cost)
    {
        super(x, y, health);
        this.cost = cost;
    }
}
