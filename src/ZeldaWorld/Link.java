import greenfoot.*;

/**
 * An demo class which is meant to be a camera follower.
 * It moves to face your mouse cursor, and it can move
 * back and forward.
 * 
 * @author Sven van Nigtevecht
 * @version 1.0
 */
public class Link extends Character
{
    /** The number of cells we move forward and backword */
    private static final int MOVE_AMOUNT = 5;
    /**
     * Create the main character Link
     */
    public Link(int health, int damage) {
        super.health = health;
        super.damage = damage;
    }
    /**
     * Move to face the mouse,
     * and listen to the up and down keys.
     */
    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null) {
            turnTowards(m.getX(), m.getY());
            // set the camera's direction to ours:
            getWorld().setCameraDirection(getRotation());
        }
        //TODO ALH: Make really smooth!
        if (getOneIntersectingObject(GameObject.class) == null || getOneIntersectingObject(WallWithEntrance.class) != null) {
            if (Greenfoot.isKeyDown("up")) {
                // move the camera forwards:
                getWorld().moveCamera(MOVE_AMOUNT);
            }
        } else if (Greenfoot.isKeyDown("down")) {
            // move the camera backwards:
            getWorld().moveCamera(-MOVE_AMOUNT);
        }
        //If character enters dungeon set world to DungeonWorld
        if (isTouching(Dungeon.class)) {
            Greenfoot.setWorld(ZeldaWorld.dungeonWorld);
        }

    }
    
    /**
     * Gets the health of Link
     */
    public static int getHealth() {
        return health;
    }
    
    //TODO ALH: We need to be able to get information about the damage of Link!
}