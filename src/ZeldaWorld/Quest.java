import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Quest here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public class Quest extends Actor
{ 
    private static final Color textColor = Color.BLACK;
    private static final Color numberColor = Color.RED;
    private String questName;
    private String questDescription;
    private static int questAmount;
    private int questGoal;
    private Class questEnemy;
    private boolean questCompleted;
    /**
     * Creates the quest based on information parameters
     */
    public Quest(String name, String description, int amount, Class targetEnemy) {
        questName = name;
        questDescription = description;
        questAmount = 0;
        questGoal = amount;
        questCompleted = false;
        questEnemy = targetEnemy;
        setImage(new GreenfootImage(200, 90));
        GreenfootImage image = getImage();
    }
    
    /**
     * Act - do whatever the Quest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
        checkQuestComplete();
    }
    
    /**
     * Check if quest is completed
     */
    public boolean checkQuestComplete() {
        boolean complete = false;
        if (questAmount == questGoal) {
            complete = true;
            questCompleted = true;
        }
        return complete;
    }
    
    /**
     * Update quest amount
     */
    public static void updateQuestAmount() {
        questAmount++;
    }
    
    /**
     * Get quest enemy
     */
    public Class getQuestEnemy() {
        return questEnemy;
    }
    /**
     * Get the quest completed boolean
     */
    public boolean getQuestCompleted() {
        return questCompleted;
    }
    
    /**
     * Draw the quest image.<p>
     */
    private final void updateImage()
    {
        getImage().clear();
        GreenfootImage name = new GreenfootImage(questName, 25, textColor, null);
        GreenfootImage description = new GreenfootImage(questDescription, 25, textColor, null);
        GreenfootImage amount = new GreenfootImage (Integer.toString(questAmount), 25, numberColor, null);
        getImage().drawImage(name, 0, 15);
        getImage().drawImage(description, 0, 30);
        getImage().drawImage(amount, 0, 45);
    }
}
