import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StigGood here.
 * 
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class StigGood extends Guardian
{
    public StigGood(int protection, int health) {
        super.protection = protection;
        super.health = health;
    }
    /**
     * Act - do whatever the StigGood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isNearHero()) {
           followHero();
        }
    }
}
