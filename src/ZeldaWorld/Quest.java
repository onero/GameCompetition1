import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Quest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quest extends Actor
{
    private static final Color textColor = Color.BLACK;
    private String questName;
    private String questDescription;
    
    /**
     * Creates the quest based on information parameters
     */
    public Quest(String name, String description) {
        questName = name;
        questDescription = description;
        
        setImage(new GreenfootImage(150, 50));
        GreenfootImage image = getImage();
    }
    
    /**
     * Act - do whatever the Quest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }    
    
    /**
     * Draw the quest image.<p>
     */
    private final void updateImage()
    {
        getImage().clear();
        //TODO ALH: Get this to work with real data!
        GreenfootImage quest = new GreenfootImage(questName, 25, textColor, null);
        getImage().drawImage(quest, 2, 15);
    }
}
