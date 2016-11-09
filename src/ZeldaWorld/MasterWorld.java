import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MasterWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MasterWorld extends ScrollWorld
{
    protected Quest quest;
    /**
     * Constructor for objects of class MasterWorld.
     * 
     */
    public MasterWorld(int width, int height, int cellSize, int fullWidth, int fullHeight)
    {
        super(width, height, cellSize, fullWidth, fullHeight);
    }
    
    public Quest getQuest() {
        return quest;
    }
}
