import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CastleWorld here.
 *
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class CastleWorld extends MasterWorld
{
    Random rand = new Random();
    private MusicPlayer musicPlayer;
    public static GreenfootSound castleWorldSound;
    /**
     * Constructor for objects of class CastleWorld.
     *
     */
    public CastleWorld()
    {
        super(ZeldaWorld.PLAYABLE_AREA, ZeldaWorld.PLAYABLE_AREA, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        //Add player and information for game
        addCameraFollower(new Link(10, 5), 0, 0);
        addObject(new PlayerInfo(), 85, 15);
        //Add quest
        quest = new Quest("The Boss!", "Slay Jeppe the Forker!", 0, JeppeTheForker.class);
        addObject(quest, 450, 30);
        //Add guardian
        addObject(new Knight(10, 10), 500, 200);
        //Add boss
        addObject(new JeppeTheForker(20, 6, "trident", 6),600, 300);
     
        addObjects();
        
        //Add music
        musicPlayer = new MusicPlayer();
        castleWorldSound = new GreenfootSound(musicPlayer.getSound(3));
        castleWorldSound.play();
    }
    
    /**
     * Add objects for CastleWorld
     */
    private void addObjects() {
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 110 , i);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 110);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 1770);
        }

        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 1770 , i);
        }
    }
}
