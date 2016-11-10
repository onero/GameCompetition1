import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DungeonWorld here.
 *
 * @author EASV2016 Group 12
 * @version (a version number or a date)
 */
public class DungeonWorld extends MasterWorld
{
    Random rand = new Random();
    private boolean castleEntranceCreated = false;
    public static CastleWorld castleWorld;
    private MusicPlayer musicPlayer;
    public static GreenfootSound dungeonWorldSound;
    /**
     * Constructor for objects of class DungeonWorld.
     *
     */
    public DungeonWorld()
    {
        super(ZeldaWorld.PLAYABLE_AREA, ZeldaWorld.PLAYABLE_AREA, 1, ZeldaWorld.GAME_WIDTH, ZeldaWorld.GAME_HEIGHT);
        //Add player and information for game
        addCameraFollower(new Link(10, 5), 0, 0);
        addObject(new PlayerInfo(), 85, 15);
        
        //Add Enemies
            addObject(new Slime(8, 3), 300, 500);
            addObject(new Slime(8, 3), 300, 1000);
            addObject(new Slime(8, 3), 900, 500);
            addObject(new Slime(8, 3), 1200, 800);
            addObject(new Slime(8, 3), 1700, 1600);
        
        addObjects();
        
        //Add quest
        quest = new Quest("Slimey!", "Slay five slimes!", 5 , Slime.class);
        addObject(quest, 500, 30);
        //Add Guardian
        addObject(new StigGood(10, 10), 1500, 300);
        
        //Add music
        musicPlayer = new MusicPlayer();
        dungeonWorldSound = new GreenfootSound(musicPlayer.getSound(2));
        dungeonWorldSound.play();
    }
    
    /**
     * Add objects to DungeonWorld
     */
    private void addObjects() {
        //Difference between CaveWalls is 30
        
        //Top line off walls
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 110 , i);
        }
        //Left line off walls
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 110);
        }
        //Button line off walls
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), i, 1770);
        }
        //Right line off walls
        for(int i = 110; i < 1771; i+=30)
        {
            addObject(new CaveWall(), 1770 , i);
        }
        // Level wall layout
        for(int i = 110; i < 1400; i+=30)
        {
            addObject(new CaveWall(), 400 , i);
        }
        for(int i = 400; i < 1400; i+=30)
        {
            addObject(new CaveWall(), i , 400);
        }
        for(int i = 800; i < 2000; i+=30)
        {
            addObject(new CaveWall(), i , 1000);
        }
        
        addObject(new CastleEntrance(), 1500, 1500);
    }
    
    /**
     * Check if we should create entrance to castleWorld
     */
    public void checkCreateCastleEntrance() {
        Quest quest = this.getQuest();
        if (quest.getQuestCompleted() == true && castleEntranceCreated == false) {
            addObject(new CastleEntrance(), 1500, 1500);
            castleEntranceCreated = true;
        }
    }
}
