import greenfoot.*;

/**
 * It moves to face your mouse cursor, and it can move
 * back and forward.
 * 
 * @author EASV2016 Group 12
 * @version 1.0
 */
public class Link extends Character
{
    /** The number of cells we move forward and backword */
    private static final int MOVE_AMOUNT = 5;
    private static boolean isGuarded = false;
    private static int heroHealth;
    public static int killCount;
    /**
     * Create the main character Link
     */
    public Link(int health, int damage) {
        heroHealth = health;
        super.damage = damage;
        killCount = 0;
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
            ZeldaWorld.zeldaWorldSound.stop();
            ZeldaWorld.dungeonWorld = new DungeonWorld();
            Greenfoot.setWorld(ZeldaWorld.dungeonWorld);
        }

        if (enemyIsNear()) {
            fightMonster();
        }

        //If character enters castle set world to CastleWorld
        if (isTouching(CastleEntrance.class)) {
            DungeonWorld.dungeonWorldSound.stop();
            DungeonWorld.castleWorld = new CastleWorld();
            Greenfoot.setWorld(DungeonWorld.castleWorld);
        }
    }

    /**
     * Gets the heros health
     */
    public static int getHeroHealth() {
        return heroHealth;
    }

    /**
     * Check for monster in the vicinity of Link
     */
    private boolean enemyIsNear() {
        return getOneIntersectingObject(Enemy.class) != null;
    }

    /**
     * Fight the enemy
     */
    private void fightMonster() {
        Enemy currentEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (currentEnemy.isAlive()) {
            takeDamage(currentEnemy.getDamage());
            currentEnemy.takeDamage(damage);
        } else {
            getKill();
            removeTouching(currentEnemy.getClass());
        }
    }

    /**
     * When a guardian is near, update isGuarded
     */
    public static void setGuarded(boolean guardedStatus, int protection) {
        if (isGuarded != true) {
            isGuarded = guardedStatus;
            heroHealth += protection;
        }
    }
    
    private void getKill()
    {
        Enemy currentEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(currentEnemy.isAlive != true)
        {
            killCount++;
            MasterWorld world = (MasterWorld)getWorld();
            Quest quest = world.getQuest();
            quest.sendEnemy(currentEnemy);
        }
    }
    
    public static int getKillCounter()
    {
        return killCount;
    }
}