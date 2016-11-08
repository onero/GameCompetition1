import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GameObject extends ScrollActor
{
    protected boolean canPass = false;
    /**
     * Act - do whatever the GameObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public boolean isPassable() {
        return canPass;
    }
}
