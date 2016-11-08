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

    /**
     * Constructor for objects of class CastleWorld.
     *
     */
    public CastleWorld()
    {
        super(600, 400, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        addCameraFollower(new Link(10, 5), 0, 0);
        addObject(new StigEvil(30, 5, "wand", 5), 600, 300);
        //TODO ALH: Add enemies and objects!
    }
}
