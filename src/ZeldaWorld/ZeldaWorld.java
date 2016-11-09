import greenfoot.*;
import java.util.*;

/**
 *
 * @author EASV2016 Group 12
 */
public class ZeldaWorld extends MasterWorld
{
    public static final int GAME_WIDTH = 2000;
    public static final int GAME_HEIGHT = 2000;
    public static final int GAME_AREA = 1000;
    public static final int GAME_AREA_MIN = 250;
    private Random rand;
    private static Character link;
    private int ratKill;
    public static DungeonWorld dungeonWorld;
    private MusicPlayer musicPlayer;
    public static GreenfootSound zeldaWorldSound;

    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(1000, 1000, 1, GAME_WIDTH, GAME_HEIGHT);
        rand = new Random();
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
        //TODO ALH: Add real quest
        ratKill = 0;
        musicPlayer = new MusicPlayer();
        zeldaWorldSound = new GreenfootSound(musicPlayer.getSound(1));
        zeldaWorldSound.play();
        quest = new Quest("Rats!", "Slay five rats!",Link.getKillCounter(),Rat.class);
        addObject(quest, 500, 30);
    }


    /**
     *Create the objects
     */
    private void createObjects() {
        //Top wall
        for(int i = GAME_AREA_MIN; i < GAME_WIDTH - GAME_AREA_MIN; i += 215)
        {
            addObject(new Wall(), i , GAME_AREA_MIN - 60);
        }
        addObject(new WallWithEntrance(), 500, GAME_AREA_MIN - 60);
        //Left side wall
        for(int i = 250; i < GAME_WIDTH - GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, 100, i);
            sideWall.setRotation(sideWall.getRotation() - 90);
        }
        //Buttom side wall
        for(int i = GAME_AREA_MIN; i < GAME_WIDTH - GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, i , GAME_WIDTH - GAME_AREA_MIN);
            sideWall.setRotation(sideWall.getRotation() - 180);
        }
        //Right side wall
        for(int i = 350; i < GAME_WIDTH - GAME_AREA_MIN; i += 150)
        {
            Wall sideWall = new Wall();
            addObject(sideWall, GAME_WIDTH - 180, i);
            sideWall.setRotation(sideWall.getRotation() + 90);
        }
        //Add rocks
        addObject(new Rock(),1200, 600);
        addObject(new Rock(),1400, 700);
        addObject(new Rock(),1050, 1000);
        // Trees
        for(int i = 940 ; i < GAME_WIDTH - 300 ; i += 200)
        { 
            addObject(new Tree(), GAME_WIDTH - 1500, i);
            addObject(new Tree(), GAME_WIDTH - 1250, i);
        }
        for(int i = 1140 ; i < GAME_WIDTH - 300 ; i += 200)
        { 
            addObject(new Tree(), GAME_WIDTH - 1000, i);
            addObject(new Tree(), GAME_WIDTH - 750, i);
            addObject(new Tree(), GAME_WIDTH - 500, i);
            
        }

        for(int i = 700 ; i < 1600; i += 215)
        { 
            addObject(new Tree(), i , GAME_AREA_MIN + 100);
        }
        for(int i = 500 ; i < GAME_WIDTH - 1000 ; i += 200)
        {
            addObject(new Tree(), GAME_WIDTH - 350, i);
        }

        addObject(new Dungeon(), 300, 1100);
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


}
