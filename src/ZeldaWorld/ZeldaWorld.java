import greenfoot.*;

/**
 * A little demo world to show you how this works.
 * 
 * @author Sven van Nigtevecht
 */
public class ZeldaWorld extends ScrollWorld
{
    /**
     * Constructor for objects of class DemoWorld.
     */
    public ZeldaWorld()
    {
        super(600, 400, 1, 1500, 1500);
        addObject(new Rock(), 400, 254);
        
        addCameraFollower(new Link(), 0, 0);
        
        addObject(new FPS(), 85, 15); // FPS isn't a subclass of
        // ScrollActor, so it will looklike it's a camera follower
    }
}