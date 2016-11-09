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
    private int questAmount = 0;
    private Class<?> targetEnemy = null;
    // <?> Undefined type
    
    /**
     * Creates the quest based on information parameters
     */
    public Quest(String name, String description, int amount) {
        questName = name;
        questDescription = description;
        questAmount = amount;
        
        setImage(new GreenfootImage(200, 90));
        GreenfootImage image = getImage();
    }
    
    //<T> Udefined subclass of the Enemy class
    //Generics
    public <T extends Enemy> Quest(String name, String description, int amount, Class<T> targetEnemy) {
        this(name,description,amount);
        this.targetEnemy = targetEnemy; 
        
    }
    public Quest(String name, String description, String amount) {
       //blahblah
    }
    /**
     * Act - do whatever the Quest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }    
    
    public <T extends Enemy> void sendEnemy(T enemy) {
        if (targetEnemy != null) {
            if (enemy.getClass() == targetEnemy) {
                questAmount++;
            }
        }
    }
    
    /**
     * Draw the quest image.<p>
     */
    private final void updateImage()
    {
        getImage().clear();
        //TODO ALH: Get this to work with real data!
        GreenfootImage name = new GreenfootImage(questName, 25, textColor, null);
        GreenfootImage description = new GreenfootImage(questDescription, 25, textColor, null);
        GreenfootImage amount = new GreenfootImage (Integer.toString(questAmount), 25, textColor, null);
        getImage().drawImage(name, 0, 15);
        getImage().drawImage(description, 0, 30);
        getImage().drawImage(amount, 0, 45);
    }
}
