import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class GameOverWorld extends MasterWorld
{
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {
        super(ZeldaWorld.PLAYABLE_AREA, ZeldaWorld.PLAYABLE_AREA, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        MasterWorld.looseSound.play();
    }
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            MasterWorld.zeldaWorld = new ZeldaWorld();
            Greenfoot.setWorld(MasterWorld.zeldaWorld);
        }
    }
}
