import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MusicPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicPlayer extends Actor
{
    private final String DESTINATION_PREFIX = "sounds/";
    private ArrayList<String> musicArray;
    
    public MusicPlayer()
    {
        musicArray = new ArrayList();
        
        musicArray.add(DESTINATION_PREFIX + "TitleMusic" + ".mp3");
        musicArray.add(DESTINATION_PREFIX + "ZeldaOverWorld" + ".mp3");
        musicArray.add(DESTINATION_PREFIX + "Dungeon" + ".mp3");
        musicArray.add(DESTINATION_PREFIX + "Castle" + ".mp3");
    }
    
    /**
     * Get sound
     */
    public String getSound(int position) {
        return musicArray.get(position);
    }
    
    /**
     * Act - do whatever the MusicPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
}
