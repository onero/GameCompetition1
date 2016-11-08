import greenfoot.*;
import java.util.*;

/**
 * A little demo world to show you how this works.
 * 
 * @author Sven van Nigtevecht
 */
public class ZeldaWorld extends ScrollWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static DungeonWorld dungeonWorld;
    public static CastleWorld castleWorld;
    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(600, 600, 1, GAME_WIDTH, GAME_HEIGHT);
        Random rand = new Random();
        //Add worlds
        dungeonWorld = new DungeonWorld();
        castleWorld = new CastleWorld();
        //Add objects
        for (int i = 0; i < 10; i++) {
            addObject(new Rock(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Wall(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new WallWithEntrance(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
        addObject(new Dungeon(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        addObject(new Dungeon(), 600, 600); 
        
        addCameraFollower(new Link(10, 5), 0, 0);

        //addObject(new FPS(), 85, 15); // FPS isn't a subclass of
        // ScrollActor, so it will looklike it's a camera 
        addObject(new PlayerInfo(), 85, 15);
        
        //Add Enemies
        for (int i = 0; i < 10; i++) {
            addObject(new Rat(1), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Slime(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
    }
}