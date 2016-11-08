import greenfoot.*;
import java.util.*;

/**
 * 
 * @author EASV2016 Group 12
 */
public class ZeldaWorld extends ScrollWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static DungeonWorld dungeonWorld;
    public static CastleWorld castleWorld;
    private Random rand;
    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(600, 600, 1, GAME_WIDTH, GAME_HEIGHT);
        rand = new Random();
        //Add worlds
        dungeonWorld = new DungeonWorld();
        castleWorld = new CastleWorld();

        createObjects();

        addCameraFollower(new Link(10, 5), 0, 0);

        createBosses();

        createEnemies();
        
    }

    /**
     *Create the objects
     */
    private void createObjects() {
        for (int i = 0; i < 10; i++) {
            addObject(new Rock(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Wall(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new WallWithEntrance(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
        addObject(new Dungeon(), 600, 600);
    }

    /**
     *Create the bosses
     */
    private void createBosses() {
        
        addObject(new Dungeon(), 600, 600); 
        
        addCameraFollower(new Link(10, 5), 0, 0);

        //addObject(new FPS(), 85, 15); // FPS isn't a subclass of
        // ScrollActor, so it will looklike it's a camera 
        addObject(new PlayerInfo(), 85, 15);
        addObject(new JeppeTheForker(20, 6, "trident", 6),rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        addObject(new Peter(15, 4, "sword", 4), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
    }

    /**
     *Create the Enemies
     */
    private void createEnemies() {
        for (int i = 0; i < 10; i++) {
            addObject(new Rat(5, 1), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Slime(8, 3), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
    }
}