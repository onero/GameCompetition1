import greenfoot.*;
import java.util.*;

/**
 *
 * @author EASV2016 Group 12
 */
public class ZeldaWorld extends MasterWorld
{
    private boolean dungeonEntranceCreated;
    private Random rand;
    private static Character link;
    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(MasterWorld.PLAYABLE_AREA, MasterWorld.PLAYABLE_AREA, 1, MasterWorld.GAME_HEIGHT, MasterWorld.GAME_WIDTH);
        rand = new Random();
        dungeonEntranceCreated = false;
        //Create objects
        createObjects();
        //Add main player
        link = new Link(10, 5);
        addCameraFollower(link, 0, 0);
        //Create the player information
        addObject(new PlayerInfo(), 85, 15);

        //Create enemies
        createEnemies();
        //Create quest
        MasterWorld.zeldaWorldSound.play();
        
        quest = new Quest("Rats!", "Slay five rats!", 5, Rat.class);
        addObject(quest, 500, 30);
    }


    /**
     *Create the objects
     */
    private void createObjects() {
        //Top wall
        for(int i = MasterWorld.GAME_AREA_MIN; i < MasterWorld.GAME_WIDTH - MasterWorld.GAME_AREA_MIN; i += 215)
        {
            addObject(new Wall(), i , MasterWorld.GAME_AREA_MIN - 60);
        }
        addObject(new WallWithEntrance(), 500, MasterWorld.GAME_AREA_MIN - 60);
        //Left side wall
        for(int i = 250; i < MasterWorld.GAME_WIDTH - MasterWorld.GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, 100, i);
            sideWall.setRotation(sideWall.getRotation() - 90);
        }
        //Buttom side wall
        for(int i = MasterWorld.GAME_AREA_MIN; i < MasterWorld.GAME_WIDTH - MasterWorld.GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, i , MasterWorld.GAME_WIDTH - MasterWorld.GAME_AREA_MIN);
            sideWall.setRotation(sideWall.getRotation() - 180);
        }
        //Right side wall
        for(int i = 350; i < MasterWorld.GAME_WIDTH - MasterWorld.GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, MasterWorld.GAME_WIDTH - 180, i);
            sideWall.setRotation(sideWall.getRotation() + 90);
        }
        //Add rocks
        addObject(new Rock(),1200, 600);
        addObject(new Rock(),1400, 700);
        addObject(new Rock(),1050, 1000);
        // Trees
        for(int i = 940 ; i < MasterWorld.GAME_WIDTH - 300 ; i += 200)
        { 
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 1500, i);
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 1250, i);
        }
        for(int i = 1140 ; i < MasterWorld.GAME_WIDTH - 300 ; i += 200)
        { 
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 1000, i);
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 750, i);
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 500, i);
            
        }

        for(int i = 700 ; i < 1600; i += 215)
        { 
            addObject(new Tree(), i , MasterWorld.GAME_AREA_MIN + 100);
        }
        for(int i = 500 ; i < MasterWorld.GAME_WIDTH - 1000 ; i += 200)
        {
            addObject(new Tree(), MasterWorld.GAME_WIDTH - 350, i);
        }
    }

    /**
     *Create the Enemies
     */
    private void createEnemies() {
            addObject(new Rat(5, 1), 1100, 900);
            addObject(new Rat(5, 1), 1000, 800);
            addObject(new Rat(5, 1), 1200, 700);
            addObject(new Rat(5, 1), 600, 700);
            addObject(new Rat(5, 1), 300, 1500);
    }

    /**
     * Get the current character
     */
    public static Character getPlayer() {
        return link;
    }
    
    /**
     * create dungeonEntrance
     */
    public void checkCreateDungeonEntrance() {
        Quest quest = this.getQuest();
        if (quest.getQuestCompleted() == true && dungeonEntranceCreated == false) {
            addObject(new Dungeon(), 300, 1100);
            dungeonEntranceCreated = true;
        }
    }
}
