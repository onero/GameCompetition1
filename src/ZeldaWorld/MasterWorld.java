import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MasterWorld here.
 * 
 * @author EASV2016 Group 12 
 * @version (a version number or a date)
 */
public abstract class MasterWorld extends ScrollWorld
{
    protected static ZeldaWorld zeldaWorld;
    protected static DungeonWorld dungeonWorld;
    protected static CastleWorld castleWorld;
    protected static GameOverWorld gameOverWorld;
    protected static WinWorld winWorld;
    private static MusicPlayer musicPlayer;
    public static GreenfootSound zeldaWorldSound;
    public static GreenfootSound dungeonWorldSound;
    public static GreenfootSound castleWorldSound;
    public static GreenfootSound winSound;
    public static GreenfootSound looseSound;
    
    protected Quest quest;
    /**
     * Constructor for objects of class MasterWorld.
     * 
     */
    public MasterWorld(int width, int height, int cellSize, int fullWidth, int fullHeight)
    {
        super(width, height, cellSize, fullWidth, fullHeight);
        musicPlayer = new MusicPlayer();
        zeldaWorldSound = new GreenfootSound(musicPlayer.getSound(1));
        dungeonWorldSound = new GreenfootSound(musicPlayer.getSound(2));
        castleWorldSound = new GreenfootSound(musicPlayer.getSound(3));
        winSound = new GreenfootSound(musicPlayer.getSound(4));
        looseSound = new GreenfootSound(musicPlayer.getSound(5));
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
    
    /**
     * Stop sound if any is playing
     */
    public static void stopSound() {
        if (zeldaWorldSound.isPlaying()) {
            zeldaWorldSound.stop();
        }
        if (dungeonWorldSound.isPlaying()) {
            dungeonWorldSound.stop();
        }
        if (castleWorldSound.isPlaying()) {
            castleWorldSound.stop();
        }
        if (winSound.isPlaying()) {
            winSound.stop();
        }
        if (looseSound.isPlaying()) {
            looseSound.stop();
        }
    }
}
