import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guardian here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public abstract class Guardian extends Character
{
    protected int protection;
    /**
     * Act - do whatever the Guardian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    /**
     * Check if guardian is near Hero
     */
    public boolean isNearHero() {
        return isTouching(Link.class);
    }
    
    /**
     * Follow the Hero
     */
    public void followHero() {
        Link hero = (Link) getOneIntersectingObject(Link.class);
        setLocation(hero.getX() - 35, hero.getY());
        Link.setGuarded(true, protection);
    }
    
    /**
     * Get the protection amount
     */
    public int getProtection() {
        return protection;
    }
}
