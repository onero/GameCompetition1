import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MasterWorld here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public abstract class MasterWorld extends ScrollWorld
{
    protected static GameOverWorld gameOverWorld;
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
    
    /**
     * Get quest completed
     */
    public boolean getQuestCompleted() {
        return quest.getQuestCompleted();
    }
}
