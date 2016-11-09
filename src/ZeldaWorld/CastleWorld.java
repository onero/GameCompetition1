import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CastleWorld here.
 *
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class CastleWorld extends ScrollWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static final int GAME_AREA = 1000;
    public static final int GAME_AREA_MIN = 250;
    Random rand = new Random();
    /**
     * Constructor for objects of class CastleWorld.
     *
     */
    public CastleWorld()
    {
        super(600, 600, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        addCameraFollower(new Link(10, 5), 0, 0);
        addObject(new PlayerInfo(), 85, 15);
        addObject(new Quest("The Boss!", "Slay Jeppe the Forker!", "Find the guardian!"), 450, 30);
        addObject(new Knight(10, 10), 500, 200);
        addObject(new JeppeTheForker(20, 6, "trident", 6),600, 300);
     
        //TODO ALH: Add enemies and objects!
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 110 , i);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 110);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 1770);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 1770 , i);
        }
    }
}
