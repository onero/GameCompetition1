import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DungeonWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DungeonWorld extends ScrollWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    Random rand = new Random();
    
    /**
     * Constructor for objects of class DungeonWorld.
     * 
     */
    public DungeonWorld()
    {
        super(600, 600, 1, GAME_WIDTH, GAME_HEIGHT);
        
        for(int i = 0; i < 10; i++)
        {
            addObject(new Rat(1), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
        
        addCameraFollower(new Link(10, 5), 0, 0);

        addObject(new PlayerInfo(), 85, 15);
        
        //difference between CaveWalls is 30
        
        addObject(new CaveWall(), 260, 260);
        addObject(new CaveWall(), 260, 290);
        addObject(new CaveWall(), 260, 320);
        addObject(new CaveWall(), 260, 1710);

    }
}
