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
    //The number of cells we move forward and backword 
    private static final int MOVE_AMOUNT = 5;
    private static boolean isGuarded;
    private static int heroHealth;
    /**
     * Create the main character Link
     */
    public Link(int health, int damage) {
        heroHealth = health;
        super.damage = damage;
        isGuarded = false;
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
            MasterWorld.stopSound();
            MasterWorld.dungeonWorld = new DungeonWorld();
            Greenfoot.setWorld(MasterWorld.dungeonWorld);
        }

        if (enemyIsNear()) {
            fightMonster();
        }

        //If character enters castle set world to CastleWorld
        if (isTouching(CastleEntrance.class)) {
            MasterWorld.stopSound();
            MasterWorld.castleWorld = new CastleWorld();
            Greenfoot.setWorld(MasterWorld.castleWorld);
        }
        
        checkPlayerDeath();
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
            takeHeroDamage(currentEnemy.getDamage());
            currentEnemy.takeDamage(damage);
        } else {
            checkKillForQuest();
            if  (currentEnemy.getClass().equals(JeppeTheForker.class)) {
                MasterWorld.stopSound();
                killedLastBoss();
            }
            removeTouching(currentEnemy.getClass());
        }
    }
    
    /**
     * Killed last boss
     */
    private void killedLastBoss() {
        MasterWorld.winWorld = new WinWorld();
        Greenfoot.setWorld(MasterWorld.winWorld);
    }
    
    /**
     * Hero takes damage
     */
    private void takeHeroDamage(int damage) {
        heroHealth -= damage;
    }
    
    /**
     * Check player death
     */
    private void checkPlayerDeath() {
        if (heroHealth <= 0) {
            MasterWorld.stopSound();
            MasterWorld.gameOverWorld = new GameOverWorld();
            Greenfoot.setWorld(MasterWorld.gameOverWorld);
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
    
    /**
     * Checks the enemy we just killed 
     */
    private void checkKillForQuest()
    {
        Enemy currentEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(currentEnemy.isAlive != true)
        {
            MasterWorld world = (MasterWorld)getWorld();
            ZeldaWorld zeldaWorld = null;
            DungeonWorld dungeonWorld = null;
            Quest quest = world.getQuest();
            if (quest.getQuestEnemy().equals(currentEnemy.getClass())) {
                quest.updateQuestAmount();
                quest.checkQuestComplete();
                if (getWorld().getClass().equals(ZeldaWorld.class)) {
                    zeldaWorld = (ZeldaWorld)getWorld();
                    zeldaWorld.checkCreateDungeonEntrance();
                }
                if (getWorld().getClass().equals(DungeonWorld.class)) {
                    dungeonWorld = (DungeonWorld)getWorld();
                    dungeonWorld.checkCreateCastleEntrance();
                }
            }
        }
    }
}