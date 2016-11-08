import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DungeonWorld here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public class DungeonWorld extends ScrollWorld
{

    /**
     * Constructor for objects of class DungeonWorld.
     * 
     */
    public DungeonWorld()
    {
        super(600, 400, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        addCameraFollower(new Link(10, 5), 0, 0);
        //TODO ALH: Add enemies and objects!
    }
}
