import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Health here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public class PlayerInfo extends Actor
{
    private static final Color textColor = Color.BLACK;
    private static final String HEALTH_PREFIX = "Health: ";
    private static final String DAMAGE_PREFIX = "Damage: ";
    
    /**
     * Create a new the player info.
     */
    public PlayerInfo()
    {
        setImage(new GreenfootImage(150, 32));
        GreenfootImage image = getImage();
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }
    
    /**
     * Draw the image.<p>
     */
    private final void updateImage()
    {
        getImage().clear();
        //TODO ALH: Get this to work with real data!
        GreenfootImage health = new GreenfootImage(HEALTH_PREFIX + 10, 16, textColor, null);
        GreenfootImage damage = new GreenfootImage(DAMAGE_PREFIX + 5, 16, textColor, null);
        getImage().drawImage(health, 1, 1);
        getImage().drawImage(damage, 1, 15);
    }
}
