import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinWorld here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public class WinWorld extends MasterWorld
{
    /**
     * Constructor for objects of class WinWorld.
     * 
     */
    public WinWorld()
    {
        super(ZeldaWorld.PLAYABLE_AREA, ZeldaWorld.PLAYABLE_AREA, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        MasterWorld.winSound.play();
    }

    public void act(){
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            MasterWorld.zeldaWorld = new ZeldaWorld();
            Greenfoot.setWorld(MasterWorld.zeldaWorld);
        }
    }
}
