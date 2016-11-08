import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DungeonWorld here.
 *
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class DungeonWorld extends ScrollWorld
{
    Random rand = new Random();

    /**
     * Constructor for objects of class DungeonWorld.
     *
     */
    public DungeonWorld()
    {
        super(600, 400, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        addCameraFollower(new Link(10, 5), 0, 0);
        for(int i = 0; i < 10; i++)
        {
            addObject(new Rat(5, 1), rand.nextInt(ZeldaWorld.GAME_WIDTH), rand.nextInt(ZeldaWorld.GAME_HEIGHT));
        }

        addCameraFollower(new Link(10, 5), 0, 0);

        addObject(new PlayerInfo(), 85, 15);

        //difference between CaveWalls is 30


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

        addObject(new CastleEntrance(), 1500, 1500);

    }
}
