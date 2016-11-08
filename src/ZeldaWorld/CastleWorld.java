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

    /**
     * Constructor for objects of class CastleWorld.
     * 
     */
    public CastleWorld()
    {
        super(600, 400, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        Random rand = new Random();
        //TODO ALH: Add enemies and objects!
                for (int i = 0; i < 10; i++) {
            addObject(new Pillar(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Rock(), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Rat(2,2), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
            addObject(new Knight(20), rand.nextInt(GAME_WIDTH), rand.nextInt(GAME_HEIGHT));
        }
    }
}
