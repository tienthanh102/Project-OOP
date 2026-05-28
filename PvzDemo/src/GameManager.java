import java.util.ArrayList;

public class GameManager 
{
    private static GameManager instance;
    private int sunCount;
    private ArrayList<Plant> plants;
    private ArrayList<Zombie> zombies;
    private ArrayList<Bullet> bullets;

    private GameManager()
    {
        sunCount = 1000; //initial sun count for testing
        plants = new ArrayList<>();
        zombies = new ArrayList<>();
        bullets = new ArrayList<>();
    }

    public static GameManager getInstance()
    {
        if(instance == null)
        {
            instance = new GameManager();
        }
        return instance;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
    public ArrayList<Plant> getPlants(){
        return plants;
    }

    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    public void addZombie(Zombie z)
    {
        zombies.add(z);
    }

    public void addPlant(Plant p)
    {
        if(sunCount >= p.cost){
            plants.add(p);
            sunCount -= p.cost;
        }
        else{
            System.out.println("Not enough sun to plant this plant!");
        }
    }
}
