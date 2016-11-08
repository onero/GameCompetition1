import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public abstract class Character extends ScrollActor
{
    protected String name;
    protected int health;
    protected int damage;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Take damage
     */
    public void takeDamage(int damage) {
        health -= damage;
    }
}
