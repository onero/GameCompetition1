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

        addEnemies();

        addObjects();
        //Add quest
        quest = new Quest("Slimey!", "Slay five slimes!", 5 , Slime.class);
        addObject(quest, 500, 30);
        //Add Guardian
        addObject(new StigGood(10, 10), 300, 800);
        addObject(new StigEvil(10, 4, "", 0), 600, 200);

        //Add music
        MasterWorld.dungeonWorldSound.play();
    }

    /**
     * Add Enemies
     */
    private void addEnemies() {
        addObject(new Slime(5, 2), 300, 500);
        addObject(new Slime(5, 2), 300, 1000);
        addObject(new Slime(5, 2), 900, 500);
        addObject(new Slime(5, 2), 1200, 800);
        addObject(new Slime(5, 2), 1700, 1600);
        addObject(new Slime(5, 2), 800, 1300);
        addObject(new Slime(5, 2), 1100, 1700);
    }

    /**
     * Add objects to DungeonWorld
     */
    private void addObjects() {
        //Difference between CaveWalls is 30
        int standardMinSize = 110;
        int standardMaxSize = 1771;
        int standardOffset = 30;

        //Top line off walls
        for(int i = standardMinSize; i < standardMaxSize; i += standardOffset)
        {
            addObject(new CaveWall(), standardMinSize , i);
        }
        //Left line off walls
        for(int i = standardMinSize; i < standardMaxSize; i += standardOffset)
        {
            addObject(new CaveWall(), i, standardMinSize);
        }
        //Button line off walls
        for(int i = standardMinSize; i < standardMaxSize; i += standardOffset)
        {
            addObject(new CaveWall(), i, 1770);
        }
        //Right line off walls
        for(int i = standardMinSize; i < standardMaxSize; i += standardOffset)
        {
            addObject(new CaveWall(), 1770 , i);
        }
        // Level wall layout
        for(int i = standardMinSize; i < 1400; i += standardOffset)
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
