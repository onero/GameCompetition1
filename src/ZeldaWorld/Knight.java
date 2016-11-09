import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knight here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public class Knight extends Guardian
{
    public Knight(int protection, int health) {
        super.protection = protection;
        super.health = health;
    }
    /**
     * Act - do whatever the Knight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isNearHero()) {
           followHero();
        }
    }    
}
